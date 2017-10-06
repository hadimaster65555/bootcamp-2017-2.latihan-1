package com.tabeldata.controller;

import com.tabeldata.Model.Pasien;
import com.tabeldata.dao.PasienDao;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/pasien/new")
public class PasienController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    req.getRequestDispatcher("/pages/pasien/tambahPasien/tambahPasien.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    Pasien pasien = new Pasien();
    pasien.setNama(req.getParameter("namaPasien"));
    pasien.setAlamat(req.getParameter("alamat"));
    pasien.setTanggal_lahir(Date.valueOf("tanggalLahir"));
    
    PasienDao pasienDao = new PasienDao();
    try {
        pasienDao.save(pasien);
    } catch (SQLException ex) {
        Logger.getLogger(PasienController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    
    
    
    
}
