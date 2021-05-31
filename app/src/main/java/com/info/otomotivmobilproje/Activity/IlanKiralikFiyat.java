package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;
//import com.info.otomotivmobilproje.dao.Veritabani;

import java.util.ArrayList;

public class IlanKiralikFiyat extends AppCompatActivity {
    private Spinner spinnerHaftalikAylik;
    private EditText editTextKiralikFiyat;
    private Button buttonKiralikYayinla;
    private HelperClass helperClass;

//    private Veritabani vt = new Veritabani(this);

    ArrayList<String> arrayListFiyatTur = new ArrayList<>();
    ArrayAdapter<String> arrayAdapterFiyatTur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_kiralik_fiyat);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");

        spinnerHaftalikAylik = findViewById(R.id.spinerHaftalikAylik);
        editTextKiralikFiyat = findViewById(R.id.editTextKiralikFiyat);
        buttonKiralikYayinla = findViewById(R.id.buttonIlaniYayinlaKiralik);

        arrayListFiyatTur.add("Haftalık");
        arrayListFiyatTur.add("Aylık");

        arrayAdapterFiyatTur = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, arrayListFiyatTur);
        spinnerHaftalikAylik.setAdapter(arrayAdapterFiyatTur);


        buttonKiralikYayinla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontolListe = new ArrayList<>();
                kontolListe.add(editTextKiralikFiyat);

                helperClass = new HelperClass();

                boolean sonuc = helperClass.editTextDolulukKontrol(kontolListe, v);

                if (sonuc == true) {

                    String fiyat = editTextKiralikFiyat.getText().toString();
                    aktifIlan.setIlanFiyat(Integer.parseInt(fiyat));
                    aktifIlan.setIlanKiralikHaftalikAylik(ilanKiralikTuru(spinnerHaftalikAylik.getSelectedItemPosition()));


                    Toast.makeText(IlanKiralikFiyat.this,


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


                    DbHelper helper = new DbHelper(IlanKiralikFiyat.this);

                    helper.AracIlanAdd(aktifIlan);

                    Snackbar.make(v, "İLAN VERME İŞLEMİ BAŞARILI\nİlanınız yayınlanacaktır.", Snackbar.LENGTH_LONG).show();

                    finish();




                }
            }
        });
    }

    public String ilanKiralikTuru(int id) {

        String sonuc = "";

        if (id == 0) sonuc = "Haftalık";
        else sonuc = "Aylık";

        return sonuc;
    }

}
