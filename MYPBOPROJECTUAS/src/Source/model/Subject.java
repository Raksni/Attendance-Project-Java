package Source.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Wa Ode Raksni Dumpatua
 */
public class Subject implements Serializable{
    private String subjectname;
    private String subjectid;
    private kelas kelas;
    private List<String> classes;    
    public Subject(){}

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public kelas getKelas() {
        return kelas;
    }

    public void setKelas(kelas kelas) {
        this.kelas = kelas;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }
    
    
}
