/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Model.Rawat;
import com.tabeldata.dao.RawatDao;
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

@WebServlet(urlPatterns={"/rawat/list","/rawat/"})
public class RawatListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Rawat> listRawat;
        try {
            listRawat = new RawatDao().daftarRawat();
            req.setAttribute("listRawat", listRawat);
        } catch (SQLException ex) {
            Logger.getLogger(RawatListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.getRequestDispatcher("/pages/rawat/listRawat.jsp").forward(req, resp);
    }
    
    
}
