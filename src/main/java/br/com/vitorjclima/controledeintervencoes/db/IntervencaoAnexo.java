/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vitor
 */
@Entity
@Table(name = "intervencao_anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntervencaoAnexo.findAll", query = "SELECT i FROM IntervencaoAnexo i"),
    @NamedQuery(name = "IntervencaoAnexo.findByAnexoId", query = "SELECT i FROM IntervencaoAnexo i WHERE i.intervencaoAnexoPK.anexoId = :anexoId"),
    @NamedQuery(name = "IntervencaoAnexo.findByIntervencaoId", query = "SELECT i FROM IntervencaoAnexo i WHERE i.intervencaoAnexoPK.intervencaoId = :intervencaoId")})
public class IntervencaoAnexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IntervencaoAnexoPK intervencaoAnexoPK;

    public IntervencaoAnexo() {
    }

    public IntervencaoAnexo(IntervencaoAnexoPK intervencaoAnexoPK) {
        this.intervencaoAnexoPK = intervencaoAnexoPK;
    }

    public IntervencaoAnexo(int anexoId, int intervencaoId) {
        this.intervencaoAnexoPK = new IntervencaoAnexoPK(anexoId, intervencaoId);
    }

    public IntervencaoAnexoPK getIntervencaoAnexoPK() {
        return intervencaoAnexoPK;
    }

    public void setIntervencaoAnexoPK(IntervencaoAnexoPK intervencaoAnexoPK) {
        this.intervencaoAnexoPK = intervencaoAnexoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intervencaoAnexoPK != null ? intervencaoAnexoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntervencaoAnexo)) {
            return false;
        }
        IntervencaoAnexo other = (IntervencaoAnexo) object;
        if ((this.intervencaoAnexoPK == null && other.intervencaoAnexoPK != null) || (this.intervencaoAnexoPK != null && !this.intervencaoAnexoPK.equals(other.intervencaoAnexoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.IntervencaoAnexo[ intervencaoAnexoPK=" + intervencaoAnexoPK + " ]";
    }
    
}
