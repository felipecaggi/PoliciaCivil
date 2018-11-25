/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hueli
 */
@Entity
@Table(name = "arma", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Arma.findAll", query = "SELECT a FROM Arma a")
    , @NamedQuery(name = "Arma.findByCalibre", query = "SELECT a FROM Arma a WHERE a.armaPK.calibre = :calibre")
    , @NamedQuery(name = "Arma.findByNumserie", query = "SELECT a FROM Arma a WHERE a.armaPK.numserie = :numserie")
    , @NamedQuery(name = "Arma.findByFabricante", query = "SELECT a FROM Arma a WHERE a.fabricante = :fabricante")
    , @NamedQuery(name = "Arma.findByModelo", query = "SELECT a FROM Arma a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Arma.findByIdevidencia", query = "SELECT a FROM Arma a WHERE a.armaPK.idevidencia = :idevidencia")})
public class Arma implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArmaPK armaPK;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "modelo")
    private String modelo;

    public Arma() {
    }

    public Arma(ArmaPK armaPK) {
        this.armaPK = armaPK;
    }

    public Arma(String calibre, String numserie, int idevidencia) {
        this.armaPK = new ArmaPK(calibre, numserie, idevidencia);
    }

    public ArmaPK getArmaPK() {
        return armaPK;
    }

    public void setArmaPK(ArmaPK armaPK) {
        this.armaPK = armaPK;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        String oldFabricante = this.fabricante;
        this.fabricante = fabricante;
        changeSupport.firePropertyChange("fabricante", oldFabricante, fabricante);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (armaPK != null ? armaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arma)) {
            return false;
        }
        Arma other = (Arma) object;
        if ((this.armaPK == null && other.armaPK != null) || (this.armaPK != null && !this.armaPK.equals(other.armaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Arma[ armaPK=" + armaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
