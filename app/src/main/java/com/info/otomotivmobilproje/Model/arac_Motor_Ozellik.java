package com.info.otomotivmobilproje.Model;

import java.io.Serializable;

public class arac_Motor_Ozellik extends arac_Fotografları implements Serializable {

    private String motorTipi;
    private String motorHacmi;
    private String azamiSurat;


    public arac_Motor_Ozellik() {
    }

    public arac_Motor_Ozellik(String motorTipi, String motorHacmi, String azamiSurat) {
        this.motorTipi = motorTipi;
        this.motorHacmi = motorHacmi;
        this.azamiSurat = azamiSurat;
    }

   /* public arac_Motor_Ozellik(String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat) {
        super(fotoisim1, fotoisim2, fotoisim3, fotoisim4);
        this.motorTipi = motorTipi;
        this.motorHacmi = motorHacmi;
        this.azamiSurat = azamiSurat;
    }*/

/*    public arac_Motor_Ozellik(String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat) {
        super(marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4);
        this.motorTipi = motorTipi;
        this.motorHacmi = motorHacmi;
        this.azamiSurat = azamiSurat;
    }*/

/*    public arac_Motor_Ozellik(String sehir, String ilce, String mahalle, String marka, String model, String seri, String yil, String kilometre, String fotoisim1, String fotoisim2, String fotoisim3, String fotoisim4, String motorTipi, String motorHacmi, String azamiSurat) {
        super(sehir, ilce, mahalle, marka, model, seri, yil, kilometre, fotoisim1, fotoisim2, fotoisim3, fotoisim4);
        this.motorTipi = motorTipi;
        this.motorHacmi = motorHacmi;
        this.azamiSurat = azamiSurat;
    }*/

    public String getMotorTipi() {
        return motorTipi;
    }

    public void setMotorTipi(String motorTipi) {
        this.motorTipi = motorTipi;
    }

    public String getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(String motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public String getAzamiSurat() {
        return azamiSurat;
    }

    public void setAzamiSurat(String azamiSurat) {
        this.azamiSurat = azamiSurat;
    }
}
