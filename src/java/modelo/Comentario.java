/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "Comentario.findByComentario", query = "SELECT c FROM Comentario c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "Comentario.findByDataCadastro", query = "SELECT c FROM Comentario c WHERE c.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Comentario.findByNomeAluno", query = "SELECT c FROM Comentario c WHERE c.nomeAluno = :nomeAluno"),
    @NamedQuery(name = "Comentario.findByIdOcorrencia", query = "SELECT c FROM Comentario c WHERE c.idOcorrencia = :idOcorrencia")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @Column(name = "nome_aluno")
    private String nomeAluno;
    @JoinColumn(name = "id_ocorrencia", referencedColumnName = "id_ocorrencia")
    @ManyToOne(optional = false)
    private Ocorrencia idOcorrencia;

    public Comentario() {
    }

    public Comentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Integer idComentario, String comentario, Date dataCadastro, String nomeAluno) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.dataCadastro = dataCadastro;
        this.nomeAluno = nomeAluno;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Ocorrencia getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Ocorrencia idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Comentario[ idComentario=" + idComentario + " ]";
    }
    
}
