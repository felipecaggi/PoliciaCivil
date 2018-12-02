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
@Table(name = "delegacia", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Delegacia.findAll", query = "SELECT d FROM Delegacia d")
    , @NamedQuery(name = "Delegacia.findByIddel", query = "SELECT d FROM Delegacia d WHERE d.idDelegacia = :iddel")
    , @NamedQuery(name = "Delegacia.findByNome", query = "SELECT d FROM Delegacia d WHERE d.nome = :nome")
    , @NamedQuery(name = "Delegacia.findBySigla", query = "SELECT d FROM Delegacia d WHERE d.sigla = :sigla")})
public class Delegacia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDelegacia")
    private Integer idDelegacia;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sigla")
    private String sigla;

    public Delegacia() {
    }

    public Delegacia(Integer iddel) {
        this.idDelegacia = iddel;
    }

    public Delegacia(Integer iddel, String nome, String sigla) {
        this.idDelegacia = iddel;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getIdDelegacia() {
        return idDelegacia;
    }

    public void setIdDelegacia(Integer idDelegacia) {
        Integer oldIddel = this.idDelegacia;
        this.idDelegacia = idDelegacia;
        changeSupport.firePropertyChange("iddel", oldIddel, idDelegacia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        String oldSigla = this.sigla;
        this.sigla = sigla;
        changeSupport.firePropertyChange("sigla", oldSigla, sigla);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelegacia != null ? idDelegacia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delegacia)) {
            return false;
        }
        Delegacia other = (Delegacia) object;
        if ((this.idDelegacia == null && other.idDelegacia != null) || (this.idDelegacia != null && !this.idDelegacia.equals(other.idDelegacia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Delegacia[ iddel=" + idDelegacia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
