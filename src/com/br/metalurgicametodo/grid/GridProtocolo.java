/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.metalurgicametodo.grid;

import com.br.metalurgicametodo.dao.PessoaDao;
import com.br.metalurgicametodo.dao.PessoaFisicaDAO;
import com.br.metalurgicametodo.dao.PessoaJuridicaDAO;
import com.br.metalurgicametodo.entidades.Atendimento;
import com.br.metalurgicametodo.entidades.Pessoa;
import com.br.metalurgicametodo.entidades.PessoaFisica;
import com.br.metalurgicametodo.entidades.PessoaJuridica;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
//classe responsavel por gerar a Grid de protocolos
public class GridProtocolo {
    //metodo que gera a grid de protocolo recebendo como parametro um atendimento
    public Object[] carregarGridProtocolo(Atendimento atendimento)
    {
        Pessoa pessoa = new Pessoa();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = (Date) (atendimento.getDataContato());
        String data = format.format(d1);
        
        PessoaDao pessoaDAO = new PessoaDao();
        pessoa = pessoaDAO.buscar(atendimento.getPessoa().getCodigoPessoa());
        //identifica se a pessoa é juridica ou fisica
        if(pessoa.getTipoPessoa().equalsIgnoreCase("pf"))
        {
            PessoaFisica pessoaF = new PessoaFisica();
            PessoaFisicaDAO pFDAO = new PessoaFisicaDAO();
            pessoaF = pFDAO.buscarPorID(atendimento.getPessoa().getCodigoPessoa());
            //retorna um objeto com todas as informaçoes que serão inseridas na grid
            return new Object[] {atendimento.getProtocolo(),pessoa.getNome(),pessoaF.getCpf(),data,atendimento.getTipoAssunto(),atendimento.getMotivo(),
            atendimento.getStatus()};
        }else if (pessoa.getTipoPessoa().equalsIgnoreCase("pj"))
        {
            PessoaJuridica pessoaJ = new PessoaJuridica();
            PessoaJuridicaDAO pJDAO = new PessoaJuridicaDAO();
            pessoaJ = pJDAO.buscarPorID(atendimento.getPessoa().getCodigoPessoa());
            //retorna um objeto com todas as informaçoes que serão inseridas na grid
            return new Object[] {atendimento.getProtocolo(),pessoa.getNome(),pessoaJ.getCnpj(),data,atendimento.getTipoAssunto(),atendimento.getMotivo(),
            atendimento.getStatus()};
        }
        return null;
    
    }
}
