/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Model.Pasien;
import com.tabeldata.dao.PasienDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(urlPatterns={"/pasien/list","/pasien/"})
public class PasienListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        List<Pasien> listPasien;
        
        try {
            listPasien = new PasienDao().findAll();
            req.setAttribute("listPasien", listPasien);
        } catch (SQLException ex) {
            Logger.getLogger(PasienListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.getRequestDispatcher("/pages/pasien/listPasien.jsp").forward(req, resp);
    }
    
    
}
