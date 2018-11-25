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
@Table(name = "celular", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Celular.findAll", query = "SELECT c FROM Celular c")
    , @NamedQuery(name = "Celular.findByImei", query = "SELECT c FROM Celular c WHERE c.celularPK.imei = :imei")
    , @NamedQuery(name = "Celular.findByNumero", query = "SELECT c FROM Celular c WHERE c.numero = :numero")
    , @NamedQuery(name = "Celular.findByFabricacao", query = "SELECT c FROM Celular c WHERE c.fabricacao = :fabricacao")
    , @NamedQuery(name = "Celular.findByModelo", query = "SELECT c FROM Celular c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Celular.findByNome", query = "SELECT c FROM Celular c WHERE c.nome = :nome")
    , @NamedQuery(name = "Celular.findByCpfproprietario", query = "SELECT c FROM Celular c WHERE c.cpfproprietario = :cpfproprietario")
    , @NamedQuery(name = "Celular.findByNomeproprietario", query = "SELECT c FROM Celular c WHERE c.nomeproprietario = :nomeproprietario")
    , @NamedQuery(name = "Celular.findByIdevidencia", query = "SELECT c FROM Celular c WHERE c.celularPK.idevidencia = :idevidencia")})
public class Celular implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CelularPK celularPK;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Column(name = "fabricacao")
    private String fabricacao;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cpfproprietario")
    private String cpfproprietario;
    @Basic(optional = false)
    @Column(name = "nomeproprietario")
    private String nomeproprietario;

    public Celular() {
    }

    public Celular(CelularPK celularPK) {
        this.celularPK = celularPK;
    }

    public Celular(CelularPK celularPK, int numero, String modelo, String nome, String cpfproprietario, String nomeproprietario) {
        this.celularPK = celularPK;
        this.numero = numero;
        this.modelo = modelo;
        this.nome = nome;
        this.cpfproprietario = cpfproprietario;
        this.nomeproprietario = nomeproprietario;
    }

    public Celular(String imei, int idevidencia) {
        this.celularPK = new CelularPK(imei, idevidencia);
    }

    public CelularPK getCelularPK() {
        return celularPK;
    }

    public void setCelularPK(CelularPK celularPK) {
        this.celularPK = celularPK;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        int oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        String oldFabricacao = this.fabricacao;
        this.fabricacao = fabricacao;
        changeSupport.firePropertyChange("fabricacao", oldFabricacao, fabricacao);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCpfproprietario() {
        return cpfproprietario;
    }

    public void setCpfproprietario(String cpfproprietario) {
        String oldCpfproprietario = this.cpfproprietario;
        this.cpfproprietario = cpfproprietario;
        changeSupport.firePropertyChange("cpfproprietario", oldCpfproprietario, cpfproprietario);
    }

    public String getNomeproprietario() {
        return nomeproprietario;
    }

    public void setNomeproprietario(String nomeproprietario) {
        String oldNomeproprietario = this.nomeproprietario;
        this.nomeproprietario = nomeproprietario;
        changeSupport.firePropertyChange("nomeproprietario", oldNomeproprietario, nomeproprietario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (celularPK != null ? celularPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Celular)) {
            return false;
        }
        Celular other = (Celular) object;
        if ((this.celularPK == null && other.celularPK != null) || (this.celularPK != null && !this.celularPK.equals(other.celularPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Celular[ celularPK=" + celularPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
