/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea Itzhel
 */
public class PacienteDAO {
    
     public void agregarPaciente(Paciente pa) {
        DBConec conec = new DBConec();
        
        try {
            Statement consulta = conec.getConnection().createStatement();
            String sql = "INSERT INTO agregar VALUES('" + pa.getId() + "', '" +
                    pa.getNombre() + "', '" + pa.getCurp() + "', '" + pa.getDomicilio() + "', " +
                    pa.getTel() + "')";
            consulta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Se ha registrado el paciente");
            consulta.close();
            conec.desconectar();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "No se registro la persona " + e);
        }
     }
        
    /**
     *
     * @return
     */
    public ArrayList<Paciente> obtenPaciente() {
        ArrayList <Paciente> arrPac = new ArrayList<Paciente>();
        DBConec conec = new DBConec();
        String sql = "SELECT * FROM agregar";
        
        try {
            PreparedStatement st = conec.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Paciente pa = new Paciente(
                    rs.getString("IdPaciente"),
                    rs.getString("Nmbre"),
                    rs.getString("CURP"),
                    rs.getString("Domicilio"),
                    rs.getString("Telefono")
                );
                arrPac.add(pa);
            }
            rs.close();
            st.close();
            conec.desconectar();
            
        } catch(Exception e) {
            
        }
        return arrPac;
    }
    
}
