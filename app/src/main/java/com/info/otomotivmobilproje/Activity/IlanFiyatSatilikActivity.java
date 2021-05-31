package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

//import com.info.otomotivmobilproje.dao.Arac_ilanDao;
//import com.info.otomotivmobilproje.dao.Veritabani;

public class IlanFiyatSatilikActivity extends AppCompatActivity {
    private EditText editTextSatilikFiyat;
    private Button buttonSatilikYayinla;
    private HelperClass helperClass;
    //public Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_fiyat_satilik);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");

        aktifIlan.setIlanKiralikHaftalikAylik("Satılık");

        editTextSatilikFiyat = findViewById(R.id.editTextSatilikFiyat);
        buttonSatilikYayinla = findViewById(R.id.buttonIlaniYayinlaSatilik);
   //     vt = new Veritabani(this);

        buttonSatilikYayinla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolListe = new ArrayList<>();
                kontrolListe.add(editTextSatilikFiyat);

                helperClass = new HelperClass();

                boolean sonuc = helperClass.editTextDolulukKontrol(kontrolListe, v);

                Toast.makeText(IlanFiyatSatilikActivity.this,

                        "ilanAracIlanId: " + String.valueOf(aktifIlan.getIlanAracIlanId()) + "\n" +
                                "ilanKullaniciId: " + String.valueOf(aktifIlan.getIlanKullaniciId()) + "\n" +
                                "ilanTuruId: " + String.valueOf(aktifIlan.getIlanTuruId()) + "\n" +
                                "ilanSahibiTuruId: " + String.valueOf(aktifIlan.getIlanSahibiTuruId()) + "\n" +
                                "yakitTuruId: " + String.valueOf(aktifIlan.getYakitTuruId()) + "\n" +
                                "ilanFiyat: " + String.valueOf(aktifIlan.getIlanFiyat()) + "\n" +
                                "ilanKiralikHaftalikAylik:" + String.valueOf(aktifIlan.getIlanKiralikHaftalikAylik()) + "\n" +
                                "ortalamaYakit: " + aktifIlan.getOrtalamaYakit() + "\n" +
                                "depoHacmi: " + aktifIlan.getDepoHacmi() + "\n" +
                                "motorTipi: " + aktifIlan.getMotorTipi() + "\n" +
                                "motorHacmi: " + aktifIlan.getMotorHacmi() + "\n" +
                                "azamiSurat: " + aktifIlan.getAzamiSurat() + "\n" +
                                "fotoisim1:" + aktifIlan.getFotoisim1() + "\n" +
                                "fotoisim2:" + aktifIlan.getFotoisim2() + "\n" +
                                "fotoisim3:" + aktifIlan.getFotoisim3() + "\n" +
                                "fotoisim4:" + aktifIlan.getFotoisim4() + "\n" +
                                "marka:" + aktifIlan.getMarka() + "\n" +
                                "model:" + aktifIlan.getModel() + "\n" +
                                "seri:" + aktifIlan.getSeri() + "\n" +
                                "yil:" + aktifIlan.getYil() + "\n" +
                                "kilometre:" + aktifIlan.getKilometre() + "\n" +
                                "sehir:" + aktifIlan.getSehir() + "\n" +
                                "ilce:" + aktifIlan.getIlce() + "\n" +
                                "mahalle:" + aktifIlan.getMahalle() + "\n"

                        , Toast.LENGTH_LONG).show();


                if (sonuc == true) {

                    String fiyat = editTextSatilikFiyat.getText().toString();
                    aktifIlan.setIlanFiyat(Integer.parseInt(fiyat));


                    try {

                        DbHelper helper = new DbHelper(IlanFiyatSatilikActivity.this);
                        helper.AracIlanAdd(aktifIlan);

                        Snackbar.make(v, "İLAN VERME İŞLEMİ BAŞARILI\nİlan onaylandıktan sonra yayınlanacaktır.", Snackbar.LENGTH_LONG).show();
                        finish();

                    } catch (Exception e) {

                      Toast.makeText(IlanFiyatSatilikActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }


                    Toast.makeText(getApplicationContext(), "İlan Yayınlanacaktır.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
