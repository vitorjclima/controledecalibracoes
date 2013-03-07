/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vitor
 */
@Entity
@Table(name = "condicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condicao.findAll", query = "SELECT c FROM Condicao c"),
    @NamedQuery(name = "Condicao.findByCondicaoId", query = "SELECT c FROM Condicao c WHERE c.condicaoId = :condicaoId"),
    @NamedQuery(name = "Condicao.findByEquipamentoId", query = "SELECT c FROM Condicao c WHERE c.equipamentoId = :equipamentoId"),
    @NamedQuery(name = "Condicao.findByCondicaoEquipamento", query = "SELECT c FROM Condicao c WHERE c.condicaoEquipamento = :condicaoEquipamento"),
    @NamedQuery(name = "Condicao.findByCondicaoDataInicio", query = "SELECT c FROM Condicao c WHERE c.condicaoDataInicio = :condicaoDataInicio")})
public class Condicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "condicao_id")
    private Integer condicaoId;
    @Column(name = "equipamento_id")
    private Integer equipamentoId;
    @Basic(optional = false)
    @Column(name = "condicao_equipamento")
    private String condicaoEquipamento;
    @Basic(optional = false)
    @Column(name = "condicao_data_inicio")
    @Temporal(TemporalType.DATE)
    private Date condicaoDataInicio;

    public Condicao() {
    }

    public Condicao(Integer condicaoId) {
        this.condicaoId = condicaoId;
    }

    public Condicao(Integer condicaoId, String condicaoEquipamento, Date condicaoDataInicio) {
        this.condicaoId = condicaoId;
        this.condicaoEquipamento = condicaoEquipamento;
        this.condicaoDataInicio = condicaoDataInicio;
    }

    public Integer getCondicaoId() {
        return condicaoId;
    }

    public void setCondicaoId(Integer condicaoId) {
        this.condicaoId = condicaoId;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getCondicaoEquipamento() {
        return condicaoEquipamento;
    }

    public void setCondicaoEquipamento(String condicaoEquipamento) {
        this.condicaoEquipamento = condicaoEquipamento;
    }

    public Date getCondicaoDataInicio() {
        return condicaoDataInicio;
    }

    public void setCondicaoDataInicio(Date condicaoDataInicio) {
        this.condicaoDataInicio = condicaoDataInicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (condicaoId != null ? condicaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condicao)) {
            return false;
        }
        Condicao other = (Condicao) object;
        if ((this.condicaoId == null && other.condicaoId != null) || (this.condicaoId != null && !this.condicaoId.equals(other.condicaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Condicao[ condicaoId=" + condicaoId + " ]";
    }
    
}
