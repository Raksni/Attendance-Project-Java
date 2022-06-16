/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source.model;

/**
 *
 * @author Wa Ode Raksni Dumpat
 */
public class CreateUser{
    public teacher Create(String type){
        switch(type){
            case "Admin":
                return null;
            case "Teacher":
                return new teacher();
            default: 
                return null;
        }
    }
}
