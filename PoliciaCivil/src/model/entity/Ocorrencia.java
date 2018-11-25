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
@Table(name = "ocorrencia", catalog = "policia", schema = "policiaschema")
@NamedQueries({
    @NamedQuery(name = "Ocorrencia.findAll", query = "SELECT o FROM Ocorrencia o")
    , @NamedQuery(name = "Ocorrencia.findByIdoco", query = "SELECT o FROM Ocorrencia o WHERE o.idoco = :idoco")
    , @NamedQuery(name = "Ocorrencia.findByDataocor", query = "SELECT o FROM Ocorrencia o WHERE o.dataocor = :dataocor")
    , @NamedQuery(name = "Ocorrencia.findByStatus", query = "SELECT o FROM Ocorrencia o WHERE o.status = :status")
    , @NamedQuery(name = "Ocorrencia.findByHorario", query = "SELECT o FROM Ocorrencia o WHERE o.horario = :horario")
    , @NamedQuery(name = "Ocorrencia.findByInfracao", query = "SELECT o FROM Ocorrencia o WHERE o.infracao = :infracao")
    , @NamedQuery(name = "Ocorrencia.findBySegredojustica", query = "SELECT o FROM Ocorrencia o WHERE o.segredojustica = :segredojustica")
    , @NamedQuery(name = "Ocorrencia.findByIdpolicial", query = "SELECT o FROM Ocorrencia o WHERE o.idpolicial = :idpolicial")
    , @NamedQuery(name = "Ocorrencia.findByIdendereco", query = "SELECT o FROM Ocorrencia o WHERE o.idendereco = :idendereco")
    , @NamedQuery(name = "Ocorrencia.findByIddelegacia", query = "SELECT o FROM Ocorrencia o WHERE o.iddelegacia = :iddelegacia")
    , @NamedQuery(name = "Ocorrencia.findByIddelegado", query = "SELECT o FROM Ocorrencia o WHERE o.iddelegado = :iddelegado")
    , @NamedQuery(name = "Ocorrencia.findByIdcomunicante", query = "SELECT o FROM Ocorrencia o WHERE o.idcomunicante = :idcomunicante")})
public class Ocorrencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idoco")
    private Integer idoco;
    @Basic(optional = false)
    @Column(name = "dataocor")
    @Temporal(TemporalType.DATE)
    private Date dataocor;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "horario")
    @Temporal(TemporalType.DATE)
    private Date horario;
    @Basic(optional = false)
    @Column(name = "infracao")
    private String infracao;
    @Basic(optional = false)
    @Column(name = "segredojustica")
    private boolean segredojustica;
    @Basic(optional = false)
    @Column(name = "idpolicial")
    private int idpolicial;
    @Basic(optional = false)
    @Column(name = "idendereco")
    private int idendereco;
    @Basic(optional = false)
    @Column(name = "iddelegacia")
    private int iddelegacia;
    @Basic(optional = false)
    @Column(name = "iddelegado")
    private int iddelegado;
    @Basic(optional = false)
    @Column(name = "idcomunicante")
    private String idcomunicante;

    public Ocorrencia() {
    }

    public Ocorrencia(Integer idoco) {
        this.idoco = idoco;
    }

    public Ocorrencia(Integer idoco, Date dataocor, String status, Date horario, String infracao, boolean segredojustica, int idpolicial, int idendereco, int iddelegacia, int iddelegado, String idcomunicante) {
        this.idoco = idoco;
        this.dataocor = dataocor;
        this.status = status;
        this.horario = horario;
        this.infracao = infracao;
        this.segredojustica = segredojustica;
        this.idpolicial = idpolicial;
        this.idendereco = idendereco;
        this.iddelegacia = iddelegacia;
        this.iddelegado = iddelegado;
        this.idcomunicante = idcomunicante;
    }

    public Integer getIdoco() {
        return idoco;
    }

    public void setIdoco(Integer idoco) {
        Integer oldIdoco = this.idoco;
        this.idoco = idoco;
        changeSupport.firePropertyChange("idoco", oldIdoco, idoco);
    }

    public Date getDataocor() {
        return dataocor;
    }

    public void setDataocor(Date dataocor) {
        Date oldDataocor = this.dataocor;
        this.dataocor = dataocor;
        changeSupport.firePropertyChange("dataocor", oldDataocor, dataocor);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        Date oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    public String getInfracao() {
        return infracao;
    }

    public void setInfracao(String infracao) {
        String oldInfracao = this.infracao;
        this.infracao = infracao;
        changeSupport.firePropertyChange("infracao", oldInfracao, infracao);
    }

    public boolean getSegredojustica() {
        return segredojustica;
    }

    public void setSegredojustica(boolean segredojustica) {
        boolean oldSegredojustica = this.segredojustica;
        this.segredojustica = segredojustica;
        changeSupport.firePropertyChange("segredojustica", oldSegredojustica, segredojustica);
    }

    public int getIdpolicial() {
        return idpolicial;
    }

    public void setIdpolicial(int idpolicial) {
        int oldIdpolicial = this.idpolicial;
        this.idpolicial = idpolicial;
        changeSupport.firePropertyChange("idpolicial", oldIdpolicial, idpolicial);
    }

    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        int oldIdendereco = this.idendereco;
        this.idendereco = idendereco;
        changeSupport.firePropertyChange("idendereco", oldIdendereco, idendereco);
    }

    public int getIddelegacia() {
        return iddelegacia;
    }

    public void setIddelegacia(int iddelegacia) {
        int oldIddelegacia = this.iddelegacia;
        this.iddelegacia = iddelegacia;
        changeSupport.firePropertyChange("iddelegacia", oldIddelegacia, iddelegacia);
    }

    public int getIddelegado() {
        return iddelegado;
    }

    public void setIddelegado(int iddelegado) {
        int oldIddelegado = this.iddelegado;
        this.iddelegado = iddelegado;
        changeSupport.firePropertyChange("iddelegado", oldIddelegado, iddelegado);
    }

    public String getIdcomunicante() {
        return idcomunicante;
    }

    public void setIdcomunicante(String idcomunicante) {
        String oldIdcomunicante = this.idcomunicante;
        this.idcomunicante = idcomunicante;
        changeSupport.firePropertyChange("idcomunicante", oldIdcomunicante, idcomunicante);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoco != null ? idoco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencia)) {
            return false;
        }
        Ocorrencia other = (Ocorrencia) object;
        if ((this.idoco == null && other.idoco != null) || (this.idoco != null && !this.idoco.equals(other.idoco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Ocorrencia[ idoco=" + idoco + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
