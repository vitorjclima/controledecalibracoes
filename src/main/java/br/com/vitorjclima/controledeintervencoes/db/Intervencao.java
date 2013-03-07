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
@Table(name = "intervencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervencao.findAll", query = "SELECT i FROM Intervencao i"),
    @NamedQuery(name = "Intervencao.findByIntervencaoId", query = "SELECT i FROM Intervencao i WHERE i.intervencaoId = :intervencaoId"),
    @NamedQuery(name = "Intervencao.findByEquipamentoId", query = "SELECT i FROM Intervencao i WHERE i.equipamentoId = :equipamentoId"),
    @NamedQuery(name = "Intervencao.findByIntervencaoTipoId", query = "SELECT i FROM Intervencao i WHERE i.intervencaoTipoId = :intervencaoTipoId"),
    @NamedQuery(name = "Intervencao.findByEmpresaId", query = "SELECT i FROM Intervencao i WHERE i.empresaId = :empresaId"),
    @NamedQuery(name = "Intervencao.findByIntervencaoEmpresaCodigoLaudo", query = "SELECT i FROM Intervencao i WHERE i.intervencaoEmpresaCodigoLaudo = :intervencaoEmpresaCodigoLaudo"),
    @NamedQuery(name = "Intervencao.findByIntervencaoData", query = "SELECT i FROM Intervencao i WHERE i.intervencaoData = :intervencaoData"),
    @NamedQuery(name = "Intervencao.findByIntervencaoAceitaPor", query = "SELECT i FROM Intervencao i WHERE i.intervencaoAceitaPor = :intervencaoAceitaPor"),
    @NamedQuery(name = "Intervencao.findByIntervencaoObservacao", query = "SELECT i FROM Intervencao i WHERE i.intervencaoObservacao = :intervencaoObservacao")})
public class Intervencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "intervencao_id")
    private Integer intervencaoId;
    @Column(name = "equipamento_id")
    private Integer equipamentoId;
    @Basic(optional = false)
    @Column(name = "intervencao_tipo_id")
    private String intervencaoTipoId;
    @Basic(optional = false)
    @Column(name = "empresa_id")
    private int empresaId;
    @Basic(optional = false)
    @Column(name = "intervencao_empresa_codigo_laudo")
    private String intervencaoEmpresaCodigoLaudo;
    @Basic(optional = false)
    @Column(name = "intervencao_data")
    @Temporal(TemporalType.DATE)
    private Date intervencaoData;
    @Basic(optional = false)
    @Column(name = "intervencao_aceita_por")
    private String intervencaoAceitaPor;
    @Basic(optional = false)
    @Column(name = "intervencao_observacao")
    private String intervencaoObservacao;

    public Intervencao() {
    }

    public Intervencao(Integer intervencaoId) {
        this.intervencaoId = intervencaoId;
    }

    public Intervencao(Integer intervencaoId, String intervencaoTipoId, int empresaId, String intervencaoEmpresaCodigoLaudo, Date intervencaoData, String intervencaoAceitaPor, String intervencaoObservacao) {
        this.intervencaoId = intervencaoId;
        this.intervencaoTipoId = intervencaoTipoId;
        this.empresaId = empresaId;
        this.intervencaoEmpresaCodigoLaudo = intervencaoEmpresaCodigoLaudo;
        this.intervencaoData = intervencaoData;
        this.intervencaoAceitaPor = intervencaoAceitaPor;
        this.intervencaoObservacao = intervencaoObservacao;
    }

    public Integer getIntervencaoId() {
        return intervencaoId;
    }

    public void setIntervencaoId(Integer intervencaoId) {
        this.intervencaoId = intervencaoId;
    }

    public Integer getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getIntervencaoTipoId() {
        return intervencaoTipoId;
    }

    public void setIntervencaoTipoId(String intervencaoTipoId) {
        this.intervencaoTipoId = intervencaoTipoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getIntervencaoEmpresaCodigoLaudo() {
        return intervencaoEmpresaCodigoLaudo;
    }

    public void setIntervencaoEmpresaCodigoLaudo(String intervencaoEmpresaCodigoLaudo) {
        this.intervencaoEmpresaCodigoLaudo = intervencaoEmpresaCodigoLaudo;
    }

    public Date getIntervencaoData() {
        return intervencaoData;
    }

    public void setIntervencaoData(Date intervencaoData) {
        this.intervencaoData = intervencaoData;
    }

    public String getIntervencaoAceitaPor() {
        return intervencaoAceitaPor;
    }

    public void setIntervencaoAceitaPor(String intervencaoAceitaPor) {
        this.intervencaoAceitaPor = intervencaoAceitaPor;
    }

    public String getIntervencaoObservacao() {
        return intervencaoObservacao;
    }

    public void setIntervencaoObservacao(String intervencaoObservacao) {
        this.intervencaoObservacao = intervencaoObservacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intervencaoId != null ? intervencaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervencao)) {
            return false;
        }
        Intervencao other = (Intervencao) object;
        if ((this.intervencaoId == null && other.intervencaoId != null) || (this.intervencaoId != null && !this.intervencaoId.equals(other.intervencaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.Intervencao[ intervencaoId=" + intervencaoId + " ]";
    }
    
}
