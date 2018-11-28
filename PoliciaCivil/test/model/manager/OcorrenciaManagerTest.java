/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipecaggi
 */
public class OcorrenciaManagerTest {
    
    OcorrenciaManager ocorrenciaManager;
    
    public OcorrenciaManagerTest() {
        
        ocorrenciaManager = new OcorrenciaManager();
        
    }

    /**
     * Test of buscaCidadao method, of class OcorrenciaManager.
     */
    @Test
    public void testBuscaCidadao() {
    }

    /**
     * Test of buscaEquipe method, of class OcorrenciaManager.
     */
    @Test
    public void testBuscaEquipe() {
    }

    /**
     * Test of salvarOcorrencia method, of class OcorrenciaManager.
     */
    @Test
    public void testSalvarOcorrencia() {
        
        int idoco = 1;
        Date dataocor = Date.valueOf("0001-01-01");
        String status = "status";
        Date horario = Date.valueOf("0001-01-01");
        String infracao = "infracao";
        boolean segredojustica = false;
        int idpolicial = 01;
        int idendereco = 01;
        int iddelegacia = 01;
        int iddelegado = 01;
        int idcomunicante = 01;
        
        ocorrenciaManager.salvarOcorrencia(idoco, dataocor, status, horario, infracao, segredojustica, idpolicial, idendereco, iddelegacia, iddelegado, idcomunicante);
        
    }

    /**
     * Test of buscaDelegado method, of class OcorrenciaManager.
     */
    @Test
    public void testBuscaDelegado() {
    }

    /**
     * Test of excluirOcorrencia method, of class OcorrenciaManager.
     */
    @Test
    public void testExcluirOcorrencia() {
    }

    /**
     * Test of buscaEvidencia method, of class OcorrenciaManager.
     */
    @Test
    public void testBuscaEvidencia() {
    }
    
}
