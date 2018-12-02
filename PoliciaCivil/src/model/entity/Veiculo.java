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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "veiculo", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")
    , @NamedQuery(name = "Veiculo.findByNumchassi", query = "SELECT v FROM Veiculo v WHERE v.veiculoPK.numchassi = :numchassi")
    , @NamedQuery(name = "Veiculo.findByPlaca", query = "SELECT v FROM Veiculo v WHERE v.veiculoPK.placa = :placa")
    , @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Veiculo.findByAnofabricacao", query = "SELECT v FROM Veiculo v WHERE v.anofabricacao = :anofabricacao")
    , @NamedQuery(name = "Veiculo.findByAno", query = "SELECT v FROM Veiculo v WHERE v.ano = :ano")
    , @NamedQuery(name = "Veiculo.findByFabricacao", query = "SELECT v FROM Veiculo v WHERE v.fabricacao = :fabricacao")
    , @NamedQuery(name = "Veiculo.findByCor", query = "SELECT v FROM Veiculo v WHERE v.cor = :cor")})
public class Veiculo extends Evidencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;

    protected VeiculoPK veiculoPK;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "anofabricacao")
    @Temporal(TemporalType.DATE)
    private Date anofabricacao;
    @Basic(optional = false)
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Column(name = "fabricacao")
    private String fabricacao;
    @Basic(optional = false)
    @Column(name = "cor")
    private String cor;

    public Veiculo() {
    }

    public Veiculo(VeiculoPK veiculoPK) {
        this.veiculoPK = veiculoPK;
    }

    public Veiculo(VeiculoPK veiculoPK, String modelo, Date anofabricacao, Date ano, String cor) {
        this.veiculoPK = veiculoPK;
        this.modelo = modelo;
        this.anofabricacao = anofabricacao;
        this.ano = ano;
        this.cor = cor;
    }

    public Veiculo(String numchassi, String placa) {
        this.veiculoPK = new VeiculoPK(numchassi, placa);
    }

    public VeiculoPK getVeiculoPK() {
        return veiculoPK;
    }

    public void setVeiculoPK(VeiculoPK veiculoPK) {
        this.veiculoPK = veiculoPK;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public Date getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(Date anofabricacao) {
        Date oldAnofabricacao = this.anofabricacao;
        this.anofabricacao = anofabricacao;
        changeSupport.firePropertyChange("anofabricacao", oldAnofabricacao, anofabricacao);
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        Date oldAno = this.ano;
        this.ano = ano;
        changeSupport.firePropertyChange("ano", oldAno, ano);
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        String oldFabricacao = this.fabricacao;
        this.fabricacao = fabricacao;
        changeSupport.firePropertyChange("fabricacao", oldFabricacao, fabricacao);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        String oldCor = this.cor;
        this.cor = cor;
        changeSupport.firePropertyChange("cor", oldCor, cor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (veiculoPK != null ? veiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.veiculoPK == null && other.veiculoPK != null) || (this.veiculoPK != null && !this.veiculoPK.equals(other.veiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Veiculo[ veiculoPK=" + veiculoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
