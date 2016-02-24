package com.br.metalurgicametodo.dao;

import java.io.Serializable;
import java.util.List;

//Classe pai dos Crud do banco!!
public abstract class DaoBase<T> implements IDaoBase {

    public void delete(Object objeto) {

    }

    public void save(Object objeto) {

    }

    public void update(Object objeto) {

    }

    public List<T> list() {
        List<T> lista = null;
        return lista;
    }

    public Object get(Serializable id) {
        return id;
    }

}
