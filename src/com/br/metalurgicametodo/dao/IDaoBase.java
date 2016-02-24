
package com.br.metalurgicametodo.dao;

import java.io.Serializable;
import java.util.List;

//Interface de CRUD do Banco de Dados
public interface IDaoBase<T> {

    public void delete(T objeto);

    public void save(T objeto);

    public void update(T objeto);

    public List<T> list();

    public T get(Serializable id);

}
