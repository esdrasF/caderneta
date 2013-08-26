/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author DIGITACAOFUND
 */
public interface InterfaceDAO<T, ID extends Serializable> {

    void save(T entidade);

    void update(T entidade);

    void remove(T entidade);

    T getEntityByID(ID id);

    List<T> getEntityes();

    T getEntityeByCriteria(DetachedCriteria criteria);

    List<T> getEntitiesByCriteria(DetachedCriteria criteria);
}
