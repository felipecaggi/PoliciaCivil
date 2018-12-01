package model.manager;

import java.util.Date;
import javax.persistence.EntityManager;
import model.entity.Cidadao;
import model.entity.Delegado;
import model.entity.Delegacia;
import model.entity.Evidencia;
import model.entity.Ocorrencia;

public class OcorrenciaManager {
    
    private final DAO dao;

    public OcorrenciaManager() {
        
        dao = DAO.getDao();
        
    }

    public Cidadao buscaCidadao(int idCidadao) {
        return null;
    }

    public int buscaEquipe(int idEquipe) {
        return 0;
    }

    public void salvarOcorrencia(Integer idoco, Date dataocor, String status, Date horario, String infracao, boolean segredojustica, int idpolicial, int idendereco, int iddelegacia, int iddelegado, int idcomunicante) {
        
        dao.persist(new Ocorrencia(idoco, dataocor, status, horario, infracao, segredojustica, idpolicial, idendereco, iddelegacia, iddelegado, idcomunicante));
        
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
