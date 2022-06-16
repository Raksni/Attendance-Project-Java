package Source.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author Asus
 */
public class database implements Serializable{
    public static database instance;
    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "tugasmandiripbo";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    
    private database(){}
    public static synchronized database getInstance(){    
        if(instance == null){
            instance = new database();
        }
        return instance;
    }
//   
    public String getLogin(User user) throws SQLException{
        Connection conn = getConnection();
        String result="0";
        
        try{
            
            String sql = "SELECT * FROM login WHERE username ='"+user.getUsername()+"'AND password ='"+user.getPassword()+"'";
            teacher dsn;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                if(user.getUsername().equals(rs.getString("username"))){
                    if(user.getPassword().equals(rs.getString("password"))){
                        result= rs.getString("usertype");
                    }
                }
            }
            
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return result;
    }
    
    public void insertClass(kelas kls) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql="INSERT INTO classes VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kls.getClassname());            
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertClassSubject(kelas kls, Subject sub) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql="insert into class_subject values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kls.getClassname());
            pstmt.setString(2, sub.getSubjectid());            
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void validateClassName(kelas k) throws SQLException{
        Connection conn = getConnection();
        try{            
            String sql="SELECT * FROM classes WHERE classname ='"+k.getClassname()+"'";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("Kelas sudah ada di database");                
            }else{
                insertClass(k);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
    }
    
    public void deleteClass(kelas kelas) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql="DELETE FROM classes WHERE classname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kelas.getClassname());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }
        try{
            String sql="DELETE FROM class_subject WHERE classname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kelas.getClassname());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }try{
            String sql="DELETE FROM student WHERE classname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kelas.getClassname());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }try{
            String sql="DELETE FROM teaches WHERE classname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kelas.getClassname());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertMahasiswa(Mahasiswa mahasiswa) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql="INSERT INTO student VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNim());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getDept());
            pstmt.setString(4, mahasiswa.getSemester());
            pstmt.setString(5, mahasiswa.getKelas());
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void updateStudent(Mahasiswa mahasiswa)throws SQLException{
        Connection conn = getConnection();
        try{            
            String sql = "UPDATE student SET dept= ?, semester = ?, classname= ?";
            sql+=" WHERE studentid= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getDept());
            pstmt.setString(2, mahasiswa.getSemester());
            pstmt.setString(3, mahasiswa.getKelas());
            pstmt.setString(4, mahasiswa.getNim());
            pstmt.executeUpdate();
            
        } catch(SQLException ex){
            throw ex;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
        
    }
    
//    //DELETE DATA
    public void deleteStudent(Mahasiswa mhs) throws SQLException
    {
        
        Connection conn = getConnection();
        //boolean rowDel = false;
        try{         
            String sql="DELETE FROM student WHERE studentid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mhs.getNim());
            //rowDel=pstmt.executeUpdate()>0;
            //return rowDel;
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertTeacher(teacher dosen) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql="INSERT INTO teacher VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dosen.getTeacherid());
            pstmt.setString(2, dosen.getTeachername());
            pstmt.setString(3, dosen.getUsername());
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertTeacherLogin(teacher dosen) throws SQLException{
        Connection conn = getConnection();
        String user = "Teacher";
        try{
            String sql="INSERT INTO login VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dosen.getUsername());
            pstmt.setString(2, dosen.getPassword());
            pstmt.setString(3, user);
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertTeacherClass(teacher dosen) throws SQLException{
        Connection conn = getConnection();
        
        try{
            String sql="INSERT INTO teaches VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dosen.getTeacherid());
            pstmt.setString(2, dosen.getKelas());
            pstmt.setString(3, dosen.getSubject().getSubjectid());
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void validateTeacherInsert(teacher k) throws SQLException{
        Connection conn = getConnection();
        try{            
            String sql="SELECT * FROM login WHERE username ='"+k.getUsername()+"'";            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){               
            }else{
                insertTeacherLogin(k);
            }
        }catch(SQLException ex){
            throw ex;
        }         
        try{   
            
            String sql="SELECT * FROM teacher WHERE teacherid ='"+k.getTeacherid()+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){            
                insertTeacherClass(k);
            }else{
                insertTeacher(k);
                insertTeacherClass(k);
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
           if (conn!=null){
                conn.close();
            }
        }
    }
    
    public void updateTeacherClass(teacher guru) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql1 = "UPDATE teaches SET classname = ?";
            sql1+=" WHERE subjectid=? AND teacher_teacherid= ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, guru.getKelas());     
            pstmt.setString(2, guru.getSubject().getSubjectid());     
            pstmt.setString(3, guru.getTeacherid());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            throw ex;
        }  
    }
    
    public void updateTeacherLogin(teacher guru) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql2 = "UPDATE login SET password = ?";
            sql2+=" WHERE username= ?";            
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, guru.getPassword());            
            pstmt2.setString(2, guru.getUsername());
            
            pstmt2.executeUpdate();
        }catch(SQLException ex){
            throw ex;
        }  
    }
    
    public void updateTeacher(teacher guru)throws SQLException{
        try{
            List<teacher> t = getTeacherList();
            for(int i = 0; i<t.size();i++){
                System.out.println(t.get(i).getTeacherid());
                System.out.println(guru.getTeacherid());
                if(t.get(i).getTeacherid().equals(guru.getTeacherid())){
                    System.out.println(guru.getTeacherid());
                    if(t.get(i).getSubject().getSubjectid().equals(guru.getSubject().getSubjectid())){
                        if(!getTeacherClassName(t.get(i),t.get(i).getSubject()).equals(guru.getKelas())){                            
                            updateTeacherClass(guru);
                        }
                    }
                    if(t.get(i).getUsername().equals(guru.getUsername())){
                        System.out.println("Pass:"+guru.getPassword());
                        System.out.println("Pass2:"+getTeacherPassword(t.get(i).getUsername()));
                        if(!getTeacherPassword(t.get(i).getUsername()).equals(guru.getPassword())){
                            updateTeacherLogin(guru);
                        }
                    }
                }
            }
            
        } catch(SQLException ex){
            throw ex;
        }      
    }
    
    public void deleteTeacher(teacher teacher) throws SQLException{
        Connection conn = getConnection();
        try{
            String sql="DELETE FROM teacher WHERE teacherid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getTeacherid());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }
        try{
            String sql="DELETE FROM teaches WHERE teacher_teacherid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getTeacherid());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }try{
            String sql="DELETE FROM login WHERE username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getUsername());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void deleteTeacherSubject(teacher teacher) throws SQLException{
        Connection conn = getConnection();
        
        try{
            String sql="DELETE FROM teaches WHERE teacher_teacherid=? AND subjectid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getTeacherid());
            pstmt.setString(2, teacher.getSubject().getSubjectid());
            pstmt.executeUpdate();
        } 
        catch(SQLException ex){
            throw ex;
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertAttendance(attendance att) throws SQLException{
        Connection conn = getConnection();
        String status = "";
        try{
            String sql = "INSERT INTO attendance_batch VALUE(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, (att.getDate().trim()));
            pstmt.setString(2, att.getKelas().getClassname());
            pstmt.setString(3, att.getSubject().getSubjectid());
            pstmt.setString(4, att.getSession());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            throw ex;
        }
        try{            
            for(Mahasiswa mhs:getListMahasiswa()){
                if(mhs.getKelas().equals(att.getKelas().getClassname())){
                    att.setMahasiswa(mhs);
                    String sql = "INSERT INTO attendence VALUES(?,?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, att.getDate().trim());
                    pstmt.setString(2, status);
                    pstmt.setString(3, att.getMahasiswa().getNim());
                    pstmt.setString(4, att.getMahasiswa().getKelas());
                    pstmt.setString(5, att.getSubject().getSubjectid()); 
                    pstmt.setString(6, att.getSession());
                    pstmt.executeUpdate();
                }                
            }
        }catch(SQLException ex){
            throw ex;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
    }
    
    public void updateAttendance(attendance att)throws SQLException{
        Connection conn = getConnection();
        try{            
            String sql = "UPDATE attendence SET status= ?";
            sql+=" WHERE studentid= ? AND date=? AND subjectid=? AND classname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, att.getStatus());
            pstmt.setString(2, att.getMahasiswa().getNim());
            pstmt.setString(3, att.getDate());   
            pstmt.setString(4,att.getSubject().getSubjectid());
            pstmt.setString(5,att.getKelas().getClassname());
            pstmt.executeUpdate();
            
        } catch(SQLException ex){
            throw ex;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
    }
    
    public List<attendance> getAttendanceBatch() throws SQLException{
        List<attendance> attList = new ArrayList<>();
        Connection conn = getConnection();        
        try{                
            String sql = "SELECT * FROM attendance_batch";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                attendance att = new attendance();
                kelas kls = new kelas();
                Subject sub = new Subject();
                att.setDate(rs.getString("date"));
                att.setSession(rs.getString("session"));
                kls.setClassname(rs.getString("classname"));
                sub.setSubjectid(rs.getString("subjectid"));
                sub.setSubjectname(getSubjectName(sub.getSubjectid()));
                
                att.setKelas(kls);
                att.setSubject(sub);
                attList.add(att);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return attList;
    }
    
    public List<attendance> getAttendence(String d, String s, String k) throws SQLException{
        List<attendance> attList = new ArrayList<>();
        Connection conn = getConnection();
        String sql ="";
        try{
            
            if(d.isBlank()){
                sql = "SELECT * FROM attendence WHERE classname ='"+k+"' AND subjectid ='"+s+"'";
            }else{
                sql = "SELECT * FROM attendence WHERE classname ='"+k+"' AND date='"+d+"' AND subjectid ='"+s+"'";
            }                
            //String sql = "SELECT * FROM attendence WHERE classname ='"+k+"'AND subjectid ='"+s+"'AND date ='"+d+"'";
                     
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                attendance att = new attendance();
                Mahasiswa mhs = new Mahasiswa();
                kelas kls = new kelas();
                Subject sub = new Subject();
                att.setDate(rs.getString("date"));
                att.setStatus(rs.getString("status"));
                att.setSession(rs.getString("session"));
                mhs.setNim(rs.getString("studentid"));
                mhs.setNama(getStudentName(mhs.getNim()));
                kls.setClassname(rs.getString("classname"));
                sub.setSubjectid(rs.getString("subjectid"));
                sub.setSubjectname(getSubjectName(sub.getSubjectid()));
                att.setKelas(kls);
                att.setSubject(sub);
                att.setMahasiswa(mhs);
                attList.add(att);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return attList;
    }
    
    public List<attendance> getAttendance(String d, String s, String k) throws SQLException{
        List<attendance> attList = new ArrayList<>();
        Connection conn = getConnection();
        String sql ="";
        try{
            if(d.equals("") && s.equals("") && k.equals("")){
                sql = "SELECT * FROM attendence";
            }else if(s.equals("") && k.equals("")){
                sql = "SELECT * FROM attendence WHERE date ='"+d+"'";
            }else if(d.equals("") && k.equals("")){
                sql = "SELECT * FROM attendence WHERE subjectid ='"+s+"'";
            }else if(d.equals("") && s.equals("")){
                sql = "SELECT * FROM attendence WHERE classname ='"+k+"'";
            }else if(k.equals("")){
                sql = "SELECT * FROM attendence WHERE date ='"+d+"'AND subjectid ='"+s+"'";
            }else if(s.equals("")){
                sql = "SELECT * FROM attendence WHERE date ='"+d+"'AND classname ='"+k+"'";
            }else if(d.equals("")){
                sql = "SELECT * FROM attendence WHERE classname ='"+k+"'AND subjectid ='"+s+"'";
            }else{
                sql = "SELECT * FROM attendence WHERE classname ='"+k+"'AND subjectid ='"+s+"'AND date ='"+d+"'";
            }                
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                attendance att = new attendance();
                Mahasiswa mhs = new Mahasiswa();
                kelas kls = new kelas();
                Subject sub = new Subject();
                att.setDate(rs.getString("date"));
                att.setStatus(rs.getString("status"));
                att.setSession(rs.getString("session"));
                mhs.setNim(rs.getString("studentid"));
                mhs.setNama(getStudentName(mhs.getNim()));
                kls.setClassname(rs.getString("classname"));
                sub.setSubjectid(rs.getString("subjectid"));
                sub.setSubjectname(getSubjectName(sub.getSubjectid()));
                att.setKelas(kls);
                att.setSubject(sub);
                att.setMahasiswa(mhs);
                attList.add(att);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return attList;
    }
    
    public String getStudentName(String sub) throws SQLException{
        Connection conn = getConnection();
        String id ="";
        try{
            String sq = "SELECT * FROM student WHERE studentid ='"+sub+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sq);
            while(r.next()){
                id = (r.getString("studentname"));
            }
            
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return id;
    }
    
    public List<Subject> getTeacherSubject(String id) throws SQLException{
        List<Subject> sub = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM teaches WHERE teacher_teacherid = '"+id+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //if(rs.getString())
            
            while(rs.next()){                
                Subject s = new Subject();
                s.setSubjectid(rs.getString("subjectid"));
                s.setSubjectname(getSubjectName(s.getSubjectid()));                
                sub.add(s);                
            }
        }catch(SQLException ex){
            throw ex;
        }
        return sub;
    }
    
    public List<String> getTeacherClassName(teacher tea, Subject b) throws SQLException{
        
        Connection conn = getConnection();
        List<String> s = new ArrayList<>();
        try{
            String sq = "SELECT * FROM teaches WHERE subjectid ='"+b.getSubjectid()+"' AND teacher_teacherid='"+tea.getTeacherid()+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sq);
            while(r.next()){
                String k = (r.getString("classname"));
                s.add(k);
            }
            
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        if(s.size()<0){
            s.add("Tidak Ada Kelas");
        }
        return s;
    }
    
    public String getTeacherUsername(String id) throws SQLException{
        String s="";
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM teacher WHERE teacherid ='"+id+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()){
                s =r.getString("Login_username");                
            }
        }catch(SQLException e){
            throw e;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
        return s;
    }
    
    public teacher getTeacherid(String user) throws SQLException{
        teacher teacher= new teacher();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM teacher WHERE Login_username='"+user+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            if(r.next()){
                teacher.setTeacherid(r.getString("teacherid"));    
                teacher.setTeachername(r.getString("teachername"));
            }
        }catch(SQLException e){
            throw e;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
        return teacher;
    }
    
    public String getTeacherPassword(String id) throws SQLException{
        String s="";
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM login WHERE username ='"+id+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()){
                s =r.getString("password");                
            }
        }catch(SQLException e){
            throw e;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
        return s;
    }
    
    
    
    public String getSubjectName(String id) throws SQLException{
        String s="";
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM subject WHERE subjectid ='"+id+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()){
                s =r.getString("subjectname");                
            }
        }catch(SQLException e){
            throw e;
        }finally{
            if (conn!=null){
                conn.close();
            }
        }
        return s;
    }
    
    public List<teacher> getTeacherList() throws SQLException{
        List<teacher> teacherList = new ArrayList<>();
        Connection conn = getConnection();        
        try{
            String sql1 = "SELECT * FROM teacher";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                String id = rs.getString("teacherid");
                
                for(Subject sub: getTeacherSubject(id)){
//                List<Subject> sub = getTeacherSubject(id);
//                for(int i=0;i<sub.size();i++){
//                    if(sub.size()>1){
//                        if(sub.get(i).getSubjectid().equals(sub.get(i+1).getSubjectid())){
//                            sub.remove(i+1);
//                        }
//                    }                    
                    teacher dosen = new teacher();
                    dosen.setSubject(sub);
                    dosen.setTeacherid(rs.getString("teacherid"));
                    dosen.setTeachername(rs.getString("teachername"));
                    dosen.setUsername(rs.getString("Login_username"));
                    
                    dosen.setKelass((getTeacherClassName(dosen,sub)));
                    teacherList.add(dosen);
                }
//                for(int i=0;i<sub.size();i++){
//                    Subject subject = sub.get(i);
//                    if(subject.getSubjectid()){}
//                }
                    
                
                
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return teacherList;
    }
      
    
    public List<Mahasiswa> getListMahasiswa() throws SQLException{
        List<Mahasiswa> mhsList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Mahasiswa mhs = new Mahasiswa();
                kelas kls = new kelas();
                mhs.setNim(rs.getString("studentid"));
                mhs.setNama(rs.getString("studentname"));
                mhs.setDept(rs.getString("dept"));
                mhs.setSemester(rs.getString("semester"));
                kls.setClassname(rs.getString("classname"));
                mhs.setKelas(kls);
                mhsList.add(mhs);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return mhsList;
    }
    
    public List<String> getListSubject() throws SQLException{
        List<String> classList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM subject";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("subjectname");
                classList.add(name);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return classList;
    }
    
//    public List<String> getListSubjectName(String sub) throws SQLException{
//        List<String> classList = new ArrayList<>();
//        Connection conn = getConnection();
//        try{
//            String sql = "SELECT * FROM subject WHERE subjectid='"+sub+"'";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                String name = rs.getString("subjectname");
//                classList.add(name);
//            }
//        }catch(SQLException ex){
//            throw ex;
//        } finally{
//            if (conn!=null){
//                conn.close();
//            }
//        }
//        return classList;
//    }
    
    public List<String> getListSubjectClass(String id) throws SQLException{
        List<String> classList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM class_subject WHERE subjectid='"+id+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                
                String name = rs.getString("classname");
                classList.add(name);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return classList;
    }
    
    
    
    public String getSubjectId(String sub) throws SQLException{
        Connection conn = getConnection();
        String id="";
        try{
            String sq = "SELECT * FROM subject WHERE subjectname ='"+sub+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sq);
            while(r.next()){
                id = r.getString("subjectid");
            }
            
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return id;
    }
    
//    public String getIdSubject(String sub) throws SQLException{
//        Connection conn = getConnection();
//        String id="";
//        try{
//            String sq = "SELECT * FROM class_subject WHERE classname='"+sub+"'";
//            Statement stmt = conn.createStatement();
//            ResultSet r = stmt.executeQuery(sq);
//            while(r.next()){
//                id = r.getString("subjectid");
//            }
//            
//        }catch(SQLException ex){
//            throw ex;
//        } finally{
//            if (conn!=null){
//                conn.close();
//            }
//        }
//        return id;
//    }
    
    
    
    public List<String> getClassName(String sub) throws SQLException{
        
        Connection conn = getConnection();
        List<String> s = new ArrayList<>();
        try{
            String sq = "SELECT * FROM class_subject WHERE subjectid ='"+sub+"'";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sq);
            while(r.next()){
                String k = r.getString("classname");
                s.add(k);
            }
            
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        if(s.size()==0){
            s.add("Tidak Ada Kelas");
        }
        return s;
    }
    
    
    
    public List<String> getListClass() throws SQLException{
        List<String> classList=new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM classes";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("classname");  
                classList.add(name);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return classList;
    }
    
    public List<Subject> getSubjectList() throws SQLException{
        List<Subject> subList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            String sql = "SELECT * FROM subject";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                    Subject sub = new Subject();
                    sub.setSubjectname(rs.getString("subjectname"));
                    sub.setSubjectid(rs.getString("subjectid"));                    
                    sub.setClasses(getClassName(sub.getSubjectid()));
                    subList.add(sub);
            }
             
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }

        return subList;
    }
    
    
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:"+DB_TYPE+"://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME,DB_USER,DB_PASS);
    }
}
