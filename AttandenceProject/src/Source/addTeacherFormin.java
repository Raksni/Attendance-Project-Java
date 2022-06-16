/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Source;


import Source.model.Subject;
import Source.model.database;
import Source.model.kelas;
import Source.model.teacher;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wa Ode Raksni Dumpat
 */
public class addTeacherFormin extends javax.swing.JInternalFrame {

    /**
     * Creates new form addTeacherFormin
     */
    public addTeacherFormin() {
        initComponents();
        tampil_subject();
        loadTableData();
    }
    
    public final void tampil_subject(){
        try {
            ArrayList<String> subjects = (ArrayList<String>) database.getInstance().getListSubject();
            int n = subjects.size();
            for (int i = 0; i < n; i++) {
                subject.addItem(subjects.get(i));
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal mengambil data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    private void clearForm(){
        id.setText("");
        name.setText("");
        password.setText("");
        username.setText("");
        subject.setSelectedIndex(0);
        kelas.setSelectedIndex(-1);        
    }
    
    private void loadTableData(){
        DefaultTableModel dtm = (DefaultTableModel) teachertable.getModel();
        //refresh tabel
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        try{
            for(teacher teach: database.getInstance().getTeacherList()){
                
            }
            List<teacher> teach = database.getInstance().getTeacherList();
            dtm.addRow(new Object[]{teach.get(0).getTeacherid(),teach.get(0).getTeachername(),teach.get(0).getSubject().getSubjectname(),teach.get(0).getKelass()});
            for(int i=1; i<teach.size();i++){
                if(i!=(teach.size()-1)){
                    String n = teach.get(i+1).getSubject().getSubjectid();
                    if(teach.get(i).getSubject().getSubjectid().equals(n)){                    
                    }else{
                        dtm.addRow(new Object[]{teach.get(i).getTeacherid(),teach.get(i).getTeachername(),teach.get(i).getSubject().getSubjectname(),teach.get(i).getKelass()});
                    }
                }else{
                    dtm.addRow(new Object[]{teach.get(i).getTeacherid(),teach.get(i).getTeachername(),teach.get(i).getSubject().getSubjectname(),teach.get(i).getKelass()});
                }
                    
                
            }
//               List<teacher> teach = database.getInstance().getTeacherList();
//               int j=0;
//               int k =0;
//               for(int i = 0; i<teach.size();i++){
//                   String n="";                   
//                   
//                        if((j+1)<=teach.size()){
//                            n = teach.get(i+1).getSubject().getSubjectid();
////                            
//                        }if(teach.get(i).getSubject().getSubjectid().equals(n)){
//                            dtm.addRow(new Object[]{teach.get(i).getTeacherid(),teach.get(i).getTeachername(),teach.get(i).getSubject().getSubjectname(),teach.get(i).getKelass()});
//                            //System.out.println("Teacher :"+teach.get(i).getTeacherid()+teach.get(i).getTeachername()+teach.get(i).getSubject().getSubjectname()+teach.get(i).getKelass());
//                            teach.remove(i);
//                            j=j+1;
//                            
//                        }else{
//                            //k=k+1; 
//                            //System.out.println("I+j " +(i+j)+"> teach.size"+teach.size());
//                            if((i+k)<teach.size()){
//                                //System.out.println("Teacher :"+teach.get(i).getTeacherid()+teach.get(i).getTeachername()+teach.get(i).getSubject().getSubjectname()+teach.get(i).getKelass());
//                                dtm.addRow(new Object[]{teach.get(i).getTeacherid(),teach.get(i).getTeachername(),teach.get(i).getSubject().getSubjectname(),teach.get(i).getKelass()});
//                            }
//                            if(j%2 ==0){
//                                k=0;
//                                j=j+1;
//                            }else{
//                                k=2;
//                            }
//                        }                       
//               }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(this, "Gagal mengambil data table", "Gagal", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kelas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        subject = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        teachertable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Teacher Data Management");
        setMaximumSize(new java.awt.Dimension(990, 550));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(790, 614));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lecturer ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 100, 150, 30);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lecturer Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 150, 150, 30);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 100, 150, 30);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 150, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Teacher Form");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(270, 40, 220, 22);

        id.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id);
        id.setBounds(200, 100, 150, 30);

        name.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        getContentPane().add(name);
        name.setBounds(200, 150, 150, 30);

        username.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        getContentPane().add(username);
        username.setBounds(580, 100, 150, 30);

