package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class Arac_ilan extends arac_Yakit_Ozellik implements Serializable {

    // Adres_Bilgi , Genel_Bilgi , Motor_Ozellik, Yakit_Ozellik, Fotograflar class'lar&#x131;ndan kal&#x131;t&#x131;ld&#x131;.

    private int ilanAracIlanId;
    private int ilanKullaniciId;
    private int ilanTuruId;
    private int ilanSahibiTuruId;
    private int yakitTuruId;
    private int ilanOnay; // 1 = aktif 0 = pasif
    private int ilanFiyat;
    private String ilanKiralikHaftalikAylik;


    public Arac_ilan() {
    }

    public Arac_ilan(int ilanAracIlanId, int ilanKullaniciId, int ilanTuruId, int ilanSahibiTuruId, int yakitTuruId, int ilanOnay, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanKullaniciId = ilanKullaniciId;
        this.ilanTuruId = ilanTuruId;
        this.ilanSahibiTuruId = ilanSahibiTuruId;
        this.yakitTuruId = yakitTuruId;
        this.ilanOnay = ilanOnay;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan(String ortalamaYakit, String depoHacmi, int ilanAracIlanId, int ilanKullaniciId, int ilanTuruId, int ilanSahibiTuruId, int yakitTuruId, int ilanOnay, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanKullaniciId = ilanKullaniciId;
        this.ilanTuruId = ilanTuruId;
        this.ilanSahibiTuruId = ilanSahibiTuruId;
        this.yakitTuruId = yakitTuruId;
        this.ilanOnay = ilanOnay;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan(String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, int ilanKullaniciId, int ilanTuruId, int ilanSahibiTuruId, int yakitTuruId, int ilanOnay, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanKullaniciId = ilanKullaniciId;
        this.ilanTuruId = ilanTuruId;
        this.ilanSahibiTuruId = ilanSahibiTuruId;
        this.yakitTuruId = yakitTuruId;
        this.ilanOnay = ilanOnay;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

   /* public Arac_ilan(String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, int ilanKullaniciId, int ilanTuruId, int ilanSahibiTuruId, int yakitTuruId, int ilanOnay, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanKullaniciId = ilanKullaniciId;
        this.ilanTuruId = ilanTuruId;
        this.ilanSahibiTuruId = ilanSahibiTuruId;
        this.yakitTuruId = yakitTuruId;
        this.ilanOnay = ilanOnay;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan(String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, int ilanKullaniciId, int ilanTuruId, int ilanSahibiTuruId, int yakitTuruId, int ilanOnay, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanKullaniciId = ilanKullaniciId;
        this.ilanTuruId = ilanTuruId;
        this.ilanSahibiTuruId = ilanSahibiTuruId;
        this.yakitTuruId = yakitTuruId;
        this.ilanOnay = ilanOnay;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan(String sehir, String ilce, String mahalle, String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, int ilanKullaniciId, int ilanTuruId, int ilanSahibiTuruId, int yakitTuruId, int ilanOnay, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(sehir, ilce, mahalle, marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanKullaniciId = ilanKullaniciId;
        this.ilanTuruId = ilanTuruId;
        this.ilanSahibiTuruId = ilanSahibiTuruId;
        this.yakitTuruId = yakitTuruId;
        this.ilanOnay = ilanOnay;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }*/

    public int getIlanAracIlanId() {
        return ilanAracIlanId;
    }

    public void setIlanAracIlanId(int ilanAracIlanId) {
        this.ilanAracIlanId = ilanAracIlanId;
    }

    public int getIlanKullaniciId() {
        return ilanKullaniciId;
    }

    public void setIlanKullaniciId(int ilanKullaniciId) {
        this.ilanKullaniciId = ilanKullaniciId;
    }

    public int getIlanTuruId() {
        return ilanTuruId;
    }

    public void setIlanTuruId(int ilanTuruId) {
        this.ilanTuruId = ilanTuruId;
    }

    public int getIlanSahibiTuruId() {
        return ilanSahibiTuruId;
    }

    public void setIlanSahibiTuruId(int ilanSahibiTuruId) {
        this.ilanSahibiTuruId = ilanSahibiTuruId;
    }

    public int getYakitTuruId() {
        return yakitTuruId;
    }

    public void setYakitTuruId(int yakitTuruId) {
        this.yakitTuruId = yakitTuruId;
    }

    public int getIlanOnay() {
        return ilanOnay;
    }

    public void setIlanOnay(int ilanOnay) {
        this.ilanOnay = ilanOnay;
    }

    public int getIlanFiyat() {
        return ilanFiyat;
    }

    public void setIlanFiyat(int ilanFiyat) {
        this.ilanFiyat = ilanFiyat;
    }

    public String getIlanKiralikHaftalikAylik() {
        return ilanKiralikHaftalikAylik;
    }

    public void setIlanKiralikHaftalikAylik(String ilanKiralikHaftalikAylik) {
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }
}
