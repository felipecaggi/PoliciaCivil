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
@Table(name = "mandado", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Mandado.findAll", query = "SELECT m FROM Mandado m")
    , @NamedQuery(name = "Mandado.findByIdman", query = "SELECT m FROM Mandado m WHERE m.idman = :idman")
    , @NamedQuery(name = "Mandado.findByDataexpedicao", query = "SELECT m FROM Mandado m WHERE m.dataexpedicao = :dataexpedicao")
    , @NamedQuery(name = "Mandado.findByIddelegado", query = "SELECT m FROM Mandado m WHERE m.iddelegado = :iddelegado")
    , @NamedQuery(name = "Mandado.findByCpfcidadao", query = "SELECT m FROM Mandado m WHERE m.cpfcidadao = :cpfcidadao")})
public class Mandado implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idman")
    private Integer idman;
    @Basic(optional = false)
    @Column(name = "dataexpedicao")
    @Temporal(TemporalType.DATE)
    private Date dataexpedicao;
    @Basic(optional = false)
    @Column(name = "iddelegado")
    private int iddelegado;
    @Basic(optional = false)
    @Column(name = "cpfcidadao")
    private String cpfcidadao;

    public Mandado() {
    }

    public Mandado(Integer idman) {
        this.idman = idman;
    }

    public Mandado(Integer idman, Date dataexpedicao, int iddelegado, String cpfcidadao) {
        this.idman = idman;
        this.dataexpedicao = dataexpedicao;
        this.iddelegado = iddelegado;
        this.cpfcidadao = cpfcidadao;
    }

    public Integer getIdman() {
        return idman;
    }

    public void setIdman(Integer idman) {
        Integer oldIdman = this.idman;
        this.idman = idman;
        changeSupport.firePropertyChange("idman", oldIdman, idman);
    }

    public Date getDataexpedicao() {
        return dataexpedicao;
    }

    public void setDataexpedicao(Date dataexpedicao) {
        Date oldDataexpedicao = this.dataexpedicao;
        this.dataexpedicao = dataexpedicao;
        changeSupport.firePropertyChange("dataexpedicao", oldDataexpedicao, dataexpedicao);
    }

    public int getIddelegado() {
        return iddelegado;
    }

    public void setIddelegado(int iddelegado) {
        int oldIddelegado = this.iddelegado;
        this.iddelegado = iddelegado;
        changeSupport.firePropertyChange("iddelegado", oldIddelegado, iddelegado);
    }

    public String getCpfcidadao() {
        return cpfcidadao;
    }

    public void setCpfcidadao(String cpfcidadao) {
        String oldCpfcidadao = this.cpfcidadao;
        this.cpfcidadao = cpfcidadao;
        changeSupport.firePropertyChange("cpfcidadao", oldCpfcidadao, cpfcidadao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idman != null ? idman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mandado)) {
            return false;
        }
        Mandado other = (Mandado) object;
        if ((this.idman == null && other.idman != null) || (this.idman != null && !this.idman.equals(other.idman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Mandado[ idman=" + idman + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
