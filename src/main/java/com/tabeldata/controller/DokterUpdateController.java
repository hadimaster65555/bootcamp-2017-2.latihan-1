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
@WebServlet(urlPatterns="/dokter/update")
public class DokterUpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        Integer kodeDokter = Integer.valueOf(req.getParameter("kode_dokter"));
        Dokter daftarDokter = new DokterDao().findById(kodeDokter);
        req.setAttribute("dokter", daftarDokter);
        req.getRequestDispatcher("/pages/dokter/editDokter.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(DokterUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Dokter dokter = new Dokter();
    dokter.setId(Integer.valueOf(req.getParameter("id")));
    dokter.setNama(req.getParameter("nama"));
    dokter.setSpesialis(req.getParameter("spesialis"));
    
    DokterDao dokterDao = new DokterDao();
        try {
            dokterDao.save(dokter);
        } catch (SQLException ex) {
            Logger.getLogger(DokterUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(req.getServletContext().getContextPath()+"/dokter/");
    }
    
    
}
