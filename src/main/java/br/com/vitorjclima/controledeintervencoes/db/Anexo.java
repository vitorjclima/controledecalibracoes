/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vitor
 */
@Entity
@Table(name = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anexo.findAll", query = "SELECT a FROM Anexo a"),
    @NamedQuery(name = "Anexo.findByAnexoId", query = "SELECT a FROM Anexo a WHERE a.anexoId = :anexoId"),
    @NamedQuery(name = "Anexo.findByAnexoEndereco", query = "SELECT a FROM Anexo a WHERE a.anexoEndereco = :anexoEndereco")})
public class Anexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anexo_id")
    private Integer anexoId;
    @Basic(optional = false)
    @Column(name = "anexo_endereco")
    private String anexoEndereco;

    public Anexo() {
    }

    public Anexo(Integer anexoId) {
        this.anexoId = anexoId;
    }

    public Anexo(Integer anexoId, String anexoEndereco) {
        this.anexoId = anexoId;
        this.anexoEndereco = anexoEndereco;
    }

    public Integer getAnexoId() {
        return anexoId;
    }

    public void setAnexoId(Integer anexoId) {
        this.anexoId = anexoId;
    }

    public String getAnexoEndereco() {
        return anexoEndereco;
    }

    public void setAnexoEndereco(String anexoEndereco) {
        this.anexoEndereco = anexoEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anexoId != null ? anexoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anexo)) {
            return false;
        }
        Anexo other = (Anexo) object;
        if ((this.anexoId == null && other.anexoId != null) || (this.anexoId != null && !this.anexoId.equals(other.anexoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Anexo[ anexoId=" + anexoId + " ]";
    }
    
}
