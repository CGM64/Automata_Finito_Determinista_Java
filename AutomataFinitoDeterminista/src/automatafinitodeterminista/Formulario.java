/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatafinitodeterminista;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 *
 * @author Carlos Gómez
 */
public class Formulario extends javax.swing.JFrame {
    DefaultTableModel modelo;
    
    /**
     * Creates new form Formulario
     */
    public Formulario() {
        initComponents();
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Estado Inicial/Anterior");
        modelo.addColumn("Letra");
        modelo.addColumn("Estado Siguiente/de Aceptación");
        
        tablaTrancisiones.setModel(modelo);
        
        llenarComboBox();
    }

    String cadena = "";
    int n = 0;
    int estado = 0;
    int error = 0;
    int fin = 0;
    String simbolo;
    String cadena2 = "";
    String cadenaAEstados = ""; 
    String cadenaBEstado0 = "";  
    String cadenaBEstado1 = ""; 
    String cadenaBEstado2 = "";
    String cadenaBEstado3 = "";
    
    public int SigSimbolo(){
        //Si la cantidad de carcteres encontrados es igual al tamaño de la cadena ingresada
        if(n == cadena.length()){
            fin = 1;

            return -1;
        }else{
            //Suma la cantidad de caracteres que tiene la cadena
            n = n + 1;
            
            //Obtiene el rango de caracteres de una cadena
            //Recorre iteradamente desde la cadena anterior a la posición n cadena por cadena cada vez que se ejecute el método
            //Recorre cadena por cadena desde la posición inicial (0) de la cadena
            //Método recursivo
            simbolo = cadena.substring(n - 1, n);

            return 0;
        }
    }
    
    public void Reconocer(){   
        SigSimbolo();
        
        while(error == 0 && fin == 0){
            cadena2 = cadena2 + simbolo;

            switch(estado){
                //Desde qué estado viene
                case 0:
                    if(simbolo.equals("a")){
                        //Hacia qué estado va
                        estado = 1;
                        
                        cadenaAEstados = cadenaAEstados + simbolo;
                        
                        modelo.addRow(new Object[]{"q0", "a", "q1"});
                    }else if(simbolo.equals("b")){
                        estado = 0;
                        
                        cadenaBEstado0 = cadenaBEstado0 + simbolo;
                        
                        modelo.addRow(new Object[]{"q0", "b", "q0"});
                    }else if(!simbolo.equals("a") && !simbolo.equals("b")){
                          error = 1;
                    }

                break;

                case 1:
                    if(simbolo.equals("a")){                        
                        estado = 2;
                        
                        cadenaAEstados = cadenaAEstados + simbolo;
                    
                        modelo.addRow(new Object[]{"q1", "a", "q2"});
                    }else if(simbolo.equals("b")){
                        estado = 1;
                        
                        cadenaBEstado1 = cadenaBEstado1 + simbolo;

                        modelo.addRow(new Object[]{"q1", "b", "q1"});
                    }else if(!simbolo.equals("a") && !simbolo.equals("b")){
                        error = 1;
                    }
                break;
                
                case 2:
                    if(simbolo.equals("a")){                        
                        estado = 3;
                        
                        cadenaAEstados = cadenaAEstados + simbolo;
                        
                        modelo.addRow(new Object[]{"q2", "a", "q3"});
                    }else if(simbolo.equals("b")){
                        estado = 2;
                        
                        cadenaBEstado2 = cadenaBEstado2 + simbolo;
                        
                        modelo.addRow(new Object[]{"q2", "b", "q2"});
                    }else if(!simbolo.equals("a") && !simbolo.equals("b")){
                        error = 1;
                    }
                break;
                
                case 3:
                    if(simbolo.equals("a")){                        
                        estado = 2;
                        
                        cadenaAEstados = cadenaAEstados + simbolo;
                        
                        modelo.addRow(new Object[]{"q3", "a", "q2"});
                    }else if(simbolo.equals("b")){
                        estado = 3;
                        
                        cadenaBEstado3 = cadenaBEstado3 + simbolo;
                        
                        modelo.addRow(new Object[]{"q3", "b", "q3"});
                    }else if(!simbolo.equals("a") && !simbolo.equals("b")){
                        error = 1;
                    }
                break;
            }

            SigSimbolo();
        }
        
        //Si se ingresan caracteres diferentes a los del alfabeto o si la cantidad de a ingresada es par
        if(error == 0){
            //Validación estado de aceptación
            if(estado == 1 || estado == 3){
                txtResultado.setText("La cadena " + cadena2 + " es válida");
                txtResultado.setForeground(Color.green);
                
                txtEstado.setText(String.valueOf(estado));
                txtEstado.setForeground(Color.green);
            }else{
                txtResultado.setText("La cadena " + cadena2 + " no es válida");
                txtResultado.setForeground(Color.red);
                
                txtEstado.setText(String.valueOf(estado));
                txtEstado.setForeground(Color.red);
            }
        }else{
            JOptionPane.showMessageDialog(null,"¡Error!, ha ingresado una o varias letras fuera del alfabeto");
            
            txtResultado.setText("La cadena " + cadena2 + " no es válida");
            txtResultado.setForeground(Color.red);
            
            txtEstado.setText("¿?");
            txtEstado.setForeground(Color.red);
        }
    }
    
