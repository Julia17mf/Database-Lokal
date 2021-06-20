package com.example.toko;

import androidx.room.*;
import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tanggal")
    private String tanggal;

    @ColumnInfo(name = "pemasukkan")
    private String pemasukkan;

    @ColumnInfo(name = "pengeluaran")
    private String pengeluaran;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPemasukkan() {
        return pemasukkan;
    }

    public void setPemasukkan(String pemasukkan) {
        this.pemasukkan = pemasukkan;
    }

    public String getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(String pengeluaran) {
        this.pengeluaran = pengeluaran;
    }
}