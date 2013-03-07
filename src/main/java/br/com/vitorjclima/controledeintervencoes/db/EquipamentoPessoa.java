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
@Table(name = "equipamento_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipamentoPessoa.findAll", query = "SELECT e FROM EquipamentoPessoa e"),
    @NamedQuery(name = "EquipamentoPessoa.findByPessoaId", query = "SELECT e FROM EquipamentoPessoa e WHERE e.equipamentoPessoaPK.pessoaId = :pessoaId"),
    @NamedQuery(name = "EquipamentoPessoa.findByEquipamentoId", query = "SELECT e FROM EquipamentoPessoa e WHERE e.equipamentoPessoaPK.equipamentoId = :equipamentoId")})
public class EquipamentoPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipamentoPessoaPK equipamentoPessoaPK;

    public EquipamentoPessoa() {
    }

    public EquipamentoPessoa(EquipamentoPessoaPK equipamentoPessoaPK) {
        this.equipamentoPessoaPK = equipamentoPessoaPK;
    }

    public EquipamentoPessoa(int pessoaId, int equipamentoId) {
        this.equipamentoPessoaPK = new EquipamentoPessoaPK(pessoaId, equipamentoId);
    }

    public EquipamentoPessoaPK getEquipamentoPessoaPK() {
        return equipamentoPessoaPK;
    }

    public void setEquipamentoPessoaPK(EquipamentoPessoaPK equipamentoPessoaPK) {
        this.equipamentoPessoaPK = equipamentoPessoaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipamentoPessoaPK != null ? equipamentoPessoaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoPessoa)) {
            return false;
        }
        EquipamentoPessoa other = (EquipamentoPessoa) object;
        if ((this.equipamentoPessoaPK == null && other.equipamentoPessoaPK != null) || (this.equipamentoPessoaPK != null && !this.equipamentoPessoaPK.equals(other.equipamentoPessoaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.EquipamentoPessoa[ equipamentoPessoaPK=" + equipamentoPessoaPK + " ]";
    }
    
}
