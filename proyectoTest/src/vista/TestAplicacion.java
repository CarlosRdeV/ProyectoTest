/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Opcion;
import modelo.PersistenciaPregunta;
import modelo.Pregunta;

/**
 *
 * @author Oldspice
 */
public class TestAplicacion extends javax.swing.JFrame {

    int numero = 0; //Variable usada para el numero de la pregunta
    int tiempo; //Variable usada para generar tiempo
    int respuestas;
    int solocinco = 1;
    int correctas = 0;
    String respuestaActual;

    /**
     * Creates new form TestAplicacion
     */
    public TestAplicacion() {
        initComponents();
        setLocationRelativeTo(this);
        setSize(300, 500);
        mostrarPregunta(numero++);
        txtRespuestasTotales.setVisible(false);
        txtResultado.setVisible(false);
        txtcorrectas.setVisible(false);
        ResultadosFinales.setVisible(false);

        //Hacemos el thread
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    tiempo++;
                    try {
                        Thread.sleep(1000);
                        etiquetaTiempo.setText("Tiempo: " + tiempo);
                        if (tiempo >= 5) {
                            mostrarPregunta(numero++);
                            solocinco++;
                            if (solocinco > 5) {
                                ResultadosFinales.setText("El resulado es: " + correctas + " de 5");
            ResultadosFinales.setVisible(true);
                                
                            }
                        }
                    } catch (Exception e) {
                    }
                }

            }

        });
        t1.start();
        rb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String texto = rb1.getText();
                if (rb1.isSelected()) {
                    texto = "" + texto;
                    txtcorrectas.setText(texto);
                }

            }
        });

        rb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String texto = rb2.getText();
                if (rb2.isSelected()) {
                    texto = "" + texto;
                    txtcorrectas.setText(texto);
                }

            }
        });

        rb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String texto = rb3.getText();
                if (rb3.isSelected()) {
                    texto = "" + texto;
                    txtcorrectas.setText(texto);
                }

            }
        });

        rb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String texto = rb4.getText();
                if (rb4.isSelected()) {
                    texto = "" + texto;
                    txtcorrectas.setText(texto);
                }
            }
        });

    }

    //CREAMOS UN METODO 
    public void mostrarPregunta(int numero) {
        tiempo = 0;
        try {
            //Primero sacamos la pregunta del numero dado
            ArrayList<Pregunta> preguntas = PersistenciaPregunta.leer();
            Pregunta p = preguntas.get(numero);
            //Ahora ajustamos los valores
            //Primero va el titulo
            etiquetaPregunta.setText(p.getTitulo());
            //Ahora las opciones
            ArrayList<Opcion> opciones = p.getOpciones();
            respuestaActual = opciones.get(0).getTitulo();
            txtResultado.setText(respuestaActual);
            //Aplicamos el algoritmo
            opciones = PersistenciaPregunta.opcionesAletorias(opciones);

            rb1.setText(opciones.get(0).getTitulo());
            rb2.setText(opciones.get(1).getTitulo());
            rb3.setText(opciones.get(2).getTitulo());
            rb4.setText(opciones.get(3).getTitulo());

        } catch (Exception ex) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        etiquetaPregunta = new javax.swing.JLabel();
        etiquetaTiempo = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        txtcorrectas = new javax.swing.JLabel();
        txtResultado = new javax.swing.JLabel();
        txtRespuestasTotales = new javax.swing.JLabel();
        ResultadosFinales = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        etiquetaPregunta.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etiquetaPregunta.setText("Aqui ira la pregunta");
        getContentPane().add(etiquetaPregunta);

        etiquetaTiempo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etiquetaTiempo.setText("Tiempo");
        getContentPane().add(etiquetaTiempo);

        buttonGroup1.add(rb1);
        rb1.setText("jRadioButton1");
        getContentPane().add(rb1);

        buttonGroup1.add(rb2);
        rb2.setText("jRadioButton2");
        getContentPane().add(rb2);

        buttonGroup1.add(rb3);
        rb3.setText("jRadioButton3");
        getContentPane().add(rb3);

        buttonGroup1.add(rb4);
        rb4.setText("jRadioButton4");
        getContentPane().add(rb4);

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        txtcorrectas.setText("..");
        getContentPane().add(txtcorrectas);

        txtResultado.setText("Resultado");
        getContentPane().add(txtResultado);

        txtRespuestasTotales.setText("Respuestas totales");
        getContentPane().add(txtRespuestasTotales);

        ResultadosFinales.setText("hola");
        getContentPane().add(ResultadosFinales);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //usar este       
        solocinco++;
        if (txtcorrectas.getText().equals(txtResultado.getText())) {
            correctas++;
        }
        txtRespuestasTotales.setText("" + correctas);
        if (solocinco > 5) {
            ResultadosFinales.setText("El resulado es: " + correctas + " de 5");
            ResultadosFinales.setVisible(true);
        }
        mostrarPregunta(numero++);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestAplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ResultadosFinales;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel etiquetaPregunta;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JLabel txtRespuestasTotales;
    private javax.swing.JLabel txtResultado;
    private javax.swing.JLabel txtcorrectas;
    // End of variables declaration//GEN-END:variables
}
