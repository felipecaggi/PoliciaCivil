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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    , @NamedQuery(name = "Policial.findByIdpol", query = "SELECT p FROM Policial p WHERE p.idPolicial = :idpol")
    , @NamedQuery(name = "Policial.findByNome", query = "SELECT p FROM Policial p WHERE p.nome = :nome")
    , @NamedQuery(name = "Policial.findByLogin", query = "SELECT p FROM Policial p WHERE p.login = :login")
    , @NamedQuery(name = "Policial.findBySenha", query = "SELECT p FROM Policial p WHERE p.senha = :senha")
    , @NamedQuery(name = "Policial.findByCargo", query = "SELECT p FROM Policial p WHERE p.cargo = :cargo")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Policial implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPolicial")
    private Integer idPolicial;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;

    public Policial() {
    }

    public Policial(Integer idpol) {
        this.idPolicial = idpol;
    }

    public Policial(Integer idpol, String nome, String login, String senha, String cargo) {
        this.idPolicial = idpol;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Integer getIdPolicial() {
        return idPolicial;
    }

    public void setIdPolicial(Integer idPolicial) {
        Integer oldIdpol = this.idPolicial;
        this.idPolicial = idPolicial;
        changeSupport.firePropertyChange("idpol", oldIdpol, idPolicial);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
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
        hash += (idPolicial != null ? idPolicial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Policial)) {
            return false;
        }
        Policial other = (Policial) object;
        if ((this.idPolicial == null && other.idPolicial != null) || (this.idPolicial != null && !this.idPolicial.equals(other.idPolicial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Policial[ idpol=" + idPolicial + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
