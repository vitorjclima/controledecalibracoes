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
@Table(name = "laudo_intervencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LaudoIntervencao.findAll", query = "SELECT l FROM LaudoIntervencao l"),
    @NamedQuery(name = "LaudoIntervencao.findByLaudoIntervencaoId", query = "SELECT l FROM LaudoIntervencao l WHERE l.laudoIntervencaoId = :laudoIntervencaoId"),
    @NamedQuery(name = "LaudoIntervencao.findBySistemaMedicaoId", query = "SELECT l FROM LaudoIntervencao l WHERE l.sistemaMedicaoId = :sistemaMedicaoId"),
    @NamedQuery(name = "LaudoIntervencao.findByIntervencaoId", query = "SELECT l FROM LaudoIntervencao l WHERE l.intervencaoId = :intervencaoId"),
    @NamedQuery(name = "LaudoIntervencao.findByLaudoIntervencaoValorPadrao", query = "SELECT l FROM LaudoIntervencao l WHERE l.laudoIntervencaoValorPadrao = :laudoIntervencaoValorPadrao"),
    @NamedQuery(name = "LaudoIntervencao.findByLaudoIntervencaoMediaMedicoes", query = "SELECT l FROM LaudoIntervencao l WHERE l.laudoIntervencaoMediaMedicoes = :laudoIntervencaoMediaMedicoes"),
    @NamedQuery(name = "LaudoIntervencao.findByLaudoIntervencaoIncertezaMedicoes", query = "SELECT l FROM LaudoIntervencao l WHERE l.laudoIntervencaoIncertezaMedicoes = :laudoIntervencaoIncertezaMedicoes")})
public class LaudoIntervencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "laudo_intervencao_id")
    private Integer laudoIntervencaoId;
    @Basic(optional = false)
    @Column(name = "sistema_medicao_id")
    private String sistemaMedicaoId;
    @Basic(optional = false)
    @Column(name = "intervencao_id")
    private int intervencaoId;
    @Basic(optional = false)
    @Column(name = "laudo_intervencao_valor_padrao")
    private double laudoIntervencaoValorPadrao;
    @Basic(optional = false)
    @Column(name = "laudo_intervencao_media_medicoes")
    private double laudoIntervencaoMediaMedicoes;
    @Basic(optional = false)
    @Column(name = "laudo_intervencao_incerteza_medicoes")
    private double laudoIntervencaoIncertezaMedicoes;

    public LaudoIntervencao() {
    }

    public LaudoIntervencao(Integer laudoIntervencaoId) {
        this.laudoIntervencaoId = laudoIntervencaoId;
    }

    public LaudoIntervencao(Integer laudoIntervencaoId, String sistemaMedicaoId, int intervencaoId, double laudoIntervencaoValorPadrao, double laudoIntervencaoMediaMedicoes, double laudoIntervencaoIncertezaMedicoes) {
        this.laudoIntervencaoId = laudoIntervencaoId;
        this.sistemaMedicaoId = sistemaMedicaoId;
        this.intervencaoId = intervencaoId;
        this.laudoIntervencaoValorPadrao = laudoIntervencaoValorPadrao;
        this.laudoIntervencaoMediaMedicoes = laudoIntervencaoMediaMedicoes;
        this.laudoIntervencaoIncertezaMedicoes = laudoIntervencaoIncertezaMedicoes;
    }

    public Integer getLaudoIntervencaoId() {
        return laudoIntervencaoId;
    }

    public void setLaudoIntervencaoId(Integer laudoIntervencaoId) {
        this.laudoIntervencaoId = laudoIntervencaoId;
    }

    public String getSistemaMedicaoId() {
        return sistemaMedicaoId;
    }

    public void setSistemaMedicaoId(String sistemaMedicaoId) {
        this.sistemaMedicaoId = sistemaMedicaoId;
    }

    public int getIntervencaoId() {
        return intervencaoId;
    }

    public void setIntervencaoId(int intervencaoId) {
        this.intervencaoId = intervencaoId;
    }

    public double getLaudoIntervencaoValorPadrao() {
        return laudoIntervencaoValorPadrao;
    }

    public void setLaudoIntervencaoValorPadrao(double laudoIntervencaoValorPadrao) {
        this.laudoIntervencaoValorPadrao = laudoIntervencaoValorPadrao;
    }

    public double getLaudoIntervencaoMediaMedicoes() {
        return laudoIntervencaoMediaMedicoes;
    }

    public void setLaudoIntervencaoMediaMedicoes(double laudoIntervencaoMediaMedicoes) {
        this.laudoIntervencaoMediaMedicoes = laudoIntervencaoMediaMedicoes;
    }

    public double getLaudoIntervencaoIncertezaMedicoes() {
        return laudoIntervencaoIncertezaMedicoes;
    }

    public void setLaudoIntervencaoIncertezaMedicoes(double laudoIntervencaoIncertezaMedicoes) {
        this.laudoIntervencaoIncertezaMedicoes = laudoIntervencaoIncertezaMedicoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laudoIntervencaoId != null ? laudoIntervencaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaudoIntervencao)) {
            return false;
        }
        LaudoIntervencao other = (LaudoIntervencao) object;
        if ((this.laudoIntervencaoId == null && other.laudoIntervencaoId != null) || (this.laudoIntervencaoId != null && !this.laudoIntervencaoId.equals(other.laudoIntervencaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledeintervencoes.db.LaudoIntervencao[ laudoIntervencaoId=" + laudoIntervencaoId + " ]";
    }
    
}
