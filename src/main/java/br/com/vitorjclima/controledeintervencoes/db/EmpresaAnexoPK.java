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
public class EmpresaAnexoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "empresa_id")
    private int empresaId;
    @Basic(optional = false)
    @Column(name = "anexo_id")
    private int anexoId;

    public EmpresaAnexoPK() {
    }

    public EmpresaAnexoPK(int empresaId, int anexoId) {
        this.empresaId = empresaId;
        this.anexoId = anexoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getAnexoId() {
        return anexoId;
    }

    public void setAnexoId(int anexoId) {
        this.anexoId = anexoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresaId;
        hash += (int) anexoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaAnexoPK)) {
            return false;
        }
        EmpresaAnexoPK other = (EmpresaAnexoPK) object;
        if (this.empresaId != other.empresaId) {
            return false;
        }
        if (this.anexoId != other.anexoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.EmpresaAnexoPK[ empresaId=" + empresaId + ", anexoId=" + anexoId + " ]";
    }
    
}
