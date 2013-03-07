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
@Table(name = "empresa_anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaAnexo.findAll", query = "SELECT e FROM EmpresaAnexo e"),
    @NamedQuery(name = "EmpresaAnexo.findByEmpresaId", query = "SELECT e FROM EmpresaAnexo e WHERE e.empresaAnexoPK.empresaId = :empresaId"),
    @NamedQuery(name = "EmpresaAnexo.findByAnexoId", query = "SELECT e FROM EmpresaAnexo e WHERE e.empresaAnexoPK.anexoId = :anexoId")})
public class EmpresaAnexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpresaAnexoPK empresaAnexoPK;

    public EmpresaAnexo() {
    }

    public EmpresaAnexo(EmpresaAnexoPK empresaAnexoPK) {
        this.empresaAnexoPK = empresaAnexoPK;
    }

    public EmpresaAnexo(int empresaId, int anexoId) {
        this.empresaAnexoPK = new EmpresaAnexoPK(empresaId, anexoId);
    }

    public EmpresaAnexoPK getEmpresaAnexoPK() {
        return empresaAnexoPK;
    }

    public void setEmpresaAnexoPK(EmpresaAnexoPK empresaAnexoPK) {
        this.empresaAnexoPK = empresaAnexoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaAnexoPK != null ? empresaAnexoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaAnexo)) {
            return false;
        }
        EmpresaAnexo other = (EmpresaAnexo) object;
        if ((this.empresaAnexoPK == null && other.empresaAnexoPK != null) || (this.empresaAnexoPK != null && !this.empresaAnexoPK.equals(other.empresaAnexoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.EmpresaAnexo[ empresaAnexoPK=" + empresaAnexoPK + " ]";
    }
    
}
