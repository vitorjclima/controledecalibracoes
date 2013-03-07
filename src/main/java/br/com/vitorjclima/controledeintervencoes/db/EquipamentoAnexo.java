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
@Table(name = "equipamento_anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipamentoAnexo.findAll", query = "SELECT e FROM EquipamentoAnexo e"),
    @NamedQuery(name = "EquipamentoAnexo.findByAnexoId", query = "SELECT e FROM EquipamentoAnexo e WHERE e.equipamentoAnexoPK.anexoId = :anexoId"),
    @NamedQuery(name = "EquipamentoAnexo.findByEquipamentoId", query = "SELECT e FROM EquipamentoAnexo e WHERE e.equipamentoAnexoPK.equipamentoId = :equipamentoId")})
public class EquipamentoAnexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipamentoAnexoPK equipamentoAnexoPK;

    public EquipamentoAnexo() {
    }

    public EquipamentoAnexo(EquipamentoAnexoPK equipamentoAnexoPK) {
        this.equipamentoAnexoPK = equipamentoAnexoPK;
    }

    public EquipamentoAnexo(int anexoId, int equipamentoId) {
        this.equipamentoAnexoPK = new EquipamentoAnexoPK(anexoId, equipamentoId);
    }

    public EquipamentoAnexoPK getEquipamentoAnexoPK() {
        return equipamentoAnexoPK;
    }

    public void setEquipamentoAnexoPK(EquipamentoAnexoPK equipamentoAnexoPK) {
        this.equipamentoAnexoPK = equipamentoAnexoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipamentoAnexoPK != null ? equipamentoAnexoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamentoAnexo)) {
            return false;
        }
        EquipamentoAnexo other = (EquipamentoAnexo) object;
        if ((this.equipamentoAnexoPK == null && other.equipamentoAnexoPK != null) || (this.equipamentoAnexoPK != null && !this.equipamentoAnexoPK.equals(other.equipamentoAnexoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.EquipamentoAnexo[ equipamentoAnexoPK=" + equipamentoAnexoPK + " ]";
    }
    
}
