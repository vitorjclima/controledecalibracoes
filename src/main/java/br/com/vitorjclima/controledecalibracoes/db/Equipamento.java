/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledecalibracoes.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT e FROM Equipamento e"),
    @NamedQuery(name = "Equipamento.findByEquipamentoId", query = "SELECT e FROM Equipamento e WHERE e.equipamentoId = :equipamentoId"),
    @NamedQuery(name = "Equipamento.findByEmpresaId", query = "SELECT e FROM Equipamento e WHERE e.empresaId = :empresaId"),
    @NamedQuery(name = "Equipamento.findByIntervencaoId", query = "SELECT e FROM Equipamento e WHERE e.intervencaoId = :intervencaoId"),
    @NamedQuery(name = "Equipamento.findByEquipamentoDescricao", query = "SELECT e FROM Equipamento e WHERE e.equipamentoDescricao = :equipamentoDescricao"),
    @NamedQuery(name = "Equipamento.findByEquipamentoModelo", query = "SELECT e FROM Equipamento e WHERE e.equipamentoModelo = :equipamentoModelo"),
    @NamedQuery(name = "Equipamento.findByEquipamentoNumeroSerie", query = "SELECT e FROM Equipamento e WHERE e.equipamentoNumeroSerie = :equipamentoNumeroSerie"),
    @NamedQuery(name = "Equipamento.findByEquipamentoFaixaMedicao", query = "SELECT e FROM Equipamento e WHERE e.equipamentoFaixaMedicao = :equipamentoFaixaMedicao"),
    @NamedQuery(name = "Equipamento.findByEquipamentoMenorDivisao", query = "SELECT e FROM Equipamento e WHERE e.equipamentoMenorDivisao = :equipamentoMenorDivisao"),
    @NamedQuery(name = "Equipamento.findByEquipamentoTolerancia", query = "SELECT e FROM Equipamento e WHERE e.equipamentoTolerancia = :equipamentoTolerancia")})
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "equipamento_id")
    private Integer equipamentoId;
    @Basic(optional = false)
    @Column(name = "empresa_id")
    private int empresaId;
    @Basic(optional = false)
    @Column(name = "intervencao_id")
    private int intervencaoId;
    @Column(name = "equipamento_descricao")
    private String equipamentoDescricao;
    @Column(name = "equipamento_modelo")
    private String equipamentoModelo;
    @Basic(optional = false)
    @Column(name = "equipamento_numero_serie")
    private String equipamentoNumeroSerie;
    @Basic(optional = false)
    @Column(name = "equipamento_faixa_medicao")
    private String equipamentoFaixaMedicao;
    @Basic(optional = false)
    @Column(name = "equipamento_menor_divisao")
    private String equipamentoMenorDivisao;
    @Basic(optional = false)
    @Column(name = "equipamento_tolerancia")
    private double equipamentoTolerancia;

    public Equipamento() {
    }

    public Equipamento(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Equipamento(Integer equipamentoId, int empresaId, int intervencaoId, String equipamentoNumeroSerie, String equipamentoFaixaMedicao, String equipamentoMenorDivisao, double equipamentoTolerancia) {
        this.equipamentoId = equipamentoId;
        this.empresaId = empresaId;
        this.intervencaoId = intervencaoId;
        this.equipamentoNumeroSerie = equipamentoNumeroSerie;
        this.equipamentoFaixaMedicao = equipamentoFaixaMedicao;
        this.equipamentoMenorDivisao = equipamentoMenorDivisao;
        this.equipamentoTolerancia = equipamentoTolerancia;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getIntervencaoId() {
        return intervencaoId;
    }

    public void setIntervencaoId(int intervencaoId) {
        this.intervencaoId = intervencaoId;
    }

    public String getEquipamentoDescricao() {
        return equipamentoDescricao;
    }

    public void setEquipamentoDescricao(String equipamentoDescricao) {
        this.equipamentoDescricao = equipamentoDescricao;
    }

    public String getEquipamentoModelo() {
        return equipamentoModelo;
    }

    public void setEquipamentoModelo(String equipamentoModelo) {
        this.equipamentoModelo = equipamentoModelo;
    }

    public String getEquipamentoNumeroSerie() {
        return equipamentoNumeroSerie;
    }

    public void setEquipamentoNumeroSerie(String equipamentoNumeroSerie) {
        this.equipamentoNumeroSerie = equipamentoNumeroSerie;
    }

    public String getEquipamentoFaixaMedicao() {
        return equipamentoFaixaMedicao;
    }

    public void setEquipamentoFaixaMedicao(String equipamentoFaixaMedicao) {
        this.equipamentoFaixaMedicao = equipamentoFaixaMedicao;
    }

    public String getEquipamentoMenorDivisao() {
        return equipamentoMenorDivisao;
    }

    public void setEquipamentoMenorDivisao(String equipamentoMenorDivisao) {
        this.equipamentoMenorDivisao = equipamentoMenorDivisao;
    }

    public double getEquipamentoTolerancia() {
        return equipamentoTolerancia;
    }

    public void setEquipamentoTolerancia(double equipamentoTolerancia) {
        this.equipamentoTolerancia = equipamentoTolerancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipamentoId != null ? equipamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
        if ((this.equipamentoId == null && other.equipamentoId != null) || (this.equipamentoId != null && !this.equipamentoId.equals(other.equipamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledecalibracoes.db.Equipamento[ equipamentoId=" + equipamentoId + " ]";
    }
    
}
