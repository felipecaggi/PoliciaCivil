package model.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.entity.Cidadao;
import model.entity.Delegado;
import model.entity.Delegacia;
import model.entity.Evidencia;
import model.entity.Ocorrencia;
import model.entity.Policial;

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

    public Delegado buscaDelegado(int idDelegado) {
        return null;
    }
    
    public void excluirOcorrencia(int idOcorrencia) {

    }

    public Evidencia buscaEvidencia(int idEvidencia) {
        return null;
    }

    public Policial buscaPolicial(int idPolicial) {
        return (Policial) dao.find(new Policial(), idPolicial);
    }
    
    public boolean salvarOcorrencia(String infracao, String cidade, String estado, String logradouro, Integer numero, String cep, String bairro, String referencia, String complemento, Calendar data, List<Cidadao> vitimas, Cidadao comunicantes, List<Cidadao> testemunhas, List<Cidadao> autores, List<Evidencia> evidencias, Delegado delegados, List<Policial> equipe, boolean segredoJustica) {

        
        return false;
    }

}
