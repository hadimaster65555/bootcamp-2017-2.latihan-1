/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Model.Ruang;
import com.tabeldata.dao.RuangDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ruang/update")
public class RuangUpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer kodeRuang = Integer.valueOf(req.getParameter("kode_ruang"));
            Ruang daftarRuang = new RuangDao().findById(kodeRuang);
            req.setAttribute("ruang", daftarRuang);
            req.getRequestDispatcher("/pages/ruang/editRuang.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RuangUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Ruang ruang = new Ruang();
    ruang.setId(Integer.valueOf(req.getParameter("id")));
    ruang.setNo_ruangan(Integer.valueOf(req.getParameter("no_ruangan")));
    ruang.setKosong(Boolean.valueOf(req.getParameter("kosong")));
    
    RuangDao ruangDao = new RuangDao();
        try {
            ruangDao.update(ruang);
        } catch (SQLException ex) {
            Logger.getLogger(RuangUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath()+"/ruang/");
    }
    
    
}
