/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
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

    public boolean salvarOcorrencia(String infracao,
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
            Cidadao comunicantes,
            List<Cidadao> testemunhas,
            List<Cidadao> autores,
            List<Evidencia> evidencias,
            Delegado delegados,
            List<Policial> equipe,
            boolean segredoJustica)
    {
        return ocorrenciaManager.salvarOcorrencia(infracao, cidade, estado, logradouro, numero, cep, bairro, referencia, complemento, data, vitimas, comunicantes, testemunhas, autores, evidencias, delegados, equipe, segredoJustica);
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
