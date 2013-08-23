/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.util;

/**
 *
 * @author DIGITACAOFUND
 */

public class TestConnection {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        
    }
}