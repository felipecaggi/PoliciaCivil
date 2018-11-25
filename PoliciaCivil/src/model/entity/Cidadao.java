/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "cidadao", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Cidadao.findAll", query = "SELECT c FROM Cidadao c")
    , @NamedQuery(name = "Cidadao.findByCpf", query = "SELECT c FROM Cidadao c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Cidadao.findByNome", query = "SELECT c FROM Cidadao c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cidadao.findByDatanasc", query = "SELECT c FROM Cidadao c WHERE c.datanasc = :datanasc")
    , @NamedQuery(name = "Cidadao.findByRg", query = "SELECT c FROM Cidadao c WHERE c.rg = :rg")
    , @NamedQuery(name = "Cidadao.findByTelefone", query = "SELECT c FROM Cidadao c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Cidadao.findByEstadoorigem", query = "SELECT c FROM Cidadao c WHERE c.estadoorigem = :estadoorigem")
    , @NamedQuery(name = "Cidadao.findByCidadeorigem", query = "SELECT c FROM Cidadao c WHERE c.cidadeorigem = :cidadeorigem")
    , @NamedQuery(name = "Cidadao.findByStatus", query = "SELECT c FROM Cidadao c WHERE c.status = :status")
    , @NamedQuery(name = "Cidadao.findByAlcunha", query = "SELECT c FROM Cidadao c WHERE c.alcunha = :alcunha")
    , @NamedQuery(name = "Cidadao.findByIdendereco", query = "SELECT c FROM Cidadao c WHERE c.idendereco = :idendereco")})
public class Cidadao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "datanasc")
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "telefone")
    private int telefone;
    @Basic(optional = false)
    @Column(name = "estadoorigem")
    private String estadoorigem;
    @Basic(optional = false)
    @Column(name = "cidadeorigem")
    private String cidadeorigem;
    @Column(name = "status")
    private String status;
    @Column(name = "alcunha")
    private String alcunha;
    @Basic(optional = false)
    @Column(name = "idendereco")
    private int idendereco;

    public Cidadao() {
    }

    public Cidadao(String cpf) {
        this.cpf = cpf;
    }

    public Cidadao(String cpf, String nome, Date datanasc, String rg, int telefone, String estadoorigem, String cidadeorigem, int idendereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.datanasc = datanasc;
        this.rg = rg;
        this.telefone = telefone;
        this.estadoorigem = estadoorigem;
        this.cidadeorigem = cidadeorigem;
        this.idendereco = idendereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        Date oldDatanasc = this.datanasc;
        this.datanasc = datanasc;
        changeSupport.firePropertyChange("datanasc", oldDatanasc, datanasc);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        int oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getEstadoorigem() {
        return estadoorigem;
    }

    public void setEstadoorigem(String estadoorigem) {
        String oldEstadoorigem = this.estadoorigem;
        this.estadoorigem = estadoorigem;
        changeSupport.firePropertyChange("estadoorigem", oldEstadoorigem, estadoorigem);
    }

    public String getCidadeorigem() {
        return cidadeorigem;
    }

    public void setCidadeorigem(String cidadeorigem) {
        String oldCidadeorigem = this.cidadeorigem;
        this.cidadeorigem = cidadeorigem;
        changeSupport.firePropertyChange("cidadeorigem", oldCidadeorigem, cidadeorigem);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getAlcunha() {
        return alcunha;
    }

    public void setAlcunha(String alcunha) {
        String oldAlcunha = this.alcunha;
        this.alcunha = alcunha;
        changeSupport.firePropertyChange("alcunha", oldAlcunha, alcunha);
    }

    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        int oldIdendereco = this.idendereco;
        this.idendereco = idendereco;
        changeSupport.firePropertyChange("idendereco", oldIdendereco, idendereco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidadao)) {
            return false;
        }
        Cidadao other = (Cidadao) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cidadao{" + "cpf=" + cpf + ", nome=" + nome + ", datanasc=" + datanasc + ", rg=" + rg + ", telefone=" + telefone + ", estadoorigem=" + estadoorigem + ", cidadeorigem=" + cidadeorigem + ", status=" + status + ", alcunha=" + alcunha + ", idendereco=" + idendereco + '}';
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
