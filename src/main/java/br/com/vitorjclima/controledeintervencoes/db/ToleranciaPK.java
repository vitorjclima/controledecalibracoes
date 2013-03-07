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
public class ToleranciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tolerancia_id")
    private int toleranciaId;
    @Basic(optional = false)
    @Column(name = "equipamento_id")
    private int equipamentoId;

    public ToleranciaPK() {
    }

    public ToleranciaPK(int toleranciaId, int equipamentoId) {
        this.toleranciaId = toleranciaId;
        this.equipamentoId = equipamentoId;
    }

    public int getToleranciaId() {
        return toleranciaId;
    }

    public void setToleranciaId(int toleranciaId) {
        this.toleranciaId = toleranciaId;
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
        hash += (int) toleranciaId;
        hash += (int) equipamentoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToleranciaPK)) {
            return false;
        }
        ToleranciaPK other = (ToleranciaPK) object;
        if (this.toleranciaId != other.toleranciaId) {
            return false;
        }
        if (this.equipamentoId != other.equipamentoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.ToleranciaPK[ toleranciaId=" + toleranciaId + ", equipamentoId=" + equipamentoId + " ]";
    }
    
}
