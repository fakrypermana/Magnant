package com.example.user.magnant.home.hubungi_dokter;

public class HubungiModel {
    private String nama;
    private String exp;
    private int pasien;
    private double harga;
    private String alamat_klinik;

    public HubungiModel(){

    }

    public HubungiModel(String nama, String exp, int pasien, double harga, String alamat_klinik) {
        this.nama = nama;
        this.exp = exp;
        this.pasien = pasien;
        this.harga = harga;
        this.alamat_klinik = alamat_klinik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getPasien() {
        return pasien;
    }

    public void setPasien(int pasien) {
        this.pasien = pasien;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getAlamat_klinik() {
        return alamat_klinik;
    }

    public void setAlamat_klinik(String alamat_klinik) {
        this.alamat_klinik = alamat_klinik;
    }
}
