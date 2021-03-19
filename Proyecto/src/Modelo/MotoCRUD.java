/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class MotoCRUD {
     modelo.Conexion conectar = new modelo.Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     public List listar(){
        List<Moto>datos=new ArrayList<>();
        String sql="SELECT motos.matricula, marca.nombre, motos.modelo, motos.color, tipomoto.nombre FROM `motos` inner join marca on motos.id_marca=marca.id inner join tipomoto on motos.id_tipoMoto=tipomoto.id group by marca.nombre";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Moto p=new Moto();
                p.setMatricula(rs.getString(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setColor(rs.getString(4));
                p.setEstado(rs.getString(5));
              
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}
