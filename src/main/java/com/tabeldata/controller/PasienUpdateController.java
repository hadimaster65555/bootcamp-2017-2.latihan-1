/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author USER
 */
@WebServlet(urlPatterns="/pasien/ubah")
public class PasienUpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    
        try {
            Integer kodePasien = Integer.valueOf(req.getParameter("kode_pasien"));
            Pasien daftarPasien = new PasienDao().findById(kodePasien);
            req.setAttribute("pasien", kodePasien);
            req.getRequestDispatcher("/pages/pasien/editPasien.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(PasienUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    Pasien pasien=new Pasien();
    pasien.setId(Integer.valueOf(req.getParameter("id")));
    pasien.setNama(req.getParameter("namaPasien"));
    pasien.setAlamat(req.getParameter("alamatPasien"));
    pasien.setTanggal_lahir(Date.valueOf(req.getParameter("tanggalLahir")));
    PasienDao pasienDao = new PasienDao();
        try {
            pasienDao.update(pasien);
        } catch (SQLException ex) {
            Logger.getLogger(PasienUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath()+"/pasien/");
    }
    
}
