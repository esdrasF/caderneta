/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.dao;

import br.com.sga.dao.imp.AlunoDAOImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DAOFactory {
    
    private static Logger logger = LoggerFactory.getLogger(DAOFactory.class);

    public static final Class HIBERNATE = br.com.sga.dao.HibernateDAOFactory.class;

    public static DAOFactory instance(Class daoClass) {
        logger.debug("Fabrica da DAO (DAOFactory iniciada.)");
        try {
            return (DAOFactory) daoClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível criar o DAOFactory." + e);
        }
    }

    public abstract AlunoDAOImp getAlunoDAO();
}
