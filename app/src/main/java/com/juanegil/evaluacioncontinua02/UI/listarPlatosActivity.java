package com.juanegil.evaluacioncontinua02.UI;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.juanegil.evaluacioncontinua02.Adapters.PlatosAdapter;
import com.juanegil.evaluacioncontinua02.Dao.PlatosDao;
import com.juanegil.evaluacioncontinua02.R;
import com.juanegil.evaluacioncontinua02.databinding.ActivityListarPlatosBinding;

public class listarPlatosActivity extends AppCompatActivity {

    private ActivityListarPlatosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListarPlatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mostrarListadoDePlatos();
        initListener();
    }

    private void initListener() {
        // Mostrar Indice del plato
        binding.lvPlatosTipicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listarPlatosActivity.this, "Seleccionaste el Indice: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        // Eliminar Plato
        binding.lvPlatosTipicos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PlatosDao dao = new PlatosDao();
                int codigo = dao.listarPlatos().get(position).getCod_plato();
                String mensaje = dao.eliminarPlato(codigo);

                Snackbar.make(view, mensaje, LENGTH_LONG).setTextColor(Color.YELLOW).show();

                mostrarListadoDePlatos();
                dao = null;
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // llamar al metodo para mostrar el listado de los platos
        mostrarListadoDePlatos();
    }

    private void mostrarListadoDePlatos() {
        PlatosDao dao = new PlatosDao();
        PlatosAdapter adapter = new PlatosAdapter(getApplicationContext(), R.layout.item_fila_plato, dao.listarPlatos());
        binding.lvPlatosTipicos.setAdapter(adapter);
    }
}