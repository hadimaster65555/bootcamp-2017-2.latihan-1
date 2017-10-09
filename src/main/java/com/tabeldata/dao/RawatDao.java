/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.KoneksiDatabase;
import com.tabeldata.Model.Dokter;
import com.tabeldata.Model.Pasien;
import com.tabeldata.Model.Rawat;
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

public class RawatDao {
    public void register(Rawat rawat) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        connection.setAutoCommit(false);
        
        String sql = "insert into latihan_1.rawat(pasien_id,dokter_id,ruang_id,waktu_register,waktu_checkout) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,rawat.getPasien().getId());
        preparedStatement.setInt(2,rawat.getDokter().getId());
        preparedStatement.setInt(3,rawat.getRuang().getId());
        preparedStatement.setTimestamp(4, rawat.getWaktu_register());
        preparedStatement.setTimestamp(5, rawat.getWaktu_checkout());
        
        preparedStatement.executeUpdate();
        
        sql="update latihan_1.ruang SET kosong=FALSE WHERE id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,rawat.getRuang().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        preparedStatement.close();
        connection.close();
    }
    
    public List<Rawat> daftarRawat() throws SQLException{ 
       
        
    String sql="SELECT \n" +
    "rawat.id as id_rawat,\n" +
    "rawat.waktu_register as waktu_register,\n" +
    "rawat.waktu_checkout as waktu_checkout\n" +
    "pasien.id as id_pasien, \n" +
    "pasien.nama as nama_pasien,\n" +
    "pasien.alamat as alamat_pasien,\n" +
    "pasien.tanggal_lahir as tanggal_lahir,\n" +
    "dokter.id as id_dokter,\n" +
    "dokter.nama as nama_dokter,\n" +
    "dokter.spesialis as spesialis,\n" +
    "ruang.id as id_ruang,\n" +
    "ruang.no_ruangan as no_ruangan,\n" +
    "ruang.kosong as ketersediaan,\n" +
    "FROM latihan_1.rawat rawat\n" +
    "JOIN latihan_1.pasien pasien on (rawat.pasien_id=pasien.id)\n" +
    "JOIN latihan_1.dokter dokter on (rawat.dokter_id=dokter.id)\n" +
    "JOIN latihan_1.ruang ruang on (rawat.ruang_id=ruang.id)";
    
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        List<Rawat> listRawat = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            
            Rawat rawat = new Rawat();
            rawat.setId(resultSet.getInt("id_rawat"));
            
            rawat.setPasien(new Pasien(
                    resultSet.getInt("id_pasien"),
                    resultSet.getString("nama_pasien"),
                    resultSet.getString("alamat_pasien"),
                    resultSet.getDate("tanggal_lahir")));
            
            rawat.setDokter(new Dokter(
            resultSet.getInt("id_dokter"),
            resultSet.getString("nama_dokter"),
            resultSet.getString("spesialis")));
            
            rawat.setRuang(new Ruang(
            resultSet.getInt("id_ruang"),
            resultSet.getInt("no_ruangan"),
            resultSet.getBoolean("ketersediaan")));
            
            rawat.setWaktu_register(resultSet.getTimestamp("waktu_register"));
            rawat.setWaktu_checkout(resultSet.getTimestamp("waktu_checkout"));
            
            listRawat.add(rawat);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listRawat;
}
    
        public List<Rawat> findAll() throws SQLException {
        List<Rawat> listRawat = new ArrayList<>();
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select * from latihan_1.rawat";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Rawat rawat = new Rawat();
            //inputkan informasi
            rawat.setId(resultSet.getInt("id"));
            rawat.setPasien_id(resultSet.getInt("pasien_id"));
            rawat.setDokter_id(resultSet.getInt("dokter_id"));
            rawat.setRuang_id(resultSet.getInt("ruang_id"));
            rawat.setWaktu_register(resultSet.getTimestamp("waktu_register"));
            rawat.setWaktu_checkout(resultSet.getTimestamp("waktu_checkout"));
            //hasi; input dimasukkan kedalam variabel listRawat
            listRawat.add(rawat);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return listRawat;
    }

    
    public Rawat findById(Integer idRawat) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        String sql="select * from latihan_1.rawat where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idRawat);
        ResultSet resultSet = preparedStatement.executeQuery();
        Rawat rawat = new Rawat();

        if (resultSet.next()){
            
            rawat.setId(resultSet.getInt("id"));
            Pasien pasien = new Pasien();
            pasien.setId(resultSet.getInt("pasien_id"));
            rawat.setPasien(pasien);
            Dokter dokter = new Dokter();
            dokter.setId(resultSet.getInt("dokter_id"));
            rawat.setDokter(dokter);
            Ruang ruang = new Ruang();
            ruang.setId(resultSet.getInt("ruang_id"));
            rawat.setRuang(ruang);
            
            rawat.setWaktu_register(resultSet.getTimestamp("waktu_register"));
            rawat.setWaktu_checkout(resultSet.getTimestamp("waktu_checkout"));
        }
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return rawat;    
}
}
