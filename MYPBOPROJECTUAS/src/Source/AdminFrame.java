package Source;


import Source.model.Subject;
import Source.model.database;
import Source.model.kelas;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umang
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form Addinfoform
     */
    public AdminFrame() {
        initComponents();
        tampil_subjects();
        loadTableData();
        setResizable(false);
        setTitle("Admin Panel");
        
        DateFormat dateFormat = new SimpleDateFormat("EEEE',' dd MMMMMM yyyy");
        //get current date with Date()
        Date date = new Date();
        jLabeldate.setText(dateFormat.format(date).toString());
        
        Thread t = new Thread(){
        
            /**
             * @override
             */
            public void run() {
              for (;;){
                  try {
                      sleep(1000);
                  } catch (InterruptedException ex) {
                      System.out.println(ex.toString());
                  }
                  SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
                  Calendar cal = Calendar.getInstance();
                  jLabeltime.setText(time.format(cal.getTime()));
                  
              }
          }  
        };
        
        t.start();
    }
    
    public final void tampil_subjects(){
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
        name.setText("");        
        subject.setSelectedIndex(-1);
    }
    private void loadTableData(){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //refresh tabel
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        try{
        //isi tabel 
            for(Subject sub:
            database.getInstance().getSubjectList()){
                dtm.addRow(new Object[]{sub.getSubjectname(),sub.getClasses()});
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(this, "Gagal mengambil data", "Gagal", JOptionPane.ERROR_MESSAGE);
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

        DesktopPane1 = new javax.swing.JDesktopPane();
        addSubjectPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        subject = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        add1 = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        addStudent = new javax.swing.JButton();
        addTeacher = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        getAttendance = new javax.swing.JButton();
        addClass = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        getAttendance1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabeldate = new javax.swing.JLabel();
        jLabeltime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1000, 690));
        getContentPane().setLayout(null);

        DesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        DesktopPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        DesktopPane1.setPreferredSize(new java.awt.Dimension(794, 620));

        addSubjectPanel.setBackground(new java.awt.Color(0, 0, 0));
        addSubjectPanel.setMinimumSize(new java.awt.Dimension(850, 550));
        addSubjectPanel.setLayout(null);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Subject Name");
        addSubjectPanel.add(jLabel4);
        jLabel4.setBounds(180, 110, 134, 31);
        addSubjectPanel.add(name);
        name.setBounds(330, 170, 222, 31);

        add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.setText("ADD CLASS");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        addSubjectPanel.add(add);
        add.setBounds(470, 250, 110, 32);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Class"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        addSubjectPanel.add(jScrollPane1);
        jScrollPane1.setBounds(60, 300, 670, 245);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Class");
        addSubjectPanel.add(jLabel5);
        jLabel5.setBounds(180, 170, 130, 31);

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih Subject---"}));
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });
        addSubjectPanel.add(subject);
        subject.setBounds(330, 110, 220, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Class Form");
        addSubjectPanel.add(jLabel6);
        jLabel6.setBounds(270, 20, 220, 22);

        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setText("DELETE CLASS");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        addSubjectPanel.add(delete);
        delete.setBounds(300, 250, 130, 32);

        add1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add1.setText("CLEAR FORM");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        addSubjectPanel.add(add1);
        add1.setBounds(610, 250, 110, 32);

        DesktopPane1.setLayer(addSubjectPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPane1Layout = new javax.swing.GroupLayout(DesktopPane1);
        DesktopPane1.setLayout(DesktopPane1Layout);
        DesktopPane1Layout.setHorizontalGroup(
            DesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addSubjectPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 788, Short.MAX_VALUE)
        );
        DesktopPane1Layout.setVerticalGroup(
            DesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPane1Layout.createSequentialGroup()
                .addComponent(addSubjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(DesktopPane1);
        DesktopPane1.setBounds(190, 70, 790, 610);

        sidemenu.setBackground(new java.awt.Color(0, 102, 51));
        sidemenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        sidemenu.setLayout(null);

        addStudent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addStudent.setText("Student");
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });
        sidemenu.add(addStudent);
        addStudent.setBounds(20, 170, 150, 50);

        addTeacher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addTeacher.setText("Teacher");
        addTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherActionPerformed(evt);
            }
        });
        sidemenu.add(addTeacher);
        addTeacher.setBounds(20, 240, 150, 50);

        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setText("Logout");
        logout.setBorder(null);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        sidemenu.add(logout);
        logout.setBounds(20, 493, 150, 50);

        getAttendance.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        getAttendance.setText("Add Attendance");
        getAttendance.setMaximumSize(new java.awt.Dimension(40, 16));
        getAttendance.setMinimumSize(new java.awt.Dimension(40, 16));
        getAttendance.setPreferredSize(new java.awt.Dimension(40, 16));
        getAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAttendanceActionPerformed(evt);
            }
        });
        sidemenu.add(getAttendance);
        getAttendance.setBounds(20, 310, 150, 60);

        addClass.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        addClass.setText("Class Subject");
        addClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassActionPerformed(evt);
            }
        });
        sidemenu.add(addClass);
        addClass.setBounds(20, 100, 150, 50);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMIN PANEL");
        sidemenu.add(jLabel2);
        jLabel2.setBounds(40, 40, 97, 37);

        getAttendance1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        getAttendance1.setText("View Attendance");
        getAttendance1.setMaximumSize(new java.awt.Dimension(40, 16));
        getAttendance1.setMinimumSize(new java.awt.Dimension(40, 16));
        getAttendance1.setPreferredSize(new java.awt.Dimension(40, 16));
        getAttendance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAttendance1ActionPerformed(evt);
            }
        });
        sidemenu.add(getAttendance1);
        getAttendance1.setBounds(20, 390, 150, 60);

        getContentPane().add(sidemenu);
        sidemenu.setBounds(0, 70, 200, 610);

        header.setBackground(new java.awt.Color(0, 102, 51));
        header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        header.setToolTipText("");
        header.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ATTENDANCE MANAGEMENT SYSTEM");
        header.add(jLabel1);
        jLabel1.setBounds(233, 25, 482, 35);

        jLabeldate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeldate.setForeground(new java.awt.Color(255, 255, 255));
        header.add(jLabeldate);
        jLabeldate.setBounds(820, 20, 140, 20);

        jLabeltime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeltime.setForeground(new java.awt.Color(255, 255, 255));
        header.add(jLabeltime);
        jLabeltime.setBounds(850, 40, 120, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome Admin");
        header.add(jLabel3);
        jLabel3.setBounds(30, 30, 150, 20);

        getContentPane().add(header);
        header.setBounds(0, -1, 980, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        // TODO add your handling code here:
        addStudentFormin f3 = new addStudentFormin();
        DesktopPane1.removeAll();
        DesktopPane1.add(f3);
        f3.show();
    }//GEN-LAST:event_addStudentActionPerformed

    private void addTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherActionPerformed
        // TODO add your handling code here:
        addTeacherFormin f4 = new addTeacherFormin();
        DesktopPane1.removeAll();
        DesktopPane1.add(f4);
        f4.show();
    }//GEN-LAST:event_addTeacherActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int op = JOptionPane.showConfirmDialog(null,"Do you really want to logout?","confirm",0);
        
        if(op == 0)
        {
                Entryportal f1 = new Entryportal();
                f1.setVisible(true);
                dispose();
        }
        else{
           // dispose();
        }
            
    }//GEN-LAST:event_logoutActionPerformed

    private void addClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassActionPerformed
        // TODO add your handling code here:
        DesktopPane1.removeAll();
        DesktopPane1.add(addSubjectPanel);
        addSubjectPanel.show();
    }//GEN-LAST:event_addClassActionPerformed

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        Subject sub = new Subject();
        kelas k = new kelas();        
        k.setClassname(name.getText());
        try{ 
            sub.setSubjectid(database.getInstance().getSubjectId(subject.getSelectedItem().toString()));
            database.getInstance().validateClassName(k);
            database.getInstance().insertClassSubject(k,sub);
            JOptionPane.showMessageDialog(this, "Sukses Menyimpan data");
        }catch(SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data pada kelas ", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        loadTableData();
        clearForm();
        
        
    }//GEN-LAST:event_addActionPerformed

    private void getAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAttendanceActionPerformed
        // TODO add your handling code here:
        addAttendanceFormin f9 = new addAttendanceFormin();
        DesktopPane1.removeAll();
        DesktopPane1.add(f9);
        f9.show();
    }//GEN-LAST:event_getAttendanceActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        subject.setSelectedItem(table.getValueAt(table.getSelectedRow(),0).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        kelas k = new kelas();
        k.setClassname(name.getText());
        try{
            database.getInstance().deleteClass(k);
            JOptionPane.showMessageDialog(this, "Sukses Menghapus Data");
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Gagal mengambil data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        loadTableData();
    }//GEN-LAST:event_deleteActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_add1ActionPerformed

    private void getAttendance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAttendance1ActionPerformed
        // TODO add your handling code here:
        viewAttendance f10 = new viewAttendance();
        DesktopPane1.removeAll();
        DesktopPane1.add(f10);
        f10.show();
    }//GEN-LAST:event_getAttendance1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Dark Numbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminFrame().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane1;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton addClass;
    private javax.swing.JButton addStudent;
    private javax.swing.JPanel addSubjectPanel;
    private javax.swing.JButton addTeacher;
    private javax.swing.JButton delete;
    private javax.swing.JButton getAttendance;
    private javax.swing.JButton getAttendance1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabeldate;
    private javax.swing.JLabel jLabeltime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTextField name;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JComboBox<String> subject;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
