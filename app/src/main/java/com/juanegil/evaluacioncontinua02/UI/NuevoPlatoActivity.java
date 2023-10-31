package com.juanegil.evaluacioncontinua02.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.juanegil.evaluacioncontinua02.Dao.PlatosDao;
import com.juanegil.evaluacioncontinua02.Entities.Platos;
import com.juanegil.evaluacioncontinua02.R;
import com.juanegil.evaluacioncontinua02.databinding.ActivityNuevoPlatoBinding;

public class NuevoPlatoActivity extends AppCompatActivity {

    private ActivityNuevoPlatoBinding binding;
    private RadioGroup radioGroupLeft;
    private RadioGroup radioGroupRight;
    private boolean isLeftGroupChecked = false;
    private boolean isRightGroupChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNuevoPlatoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        radioGroupLeft = findViewById(R.id.radioGroupLeft);
        radioGroupRight = findViewById(R.id.radioGroupRight);

        limpiarPantalla();
        initListener();
    }

    private void initListener() {
        binding.btnNuevoPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarPantalla();
            }
        });

        binding.btnGuardarPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPlato();
            }
        });

        binding.btnListarPlatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), listarPlatosActivity.class);
                startActivity(intent);
            }
        });

        radioGroupLeft.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!isRightGroupChecked) {
                    isLeftGroupChecked = true;
                    radioGroupRight.clearCheck();
                }
                isLeftGroupChecked = false;
            }
        });

        radioGroupRight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!isLeftGroupChecked) {
                    isRightGroupChecked = true;
                    radioGroupLeft.clearCheck();
                }
                isRightGroupChecked = false;
            }
        });
    }

    private void guardarPlato() {
        String radioButtonSeleccionado = obtenerTextoRadioButtonSeleccionado();

        Platos plato = new Platos(
                Integer.parseInt(binding.edtCodigoPlato.getText().toString()),
                binding.edtNombrePlato.getText().toString(),
                Double.parseDouble(binding.edtPrecioPlato.getText().toString()),
                radioButtonSeleccionado,
                binding.spinnerDepartamentos.getSelectedItem().toString()
        );

        PlatosDao dao = new PlatosDao();
        String mensaje = dao.guardarPlato(plato);

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        dao = null;
    }

    private void limpiarPantalla() {
        binding.edtCodigoPlato.setText("");
        binding.edtNombrePlato.setText("");
        binding.edtPrecioPlato.setText("");
        binding.rbEntrada.setChecked(true);
        binding.spinnerDepartamentos.setSelection(0);

        binding.edtCodigoPlato.requestFocus();
    }

    private int obtenerRadioButtonSeleccionado() {
        int radioButtonSeleccionadoId = radioGroupLeft.getCheckedRadioButtonId();
        if (radioButtonSeleccionadoId == -1) {
            radioButtonSeleccionadoId = radioGroupRight.getCheckedRadioButtonId();
        }
        return radioButtonSeleccionadoId;
    }

    private String obtenerTextoRadioButtonSeleccionado() {
        int radioButtonSeleccionadoId = obtenerRadioButtonSeleccionado();

        if (radioButtonSeleccionadoId != -1) {
            RadioButton radioButtonSeleccionado = findViewById(radioButtonSeleccionadoId);
            if (radioButtonSeleccionado != null) {
                return radioButtonSeleccionado.getText().toString();
            }
        }
        return "Ningún RadioButton seleccionado";
    }


}