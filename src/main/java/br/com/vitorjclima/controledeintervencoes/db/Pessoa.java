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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByPessoaId", query = "SELECT p FROM Pessoa p WHERE p.pessoaId = :pessoaId"),
    @NamedQuery(name = "Pessoa.findByPessoaCpf", query = "SELECT p FROM Pessoa p WHERE p.pessoaCpf = :pessoaCpf"),
    @NamedQuery(name = "Pessoa.findByPessoaNome", query = "SELECT p FROM Pessoa p WHERE p.pessoaNome = :pessoaNome"),
    @NamedQuery(name = "Pessoa.findByPessoaEmail", query = "SELECT p FROM Pessoa p WHERE p.pessoaEmail = :pessoaEmail")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Basic(optional = false)
    @Column(name = "pessoa_cpf")
    private String pessoaCpf;
    @Basic(optional = false)
    @Column(name = "pessoa_nome")
    private String pessoaNome;
    @Basic(optional = false)
    @Column(name = "pessoa_email")
    private String pessoaEmail;

    public Pessoa() {
    }

    public Pessoa(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Pessoa(Integer pessoaId, String pessoaCpf, String pessoaNome, String pessoaEmail) {
        this.pessoaId = pessoaId;
        this.pessoaCpf = pessoaCpf;
        this.pessoaNome = pessoaNome;
        this.pessoaEmail = pessoaEmail;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaCpf() {
        return pessoaCpf;
    }

    public void setPessoaCpf(String pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getPessoaEmail() {
        return pessoaEmail;
    }

    public void setPessoaEmail(String pessoaEmail) {
        this.pessoaEmail = pessoaEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vitorjclima.controledecalibracoes.db.Pessoa[ pessoaId=" + pessoaId + " ]";
    }
    
}
