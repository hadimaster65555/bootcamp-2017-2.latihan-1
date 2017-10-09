/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Model.Dokter;
import com.tabeldata.Model.Pasien;
import com.tabeldata.Model.Rawat;
import com.tabeldata.Model.Ruang;
import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
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

@WebServlet(urlPatterns="/rawat/new")
public class RawatAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Pasien> listPasien;
            listPasien = new PasienDao().findAll();
            List<Dokter> listDokter;
            listDokter = new DokterDao().findAll();
            List<Ruang> listRuang = new RuangDao().findAll();
            req.setAttribute("listPasien", listPasien);
            req.setAttribute("listDokter",listDokter);
            req.setAttribute("listRuang",listRuang);
            req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rawat rawat = new Rawat();
    
        try {
            Integer pasienId = Integer.valueOf(req.getParameter("pasienId"));
            rawat.setPasien(new PasienDao().findById(pasienId));
            Integer dokterId = Integer.valueOf(req.getParameter("dokterId"));
            rawat.setDokter(new DokterDao().findById(dokterId));
            Integer ruangId = Integer.valueOf(req.getParameter("ruangId"));
            rawat.setRuang(new RuangDao().findById(ruangId));
            
            new RawatDao().register(rawat);
            
            resp.sendRedirect(req.getServletContext().getContextPath()+"/rawat/list");
        } catch (SQLException ex) {
            Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
    }
    
    
}
