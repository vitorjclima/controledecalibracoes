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
@Table(name = "intervencao_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntervencaoTipo.findAll", query = "SELECT i FROM IntervencaoTipo i"),
    @NamedQuery(name = "IntervencaoTipo.findByIntervencaoTipoId", query = "SELECT i FROM IntervencaoTipo i WHERE i.intervencaoTipoId = :intervencaoTipoId")})
public class IntervencaoTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "intervencao_tipo_id")
    private String intervencaoTipoId;

    public IntervencaoTipo() {
    }

    public IntervencaoTipo(String intervencaoTipoId) {
        this.intervencaoTipoId = intervencaoTipoId;
    }

    public String getIntervencaoTipoId() {
        return intervencaoTipoId;
    }

    public void setIntervencaoTipoId(String intervencaoTipoId) {
        this.intervencaoTipoId = intervencaoTipoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intervencaoTipoId != null ? intervencaoTipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntervencaoTipo)) {
            return false;
        }
        IntervencaoTipo other = (IntervencaoTipo) object;
        if ((this.intervencaoTipoId == null && other.intervencaoTipoId != null) || (this.intervencaoTipoId != null && !this.intervencaoTipoId.equals(other.intervencaoTipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.IntervencaoTipo[ intervencaoTipoId=" + intervencaoTipoId + " ]";
    }
    
}
