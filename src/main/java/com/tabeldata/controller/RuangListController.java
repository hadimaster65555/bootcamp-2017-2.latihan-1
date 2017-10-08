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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/ruang/list","/ruang/"})
public class RuangListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Ruang> listRuang;
        try {
            listRuang = new RuangDao().findAll();
            req.setAttribute("listRuang", listRuang);
        } catch (SQLException ex) {
            Logger.getLogger(RuangListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            req.getRequestDispatcher("/pages/ruang/listRuang.jsp").forward(req, resp);
    }
    
    
}
