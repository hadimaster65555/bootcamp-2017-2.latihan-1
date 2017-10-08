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

/**
 *
 * @author USER
 */
@WebServlet(urlPatterns="/ruang/new")
public class RuangAddController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/ruang/tambahRuang/tambahRuang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ruang ruang=new Ruang();
        ruang.setNo_ruangan(Integer.valueOf(req.getParameter("no_ruangan")));
        ruang.setKosong(Boolean.valueOf(req.getParameter("kosong")));
        
        RuangDao ruangDao = new RuangDao();
        try {
            ruangDao.save(ruang);
        } catch (SQLException ex) {
            Logger.getLogger(RuangAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath()+"/ruang/");
    }
    
    
}
