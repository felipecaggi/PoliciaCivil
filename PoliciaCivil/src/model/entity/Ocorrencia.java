/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    , @NamedQuery(name = "Ocorrencia.findByIdoco", query = "SELECT o FROM Ocorrencia o WHERE o.idOcorrencia = :idoco")
    , @NamedQuery(name = "Ocorrencia.findByDataocor", query = "SELECT o FROM Ocorrencia o WHERE o.dataocor = :dataocor")
    , @NamedQuery(name = "Ocorrencia.findByStatus", query = "SELECT o FROM Ocorrencia o WHERE o.status = :status")
    , @NamedQuery(name = "Ocorrencia.findByInfracao", query = "SELECT o FROM Ocorrencia o WHERE o.infracao = :infracao")
    , @NamedQuery(name = "Ocorrencia.findBySegredojustica", query = "SELECT o FROM Ocorrencia o WHERE o.segredojustica = :segredojustica")})
public class Ocorrencia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idOcorrencia")
    private Integer idOcorrencia;

    @Basic(optional = false)
    @Column(name = "dataocor")
    @Temporal(TemporalType.DATE)
    private Calendar dataocor;

    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    @Basic(optional = false)
    @Column(name = "infracao")
    private String infracao;

    @Basic(optional = false)
    @Column(name = "segredojustica")
    private boolean segredojustica;

    @ManyToOne
    @JoinColumn(name = "idPolicial", referencedColumnName = "idPolicial")
    private Policial policial;

    @ManyToOne
    @JoinColumn(name = "idendereco", referencedColumnName = "idendereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "iddelegacia", referencedColumnName = "iddelegacia")
    private Delegacia delegacia;

    @ManyToOne
    @JoinColumn(name = "idDelegado", referencedColumnName = "idPolicial")
    private Delegado delegado;

    @ManyToOne
    @JoinColumn(name = "idComunicante", referencedColumnName = "cpf")
    private Cidadao comunicante;

    @ManyToMany
    @JoinTable(name = "vitima", joinColumns = {
        @JoinColumn(name = "idOcorrencia")}, inverseJoinColumns = {
        @JoinColumn(name = "cpfCidadao")})
    private List<Cidadao> vitimas;

    @ManyToMany
    @JoinTable(name = "testemunha", joinColumns = {
        @JoinColumn(name = "idOcorrencia")}, inverseJoinColumns = {
        @JoinColumn(name = "cpfCidadao")})
    private List<Cidadao> testemunhas;

    @ManyToMany
    @JoinTable(name = "autor", joinColumns = {
        @JoinColumn(name = "idOcorrencia")}, inverseJoinColumns = {
        @JoinColumn(name = "cpfCidadao")})
    private List<Cidadao> autores;

    @ManyToMany
    @JoinTable(name = "evidencia_ocorrencia", joinColumns = {
        @JoinColumn(name = "idOcorrencia")}, inverseJoinColumns = {
        @JoinColumn(name = "idEvidencia")})
    private List<Evidencia> evidencias;

    @ManyToMany
    @JoinTable(name = "envolvido", joinColumns = {
        @JoinColumn(name = "idOcorrencia")}, inverseJoinColumns = {
        @JoinColumn(name = "idPolicial")})
    private List<Policial> equipe;

    public Ocorrencia() {
    }

    public Ocorrencia(Calendar dataocor, String status, String infracao, boolean segredojustica, Policial policial, Endereco endereco, Delegacia delegacia, Delegado delegado, Cidadao comunicante, List<Cidadao> vitimas, List<Cidadao> testemunhas, List<Cidadao> autores, List<Evidencia> evidencias, List<Policial> equipe) {
        this.dataocor = dataocor;
        this.status = status;
        this.infracao = infracao;
        this.segredojustica = segredojustica;
        this.policial = policial;
        this.endereco = endereco;
        this.delegacia = delegacia;
        this.delegado = delegado;
        this.comunicante = comunicante;
        this.vitimas = vitimas;
        this.testemunhas = testemunhas;
        this.autores = autores;
        this.evidencias = evidencias;
        this.equipe = equipe;
    }

    public Ocorrencia(Integer idOcorrencia, Calendar dataocor, String status, String infracao, boolean segredojustica, Policial policial, Endereco endereco, Delegacia delegacia, Delegado delegado, Cidadao comunicante, List<Cidadao> vitimas, List<Cidadao> testemunhas, List<Cidadao> autores, List<Evidencia> evidencias, List<Policial> equipe) {
        this.idOcorrencia = idOcorrencia;
        this.dataocor = dataocor;
        this.status = status;
        this.infracao = infracao;
        this.segredojustica = segredojustica;
        this.policial = policial;
        this.endereco = endereco;
        this.delegacia = delegacia;
        this.delegado = delegado;
        this.comunicante = comunicante;
        this.vitimas = vitimas;
        this.testemunhas = testemunhas;
        this.autores = autores;
        this.evidencias = evidencias;
        this.equipe = equipe;
    }

    public Integer getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Integer idOcorrencia) {
        Integer oldIdoco = this.idOcorrencia;
        this.idOcorrencia = idOcorrencia;
        changeSupport.firePropertyChange("idoco", oldIdoco, idOcorrencia);
    }

    public Calendar getDataocor() {
        return dataocor;
    }

    public void setDataocor(Calendar dataocor) {
        Calendar oldDataocor = this.dataocor;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    public Delegado getDelegado() {
        return delegado;
    }

    public void setDelegado(Delegado delegado) {
        this.delegado = delegado;
    }

    public Cidadao getComunicante() {
        return comunicante;
    }

    public void setComunicante(Cidadao comunicante) {
        this.comunicante = comunicante;
    }

    public Policial getPolicial() {
        return policial;
    }

    public void setPolicial(Policial policial) {
        this.policial = policial;
    }

    public List<Cidadao> getVitimas() {
        return vitimas;
    }

    public void setVitimas(List<Cidadao> vitimas) {
        this.vitimas = vitimas;
    }

    public List<Cidadao> getTestemunhas() {
        return testemunhas;
    }

    public void setTestemunhas(List<Cidadao> testemunhas) {
        this.testemunhas = testemunhas;
    }

    public List<Cidadao> getAutores() {
        return autores;
    }

    public void setAutores(List<Cidadao> autores) {
        this.autores = autores;
    }

    public List<Evidencia> getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(List<Evidencia> evidencias) {
        this.evidencias = evidencias;
    }

    public List<Policial> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Policial> equipe) {
        this.equipe = equipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcorrencia != null ? idOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencia)) {
            return false;
        }
        Ocorrencia other = (Ocorrencia) object;
        if ((this.idOcorrencia == null && other.idOcorrencia != null) || (this.idOcorrencia != null && !this.idOcorrencia.equals(other.idOcorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Ocorrencia[ idoco=" + idOcorrencia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
