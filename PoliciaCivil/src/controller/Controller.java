/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import model.entity.Cidadao;
import model.entity.Evidencia;
import model.entity.Policial;
import model.manager.OcorrenciaManager;
import view.CadastrarOcorrencia;

/**
 *
 * @author hueli
 */
public class Controller {

    
    public static void salvarOcorrencia(String infracao, String cidade, String estado, String logradouro, Integer numero, String cep, String bairro, String referencia, String complemento, Date data, Time hora, List<Cidadao> vitimas, List<Cidadao> comunicantes, List<Cidadao> testemunhas, List<Cidadao> autores, List<Evidencia> evidencias, List<Policial> delegados, List<Policial> equipe, boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    private OcorrenciaManager ocorrenciaManager = new OcorrenciaManager();



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
