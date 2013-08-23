/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.model.dao;

import br.com.sga.model.dao.imp.AlunoDAOImp;
import br.com.sga.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author DIGITACAOFUND
 */
public class HibernateDAOFactory extends DAOFactory {

    @Override
    public AlunoDAOImp getAlunoDAO() {
        return (AlunoDAOImp) instantiateDAO(AlunoDAOImp.class);
    }

    private HibernateDAOImp instantiateDAO(Class daoClass) {
        try {
            HibernateDAOImp dao = (HibernateDAOImp) daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception e) {
            throw new RuntimeException("Nãom pode instanciar o DAO: " + daoClass, e);
        }
    }

    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
