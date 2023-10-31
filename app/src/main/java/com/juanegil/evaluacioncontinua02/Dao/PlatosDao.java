package com.juanegil.evaluacioncontinua02.Dao;

import com.juanegil.evaluacioncontinua02.Entities.Platos;

import java.util.ArrayList;
import java.util.List;

public class PlatosDao {

    private static List<Platos> list = new ArrayList<Platos>();


    public List<Platos> listarPlatos() {
        return list;
    }

    public String guardarPlato(Platos plato) {
        Platos find = buscarPlato(plato.getCod_plato());
        if (find == null) {
            list.add(plato);
            return "Plato Registrado Correctamente";
        } else {
            return "ERROR: El Codigo del Plato ya existe";
        }
    }

    private Platos buscarPlato(int codigo) {
        Platos plato = null;
        for (Platos platos : list) {
            if (platos.getCod_plato() == codigo) {
                plato = platos;
                break;
            }
        }
        return plato;
    }

    public String eliminarPlato(int codigo) {
        Platos plato = buscarPlato(codigo);

        if (plato != null) {
            list.remove(plato);
            return "Plato Eliminado Correctamente";
        } else {
            return "Error: Plato no encontrado";
        }
    }

    public List<Platos> platosPorDepartamento(String departamento) {
        List<Platos> platos = new ArrayList<Platos>();
        for (Platos plato : list) {
            if (plato.getDepartamento().equals(departamento)) {
                platos.add(plato);
            }
        }
        return platos;
    }

    public List<Platos> platosPorPrecio(String departamento, double precioMinimo, double precioMaximo) {
        List<Platos> platos = new ArrayList<Platos>();
        for (Platos plato : list) {
            if (plato.getDepartamento().equals(departamento) &&
                    plato.getPrecio_plato() >= precioMinimo &&
                    plato.getPrecio_plato() <= precioMaximo) {
                platos.add(plato);
            }
        }
        return platos;
    }

}
