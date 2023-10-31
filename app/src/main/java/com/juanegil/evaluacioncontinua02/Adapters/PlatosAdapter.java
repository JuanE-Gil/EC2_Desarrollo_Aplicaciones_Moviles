package com.juanegil.evaluacioncontinua02.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.juanegil.evaluacioncontinua02.Entities.Platos;
import com.juanegil.evaluacioncontinua02.R;

import java.util.List;

public class PlatosAdapter extends ArrayAdapter<Platos> {

    Context myContext;
    int myLayout;
    List<Platos> myList;


    public PlatosAdapter(@NonNull Context context, int resource, @NonNull List<Platos> objects) {
        super(context, resource, objects);
        myContext = context;
        myLayout = resource;
        myList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Configuración del ListView
        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myLayout, null);

        // Acceso a los elementos del ListView
        TextView tvNombrePlato = convertView.findViewById(R.id.tvNombrePlato);
        TextView tvCodigoPlato = convertView.findViewById(R.id.tvCodigoPlato);
        TextView tvPrecioPlato = convertView.findViewById(R.id.tvPrecioPlato);
        TextView tvTipoPlato = convertView.findViewById(R.id.tvTipoPlato);
        TextView tvDepartamentoPlato = convertView.findViewById(R.id.tvDepartamentoPlato);
        ImageView imgPlato = convertView.findViewById(R.id.imgPlato);

        // Obtener el objeto Platos en la posición actual
        Platos platos = myList.get(position);

        if (platos != null) {
            // Validación para evitar valores nulos
            tvNombrePlato.setText(platos.getNombre_plato());
            tvCodigoPlato.setText(String.format("Codigo: %d", platos.getCod_plato()));
            tvPrecioPlato.setText(String.format("Precio: S/%.2f", platos.getPrecio_plato()));
            tvTipoPlato.setText(String.format("Tipo: %s", platos.getTipo_plato()));
            tvDepartamentoPlato.setText(String.format("Departamento: %s", platos.getDepartamento()));
            imgPlato.setImageResource(getImagenPorCodigo(platos.getCod_plato()));
        } else {
            // En caso de un objeto Platos nulo, puedes mostrar un mensaje de error o una vista alternativa.
            tvNombrePlato.setText("Datos no disponibles");
        }
        return convertView;
    }

    private int getImagenPorCodigo(int codigo) {
        int imgCodigo = 0;
        String nombreImagen = "p" + codigo;
        String nombrePaquete = getContext().getPackageName();
        imgCodigo = getContext().getResources().getIdentifier(nombreImagen, "drawable", nombrePaquete);
        if (imgCodigo <= 0) imgCodigo = R.drawable.a0000;
        return imgCodigo;
    }
}
