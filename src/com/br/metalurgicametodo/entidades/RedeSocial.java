
package com.br.metalurgicametodo.entidades;

import java.util.Date;

//Classe que sera responsavel por armazenar RedeSocial
public class RedeSocial {

    private String nomeRede;
    private String comentario;
    private Date dataOcorrencia;
    private String linkUsuario;
    private String tipoComentario;

    public RedeSocial() {

    }

    public RedeSocial(String nomeRede, String comentario, Date dataOcorrencia, String linkUsuario, String tipoComentario) {
        this.nomeRede = nomeRede;
        this.comentario = comentario;
        this.dataOcorrencia = dataOcorrencia;
        this.linkUsuario = linkUsuario;
        this.tipoComentario = tipoComentario;
    }

    public String getNomeRede() {
        return nomeRede;
    }

    public void setNomeRede(String nomeRede) {
        this.nomeRede = nomeRede;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(String linkUsuario) {
        this.linkUsuario = linkUsuario;
    }

    public String getTipoComentario() {
        return tipoComentario;
    }

    public void setTipoComentario(String tipoComentario) {
        this.tipoComentario = tipoComentario;
    }

}
