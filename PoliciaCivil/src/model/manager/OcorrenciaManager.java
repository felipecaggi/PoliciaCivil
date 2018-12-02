package model.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import model.entity.Cidadao;
import model.entity.Delegado;
import model.entity.Delegacia;
import model.entity.Endereco;
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

    public boolean salvarOcorrencia(
            String infracao,
            String cidade,
            String estado,
            String logradouro,
            int numero,
            String cep,
            String bairro,
            String referencia,
            String complemento,
            Calendar data,
            List<Cidadao> vitimas,
            Cidadao comunicante,
            List<Cidadao> testemunhas,
            List<Cidadao> autores,
            List<Evidencia> evidencias,
            Delegado delegado,
            List<Policial> equipe,
            boolean segredoJustica,
            Policial policial)
    {
        Endereco endereco = new Endereco(cep, logradouro, numero, bairro, complemento, estado, cidade);
        Delegacia delegacia = delegado.getDelegacia();
        String status = "Ativo";
        Ocorrencia ocorrencia = new Ocorrencia(data,
                status,
                infracao,
                segredoJustica,
                policial,
                endereco,
                delegacia,
                delegado,
                comunicante,
                vitimas,
                testemunhas,
                autores,
                evidencias,
                equipe);

        return dao.persist(ocorrencia);
    }

}
