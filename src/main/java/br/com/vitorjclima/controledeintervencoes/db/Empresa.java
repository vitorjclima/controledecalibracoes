/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByEmpresaId", query = "SELECT e FROM Empresa e WHERE e.empresaId = :empresaId"),
    @NamedQuery(name = "Empresa.findByEmpresaRazaoSocial", query = "SELECT e FROM Empresa e WHERE e.empresaRazaoSocial = :empresaRazaoSocial"),
    @NamedQuery(name = "Empresa.findByEmpresaCnpj", query = "SELECT e FROM Empresa e WHERE e.empresaCnpj = :empresaCnpj"),
    @NamedQuery(name = "Empresa.findByEmpresaNomeFantasia", query = "SELECT e FROM Empresa e WHERE e.empresaNomeFantasia = :empresaNomeFantasia")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empresa_id")
    private Integer empresaId;
    @Basic(optional = false)
    @Column(name = "empresa_razao_social")
    private String empresaRazaoSocial;
    @Basic(optional = false)
    @Column(name = "empresa_cnpj")
    private String empresaCnpj;
    @Basic(optional = false)
    @Column(name = "empresa_nome_fantasia")
    private String empresaNomeFantasia;

    public Empresa() {
    }

    public Empresa(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Empresa(Integer empresaId, String empresaRazaoSocial, String empresaCnpj, String empresaNomeFantasia) {
        this.empresaId = empresaId;
        this.empresaRazaoSocial = empresaRazaoSocial;
        this.empresaCnpj = empresaCnpj;
        this.empresaNomeFantasia = empresaNomeFantasia;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getEmpresaRazaoSocial() {
        return empresaRazaoSocial;
    }

    public void setEmpresaRazaoSocial(String empresaRazaoSocial) {
        this.empresaRazaoSocial = empresaRazaoSocial;
    }

    public String getEmpresaCnpj() {
        return empresaCnpj;
    }

    public void setEmpresaCnpj(String empresaCnpj) {
        this.empresaCnpj = empresaCnpj;
    }

    public String getEmpresaNomeFantasia() {
        return empresaNomeFantasia;
    }

    public void setEmpresaNomeFantasia(String empresaNomeFantasia) {
        this.empresaNomeFantasia = empresaNomeFantasia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaId != null ? empresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaId == null && other.empresaId != null) || (this.empresaId != null && !this.empresaId.equals(other.empresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Empresa[ empresaId=" + empresaId + " ]";
    }
    
}
