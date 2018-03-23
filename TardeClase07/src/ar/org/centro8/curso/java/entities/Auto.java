package ar.org.centro8.curso.java.entities;

import java.util.Objects;

public class Auto {
    private String marca;
    private String modelo;
    private String color;

    @Override
    public String toString() {
        return marca + " " + modelo + " " + color;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return this.hashCode() == obj.hashCode();
    }

    public Auto(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }
}
