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
@Table(name = "frequencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frequencia.findAll", query = "SELECT f FROM Frequencia f"),
    @NamedQuery(name = "Frequencia.findByFrequenciaId", query = "SELECT f FROM Frequencia f WHERE f.frequenciaId = :frequenciaId"),
    @NamedQuery(name = "Frequencia.findByEquipamentoId", query = "SELECT f FROM Frequencia f WHERE f.equipamentoId = :equipamentoId"),
    @NamedQuery(name = "Frequencia.findByFrequenciaCalibracao", query = "SELECT f FROM Frequencia f WHERE f.frequenciaCalibracao = :frequenciaCalibracao")})
public class Frequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "frequencia_id")
    private Integer frequenciaId;
    @Column(name = "equipamento_id")
    private Integer equipamentoId;
    @Basic(optional = false)
    @Column(name = "frequencia_calibracao")
    private String frequenciaCalibracao;

    public Frequencia() {
    }

    public Frequencia(Integer frequenciaId) {
        this.frequenciaId = frequenciaId;
    }

    public Frequencia(Integer frequenciaId, String frequenciaCalibracao) {
        this.frequenciaId = frequenciaId;
        this.frequenciaCalibracao = frequenciaCalibracao;
    }

    public Integer getFrequenciaId() {
        return frequenciaId;
    }

    public void setFrequenciaId(Integer frequenciaId) {
        this.frequenciaId = frequenciaId;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getFrequenciaCalibracao() {
        return frequenciaCalibracao;
    }

    public void setFrequenciaCalibracao(String frequenciaCalibracao) {
        this.frequenciaCalibracao = frequenciaCalibracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frequenciaId != null ? frequenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frequencia)) {
            return false;
        }
        Frequencia other = (Frequencia) object;
        if ((this.frequenciaId == null && other.frequenciaId != null) || (this.frequenciaId != null && !this.frequenciaId.equals(other.frequenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Frequencia[ frequenciaId=" + frequenciaId + " ]";
    }
    
}
