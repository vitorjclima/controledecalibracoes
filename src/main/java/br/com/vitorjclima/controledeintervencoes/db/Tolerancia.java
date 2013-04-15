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
@Table(name = "tolerancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tolerancia.findAll", query = "SELECT t FROM Tolerancia t"),
    @NamedQuery(name = "Tolerancia.findByToleranciaId", query = "SELECT t FROM Tolerancia t WHERE t.toleranciaId = :toleranciaId"),
    @NamedQuery(name = "Tolerancia.findByEquipamentoId", query = "SELECT t FROM Tolerancia t WHERE t.equipamentoId = :equipamentoId"),
    @NamedQuery(name = "Tolerancia.findBySistemaMedicaoId", query = "SELECT t FROM Tolerancia t WHERE t.sistemaMedicaoId = :sistemaMedicaoId"),
    @NamedQuery(name = "Tolerancia.findByToleranciaValor", query = "SELECT t FROM Tolerancia t WHERE t.toleranciaValor = :toleranciaValor")})
public class Tolerancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tolerancia_id")
    private Integer toleranciaId;
    @Column(name = "equipamento_id")
    private Integer equipamentoId;
    @Basic(optional = false)
    @Column(name = "sistema_medicao_id")
    private String sistemaMedicaoId;
    @Basic(optional = false)
    @Column(name = "tolerancia_valor")
    private double toleranciaValor;

    public Tolerancia() {
    }

    public Tolerancia(Integer toleranciaId) {
        this.toleranciaId = toleranciaId;
    }

    public Tolerancia(Integer toleranciaId, String sistemaMedicaoId, double toleranciaValor) {
        this.toleranciaId = toleranciaId;
        this.sistemaMedicaoId = sistemaMedicaoId;
        this.toleranciaValor = toleranciaValor;
    }

    public Integer getToleranciaId() {
        return toleranciaId;
    }

    public void setToleranciaId(Integer toleranciaId) {
        this.toleranciaId = toleranciaId;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
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
        hash += (toleranciaId != null ? toleranciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tolerancia)) {
            return false;
        }
        Tolerancia other = (Tolerancia) object;
        if ((this.toleranciaId == null && other.toleranciaId != null) || (this.toleranciaId != null && !this.toleranciaId.equals(other.toleranciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Tolerancia[ toleranciaId=" + toleranciaId + " ]";
    }
    
}
