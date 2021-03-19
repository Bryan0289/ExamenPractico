/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.clienteCrud;
import Modelo.Cliente;
import Vista.Vista1;
import Vista.Vista2;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Controlador implements ActionListener {

    clienteCrud CSQL = new clienteCrud();
    Cliente p = new Cliente ();
    Vista1 v = new Vista1();
    
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Vista1 v) {
        this.v = v;
       
        this.v.btnGuardar.addActionListener(this);
   
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == v.btnGuardar) {
            agregar();
        }
       
            
    }
   
    public void agregar() {
        String cedula=v.txtCedula.getText();
        String nombre = v.txtNombre.getText();
        String apellido = v.txtApellido.getText();
        String direccion = v.txtDireccion.getText();
        String Telefono = v.txtTelefono.getText();
        p.setCedula(cedula);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDireccion(direccion);
        p.setTelefono(Telefono);
        int res= CSQL.agregar(p);
        if(res==1){
         JOptionPane.showMessageDialog(v, "Se agrego correcto");
        }
    }
   
   

}
