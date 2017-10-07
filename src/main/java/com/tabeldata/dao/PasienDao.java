/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.KoneksiDatabase;
import com.tabeldata.Model.Pasien;
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
public class PasienDao {
public void save(Pasien pasien) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="INSERT INTO latihan_1.pasien(nama,alamat,tanggal_lahir) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setString(1,pasien.getNama());
        statement.setString(2,pasien.getAlamat());
        statement.setDate(3,pasien.getTanggal_lahir());
        
        
        
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(Pasien pasien) throws SQLException {
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource datasource = koneksiDB.getDataSource();
        Connection connection = datasource.getConnection();
           
        String sql ="update latihan_1.pasien set nama=?, alamat=?,tanggal_lahir=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        //tempat isi recordnya
        statement.setString(1,pasien.getNama());
        statement.setString(2,pasien.getAlamat());
        statement.setDate(3,pasien.getTanggal_lahir());
        statement.setInt(4,pasien.getId());
        
        
        
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idPasien) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="delete from latihan_1.pasien where id=?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,idPasien);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Pasien> findAll() throws SQLException {
        List<Pasien> listPasien = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,nama,alamat,tanggal_lahir from latihan_1.pasien";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Pasien pasien = new Pasien();
            //inputkan informasi
            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
            pasien.setAlamat(resultSet.getString("alamat"));
            pasien.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
            //hasi; input dimasukkan kedalam variabel listPasien
            listPasien.add(pasien);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listPasien;
    }

    public Pasien findById(Integer idPasien) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select id,nama,alamat,tanggal_lahir from latihan_1.pasien where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idPasien);
        ResultSet resultSet = statement.executeQuery();
        Pasien pasien = new Pasien();

        if (resultSet.next()){
            
            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
            pasien.setAlamat(resultSet.getString("alamat"));
            pasien.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));

        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return pasien;    
}
    
}