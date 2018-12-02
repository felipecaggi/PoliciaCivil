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
@Table(name = "substancia", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Substancia.findAll", query = "SELECT s FROM Substancia s")
    , @NamedQuery(name = "Substancia.findByTipo", query = "SELECT s FROM Substancia s WHERE s.substanciaPK.tipo = :tipo")
    , @NamedQuery(name = "Substancia.findByPeso", query = "SELECT s FROM Substancia s WHERE s.peso = :peso")
    , @NamedQuery(name = "Substancia.findByEmbalagem", query = "SELECT s FROM Substancia s WHERE s.embalagem = :embalagem")
    , @NamedQuery(name = "Substancia.findByAltura", query = "SELECT s FROM Substancia s WHERE s.altura = :altura")
    , @NamedQuery(name = "Substancia.findByComprimento", query = "SELECT s FROM Substancia s WHERE s.comprimento = :comprimento")
    , @NamedQuery(name = "Substancia.findByLargura", query = "SELECT s FROM Substancia s WHERE s.largura = :largura")
    , @NamedQuery(name = "Substancia.findByQtd", query = "SELECT s FROM Substancia s WHERE s.qtd = :qtd")})
public class Substancia extends Evidencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    protected SubstanciaPK substanciaPK;
    @Basic(optional = false)
    @Column(name = "peso")
    private int peso;
    @Column(name = "embalagem")
    private String embalagem;
    @Column(name = "altura")
    private Integer altura;
    @Column(name = "comprimento")
    private Integer comprimento;
    @Column(name = "largura")
    private Integer largura;
    @Column(name = "qtd")
    private Integer qtd;

    public Substancia() {
    }

    public Substancia(SubstanciaPK substanciaPK) {
        this.substanciaPK = substanciaPK;
    }

    public Substancia(SubstanciaPK substanciaPK, int peso) {
        this.substanciaPK = substanciaPK;
        this.peso = peso;
    }

    public Substancia(String tipo) {
        this.substanciaPK = new SubstanciaPK(tipo);
    }

    public SubstanciaPK getSubstanciaPK() {
        return substanciaPK;
    }

    public void setSubstanciaPK(SubstanciaPK substanciaPK) {
        this.substanciaPK = substanciaPK;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        int oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        String oldEmbalagem = this.embalagem;
        this.embalagem = embalagem;
        changeSupport.firePropertyChange("embalagem", oldEmbalagem, embalagem);
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        Integer oldAltura = this.altura;
        this.altura = altura;
        changeSupport.firePropertyChange("altura", oldAltura, altura);
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        Integer oldComprimento = this.comprimento;
        this.comprimento = comprimento;
        changeSupport.firePropertyChange("comprimento", oldComprimento, comprimento);
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        Integer oldLargura = this.largura;
        this.largura = largura;
        changeSupport.firePropertyChange("largura", oldLargura, largura);
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        Integer oldQtd = this.qtd;
        this.qtd = qtd;
        changeSupport.firePropertyChange("qtd", oldQtd, qtd);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (substanciaPK != null ? substanciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Substancia)) {
            return false;
        }
        Substancia other = (Substancia) object;
        if ((this.substanciaPK == null && other.substanciaPK != null) || (this.substanciaPK != null && !this.substanciaPK.equals(other.substanciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Substancia[ substanciaPK=" + substanciaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
