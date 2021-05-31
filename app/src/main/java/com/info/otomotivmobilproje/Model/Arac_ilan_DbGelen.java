package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class Arac_ilan_DbGelen extends arac_Yakit_Ozellik implements Serializable {

    private int ilanAracIlanId;
    private String ilanSahibiAdi;
    private String ilanSahibiSoyadi;
    private String ilanTuruAdi;
    private String ilanSahibiTuruAdi;
    private String yakitTuruAdi;
    private int ilanFiyat;
    private String ilanKiralikHaftalikAylik;

    public Arac_ilan_DbGelen() {
    }

    public Arac_ilan_DbGelen(int ilanAracIlanId, String ilanSahibiAdi, String ilanSahibiSoyadi, String ilanTuruAdi, String ilanSahibiTuruAdi, String yakitTuruAdi, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanSahibiAdi = ilanSahibiAdi;
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
        this.ilanTuruAdi = ilanTuruAdi;
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
        this.yakitTuruAdi = yakitTuruAdi;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan_DbGelen(String ortalamaYakit, String depoHacmi, int ilanAracIlanId, String ilanSahibiAdi, String ilanSahibiSoyadi, String ilanTuruAdi, String ilanSahibiTuruAdi, String yakitTuruAdi, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanSahibiAdi = ilanSahibiAdi;
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
        this.ilanTuruAdi = ilanTuruAdi;
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
        this.yakitTuruAdi = yakitTuruAdi;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan_DbGelen(String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, String ilanSahibiAdi, String ilanSahibiSoyadi, String ilanTuruAdi, String ilanSahibiTuruAdi, String yakitTuruAdi, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanSahibiAdi = ilanSahibiAdi;
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
        this.ilanTuruAdi = ilanTuruAdi;
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
        this.yakitTuruAdi = yakitTuruAdi;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

 /*   public Arac_ilan_DbGelen(String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, String ilanSahibiAdi, String ilanSahibiSoyadi, String ilanTuruAdi, String ilanSahibiTuruAdi, String yakitTuruAdi, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanSahibiAdi = ilanSahibiAdi;
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
        this.ilanTuruAdi = ilanTuruAdi;
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
        this.yakitTuruAdi = yakitTuruAdi;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan_DbGelen(String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, String ilanSahibiAdi, String ilanSahibiSoyadi, String ilanTuruAdi, String ilanSahibiTuruAdi, String yakitTuruAdi, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanSahibiAdi = ilanSahibiAdi;
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
        this.ilanTuruAdi = ilanTuruAdi;
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
        this.yakitTuruAdi = yakitTuruAdi;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }

    public Arac_ilan_DbGelen(String sehir, String ilce, String mahalle, String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi, int ilanAracIlanId, String ilanSahibiAdi, String ilanSahibiSoyadi, String ilanTuruAdi, String ilanSahibiTuruAdi, String yakitTuruAdi, int ilanFiyat, String ilanKiralikHaftalikAylik) {
        super(sehir, ilce, mahalle, marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat, ortalamaYakit, depoHacmi);
        this.ilanAracIlanId = ilanAracIlanId;
        this.ilanSahibiAdi = ilanSahibiAdi;
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
        this.ilanTuruAdi = ilanTuruAdi;
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
        this.yakitTuruAdi = yakitTuruAdi;
        this.ilanFiyat = ilanFiyat;
        this.ilanKiralikHaftalikAylik = ilanKiralikHaftalikAylik;
    }
*/
    public int getIlanAracIlanId() {
        return ilanAracIlanId;
    }

    public void setIlanAracIlanId(int ilanAracIlanId) {
        this.ilanAracIlanId = ilanAracIlanId;
    }

    public String getIlanSahibiAdi() {
        return ilanSahibiAdi;
    }

    public void setIlanSahibiAdi(String ilanSahibiAdi) {
        this.ilanSahibiAdi = ilanSahibiAdi;
    }

    public String getIlanSahibiSoyadi() {
        return ilanSahibiSoyadi;
    }

    public void setIlanSahibiSoyadi(String ilanSahibiSoyadi) {
        this.ilanSahibiSoyadi = ilanSahibiSoyadi;
    }

    public String getIlanTuruAdi() {
        return ilanTuruAdi;
    }

    public void setIlanTuruAdi(String ilanTuruAdi) {
        this.ilanTuruAdi = ilanTuruAdi;
    }

    public String getIlanSahibiTuruAdi() {
        return ilanSahibiTuruAdi;
    }

    public void setIlanSahibiTuruAdi(String ilanSahibiTuruAdi) {
        this.ilanSahibiTuruAdi = ilanSahibiTuruAdi;
    }

    public String getYakitTuruAdi() {
        return yakitTuruAdi;
    }

    public void setYakitTuruAdi(String yakitTuruAdi) {
        this.yakitTuruAdi = yakitTuruAdi;
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
