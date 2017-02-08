/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "ocorrencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocorrencia.findAll", query = "SELECT o FROM Ocorrencia o"),
    @NamedQuery(name = "Ocorrencia.findByIdOcorrencia", query = "SELECT o FROM Ocorrencia o WHERE o.idOcorrencia = :idOcorrencia"),
    @NamedQuery(name = "Ocorrencia.findByDataCadastro", query = "SELECT o FROM Ocorrencia o WHERE o.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Ocorrencia.findByNomeSolicitante", query = "SELECT o FROM Ocorrencia o WHERE o.nomeSolicitante = :nomeSolicitante"),
    @NamedQuery(name = "Ocorrencia.findByTipoOcorrencia", query = "SELECT o FROM Ocorrencia o WHERE o.tipoOcorrencia = :tipoOcorrencia")})
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ocorrencia")
    private Integer idOcorrencia;
    @Basic(optional = false)
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "nome_solicitante")
    private String nomeSolicitante;
    @Basic(optional = false)
    @Column(name = "tipo_ocorrencia")
    private String tipoOcorrencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOcorrencia", fetch = FetchType.EAGER)
    private Collection<Comentario> comentarioCollection;

    public Ocorrencia() {
    }

    public Ocorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Ocorrencia(Integer idOcorrencia, Date dataCadastro, String tipoOcorrencia) {
        this.idOcorrencia = idOcorrencia;
        this.dataCadastro = dataCadastro;
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Integer getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    @XmlTransient
    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcorrencia != null ? idOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencia)) {
            return false;
        }
        Ocorrencia other = (Ocorrencia) object;
        if ((this.idOcorrencia == null && other.idOcorrencia != null) || (this.idOcorrencia != null && !this.idOcorrencia.equals(other.idOcorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ocorrencia[ idOcorrencia=" + idOcorrencia + " ]";
    }
    
}
