/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author vitor
 */
@Embeddable
public class IntervencaoAnexoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "anexo_id")
    private int anexoId;
    @Basic(optional = false)
    @Column(name = "intervencao_id")
    private int intervencaoId;

    public IntervencaoAnexoPK() {
    }

    public IntervencaoAnexoPK(int anexoId, int intervencaoId) {
        this.anexoId = anexoId;
        this.intervencaoId = intervencaoId;
    }

    public int getAnexoId() {
        return anexoId;
    }

    public void setAnexoId(int anexoId) {
        this.anexoId = anexoId;
    }

    public int getIntervencaoId() {
        return intervencaoId;
    }

    public void setIntervencaoId(int intervencaoId) {
        this.intervencaoId = intervencaoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) anexoId;
        hash += (int) intervencaoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntervencaoAnexoPK)) {
            return false;
        }
        IntervencaoAnexoPK other = (IntervencaoAnexoPK) object;
        if (this.anexoId != other.anexoId) {
            return false;
        }
        if (this.intervencaoId != other.intervencaoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.IntervencaoAnexoPK[ anexoId=" + anexoId + ", intervencaoId=" + intervencaoId + " ]";
    }
    
}
