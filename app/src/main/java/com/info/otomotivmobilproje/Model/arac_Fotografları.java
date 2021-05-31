package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class arac_Fotografları extends arac_Genel_Bilgi implements Serializable {

    private byte[] fotoisim1;
    private byte[] fotoisim2;
    private byte[] fotoisim3;
    private byte[] fotoisim4;

    public arac_Fotografları() {
    }

    public arac_Fotografları(byte[] fotoisim1, byte[] fotoisim2, byte[] fotoisim3, byte[] fotoisim4) {
        this.fotoisim1 = fotoisim1;
        this.fotoisim2 = fotoisim2;
        this.fotoisim3 = fotoisim3;
        this.fotoisim4 = fotoisim4;
    }

    public arac_Fotografları(String marka, String model, String seri, String yil, String kilometre, byte[] fotoisim1, byte[] fotoisim2, byte[] fotoisim3, byte[] fotoisim4) {
        super(marka, model, seri, yil, kilometre);
        this.fotoisim1 = fotoisim1;
        this.fotoisim2 = fotoisim2;
        this.fotoisim3 = fotoisim3;
        this.fotoisim4 = fotoisim4;
    }

    public arac_Fotografları(String sehir, String ilce, String mahalle, String marka, String model, String seri, String yil, String kilometre, byte[] fotoisim1, byte[] fotoisim2, byte[] fotoisim3, byte[] fotoisim4) {
        super(sehir, ilce, mahalle, marka, model, seri, yil, kilometre);
        this.fotoisim1 = fotoisim1;
        this.fotoisim2 = fotoisim2;
        this.fotoisim3 = fotoisim3;
        this.fotoisim4 = fotoisim4;
    }

    public byte[] getFotoisim1() {
        return fotoisim1;
    }

    public void setFotoisim1(byte[] fotoisim1) {
        this.fotoisim1 = fotoisim1;
    }

    public byte[] getFotoisim2() {
        return fotoisim2;
    }

    public void setFotoisim2(byte[] fotoisim2) {
        this.fotoisim2 = fotoisim2;
    }

    public byte[] getFotoisim3() {
        return fotoisim3;
    }

    public void setFotoisim3(byte[] fotoisim3) {
        this.fotoisim3 = fotoisim3;
    }

    public byte[] getFotoisim4() {
        return fotoisim4;
    }

    public void setFotoisim4(byte[] fotoisim4) {
        this.fotoisim4 = fotoisim4;
    }
}