        password.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(580, 150, 150, 30);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Class");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 200, 150, 30);

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelas"}));
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });
        getContentPane().add(kelas);
        kelas.setBounds(580, 200, 150, 30);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Subject");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 200, 150, 30);

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Pilih Mata Kuliah" }));
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });
        getContentPane().add(subject);
        subject.setBounds(200, 200, 150, 30);

        add.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(410, 270, 75, 30);

        clear.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(40, 270, 90, 30);

        update.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(520, 270, 110, 30);

        delete.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(660, 270, 90, 30);

        delete1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        delete1.setText("<html>DELETE<br>Teacher Subject</html>");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        getContentPane().add(delete1);
        delete1.setBounds(150, 270, 150, 38);

        teachertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Subject", "Class"
            }
        ));
        teachertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teachertableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teachertable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(42, 320, 710, 230);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/res/black1.jpg"))); // NOI18N
        jLabel2.setText("Lec");
        jLabel2.setPreferredSize(new java.awt.Dimension(794, 565));
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 790, 570);
        setBounds(0, 0, 790, 570);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 6, 820, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_kelasActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
        // TODO add your handling code here:
        //String[] bagian = kodeProvComboBox.getSelectedItem().toString().split("-");
        
        try {
            kelas.removeAllItems();
            String subjectid = database.getInstance().getSubjectId(subject.getSelectedItem().toString());
            ArrayList<String> k = (ArrayList<String>) database.getInstance().getListSubjectClass(subjectid);
            int n = k.size();
            for (int i = 0; i < n; i++) {
                kelas.addItem(k.get(i));
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal mengambil data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_subjectActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clearForm();
        id.setEditable(true);
        name.setEditable(true);
        username.setEditable(true);
        loadTableData();
    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        teacher guru = new teacher();
        guru.setTeacherid(id.getText());
        guru.setTeachername(name.getText());
        guru.setUsername(username.getText());
        guru.setPassword(password.getText());
        kelas kls = new kelas();
        kls.setClassname(kelas.getSelectedItem().toString());
        guru.setKelas(kls);
        Subject sub = new Subject();
        sub.setSubjectname(subject.getSelectedItem().toString());
        try{
            sub.setSubjectid(database.getInstance().getSubjectId(sub.getSubjectname()));
            guru.setSubject(sub);
            if(!guru.getTeacherid().equals("") || !guru.getTeachername().equals("") || !guru.getUsername().equals("")||!guru.getPassword().equals("") || !guru.getKelas().equals("") || !guru.getSubject().getSubjectid().equals("")){
                database.getInstance().validateTeacherInsert(guru);
                JOptionPane.showMessageDialog(this, "Sukses Tersimpan");
                clearForm();
                loadTableData();
            }           
            
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Gagal menambah data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        teacher guru = new teacher();
            guru.setTeacherid(id.getText());
            guru.setTeachername(name.getText());
            guru.setUsername(username.getText());
            guru.setPassword(password.getText());            
            kelas kls = new kelas();
            kls.setClassname(kelas.getSelectedItem().toString());
            guru.setKelas(kls);
            Subject sub = new Subject();
            sub.setSubjectname(subject.getSelectedItem().toString());
        try{    
            sub.setSubjectid(database.getInstance().getSubjectId(sub.getSubjectname()));
            guru.setSubject(sub);
            database.getInstance().updateTeacher(guru);
            JOptionPane.showMessageDialog(this, "Sukses Tersimpan");
            
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        loadTableData();
        clearForm();
        id.setEditable(true);
        name.setEditable(true);
        username.setEditable(true);
    }//GEN-LAST:event_updateActionPerformed

    private void teachertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teachertableMouseClicked
        // TODO add your handling code here:
        kelas.removeAllItems();
        id.setText(teachertable.getValueAt(teachertable.getSelectedRow(),0).toString());
        name.setText(teachertable.getValueAt(teachertable.getSelectedRow(),1).toString());
        subject.setSelectedItem(teachertable.getValueAt(teachertable.getSelectedRow(),2).toString());
        String k = teachertable.getValueAt(teachertable.getSelectedRow(),3).toString();
        if(k.contains("2KS1")){
            kelas.setSelectedItem("2KS1");
        }
        if(k.contains("2KS2")){
            kelas.setSelectedItem("2KS2");
        }
        try{
            username.setText(database.getInstance().getTeacherUsername(id.getText()));
            password.setText(database.getInstance().getTeacherPassword(username.getText()));
        }catch(SQLException e){
            System.out.println(e);
        }
        id.setEditable(false);
        name.setEditable(false);
        username.setEditable(false);
        
    }//GEN-LAST:event_teachertableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        teacher guru = new teacher();
        guru.setTeacherid(id.getText());
        guru.setUsername(username.getText());
        int op = JOptionPane.showConfirmDialog(null,"Do you really want to delete teacher?","confirm",0);
        
        if(op == 0)
        { 
            try{
                database.getInstance().deleteTeacher(guru);
                JOptionPane.showMessageDialog(this, "Sukses Tersimpan");
            }catch(SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Gagal menghapus data", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            
        }
        loadTableData();
        clearForm();
        id.setEditable(true);
        name.setEditable(true);
        username.setEditable(true);
    }//GEN-LAST:event_deleteActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
        teacher guru = new teacher();
            guru.setTeacherid(id.getText());
            guru.setUsername(username.getText());
            Subject sub = new Subject();
            sub.setSubjectname(subject.getSelectedItem().toString());
        int op = JOptionPane.showConfirmDialog(null,"Do you really want to delete teacher subject?","confirm",0);
        
        if(op == 0)
        {            
            try{
                sub.setSubjectid(database.getInstance().getSubjectId(sub.getSubjectname()));
                guru.setSubject(sub);
                database.getInstance().deleteTeacherSubject(guru);
                JOptionPane.showMessageDialog(this, "Sukses Tersimpan");
            }catch(SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Gagal menghapus data", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
           // dispose();
        }
        
        loadTableData();
        clearForm();
        id.setEditable(true);
        name.setEditable(true);
        username.setEditable(true);
    }//GEN-LAST:event_delete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JComboBox<String> subject;
    private javax.swing.JTable teachertable;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}