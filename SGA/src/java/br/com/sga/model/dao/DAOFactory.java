/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.model.dao;

import br.com.sga.model.dao.imp.AlunoDAOImp;

/**
 *
 * @author DIGITACAOFUND
 */
public abstract class DAOFactory {

    public static final Class HIBERNATE = br.com.sga.model.dao.HibernateDAOFactory.class;

    public static DAOFactory instance(Class daoClass) {
        try {
            return (DAOFactory) daoClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível criar o DAOFactory." + e);
        }
    }

    public abstract AlunoDAOImp getAlunoDAO();
}
