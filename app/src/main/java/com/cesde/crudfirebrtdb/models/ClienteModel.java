package com.cesde.crudfirebrtdb.models;

import java.util.Objects;

public class ClienteModel {

    private String _id;
    private String _nombre;
    private String _tipo;
    private String _valor;



    public String toString() {
        return "nombre = '" + _nombre + "'\n" +
                "valor = '" + _valor;
    }



    public ClienteModel() {
    }

    public ClienteModel(String _id, String _nombre, String _tipo, String _valor) {
        this._id = _id;
        this._nombre = _nombre;
        this._tipo = _tipo;
        this._valor = _valor;
    }
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_tipo() {
        return _tipo;
    }

    public void set_tipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String get_valor() {
        return _valor;
    }

    public void set_valor(String _valor) {
        this._valor = _valor;
    }
    /*
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
}*/
}