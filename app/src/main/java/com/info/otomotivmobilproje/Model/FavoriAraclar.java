package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class FavoriAraclar implements Serializable {

    private int favKullaniciId;
    private int favId1;
    private int favId2;
    private int favId3;
    private int favId4;
    private int favId5;
    private int sonfavId;

    public FavoriAraclar() {
    }

    public FavoriAraclar(int favKullaniciId, int favId1, int favId2, int favId3, int favId4, int favId5, int sonfavId) {
        this.favKullaniciId = favKullaniciId;
        this.favId1 = favId1;
        this.favId2 = favId2;
        this.favId3 = favId3;
        this.favId4 = favId4;
        this.favId5 = favId5;
        this.sonfavId = sonfavId;
    }

    public int getFavKullaniciId() {
        return favKullaniciId;
    }

    public void setFavKullaniciId(int favKullaniciId) {
        this.favKullaniciId = favKullaniciId;
    }

    public int getFavId1() {
        return favId1;
    }

    public void setFavId1(int favId1) {
        this.favId1 = favId1;
    }

    public int getFavId2() {
        return favId2;
    }

    public void setFavId2(int favId2) {
        this.favId2 = favId2;
    }

    public int getFavId3() {
        return favId3;
    }

    public void setFavId3(int favId3) {
        this.favId3 = favId3;
    }

    public int getFavId4() {
        return favId4;
    }

    public void setFavId4(int favId4) {
        this.favId4 = favId4;
    }

    public int getFavId5() {
        return favId5;
    }

    public void setFavId5(int favId5) {
        this.favId5 = favId5;
    }

    public int getSonfavId() {
        return sonfavId;
    }

    public void setSonfavId(int sonfavId) {
        this.sonfavId = sonfavId;
    }
}