    public void llenarComboBox(){
        colorFondo.addItem("Claro");
        colorFondo.addItem("Oscuro");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTituloPrincipal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        btnComprobar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtDescripcionGeneralEstado = new javax.swing.JLabel();
        txtDescripcionEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        txtTituloResultado = new javax.swing.JLabel();
        txtResultado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTrancisiones = new javax.swing.JTable();
        colorFondo = new javax.swing.JComboBox<>();
        txtTema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTituloPrincipal.setText("Cadena de Caracteres");

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        btnComprobar.setText("Comprobar");
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtDescripcionGeneralEstado.setText("Estados de aceptación que puede tener la cadena: 1 o 3");

        txtDescripcionEstado.setText("Estado de aceptación que tiene la cadena:");

        txtEstado.setText("Estado");

        txtTituloResultado.setText("Resultado:");

        txtResultado.setText("Su resultado se mostrará aquí");

        tablaTrancisiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaTrancisiones);

        colorFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorFondoActionPerformed(evt);
            }
        });

        txtTema.setText("Tema:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDescripcionEstado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEstado))
                                    .addComponent(txtDescripcionGeneralEstado))
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(276, 276, 276)
                                        .addComponent(txtTituloResultado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(txtResultado)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnComprobar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLimpiar))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtTituloPrincipal)
                                .addGap(114, 114, 114)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTema)
                            .addComponent(colorFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloPrincipal)
                    .addComponent(txtTema))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnComprobar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescripcionGeneralEstado)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcionEstado)
                    .addComponent(txtEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTituloResultado)
                .addGap(1, 1, 1)
                .addComponent(txtResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed
        // TODO add your handling code here:

        if(txtEntrada.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No puede dejar el campo vacío");
        }else{
            //Permite reconocer cuando se agrega un nuevo caracter
            fin = 0;
            
            cadena = txtEntrada.getText();
                        
            //Permite eliminar y retroceder un caracter y muestra su resultado en las trancisiones
            if(cadena2.length() > cadena.length()){
                int filas = modelo.getRowCount();
                int eliminar = cadena.length();

                for(int i = eliminar; i < filas; i++){
                    modelo.removeRow(eliminar);
                }
                
                cadena2 = cadena;
                
                n = cadena.length();
                
                //Estado 1
                if(cadenaBEstado1.length() >= 1){
                    estado = 1;
                    
                    String nuevaCadenaEstados = cadenaBEstado1.substring(0,cadenaBEstado1.length() - 1);
                
                    cadenaBEstado1 = nuevaCadenaEstados;
                } else if(cadenaBEstado1.length() == 1){
                    estado = 0;
                }
                
                //Estado 2
                if(cadenaBEstado2.length() >= 1){
                    estado = 2;
                    
                    String nuevaCadenaEstados = cadenaBEstado2.substring(0,cadenaBEstado2.length() - 1);
                
                    cadenaBEstado2 = nuevaCadenaEstados;
                }else if(cadenaBEstado2.length() == 0 && cadenaAEstados.length() %2 == 0 && cadenaAEstados.length() >= 2){
                    String nuevaCadenaEstados;
                    nuevaCadenaEstados = cadenaAEstados.substring(0, cadenaAEstados.length() - 1);

                    cadenaAEstados = nuevaCadenaEstados;
                    
                    estado = 1;
                }
                
                //Estado 3
                if(cadenaBEstado3.length() >= 1){
                    estado = 3;
                    
                    String nuevaCadenaEstados = cadenaBEstado3.substring(0,cadenaBEstado3.length() - 1);
                
                    cadenaBEstado3 = nuevaCadenaEstados;
                }else if(cadenaBEstado3.length() == 0 && cadenaAEstados.length() %2 != 0 && cadenaAEstados.length() >= 4){
                    //Elimina los caracteres sobrantes
                    String nuevaCadenaEstados;
                    nuevaCadenaEstados = cadenaAEstados.substring(0, cadenaAEstados.length() - 1);

                    cadenaAEstados = nuevaCadenaEstados;
                    
                    estado = 2;
                }
            }
            
            Reconocer();
            
            JOptionPane.showMessageDialog(null, "a:" + cadenaAEstados.length() + "  b0:" + cadenaBEstado0.length() + "  b1:" + cadenaBEstado1.length() + "  b2:" + cadenaBEstado2.length() + "  b3:" + cadenaBEstado3.length());
        }
    }//GEN-LAST:event_btnComprobarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText("");
        
        cadena = "";
        n = 0;
        estado = 0;
        error = 0;
        fin = 0;
        simbolo = "";
        cadena2 = "";
        cadenaAEstados = "";
        cadenaBEstado0 = "";
        cadenaBEstado1 = ""; 
        cadenaBEstado2 = "";
        cadenaBEstado3 = "";
        
        txtEstado.setText("Estado");
        txtResultado.setText("Su resultado se mostrará aquí");
        String texto = colorFondo.getSelectedItem().toString();
        
        if(texto.equals("Claro")){
            txtEstado.setForeground(Color.black);
            txtResultado.setForeground(Color.black);
        }else if(texto.equals("Oscuro")){
            txtEstado.setForeground(Color.white);
            txtResultado.setForeground(Color.white);
        }

        int filas = modelo.getRowCount();

        for(int i = 0; i < filas; i++){
            modelo.removeRow(0);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void colorFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorFondoActionPerformed
        // TODO add your handling code here:
        String texto = colorFondo.getSelectedItem().toString();
        
        if(texto.equals("Claro")){
            txtTituloPrincipal.setForeground(Color.black);
            txtTema.setForeground(Color.black);
            txtDescripcionGeneralEstado.setForeground(Color.black);
            txtDescripcionEstado.setForeground(Color.black);
            txtTituloResultado.setForeground(Color.black);
            
            if(fin == 0){
                txtEstado.setForeground(Color.black);
                txtResultado.setForeground(Color.black);
            }
            
            this.getContentPane().setBackground(Color.white);
        }else if(texto.equals("Oscuro")){
            txtTituloPrincipal.setForeground(Color.white);
            txtTema.setForeground(Color.white);
            txtDescripcionGeneralEstado.setForeground(Color.white);
            txtDescripcionEstado.setForeground(Color.white);
            txtTituloResultado.setForeground(Color.white);
            
            if(fin == 0){
                txtEstado.setForeground(Color.white);
                txtResultado.setForeground(Color.white);
            }
            
            this.getContentPane().setBackground(Color.black);
        }
    }//GEN-LAST:event_colorFondoActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> colorFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaTrancisiones;
    private javax.swing.JLabel txtDescripcionEstado;
    private javax.swing.JLabel txtDescripcionGeneralEstado;
    public javax.swing.JTextArea txtEntrada;
    private javax.swing.JLabel txtEstado;
    public javax.swing.JLabel txtResultado;
    private javax.swing.JLabel txtTema;
    private javax.swing.JLabel txtTituloPrincipal;
    private javax.swing.JLabel txtTituloResultado;
    // End of variables declaration//GEN-END:variables
}
