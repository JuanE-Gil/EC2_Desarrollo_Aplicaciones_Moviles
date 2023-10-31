package com.juanegil.evaluacioncontinua02.Entities;

public class Platos {
    private int cod_plato;
    private String nombre_plato;
    private double precio_plato;
    private String tipo_plato;
    private String departamento;

    public Platos() {
    }

    public Platos(int cod_plato, String nombre_plato, double precio_plato, String tipo_plato, String departamento) {
        this.cod_plato = cod_plato;
        this.nombre_plato = nombre_plato;
        this.precio_plato = precio_plato;
        this.tipo_plato = tipo_plato;
        this.departamento = departamento;
    }

    public int getCod_plato() {
        return cod_plato;
    }

    public void setCod_plato(int cod_plato) {
        this.cod_plato = cod_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public double getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(double precio_plato) {
        this.precio_plato = precio_plato;
    }

    public String getTipo_plato() {
        return tipo_plato;
    }

    public void setTipo_plato(String tipo_plato) {
        this.tipo_plato = tipo_plato;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
