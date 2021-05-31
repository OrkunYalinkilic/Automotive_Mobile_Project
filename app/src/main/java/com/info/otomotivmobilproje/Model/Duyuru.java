package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class Duyuru implements Serializable {

    private int duyuruId;
    private String duyuruBasligi;
    private String duyuruMetni;

    public Duyuru() {
    }

    public Duyuru(int duyuruId, String duyuruBasligi, String duyuruMetni) {
        this.duyuruId = duyuruId;
        this.duyuruBasligi = duyuruBasligi;
        this.duyuruMetni = duyuruMetni;
    }

    public int getDuyuruId() {
        return duyuruId;
    }

    public void setDuyuruId(int duyuruId) {
        this.duyuruId = duyuruId;
    }

    public String getDuyuruBasligi() {
        return duyuruBasligi;
    }

    public void setDuyuruBasligi(String duyuruBasligi) {
        this.duyuruBasligi = duyuruBasligi;
    }

    public String getDuyuruMetni() {
        return duyuruMetni;
    }

    public void setDuyuruMetni(String duyuruMetni) {
        this.duyuruMetni = duyuruMetni;
    }
}
