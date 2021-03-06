/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.List;
import model.entity.Autor;
import model.entity.Cidadao;
import model.entity.Delegado;
import model.entity.Evidencia;
import model.entity.Policial;
import model.manager.OcorrenciaManager;
import view.CadastrarOcorrencia;

/**
 *
 * @author hueli
 */
public class Controller {

    private OcorrenciaManager ocorrenciaManager = new OcorrenciaManager();
    private Policial policialLogado = ocorrenciaManager.buscaPolicial(1);

    public boolean salvarOcorrencia(
            String infracao,
            String cidade,
            String estado,
            String logradouro,
            Integer numero,
            String cep,
            String bairro,
            String referencia,
            String complemento,
            Calendar data,
            List<Cidadao> vitimas,
            Cidadao comunicante,
            List<Cidadao> testemunhas,
            List<Autor> autores,
            List<Evidencia> evidencias,
            Delegado delegado,
            List<Policial> equipe,
            boolean segredoJustica) {
        return ocorrenciaManager.salvarOcorrencia(
                infracao,
                cidade,
                estado,
                logradouro,
                numero,
                cep,
                bairro,
                referencia,
                complemento,
                data,
                vitimas,
                comunicante,
                testemunhas,
                autores,
                evidencias,
                delegado,
                equipe,
                segredoJustica,
                policialLogado
        );
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarOcorrencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarOcorrencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarOcorrencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarOcorrencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarOcorrencia().setVisible(true);
            }
        });
    }
}
