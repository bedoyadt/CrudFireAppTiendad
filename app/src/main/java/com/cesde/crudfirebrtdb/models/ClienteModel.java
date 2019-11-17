package com.cesde.crudfirebrtdb.models;

import java.util.Objects;

public class ClienteModel {

    private String _id;
    private String _cedula;
    private String _nombre;
    private String _apellido;

    /*
    @Override
    public String toString() {
        return "Cliente Model {\n" +
                "Cédula = '" + _cedula + "'\n" +
                "Nombre = '" + _nombre + "'\n" +
                "Apellido = '" + _apellido + "'\n" +
                "}\n\n";
    }
    */

    public String toString() {
        return "Nombre = '" + _nombre + "'\n" +
                "Apellido = '" + _apellido;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteModel)) return false;
        ClienteModel that = (ClienteModel) o;
        return get_id().equals(that.get_id()) &&
                get_cedula().equals(that.get_cedula()) &&
                get_nombre().equals(that.get_nombre()) &&
                get_apellido().equals(that.get_apellido());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), get_cedula(), get_nombre(), get_apellido());
    }
    */

    public ClienteModel() {
    }

    public ClienteModel(String _cedula, String _nombre, String _apellido) {
        this._cedula = _cedula;
        this._nombre = _nombre;
        this._apellido = _apellido;
    }

    public ClienteModel(String _id, String _cedula, String _nombre, String _apellido) {
        this._id = _id;
        this._cedula = _cedula;
        this._nombre = _nombre;
        this._apellido = _apellido;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_cedula() {
        return _cedula;
    }

    public void set_cedula(String _cedula) {
        this._cedula = _cedula;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }
}