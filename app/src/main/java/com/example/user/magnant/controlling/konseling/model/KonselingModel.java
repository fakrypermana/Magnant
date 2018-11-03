package com.example.user.magnant.controlling.konseling.model;

import java.util.Date;

public class KonselingModel {
    private String nama_konseling;
    private String tgl_sesi;
    private String nama_dokter;
    private String isi_sesi;

    public KonselingModel(String nama_konseling, String tgl_sesi, String nama_dokter, String isi_sesi) {
        this.nama_konseling = nama_konseling;
        this.tgl_sesi = tgl_sesi;
        this.nama_dokter = nama_dokter;
        this.isi_sesi = isi_sesi;
    }

    public String getNama_konseling() {
        return nama_konseling;
    }

    public void setNama_konseling(String nama_konseling) {
        this.nama_konseling = nama_konseling;
    }

    public String getTgl_sesi() {
        return tgl_sesi;
    }

    public void setTgl_sesi(String tgl_sesi) {
        this.tgl_sesi = tgl_sesi;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getisi_sesi() {
        return isi_sesi;
    }

    public void setisi_sesi(String isi_sesi) {
        this.isi_sesi = isi_sesi;
    }
}
