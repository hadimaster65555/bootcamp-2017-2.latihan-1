package com.tabeldata;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class KoneksiDatabase {
    private final static String url="jdbc:postgresql://localhost:5432/bootcamp_2";
    private final static String username ="bootcamp_latihan";
    private final static String password="latihan";
    
    public DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }
//    public static void main(String[] args) throws SQLException {
//        KoneksiDatabase konekDb = new KoneksiDatabase();
//        konekDb.getDataSource().getConnection();
//    }
}
