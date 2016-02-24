
package com.br.metalurgicametodo.dao;

import java.util.List;

//Interface de metodos proprios de pessoa!
public interface IPessoaDao<T> {
    public List<T> listarPorCpf(String cpf);
}
