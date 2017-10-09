/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Model.Dokter;
import com.tabeldata.dao.DokterDao;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(urlPatterns="/dokter/new")
public class DokterAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/pages/dokter/tambahDokter/tambahDokter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Dokter dokter=new Dokter();
    dokter.setNama(req.getParameter("namaDokter"));
    dokter.setSpesialis(req.getParameter("spesialisDokter"));
    
    DokterDao dokterDao = new DokterDao();
        try {
            dokterDao.save(dokter);
        } catch (SQLException ex) {
            Logger.getLogger(DokterAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
                resp.sendRedirect(req.getServletContext().getContextPath()+"/dokter/");

    }

    
    
}
