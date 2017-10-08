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
@WebServlet(urlPatterns = {"/dokter/list","/dokter/"})
public class DokterListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Dokter> listDokter;
        try {
            listDokter = new DokterDao().findAll();
            req.setAttribute("listDokter", listDokter);
        } catch (SQLException ex) {
            Logger.getLogger(DokterListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    req.getRequestDispatcher("/pages/dokter/listDokter.jsp").forward(req, resp);
            
    }


}
