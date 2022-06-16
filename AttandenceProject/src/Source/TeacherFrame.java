package Source;


import Source.model.Mahasiswa;
import Source.model.Subject;
import Source.model.attendance;
import Source.model.database;
import Source.model.kelas;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public class TeacherFrame extends javax.swing.JFrame {

    /**
     * Creates new form Addinfoform
     */
    public TeacherFrame() {
        initComponents();
        String b = tnip.getText();
        tampil_subjects(b);
        setResizable(false);
        late.setEditable(false);
        late.setVisible(false);
        ket.setVisible(false);
        setTitle("Teacher Panel");
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
    
    public final void tampil_subjects(String b){
        try {
            for(Subject sub:database.getInstance().getTeacherSubject(b)){
                subject.addItem(sub.getSubjectname());
            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal mengambil data", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    private void clearForm(){
        nim.setText("");    
        nama.setText(""); 
        status.setSelectedIndex(0);
    }
    private void loadTableData(String d,String s,String k){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        //refresh tabel
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        try{
        //isi tabel 
            for(attendance sub:database.getInstance().getAttendence(d,s,k)){
                dtm.addRow(new Object[]{sub.getMahasiswa().getNim(),sub.getMahasiswa().getNama(),sub.getStatus()});
                
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        subject = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        take = new javax.swing.JButton();
        kelas = new javax.swing.JComboBox<>();
        get = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        late = new javax.swing.JTextField();
        ket = new javax.swing.JComboBox<>();
        sidemenu = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        addClass = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        getAttendance1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabeldate = new javax.swing.JLabel();
        jLabeltime = new javax.swing.JLabel();
        tname = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tnip = new javax.swing.JLabel();

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
        jLabel4.setText("Status");
        addSubjectPanel.add(jLabel4);
        jLabel4.setBounds(120, 240, 134, 31);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "Nama", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
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
        jScrollPane1.setBounds(60, 345, 670, 230);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Class");
        addSubjectPanel.add(jLabel5);
        jLabel5.setBounds(420, 60, 130, 31);

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih Subject---"}));
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });
        addSubjectPanel.add(subject);
        subject.setBounds(170, 60, 220, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Take Student Attendance");
        addSubjectPanel.add(jLabel6);
        jLabel6.setBounds(270, 20, 260, 22);

        take.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        take.setText("UPDATE");
        take.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeActionPerformed(evt);
            }
        });
        addSubjectPanel.add(take);
        take.setBounds(440, 300, 110, 32);

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        addSubjectPanel.add(kelas);
        kelas.setBounds(500, 60, 150, 30);

        get.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        get.setText("Get");
        get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getActionPerformed(evt);
            }
        });
        addSubjectPanel.add(get);
        get.setBounds(700, 60, 72, 30);

        clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clear.setText("CLEAR FORM");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        addSubjectPanel.add(clear);
        clear.setBounds(610, 300, 110, 32);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Subject Name");
        addSubjectPanel.add(jLabel8);
        jLabel8.setBounds(40, 60, 134, 31);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NIM");
        addSubjectPanel.add(jLabel9);
        jLabel9.setBounds(120, 140, 134, 31);
        addSubjectPanel.add(nim);
        nim.setBounds(220, 140, 190, 30);
        addSubjectPanel.add(nama);
        nama.setBounds(220, 190, 190, 30);

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nama");
        addSubjectPanel.add(jLabel10);
        jLabel10.setBounds(120, 190, 134, 31);

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Status","Present","Sick","Permission","Late"}));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        addSubjectPanel.add(status);
        status.setBounds(220, 240, 190, 30);
        addSubjectPanel.add(late);
        late.setBounds(220, 290, 90, 22);

        ket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        addSubjectPanel.add(ket);
        ket.setBounds(340, 290, 72, 22);

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

        addClass.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        addClass.setText("Take Attendance");
        addClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassActionPerformed(evt);
            }
        });
        sidemenu.add(addClass);
        addClass.setBounds(20, 100, 150, 60);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<HTML>TEACHER PANEL</HTML>");
        sidemenu.add(jLabel2);
        jLabel2.setBounds(30, 40, 120, 37);

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
        getAttendance1.setBounds(20, 190, 150, 60);

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
        jLabeltime.setBounds(860, 40, 120, 20);

        tname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tname.setForeground(new java.awt.Color(255, 255, 255));
        header.add(tname);
        tname.setBounds(50, 40, 180, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Welcome Dosen");
        header.add(jLabel7);
        jLabel7.setBounds(20, 20, 140, 16);

        tnip.setForeground(new java.awt.Color(0, 102, 51));
        header.add(tnip);
        tnip.setBounds(0, 0, 60, 20);

        getContentPane().add(header);
        header.setBounds(0, -1, 980, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        nim.setText(table.getValueAt(table.getSelectedRow(),0).toString());
        nama.setText(table.getValueAt(table.getSelectedRow(),1).toString());
        status.setSelectedItem(table.getValueAt(table.getSelectedRow(),2).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void takeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeActionPerformed
        // TODO add your handling code here:
        attendance att = new attendance();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Mahasiswa mhs = new Mahasiswa();
        mhs.setNim(nim.getText());
        mhs.setNama(nama.getText());
        Date date = new Date();
        att.setDate(sdf.format(date));

        if(status.getSelectedIndex()==4){
            String stat = "Late "+late.getText()+" "+ket.getSelectedItem().toString();
            att.setStatus(stat);
        }else{
            att.setStatus(status.getSelectedItem().toString());
        }
        kelas k = new kelas();
        k.setClassname(kelas.getSelectedItem().toString());
        Subject s = new Subject();
        s.setSubjectname(subject.getSelectedItem().toString());
        try{
            s.setSubjectid(database.getInstance().getSubjectId(subject.getSelectedItem().toString()));
            att.setKelas(k);
            att.setSubject(s);
            att.setMahasiswa(mhs);
            database.getInstance().updateAttendance(att);
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(this, "Gagal mengambil kehadiran", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        loadTableData(att.getDate(),att.getSubject().getSubjectid(),att.getKelas().getClassname());
        clearForm();
    }//GEN-LAST:event_takeActionPerformed

    private void getAttendance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAttendance1ActionPerformed
        // TODO add your handling code here:
        viewAttendanceTeacher f10 = new viewAttendanceTeacher();
        f10.tnip.setText(tnip.getText());
        try{
            for(Subject sub:database.getInstance().getTeacherSubject(f10.tnip.getText())){                               
                f10.subject.addItem(sub.getSubjectname());
                f10.subject.setSelectedIndex(0);
                f10.kelas.setSelectedIndex(0);
            }
        }catch(SQLException e){
            System.err.println(e);
            //JOptionPane.showMessageDialog(this, "Gagal menambah subject", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
        
        DesktopPane1.removeAll();
        DesktopPane1.add(f10);
        f10.show();
    }//GEN-LAST:event_getAttendance1ActionPerformed

    private void getActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        String d = sdf.format(date);
        String k = "";
        String s ="";
        try{         
            if(kelas.getSelectedIndex()==-1){
                k="";
            }else{            
                k= kelas.getSelectedItem().toString();
            } 
            if(subject.getSelectedIndex()==0){
                s="";
            }else{            
                s= database.getInstance().getSubjectId(subject.getSelectedItem().toString());
            }  
            if(k.equals("")||s.equals("")){   
                JOptionPane.showMessageDialog(this, "Subject dan Kelas tidak boleh kosong");
            }else{
                loadTableData(d,s,k);
            }
            
        }catch(SQLException e){
            
        }
    }//GEN-LAST:event_getActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_clearActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
        if(status.getSelectedItem()=="Late"){
            late.setVisible(true);
            ket.setVisible(true);
            late.setEditable(true);
            ket.addItem("Jam");
            ket.addItem("Menit");
            ket.addItem("Detik");
        }else{
            ket.removeAllItems();
        }
    }//GEN-LAST:event_statusActionPerformed

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
//            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TeacherFrame().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane1;
    private javax.swing.JButton addClass;
    private javax.swing.JPanel addSubjectPanel;
    private javax.swing.JButton clear;
    private javax.swing.JButton get;
    private javax.swing.JButton getAttendance1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabeldate;
    private javax.swing.JLabel jLabeltime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JComboBox<String> ket;
    private javax.swing.JTextField late;
    private javax.swing.JButton logout;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> subject;
    private javax.swing.JTable table;
    private javax.swing.JButton take;
    public javax.swing.JLabel tname;
    public javax.swing.JLabel tnip;
    // End of variables declaration//GEN-END:variables
}
