package com.example.user.magnant.home;

public class DetailModel {
    private String nama;
    private String alamat;
    private int lamaPesan;

    public DetailModel(String nama, String alamat, int lamaPesan) {
        this.nama = nama;
        this.alamat = alamat;
        this.lamaPesan = lamaPesan;
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

    public int getLamaPesan() {
        return lamaPesan;
    }

    public void setLamaPesan(int lamaPesan) {
        this.lamaPesan = lamaPesan;
    }
}
