package com.juanegil.evaluacioncontinua02.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.RangeSlider;
import com.juanegil.evaluacioncontinua02.Adapters.PlatosAdapter;
import com.juanegil.evaluacioncontinua02.Dao.PlatosDao;
import com.juanegil.evaluacioncontinua02.R;
import com.juanegil.evaluacioncontinua02.databinding.ActivityConsultarPlatosBinding;

public class ConsultarPlatosActivity extends AppCompatActivity {

    private ActivityConsultarPlatosBinding binding;
    double precioMinimo = 10;
    double precioMaximo = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultarPlatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initListener();
    }

    private void initListener() {
        binding.btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListadoDePlatos();
            }
        });

        binding.btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.rsPrecioPlato.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                precioMinimo = value;
                Log.d("RangeSlider", "ValorMinino" + precioMinimo);
            }
        });
    }

    private void mostrarListadoDePlatos() {

        String nombreDepartamento = binding.spinnerConsultarPlato.getSelectedItem().toString();

        PlatosDao dao = new PlatosDao();
        PlatosAdapter adapter = new PlatosAdapter(
                getApplicationContext(),
                R.layout.item_fila_plato,
                dao.platosPorPrecio(nombreDepartamento, precioMinimo, precioMaximo)
        );
        binding.lvConsultarPlato.setAdapter(adapter);
    }


}