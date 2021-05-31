package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class arac_Adres_Bilgi implements Serializable {

    private String sehir;
    private String ilce;
    private String mahalle;

    public arac_Adres_Bilgi() {
    }

    public arac_Adres_Bilgi(String sehir, String ilce, String mahalle) {
        this.sehir = sehir;
        this.ilce = ilce;
        this.mahalle = mahalle;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }
}
