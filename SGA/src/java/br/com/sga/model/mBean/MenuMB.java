/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.model.mBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DIGITACAOFUND
 */
@ManagedBean(name="menuBean")
@SessionScoped
public class MenuMB {
    
    public String seriePage() {
        return "seriepage";
    }
    
}
