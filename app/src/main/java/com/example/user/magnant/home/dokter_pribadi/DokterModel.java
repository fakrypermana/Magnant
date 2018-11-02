package com.example.user.magnant.home.dokter_pribadi;

public class DokterModel {
    private String nama;
    private String exp;
    private int pasien;
    private long harga;

    public DokterModel(String nama, String exp, int pasien, long harga) {
        this.nama = nama;
        this.exp = exp;
        this.pasien = pasien;
        this.harga = harga;
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

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }
}
