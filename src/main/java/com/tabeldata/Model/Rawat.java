/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.Model;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class Rawat {
    private Integer id;
    private Integer pasien_id;
    private Integer dokter_id;
    private Integer ruang_id;
    private Date waktu_register;
    private Date waktu_checkout;
    
}
