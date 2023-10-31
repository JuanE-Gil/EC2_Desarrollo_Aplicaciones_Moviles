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

        // Acceso a los items del ListView
        TextView tvNombrePlato = convertView.findViewById(R.id.tvNombrePlato);
        TextView tvCodigoPlato = convertView.findViewById(R.id.tvCodigoPlato);
        TextView tvPrecioPlato = convertView.findViewById(R.id.tvPrecioPlato);
        TextView tvTipoPlato = convertView.findViewById(R.id.tvTipoPlato);
        TextView tvDepartamentoPlato = convertView.findViewById(R.id.tvDepartamentoPlato);
        ImageView imgPlato = convertView.findViewById(R.id.imgPlato);

        // Envio de los datos
        Platos platos = myList.get(position);
        tvNombrePlato.setText(platos.getNombre_plato());
        tvCodigoPlato.setText("Codigo: " + platos.getCod_plato());
        tvPrecioPlato.setText("Precio: " + platos.getPrecio_plato());
        tvTipoPlato.setText("Tipo: " + platos.getTipo_plato());
        tvDepartamentoPlato.setText("Departamento: " + platos.getDepartamento());

        imgPlato.setImageResource(getImagenPorCodigo(platos.getCod_plato()));

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
