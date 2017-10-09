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
        
        String sql = "insert into latihan_1.rawat(pasien_id,dokter_id,ruang_id,waktu_register) VALUES (?,?,?,now())";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,rawat.getPasien().getId());
        preparedStatement.setInt(2,rawat.getDokter().getId());
        preparedStatement.setInt(3,rawat.getRuang().getId());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        sql="update latihan_1.ruang SET kosong=? WHERE id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setBoolean(1,rawat.getRuang().getKosong());
        preparedStatement.setInt(2,rawat.getRuang().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        connection.commit();
        connection.close();
    }
    
    public List<Rawat> daftarRawat() throws SQLException{ 
       
        
    String sql="SELECT \n" +
    "pasien.id as pasien_id, \n" +
    "pasien.nama as nama_pasien,\n" +
    "pasien.alamat as alamat,\n" +
    "pasien.tanggal_lahir as tanggal_lahir,\n" +
    "dokter.id as dokter_id,\n" +
    "dokter.nama as nama_dokter,\n" +
    "dokter.spesialis as spesialis,\n" +
    "ruang.id as ruang_id,\n" +
    "ruang.no_ruangan as no_ruangan,\n" +
    "ruang.kosong as ketersediaan,\n" +
    "rawat.id as id_rawat,\n" +
    "rawat.waktu_register as waktu_register,\n" +
    "rawat.waktu_checkout as waktu_checkout\n" +
    "FROM latihan_1.pasien pasien\n" +
    "JOIN latihan_1.rawat rawat on pasien.id=rawat.pasien_id\n" +
    "JOIN latihan_1.dokter dokter on rawat.dokter_id=dokter.id\n" +
    "JOIN latihan_1.ruang ruang on rawat.ruang_id=ruang.id";
    
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource datasource = koneksiDatabase.getDataSource();
        Connection connection = datasource.getConnection();
        
        List<Rawat> listRawat = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Rawat rawat = new Rawat();
            
            rawat.setPasien(new Pasien(
                    resultSet.getInt("pasien_id"),
                    resultSet.getString("nama_pasien"),
                    resultSet.getString("alamat"),
                    resultSet.getDate("tanggal_lahir")));
            
            rawat.setDokter(new Dokter(
            resultSet.getInt("id_pengunjung"),
            resultSet.getString("nama_dokter"),
            resultSet.getString("spesialis")));
            
            rawat.setId(resultSet.getInt("id_rawat"));
            rawat.setWaktu_register(resultSet.getTimestamp("waktu_register"));
            rawat.setWaktu_checkout(resultSet.getTimestamp("waktu_checkout"));
            
            listRawat.add(rawat);
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        return listRawat;
}
}
