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

import Modelo.Moto;
import Modelo.MotoCRUD;
import Vista.Vista2;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Controlador2 implements ActionListener {

    MotoCRUD PerCRUD = new MotoCRUD();
    Moto p = new Moto();
    Vista2 v = new Vista2();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador2(Vista2 v) {
        this.v = v;
        this.v.btnListar.addActionListener(this);
        
    }

    @Override

    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == v.btnListar) {
            listar(v.tabla);
        }
       
      
            
    }
   
    public void listar(JTable Tabla) {
        modelo = (DefaultTableModel) Tabla.getModel();
        List<Moto> lista = PerCRUD.listar();
        Object[] object = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getMatricula();
            object[1] = lista.get(i).getMarca();
            object[2] = lista.get(i).getModelo();
            object[3] = lista.get(i).getColor();
            object[4] = lista.get(i).getEstado();
            modelo.addRow(object);

        }
        v.tabla.setModel(modelo);
    }

}
