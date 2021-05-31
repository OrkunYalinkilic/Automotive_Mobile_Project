package com.info.otomotivmobilproje.Model;

import com.info.otomotivmobilproje.Model.arac_Adres_Bilgi;

import java.io.Serializable;

public class arac_Genel_Bilgi extends arac_Adres_Bilgi implements Serializable {

    private String marka;
    private String model;
    private String seri;
    private String yil;
    private String kilometre;

    public arac_Genel_Bilgi() {
    }

    public arac_Genel_Bilgi(String marka, String model, String seri, String yil, String kilometre) {
        this.marka = marka;
        this.model = model;
        this.seri = seri;
        this.yil = yil;
        this.kilometre = kilometre;
    }

    public arac_Genel_Bilgi(String sehir, String ilce, String mahalle, String marka, String model, String seri, String yil, String kilometre) {
        super(sehir, ilce, mahalle);
        this.marka = marka;
        this.model = model;
        this.seri = seri;
        this.yil = yil;
        this.kilometre = kilometre;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getKilometre() {
        return kilometre;
    }

    public void setKilometre(String kilometre) {
        this.kilometre = kilometre;
    }
}
