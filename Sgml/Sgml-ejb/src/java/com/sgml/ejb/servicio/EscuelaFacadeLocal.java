/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.ejb.servicio;

import com.sgml.ejb.persistencia.Escuela;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Allen
 */
@Local
public interface EscuelaFacadeLocal {

    void create(Escuela escuela);

    void edit(Escuela escuela);

    void remove(Escuela escuela);

    Escuela find(Object id);

    List<Escuela> findAll();

    List<Escuela> findRange(int[] range);

    int count();
    
}
