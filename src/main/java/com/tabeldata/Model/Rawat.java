/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.Model;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class Rawat {
    private Integer id;
    private Pasien pasien;
    private Dokter dokter;
    private Ruang ruang;
    private Timestamp waktu_register;
    private Timestamp waktu_checkout;
    
}
