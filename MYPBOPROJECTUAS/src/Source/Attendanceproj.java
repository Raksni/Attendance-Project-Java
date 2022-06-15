package Source;

import Source.model.database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Umang
 */
public class Attendanceproj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> list = new ArrayList<String>();
        List<String> colname = Arrays.asList("No", "Kode Prov", "Kode Kab", "Kode Kec", "Kode KJU","Kode K","Kode KJ","Kode KJ", "No. Urut dalam satu Kab", "Nama Perusahaan", "Alamat","Alamat", "No. Telp", "No. Faks", "Bentuk Badan Hukum", "Konfirmasi Kunjungan", "Status Perusahaan", "Tanaman Pangan", "Hotikultura", "Perkebunan", "Peternakan", "Kehutanan", "Perikanan", "Jenis Usaha Utama","COntoh","Contoh");
        for(String name:colname){
            list.add(""+name+"");
        }
        
//         String user = "delok";
//         String id ="";
//         try{
//             id = database.getInstance().getTeacherid();
//             
//         }catch(SQLException e){
//             System.out.println(e);
//         }
//         System.out.println(id);
        //System.out.println("LIST "+list.get(1));
        String[] string = list.toArray(new String[list.size()]);
        for(int i=0;i<list.size();i++){
            string[i]=list.get(i);
        }
//        
//        for(int i=0;i<list.size();i++){
//            System.out.println(string[i]);
//        }
        int j=0;
        for(int i=0;i<list.size();i++){ 
            String n="";
            if((i+j)<list.size()){
                n = list.get(i+1);
                if(list.get(i).equals(n)){
                    System.out.println(list.get(i));
                    list.remove(i);
                    j=j+1;
                }else{
                    System.out.println(list.get(i));
                }
            }           
            
            
        }
//        
//        String[] project =new String [] {
//        "No", "Kode Prov", "Kode Kab", "Kode Kec", "Kode KJU", "No. Urut dalam satu Kab", "Nama Perusahaan", "Alamat", "No. Telp", "No. Faks", "Bentuk Badan Hukum", "Konfirmasi Kunjungan", "Status Perusahaan", "Tanaman Pangan", "Hotikultura", "Perkebunan", "Peternakan", "Kehutanan", "Perikanan", "Jenis Usaha Utama"};
//        
//        System.out.println("Project");
//        for(int i=0;i<list.size();i++){
//            System.out.println(project[i]);
//        }
    }
}
