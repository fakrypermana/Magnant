package com.example.user.magnant.home.form_pemesanan;

public class PemesananModel {
    private String nama_pasien;
    private String alamat_pasien;
    private int lama_pesan;
    private String nama_dokter;
    private String alamat_klinik;
    private double harga_perbulan;
    private double total_bayar;

    public PemesananModel(){}


    public PemesananModel(String nama_pasien, String alamat_pasien, int lama_pesan, String nama_dokter, String alamat_klinik, double harga_perbulan, double total_bayar) {
        this.nama_pasien = nama_pasien;
        this.alamat_pasien = alamat_pasien;
        this.lama_pesan = lama_pesan;
        this.nama_dokter = nama_dokter;
        this.alamat_klinik = alamat_klinik;
        this.harga_perbulan = harga_perbulan;
        this.total_bayar = total_bayar;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getAlamat_pasien() {
        return alamat_pasien;
    }

    public void setAlamat_pasien(String alamat_pasien) {
        this.alamat_pasien = alamat_pasien;
    }

    public int getLama_pesan() {
        return lama_pesan;
    }

    public void setLama_pesan(int lama_pesan) {
        this.lama_pesan = lama_pesan;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getAlamat_klinik() {
        return alamat_klinik;
    }

    public void setAlamat_klinik(String alamat_klinik) {
        this.alamat_klinik = alamat_klinik;
    }

    public double getHarga_perbulan() {
        return harga_perbulan;
    }

    public void setHarga_perbulan(double harga_perbulan) {
        this.harga_perbulan = harga_perbulan;
    }

    public double getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(double total_bayar) {
        this.total_bayar = total_bayar;
    }
}
