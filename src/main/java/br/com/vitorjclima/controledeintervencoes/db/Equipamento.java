/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

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
    @NamedQuery(name = "Equipamento.findByEquipamentoDescricao", query = "SELECT e FROM Equipamento e WHERE e.equipamentoDescricao = :equipamentoDescricao"),
    @NamedQuery(name = "Equipamento.findByEquipamentoFaixaMedicao", query = "SELECT e FROM Equipamento e WHERE e.equipamentoFaixaMedicao = :equipamentoFaixaMedicao"),
    @NamedQuery(name = "Equipamento.findByEquipamentoMenorDivisao", query = "SELECT e FROM Equipamento e WHERE e.equipamentoMenorDivisao = :equipamentoMenorDivisao"),
    @NamedQuery(name = "Equipamento.findByEquipamentoModelo", query = "SELECT e FROM Equipamento e WHERE e.equipamentoModelo = :equipamentoModelo"),
    @NamedQuery(name = "Equipamento.findByEquipamentoNumeroSerie", query = "SELECT e FROM Equipamento e WHERE e.equipamentoNumeroSerie = :equipamentoNumeroSerie")})
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "equipamento_id")
    private Integer equipamentoId;
    @Column(name = "empresa_id")
    private Integer empresaId;
    @Column(name = "equipamento_descricao")
    private String equipamentoDescricao;
    @Column(name = "equipamento_faixa_medicao")
    private String equipamentoFaixaMedicao;
    @Column(name = "equipamento_menor_divisao")
    private String equipamentoMenorDivisao;
    @Column(name = "equipamento_modelo")
    private String equipamentoModelo;
    @Column(name = "equipamento_numero_serie")
    private String equipamentoNumeroSerie;

    public Equipamento() {
    }

    public Equipamento(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getEquipamentoDescricao() {
        return equipamentoDescricao;
    }

    public void setEquipamentoDescricao(String equipamentoDescricao) {
        this.equipamentoDescricao = equipamentoDescricao;
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
        return "br.com.vitorjclima.controledeintervencoes.db.Equipamento[ equipamentoId=" + equipamentoId + " ]";
    }
    
}
