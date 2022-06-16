/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source.model;

import Source.AdminFrame;
import Source.Entryportal;
import Source.TeacherFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Wa Ode Raksni Dumpat
 */
public class CreateUser{
    public JFrame Create(User user){
        switch(user.getUsertype()){
            case "Administrator" -> {
                AdminFrame af = new AdminFrame();
                af.setVisible(true);
                return af;
                
            }
            case "Teacher" -> {
                TeacherFrame f2 = new TeacherFrame();
                teacher teach;
                try {
                    teach = database.getInstance().getTeacherid(user.getUsername());
                    f2.tnip.setText(teach.getTeacherid());
                    f2.tname.setText(teach.getTeachername());
                        
                    for(Subject sub:database.getInstance().getTeacherSubject(f2.tnip.getText())){
                        f2.subject.addItem(sub.getSubjectname());
                    }
//            }
                    f2.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                f2.setVisible(true);
                return f2;
            }

            default -> {
                    JOptionPane.showMessageDialog(new Entryportal(), "Username atau Password salah");
                    Entryportal ep = new Entryportal();
                    ep.setVisible(true);
                    return ep;
            }
        }
    }
}
