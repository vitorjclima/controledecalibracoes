/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "tolerancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tolerancia.findAll", query = "SELECT t FROM Tolerancia t"),
    @NamedQuery(name = "Tolerancia.findByToleranciaId", query = "SELECT t FROM Tolerancia t WHERE t.toleranciaPK.toleranciaId = :toleranciaId"),
    @NamedQuery(name = "Tolerancia.findByEquipamentoId", query = "SELECT t FROM Tolerancia t WHERE t.toleranciaPK.equipamentoId = :equipamentoId"),
    @NamedQuery(name = "Tolerancia.findBySistemaMedicaoId", query = "SELECT t FROM Tolerancia t WHERE t.sistemaMedicaoId = :sistemaMedicaoId"),
    @NamedQuery(name = "Tolerancia.findByToleranciaValor", query = "SELECT t FROM Tolerancia t WHERE t.toleranciaValor = :toleranciaValor")})
public class Tolerancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ToleranciaPK toleranciaPK;
    @Basic(optional = false)
    @Column(name = "sistema_medicao_id")
    private String sistemaMedicaoId;
    @Basic(optional = false)
    @Column(name = "tolerancia_valor")
    private double toleranciaValor;

    public Tolerancia() {
    }

    public Tolerancia(ToleranciaPK toleranciaPK) {
        this.toleranciaPK = toleranciaPK;
    }

    public Tolerancia(ToleranciaPK toleranciaPK, String sistemaMedicaoId, double toleranciaValor) {
        this.toleranciaPK = toleranciaPK;
        this.sistemaMedicaoId = sistemaMedicaoId;
        this.toleranciaValor = toleranciaValor;
    }

    public Tolerancia(int toleranciaId, int equipamentoId) {
        this.toleranciaPK = new ToleranciaPK(toleranciaId, equipamentoId);
    }

    public ToleranciaPK getToleranciaPK() {
        return toleranciaPK;
    }

    public void setToleranciaPK(ToleranciaPK toleranciaPK) {
        this.toleranciaPK = toleranciaPK;
    }

    public String getSistemaMedicaoId() {
        return sistemaMedicaoId;
    }

    public void setSistemaMedicaoId(String sistemaMedicaoId) {
        this.sistemaMedicaoId = sistemaMedicaoId;
    }

    public double getToleranciaValor() {
        return toleranciaValor;
    }

    public void setToleranciaValor(double toleranciaValor) {
        this.toleranciaValor = toleranciaValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toleranciaPK != null ? toleranciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tolerancia)) {
            return false;
        }
        Tolerancia other = (Tolerancia) object;
        if ((this.toleranciaPK == null && other.toleranciaPK != null) || (this.toleranciaPK != null && !this.toleranciaPK.equals(other.toleranciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Tolerancia[ toleranciaPK=" + toleranciaPK + " ]";
    }
    
}
