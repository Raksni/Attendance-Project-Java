package Source.model;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Wa Ode Raksni Dumpat
 */

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Mahasiswa implements Serializable{
    private String nim,nama, dept, semester;
    private kelas kls;
    public Mahasiswa(){}
    public Mahasiswa(String nim, String nama, String dept, String semester) {
        this.nim = nim;
        this.nama = nama;
        this.dept = dept;
        this.semester = semester;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }        

    public String getKelas() {
        return kls.getClassname();
    }

    public void setKelas(kelas kls) {
        this.kls = kls;
    }
    
}
