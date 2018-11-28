package model.manager;

import java.util.Date;
import javax.persistence.EntityManager;
import model.entity.Cidadao;
import model.entity.Delegado;
import model.entity.Delegacia;
import model.entity.Evidencia;
import model.entity.Ocorrencia;

public class OcorrenciaManager {

    private EntityManager policiaPUEntityManager;

    public OcorrenciaManager() {
        this.policiaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("policiaPU").createEntityManager();
    }

    public Cidadao buscaCidadao(int idCidadao) {
        return null;
    }

    public int buscaEquipe(int idEquipe) {
        return 0;
    }

    public void salvarOcorrencia(Ocorrencia ocorrencia) {
        policiaPUEntityManager.persist(ocorrencia);
    }

    public Delegado buscaDelegado(int idDelegado) {
        return null;
    }

    public void excluirOcorrencia(int idOcorrencia) {

    }

    public Evidencia buscaEvidencia(int idEvidencia) {
        return null;
    }

}
