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
public class EquipamentoPessoaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pessoa_id")
    private int pessoaId;
    @Basic(optional = false)
    @Column(name = "equipamento_id")
    private int equipamentoId;

    public EquipamentoPessoaPK() {
    }

    public EquipamentoPessoaPK(int pessoaId, int equipamentoId) {
        this.pessoaId = pessoaId;
        this.equipamentoId = equipamentoId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
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
        hash += (int) pessoaId;
        hash += (int) equipamentoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoPessoaPK)) {
            return false;
        }
        EquipamentoPessoaPK other = (EquipamentoPessoaPK) object;
        if (this.pessoaId != other.pessoaId) {
            return false;
        }
        if (this.equipamentoId != other.equipamentoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.EquipamentoPessoaPK[ pessoaId=" + pessoaId + ", equipamentoId=" + equipamentoId + " ]";
    }
    
}
