/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Modelo.Cliente;



/**
 *
 * @author Bryan
 */
public class clienteCrud {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
   
    public int agregar(Cliente p){
         String sql="INSERT INTO `cliente` (`cedula`, `nombres`, `apellido`, `direccion`, `telefono`) VALUES ( ?, ?, ?, ?, ?);";
         try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, p.getCedula());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTelefono());
            ps.executeUpdate();
            return 1;

        } catch (Exception e) {
        }
         return 0;

            }  
     public List listar(){
        List<Cliente>datos=new ArrayList<>();
        String sql="SELECT * FROM `cliente`";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Modelo.Cliente p=new Modelo.Cliente();
                p.setCedula(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setApellido(rs.getString(4));
                p.setDireccion(rs.getString(5));
                p.setTelefono(rs.getString(6));
              
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
}

