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
import Vista.Vista3;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Controlador3 implements ActionListener {

    clienteCrud CCRUD = new clienteCrud();
    Cliente p = new Cliente();
    Vista3 v = new Vista3();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador3(Vista3 v) {
        this.v = v;
       
        this.v.btnConsultar.addActionListener(this);
      
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        int fila=-1;
        if (e.getSource() == v.btnConsultar) {
            listar(v.tabla);
        }
       
      
            
    }
  
  
    public void listar(JTable Tabla) {
        modelo = (DefaultTableModel) Tabla.getModel();
        List<Cliente> lista = CCRUD.listar();
        Object[] object = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCedula();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getDireccion();
            object[4] = lista.get(i).getTelefono();
            modelo.addRow(object);

        }
        v.tabla.setModel(modelo);
    }

}
