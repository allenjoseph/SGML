/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgml.ejb.servicio;

import com.sgml.ejb.persistencia.AuSession;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Allen
 */
@Local
public interface AuSessionFacadeLocal {

    void create(AuSession auSession);

    void edit(AuSession auSession);

    void remove(AuSession auSession);

    AuSession find(Object id);

    List<AuSession> findAll();

    List<AuSession> findRange(int[] range);

    int count();
    
}
