/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ordenDeTrabajo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Brigada;
import jpa.OrdenTrabajo;
import sii.ejb.BaseDeDatosLocal;

/**
 * Esta clase contendrá todos los avisos de la base de datos
 */
@Named(value = "listaDeOrdenTrabajo")
@SessionScoped
public class ListaDeOrdenTrabajo implements Serializable {

    private List<OrdenTrabajo> datos;
    @EJB
    private BaseDeDatosLocal bdl;
    public ListaDeOrdenTrabajo() {

        datos = new ArrayList<>();
    }

    public List<OrdenTrabajo> getDatos() {
        datos = bdl.getOrdenesTrabajo();
        return datos;
    }

    public List<OrdenTrabajo> obtenerOTsVinculadas(Aviso a){
        List<OrdenTrabajo> datosAvisos = new ArrayList<>();
        for (OrdenTrabajo ot : datos){
            if (ot.getAviso().getId_aviso() == a.getId_aviso())
                datosAvisos.add(ot);
        }
        return datosAvisos;
    }
    public Brigada getBrigada(Integer id) {
        return bdl.obtenerBrigada(id);
    }
    public void setDatos(List<OrdenTrabajo> datos) {
        this.datos = datos;
    }
    public void setOT(OrdenTrabajo ots) {
        bdl.insertarOT(ots);
    }
    public void addDatos(OrdenTrabajo ot) {
        this.datos.add(ot);
    }
    
}
