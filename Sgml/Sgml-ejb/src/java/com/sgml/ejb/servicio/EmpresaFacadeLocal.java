/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.ejb.servicio;

import com.sgml.ejb.persistencia.Empresa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Allen
 */
@Local
public interface EmpresaFacadeLocal {

    void create(Empresa empresa);

    void edit(Empresa empresa);

    void remove(Empresa empresa);

    Empresa find(Object id);

    List<Empresa> findAll();

    List<Empresa> findRange(int[] range);

    int count();
    
}
