/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.KoneksiDatabase;
import com.tabeldata.Model.Dokter;
import com.tabeldata.Model.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author USER
 */
public class RuangDao {
  public void save(Ruang ruang) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="INSERT INTO latihan_1.ruang(no_ruangan,kosong) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setInt(1,ruang.getNo_ruangan());
        statement.setBoolean(2,ruang.getKosong());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(Ruang ruang) throws SQLException {
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="update latihan_1.ruang set no_ruangan=?, kosong=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setInt(1,ruang.getNo_ruangan());
        statement.setBoolean(2,ruang.getKosong());
        statement.setInt(3,ruang.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idRuang) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="delete from latihan_1.ruang where id=?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,idRuang);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Ruang> findAll() throws SQLException {
        List<Ruang> listRuang = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,no_ruangan,kosong from latihan_1.ruang";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Ruang ruang = new Ruang();
            //inputkan informasi
            ruang.setId(resultSet.getInt("id"));
            ruang.setNo_ruangan(resultSet.getInt("no_ruangan"));
            ruang.setKosong(resultSet.getBoolean("kosong"));
            //hasi; input dimasukkan kedalam variabel listDokter
            listRuang.add(ruang);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listRuang;
    }

    public Ruang findById(Integer idRuang) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,no_ruangan,kosong from latihan_1.ruang where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idRuang);
        ResultSet resultSet = statement.executeQuery();
        Ruang ruang = new Ruang();

        if (resultSet.next()){
            
            ruang.setId(resultSet.getInt("id"));
            ruang.setNo_ruangan(resultSet.getInt("no_ruangan"));
            ruang.setKosong(resultSet.getBoolean("kosong"));

        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return ruang;    
}  
}
