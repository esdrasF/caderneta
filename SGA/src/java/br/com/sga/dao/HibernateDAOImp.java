/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author DIGITACAOFUND
 */
public abstract class HibernateDAOImp<T, ID extends Serializable>
        implements InterfaceDAO<T, ID> {

    private Class<T> classe;
    private Session session;

    public HibernateDAOImp() {
        this.classe =
                (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getClasse() {
        return classe;
    }

    public void setClasse(Class<T> classe) {
        this.classe = classe;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(T entidade) {
        getSession().save(entidade);
    }

    @Override
    public void update(T entidade) {
        getSession().update(entidade);
    }

    @Override
    public void remove(T entidade) {
        getSession().delete(entidade);
    }

    @Override
    public T getEntityByID(Serializable id) {
        T entidade = (T) getSession().get(classe, id);
        return entidade;
    }

    @Override
    public List<T> getEntityes() {
        List<T> listEntidades = getSession().createCriteria(classe).list();
        return listEntidades;
    }

    @Override
    public T getEntityeByCriteria(DetachedCriteria criteria) {
        T entidade = (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
        return entidade;
    }

    @Override
    public List<T> getEntitiesByCriteria(DetachedCriteria criteria) {
        List<T> litEntidades = criteria.getExecutableCriteria(getSession()).list();
        return litEntidades;
    }
}
