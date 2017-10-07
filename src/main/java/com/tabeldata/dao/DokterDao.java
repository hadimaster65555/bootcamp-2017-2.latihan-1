/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.KoneksiDatabase;
import com.tabeldata.Model.Dokter;
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
public class DokterDao {
public void save(Dokter dokter) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="INSERT INTO latihan_1.dokter(nama,spesialis) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setString(1,dokter.getNama());
        statement.setString(2,dokter.getSpesialis());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(Dokter dokter) throws SQLException {
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="update latihan_1.dotker set nama=?, spesialis=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setString(1,dokter.getNama());
        statement.setString(2,dokter.getSpesialis());
        statement.setInt(3,dokter.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idDokter) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="delete from latihan_1.dokter where id=?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,idDokter);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Dokter> findAll() throws SQLException {
        List<Dokter> listDokter = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,nama,spesialis from latihan_1.dokter";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Dokter dokter = new Dokter();
            //inputkan informasi
            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));
            //hasi; input dimasukkan kedalam variabel listPasien
            listDokter.add(dokter);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listDokter;
    }

    public Dokter findById(Integer idDokter) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,nama,spesialis from latihan_1.dokter where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idDokter);
        ResultSet resultSet = statement.executeQuery();
        Dokter dokter = new Dokter();

        if (resultSet.next()){
            
            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));

        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return dokter;    
}
    
}    

