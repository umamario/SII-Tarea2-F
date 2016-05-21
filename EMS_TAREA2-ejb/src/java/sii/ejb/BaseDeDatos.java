/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sii.exception.EmasaException;
import jpa.*;

/**
 *
 * @author JenniferAdmin
 */
@Stateless
public class BaseDeDatos implements BaseDeDatosLocal {

    @PersistenceContext(unitName = "EMS_TAREA2-ejbPU")
    private EntityManager em;

    /**
     * 
     * Devuelve una lista con todos los avisos creados
     * 
     * @return
     */
    @Override
    public List<Aviso> getAvisos() {
        List<Aviso> res = em.createQuery("select a from Aviso a", Aviso.class).getResultList();
        return res;
    }

    /**
     * 
     * @param empleado
     * @throws EmasaException
     */
    @Override
    public void compruebaLogin(Empleado empleado) throws EmasaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * Inserta un aviso en la base de datos
     * 
     * @param aviso
     */
    @Override
    public void insertarAviso(Aviso aviso) {
        // throw new UnsupportedOperationException("Not supported yet.");
        em.persist(aviso);
    }

    /**
     *
     * Modifica un aviso que ya existe en la base de datos
     * 
     * @param aviso
     */
    @Override
    public void modificarAviso(Aviso aviso) {
        // throw new UnsupportedOperationException("Not supported yet.");
        em.merge(aviso);
    }

    /**
     *
     * Elimina un aviso de la base de datos
     * 
     * @param aviso
     */
    @Override
    public void eliminarAviso(Aviso aviso) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // em.remove(em.merge(aviso));
    }

    @Override
    public List<OrdenTrabajo> getOrdenesTrabajo() {
        return em.createQuery("select u from OrdenTrabajo u", OrdenTrabajo.class).getResultList();
    }

    @Override
    public void insertarOT(OrdenTrabajo a) {
        em.persist(a);
    }

    @Override
    public void modificarOT(OrdenTrabajo a) {
        em.merge(a);
    }

    @Override
    public OrdenTrabajo mostrarOT(OrdenTrabajo ot) {
        //compruebaOT(ot);
        OrdenTrabajo o = em.find(OrdenTrabajo.class, ot.getId_OT());
        return o;
    }

    @Override
    public void borrarOT(OrdenTrabajo ot) {
        //compruebaOT(ot);
        em.remove(em.merge(ot));
    }
    /*@Override
    private void compruebaOT(OrdenTrabajo ot) throws otException{
        OrdenTrabajo u2 = em.find(OrdenTrabajo.class, ot);
        
        if (u2 == null) {
            throw new otException();
        }
    }*/
    
    @Override
    public Supervisor obtenerSupervisor(Integer id) {
        Supervisor sup = em.find(Supervisor.class, id);
        
        return sup;
    }
}