/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.model.mBean;

import br.com.sga.dao.DAOFactory;
import br.com.sga.dao.imp.SerieDAOImp;
import br.com.sga.model.vo.Serie;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DIGITACAOFUND
 */
@ManagedBean(name = "serieBean")
@RequestScoped
public class SerieMB implements Serializable {

    private Serie serie;
    private List<Serie> series;
    private SerieDAOImp serieDAO;
    private boolean disable = true;

    public SerieMB() {
        setSerie(new Serie());
        serieDAO = DAOFactory.instance(DAOFactory.HIBERNATE).getSerieDAOImp();
    }

    public Serie getSerie() {

        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Serie> getSeries() {
        return serieDAO.getEntityes();
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public boolean getDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    public void habilitarCampos() {
        setDisable(false);
    }
    
    public void inserirSerie() {
        serieDAO.save(serie);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Série inserida com sucesso.",
                null));
    }
}
