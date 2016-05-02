/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

/**
 *
 * @author Andrea Itzhel
 */
public class Paciente {
    private String id;
    private String nombre;
    private String domicilio;
    private String curp;
    private String tel;
    
     Paciente() {
    }


    public Paciente(String id, String nombre,String domicilio,
            String tel, String curp)
    {
        this.id=id;
        this.nombre=nombre;
        this.curp=curp;
        this.domicilio=domicilio;
        this.tel=tel;
   
    }
    
    public void setId(String id){
        this.id=id;
    }
   
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDomiclio(String domicilio){
        this.domicilio=domicilio;
    }
    public void setCurp(String curp){
        this.curp=curp;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    
    public String getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCurp(){
        return curp;
    }
    public String getDomicilio(){
        return domicilio;
    }
    public String getTel(){
        return tel;
    }
    
    String[] getRow() {
        String [] row = new String[5];
        row[0] = id;
        row[1] = nombre;
        row[2] = curp;
        row[3] = domicilio;
        row[4] = tel;
        
        return row;
    }
}
