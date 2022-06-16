/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wa Ode Raksni Dumpat
 */
public class teacher {
    private String teacherid, teachername, password,username;
    private Subject subject;
    private kelas kelas;
    private List<String> kls;
    
    public teacher() {}
    
//    public teacher(String id) {
//        this.teacherid = id;
//    }

    teacher(String id) {
        this.teacherid = id;
    }

    
    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getKelas() {
        return kelas.getClassname();
    }

    public void setKelas(kelas kelas) {
        this.kelas = kelas;
    }

    public List<String> getKelass() {
        return kls;
    }

    public void setKelass(List<String> kls) {
        this.kls = kls;
    }
    
    
}
