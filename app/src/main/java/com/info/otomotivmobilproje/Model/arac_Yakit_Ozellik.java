package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class arac_Yakit_Ozellik extends arac_Motor_Ozellik implements Serializable {

    private String ortalamaYakit;
    private String depoHacmi;

    public arac_Yakit_Ozellik() {
    }

    public arac_Yakit_Ozellik(String ortalamaYakit, String depoHacmi) {
        this.ortalamaYakit = ortalamaYakit;
        this.depoHacmi = depoHacmi;
    }

    public arac_Yakit_Ozellik(String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi) {
        super(motorTipi, motorHacmi, azamiSurat);
        this.ortalamaYakit = ortalamaYakit;
        this.depoHacmi = depoHacmi;
    }

/*
    public arac_Yakit_Ozellik(String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi) {
        super(fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat);
        this.ortalamaYakit = ortalamaYakit;
        this.depoHacmi = depoHacmi;
    }

    public arac_Yakit_Ozellik(String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi) {
        super(marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat);
        this.ortalamaYakit = ortalamaYakit;
        this.depoHacmi = depoHacmi;
    }

    public arac_Yakit_Ozellik(String sehir, String ilce, String mahalle, String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat, String ortalamaYakit, String depoHacmi) {
        super(sehir, ilce, mahalle, marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4, motorTipi, motorHacmi, azamiSurat);
        this.ortalamaYakit = ortalamaYakit;
        this.depoHacmi = depoHacmi;
    }
*/

    public String getOrtalamaYakit() {
        return ortalamaYakit;
    }

    public void setOrtalamaYakit(String ortalamaYakit) {
        this.ortalamaYakit = ortalamaYakit;
    }

    public String getDepoHacmi() {
        return depoHacmi;
    }

    public void setDepoHacmi(String depoHacmi) {
        this.depoHacmi = depoHacmi;
    }
}
