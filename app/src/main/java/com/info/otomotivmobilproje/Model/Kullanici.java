package com.info.otomotivmobilproje.Model;

import java.io.Serializable;
import java.util.Date;

public class Kullanici implements Serializable {

    private int kullaniciId;
    private String ad;
    private String soyad;
    private String DogumTarih;
    private String eMailAdres;
    private String kullaniciAdi;
    private String sifre;
    private int kullaniciTuruId; // 0 normal // 1 admin

    // kullanıcı adı ve şifresini alacak. sonra kullanıcıturuID sine bakacak. 1 se admin sayfası açılacak.


    public Kullanici() {
    }

    public Kullanici(int kullaniciId, String ad, String soyad, String dogumTarih, String eMailAdres, String kullaniciAdi, String sifre, int kullaniciTuruId) {
        this.kullaniciId = kullaniciId;
        this.ad = ad;
        this.soyad = soyad;
        DogumTarih = dogumTarih;
        this.eMailAdres = eMailAdres;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.kullaniciTuruId = kullaniciTuruId;
    }


    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getDogumTarih() {
        return DogumTarih;
    }

    public void setDogumTarih(String dogumTarih) {
        DogumTarih = dogumTarih;
    }

    public String geteMailAdres() {
        return eMailAdres;
    }

    public void seteMailAdres(String eMailAdres) {
        this.eMailAdres = eMailAdres;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getKullaniciTuruId() {
        return kullaniciTuruId;
    }

    public void setKullaniciTuruId(int kullaniciTuruId) {
        this.kullaniciTuruId = kullaniciTuruId;
    }
}
