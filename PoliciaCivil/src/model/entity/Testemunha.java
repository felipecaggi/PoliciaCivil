/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "testemunha", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Testemunha.findAll", query = "SELECT t FROM Testemunha t")
    , @NamedQuery(name = "Testemunha.findByIdocorrencia", query = "SELECT t FROM Testemunha t WHERE t.testemunhaPK.idocorrencia = :idocorrencia")
    , @NamedQuery(name = "Testemunha.findByCpfcidadao", query = "SELECT t FROM Testemunha t WHERE t.testemunhaPK.cpfcidadao = :cpfcidadao")})
public class Testemunha implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TestemunhaPK testemunhaPK;

    public Testemunha() {
    }

    public Testemunha(TestemunhaPK testemunhaPK) {
        this.testemunhaPK = testemunhaPK;
    }

    public Testemunha(int idocorrencia, String cpfcidadao) {
        this.testemunhaPK = new TestemunhaPK(idocorrencia, cpfcidadao);
    }

    public TestemunhaPK getTestemunhaPK() {
        return testemunhaPK;
    }

    public void setTestemunhaPK(TestemunhaPK testemunhaPK) {
        this.testemunhaPK = testemunhaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testemunhaPK != null ? testemunhaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testemunha)) {
            return false;
        }
        Testemunha other = (Testemunha) object;
        if ((this.testemunhaPK == null && other.testemunhaPK != null) || (this.testemunhaPK != null && !this.testemunhaPK.equals(other.testemunhaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Testemunha[ testemunhaPK=" + testemunhaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
