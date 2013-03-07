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
public class EquipamentoAnexoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "anexo_id")
    private int anexoId;
    @Basic(optional = false)
    @Column(name = "equipamento_id")
    private int equipamentoId;

    public EquipamentoAnexoPK() {
    }

    public EquipamentoAnexoPK(int anexoId, int equipamentoId) {
        this.anexoId = anexoId;
        this.equipamentoId = equipamentoId;
    }

    public int getAnexoId() {
        return anexoId;
    }

    public void setAnexoId(int anexoId) {
        this.anexoId = anexoId;
    }

    public int getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(int equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) anexoId;
        hash += (int) equipamentoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoAnexoPK)) {
            return false;
        }
        EquipamentoAnexoPK other = (EquipamentoAnexoPK) object;
        if (this.anexoId != other.anexoId) {
            return false;
        }
        if (this.equipamentoId != other.equipamentoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.EquipamentoAnexoPK[ anexoId=" + anexoId + ", equipamentoId=" + equipamentoId + " ]";
    }
    
}
