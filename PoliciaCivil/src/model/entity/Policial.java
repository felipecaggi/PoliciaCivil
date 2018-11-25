/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "policial", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Policial.findAll", query = "SELECT p FROM Policial p")
    , @NamedQuery(name = "Policial.findByIdpol", query = "SELECT p FROM Policial p WHERE p.idpol = :idpol")
    , @NamedQuery(name = "Policial.findByNome", query = "SELECT p FROM Policial p WHERE p.nome = :nome")
    , @NamedQuery(name = "Policial.findByLoguin", query = "SELECT p FROM Policial p WHERE p.loguin = :loguin")
    , @NamedQuery(name = "Policial.findBySenha", query = "SELECT p FROM Policial p WHERE p.senha = :senha")
    , @NamedQuery(name = "Policial.findByCargo", query = "SELECT p FROM Policial p WHERE p.cargo = :cargo")})
public class Policial implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpol")
    private Integer idpol;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "loguin")
    private String loguin;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;

    public Policial() {
    }

    public Policial(Integer idpol) {
        this.idpol = idpol;
    }

    public Policial(Integer idpol, String nome, String loguin, String senha, String cargo) {
        this.idpol = idpol;
        this.nome = nome;
        this.loguin = loguin;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Integer getIdpol() {
        return idpol;
    }

    public void setIdpol(Integer idpol) {
        Integer oldIdpol = this.idpol;
        this.idpol = idpol;
        changeSupport.firePropertyChange("idpol", oldIdpol, idpol);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getLoguin() {
        return loguin;
    }

    public void setLoguin(String loguin) {
        String oldLoguin = this.loguin;
        this.loguin = loguin;
        changeSupport.firePropertyChange("loguin", oldLoguin, loguin);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpol != null ? idpol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Policial)) {
            return false;
        }
        Policial other = (Policial) object;
        if ((this.idpol == null && other.idpol != null) || (this.idpol != null && !this.idpol.equals(other.idpol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Policial[ idpol=" + idpol + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
