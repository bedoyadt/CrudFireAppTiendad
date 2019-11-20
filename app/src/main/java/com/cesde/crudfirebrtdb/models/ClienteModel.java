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
    
}
