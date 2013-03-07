/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "sistema_medicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaMedicao.findAll", query = "SELECT s FROM SistemaMedicao s"),
    @NamedQuery(name = "SistemaMedicao.findBySistemaMedicaoId", query = "SELECT s FROM SistemaMedicao s WHERE s.sistemaMedicaoId = :sistemaMedicaoId")})
public class SistemaMedicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sistema_medicao_id")
    private String sistemaMedicaoId;

    public SistemaMedicao() {
    }

    public SistemaMedicao(String sistemaMedicaoId) {
        this.sistemaMedicaoId = sistemaMedicaoId;
    }

    public String getSistemaMedicaoId() {
        return sistemaMedicaoId;
    }

    public void setSistemaMedicaoId(String sistemaMedicaoId) {
        this.sistemaMedicaoId = sistemaMedicaoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sistemaMedicaoId != null ? sistemaMedicaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaMedicao)) {
            return false;
        }
        SistemaMedicao other = (SistemaMedicao) object;
        if ((this.sistemaMedicaoId == null && other.sistemaMedicaoId != null) || (this.sistemaMedicaoId != null && !this.sistemaMedicaoId.equals(other.sistemaMedicaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.SistemaMedicao[ sistemaMedicaoId=" + sistemaMedicaoId + " ]";
    }
    
}
