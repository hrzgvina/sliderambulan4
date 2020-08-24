package com.example.sliderambulan;

import android.widget.Button;

public class NamaModel {
    private String nama;
    private String alamat;


    private NamaModel(){}

    private NamaModel(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;


    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
