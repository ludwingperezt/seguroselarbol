/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Agente.java
 *
 * Created on 17-nov-2011, 11:30:40
 */
package moduloagentes;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author ROLANDO
 */
public class Agente extends javax.swing.JDialog {
    ImageIcon img[];
    CapaNegocios.Agente nuevo;
    boolean mod;
    boolean listo=false;
    /** Creates new form Agente */
    public Agente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        img=new ImageIcon[2];
        nuevo = new CapaNegocios.Agente();
        img[0]=new ImageIcon(System.getProperty("user.dir")+File.separator+"imagenes"+File.separator+"noOK.jpg");
        img[1]=new ImageIcon(System.getProperty("user.dir")+File.separator+"imagenes"+File.separator+"ok.png");
        cargarFoto(new File(System.getProperty("user.dir")+File.separator+"imagenes"+File.separator+"nofoto.gif"));
        lblIcon.setIcon(new ImageIcon(img[0].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));            
        lblIcon1.setIcon(new ImageIcon(img[0].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));            
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblIcon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(aseguradora.AseguradoraApp.class).getContext().getResourceMap(Agente.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        jTextField3.setText(resourceMap.getString("jTextField3.text")); // NOI18N
        jTextField3.setToolTipText(resourceMap.getString("jTextField3.toolTipText")); // NOI18N
        jTextField3.setName("jTextField3"); // NOI18N

        jTextField4.setText(resourceMap.getString("jTextField4.text")); // NOI18N
        jTextField4.setName("jTextField4"); // NOI18N

        jTextField8.setText(resourceMap.getString("jTextField8.text")); // NOI18N
        jTextField8.setName("jTextField8"); // NOI18N

        jTextField7.setText(resourceMap.getString("jTextField7.text")); // NOI18N
        jTextField7.setToolTipText(resourceMap.getString("jTextField7.toolTipText")); // NOI18N
        jTextField7.setName("jTextField7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jTextField9.setText(resourceMap.getString("jTextField9.text")); // NOI18N
        jTextField9.setToolTipText(resourceMap.getString("jTextField9.toolTipText")); // NOI18N
        jTextField9.setName("jTextField9"); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jPasswordField1.setText(resourceMap.getString("jPasswordField1.text")); // NOI18N
        jPasswordField1.setName("jPasswordField1"); // NOI18N
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jPasswordField2.setName("jPasswordField2"); // NOI18N
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jTextField5.setText(resourceMap.getString("jTextField5.text")); // NOI18N
        jTextField5.setName("jTextField5"); // NOI18N

        jTextField6.setText(resourceMap.getString("jTextField6.text")); // NOI18N
        jTextField6.setName("jTextField6"); // NOI18N

        jTextField2.setText(resourceMap.getString("jTextField2.text")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Agente", "Cajero", "Invitado" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        lblFoto.setText(resourceMap.getString("lblFoto.text")); // NOI18N
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.setName("lblFoto"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        lblIcon.setText(resourceMap.getString("lblIcon.text")); // NOI18N
        lblIcon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblIcon.setName("lblIcon"); // NOI18N

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        lblIcon1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblIcon1.setName("lblIcon1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(16, 16, 16)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jLabel14)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel13))))
                        .addGap(17, 17, 17)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed

        
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        // TODO add your handling code here:        
        try {
            if (CapaNegocios.Agente.existeUsuario(jTextField9.getText().trim())){
                lblIcon.setIcon(new ImageIcon(img[0].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));
                listo=false;
                jTextField9.select(0, jTextField9.getText().length());
                jTextField9.requestFocus();
            }
            else{
                listo=true;
                lblIcon.setIcon((new ImageIcon(img[1].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField9FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = new JFileChooser();
        int resultado = selector.showOpenDialog(lblFoto);
        if (resultado==JFileChooser.APPROVE_OPTION){
            File imagen = selector.getSelectedFile();
            cargarFoto(imagen);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void cargarFoto(File f)
    {
        nuevo.setFotografia(f);
        Image imI=new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(lblFoto.getSize().width-2, lblFoto.getSize().height-2, Image.SCALE_DEFAULT);
        lblFoto.setIcon(new ImageIcon(imI));
        lblFoto.setSize(lblFoto.getIcon().getIconWidth(), lblFoto.getIcon().getIconHeight());
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (listo){
            if (!mod){
                nuevo.setDPI(jTextField3.getText());
                nuevo.setNIT(jTextField4.getText());
                nuevo.setNombre(jTextField1.getText());
                nuevo.setDireccion(jTextField2.getText());
                nuevo.setTelefono(jTextField5.getText());
                nuevo.setCelular(jTextField6.getText());
                nuevo.setComision(Double.valueOf(jTextField7.getText()));
                nuevo.setSueldoBase(Double.valueOf(jTextField8.getText()));
                nuevo.setUsuario(jTextField9.getText());
                nuevo.setContraseña(jPasswordField1.getText());
                nuevo.setNivelAcceso(jComboBox1.getSelectedIndex()+1);
                nuevo.setActivo(1);
                try {
                    nuevo.guardarAgente();
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
            else
            {
                nuevo.setDPI(jTextField3.getText());
                nuevo.setNIT(jTextField4.getText());
                nuevo.setNombre(jTextField1.getText());
                nuevo.setDireccion(jTextField2.getText());
                nuevo.setTelefono(jTextField5.getText());
                nuevo.setCelular(jTextField6.getText());
                nuevo.setComision(Double.valueOf(jTextField7.getText()));
                nuevo.setSueldoBase(Double.valueOf(jTextField8.getText()));
                //nuevo.setUsuario(jTextField9.getText());
                if ((jPasswordField1.getText().length()>0) && (jPasswordField1.getText().equals(jPasswordField2.getText())))
                    nuevo.setContraseña(jPasswordField1.getText());
                nuevo.setNivelAcceso(jComboBox1.getSelectedIndex()+1);
                nuevo.setActivo(1);
                try {
                    nuevo.modificar();
                     dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }
        else        
            JOptionPane.showMessageDialog(rootPane, "No se ha completado el ingreso del agente. Verifique datos.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        // TODO add your handling code here:
        if (!jPasswordField1.getText().equals(jPasswordField2.getText()) || jPasswordField1.getText().length()==0)
        {
            jPasswordField1.requestFocus();
            listo=false;
            lblIcon1.setIcon(new ImageIcon(img[0].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));            
        }
        else{
            listo=true;
            lblIcon1.setIcon(new ImageIcon(img[1].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));
        }
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        // TODO add your handling code here:
                
        
        if (jPasswordField2.getPassword().length!=0)
            if (!jPasswordField1.getText().equals(jPasswordField2.getText()))
            {
                jPasswordField2.requestFocus();
                listo=false;
                lblIcon1.setIcon(new ImageIcon(img[0].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));            
            }
        else{
                listo=true;
                lblIcon1.setIcon(new ImageIcon(img[1].getImage().getScaledInstance(lblIcon.getSize().width-2, lblIcon.getSize().height-2, Image.SCALE_DEFAULT)));
            }
    }//GEN-LAST:event_jPasswordField1FocusLost

      
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
            java.util.logging.Logger.getLogger(Agente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Agente dialog = new Agente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblIcon1;
    // End of variables declaration//GEN-END:variables

    public void editarAgente(CapaNegocios.Agente seleccionado, boolean b) {
        jTextField1.setText(seleccionado.getNombre());
        jTextField3.setText(seleccionado.getNIT());
        jTextField4.setText(seleccionado.getDPI());
        jTextField2.setText(seleccionado.getDireccion());
        jTextField5.setText(seleccionado.getTelefono());
        jTextField6.setText(seleccionado.getCelular());
        jTextField7.setText(String.valueOf(seleccionado.getComision()));
        jTextField8.setText(String.valueOf(seleccionado.getSueldoBase()));
        jTextField9.setText(seleccionado.getUsuario());
        jTextField9.setEnabled(false);
        jComboBox1.setSelectedIndex(seleccionado.getNivelAcceso()-1);
        if (seleccionado.getFotografia()!=null)
            lblFoto.setIcon(new ImageIcon(seleccionado.getFotografia()));
        else
            cargarFoto(new File(System.getProperty("user.dir")+File.separator+"imagenes"+File.separator+"nofoto.gif"));
        
        lblFoto.setSize(lblFoto.getIcon().getIconWidth(), lblFoto.getIcon().getIconHeight());
        if (!b)
        {
            jTextField3.setEnabled(false);
            jTextField4.setEnabled(false);
            jTextField1.setEnabled(false);
            jTextField7.setEnabled(false);
            jTextField8.setEnabled(false);
            jComboBox1.setEnabled(false);
        }
        nuevo=seleccionado;
        mod=true;
        this.setVisible(true);
    }
}
