package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

public class IlanlarimDetayDuzenleActivity extends AppCompatActivity {

    private TextView TextilanimDuzenleMarkaModelYil;
    private EditText TextilanimDuzenleMarka, TextilanimDuzenleModel, TextilanimDuzenleYil, TextilanimDuzenleKilometre, TextilanimDuzenleAzamiSurat,
            TextilanimDuzenleOrtYakit, TextilanimDuzenleDepoHacim, TextilanimDuzenleMotorHacmi, TextilanimDuzenleMotorTipi,
            TextilanimDuzenleSehir, TextilanimDuzenleIlce, TextilanimDuzenleMahalle, TextilanimDuzenleFiyat;
    private Button ButtonilanimDuzenleGuncelle;
    private HelperClass helperClass;
    ArrayList<EditText> kontrolListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlarim_detay_duzenle);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan_DbGelen aktifIlan = (Arac_ilan_DbGelen) getIntent().getSerializableExtra("aktifIlan");

        //TextilanimDuzenleMarka.setFocusable(true);


        TextilanimDuzenleMarkaModelYil = findViewById(R.id.TextilanimDuzenleMarkaModelYil);
        TextilanimDuzenleMarka = findViewById(R.id.TextilanimDuzenleMarka);
        TextilanimDuzenleModel = findViewById(R.id.TextilanimDuzenleModel);
        TextilanimDuzenleYil = findViewById(R.id.TextilanimDuzenleYil);
        TextilanimDuzenleKilometre = findViewById(R.id.TextilanimDuzenleKilometre);
        TextilanimDuzenleAzamiSurat = findViewById(R.id.TextilanimDuzenleAzamiSurat);
        TextilanimDuzenleOrtYakit = findViewById(R.id.TextilanimDuzenleOrtYakit);
        TextilanimDuzenleDepoHacim = findViewById(R.id.TextilanimDuzenleDepoHacim);
        TextilanimDuzenleMotorHacmi = findViewById(R.id.TextilanimDuzenleMotorHacmi);
        TextilanimDuzenleMotorTipi = findViewById(R.id.TextilanimDuzenleMotorTipi);
        TextilanimDuzenleSehir = findViewById(R.id.TextilanimDuzenleSehir);
        TextilanimDuzenleIlce = findViewById(R.id.TextilanimDuzenleIlce);
        TextilanimDuzenleMahalle = findViewById(R.id.TextilanimDuzenleMahalle);
        TextilanimDuzenleFiyat = findViewById(R.id.TextilanimDuzenleFiyat);
        ButtonilanimDuzenleGuncelle = findViewById(R.id.ButtonilanimDuzenleGuncelle);

        TextilanimDuzenleMarkaModelYil.setText(aktifIlan.getMarka() + " " + aktifIlan.getModel() + " " + aktifIlan.getYil());
        TextilanimDuzenleMarka.setText(aktifIlan.getMarka());
        TextilanimDuzenleModel.setText(aktifIlan.getModel());
        TextilanimDuzenleYil.setText(aktifIlan.getYil());
        TextilanimDuzenleKilometre.setText(aktifIlan.getKilometre());
        TextilanimDuzenleAzamiSurat.setText(aktifIlan.getAzamiSurat());
        TextilanimDuzenleOrtYakit.setText(aktifIlan.getOrtalamaYakit());
        TextilanimDuzenleDepoHacim.setText(aktifIlan.getDepoHacmi());
        TextilanimDuzenleMotorHacmi.setText(aktifIlan.getMotorHacmi());
        TextilanimDuzenleMotorTipi.setText(aktifIlan.getMotorTipi());
        TextilanimDuzenleSehir.setText(aktifIlan.getSehir());
        TextilanimDuzenleIlce.setText(aktifIlan.getIlce());
        TextilanimDuzenleMahalle.setText(aktifIlan.getMahalle());
        TextilanimDuzenleFiyat.setText(String.valueOf(aktifIlan.getIlanFiyat()));

        TextilanimDuzenleMarka.requestFocus();

        helperClass = new HelperClass();

        kontrolListe = new ArrayList<>();
        kontrolListe.add(TextilanimDuzenleMarka);
        kontrolListe.add(TextilanimDuzenleModel);
        kontrolListe.add(TextilanimDuzenleYil);
        kontrolListe.add(TextilanimDuzenleKilometre);
        kontrolListe.add(TextilanimDuzenleAzamiSurat);
        kontrolListe.add(TextilanimDuzenleOrtYakit);
        kontrolListe.add(TextilanimDuzenleDepoHacim);
        kontrolListe.add(TextilanimDuzenleMotorHacmi);
        kontrolListe.add(TextilanimDuzenleMotorTipi);
        kontrolListe.add(TextilanimDuzenleSehir);
        kontrolListe.add(TextilanimDuzenleIlce);
        kontrolListe.add(TextilanimDuzenleMahalle);
        kontrolListe.add(TextilanimDuzenleFiyat);

        ButtonilanimDuzenleGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               boolean sonuc =  helperClass.editTextDolulukKontrol(kontrolListe, v);

               if (sonuc==true){

                   Arac_ilan aktifIlan1 = new Arac_ilan();

                   aktifIlan1.setIlanAracIlanId(aktifIlan.getIlanAracIlanId());
                   aktifIlan1.setMarka(TextilanimDuzenleMarka.getText().toString());
                   aktifIlan1.setModel(TextilanimDuzenleModel.getText().toString());
                   aktifIlan1.setYil(TextilanimDuzenleYil.getText().toString());
                   aktifIlan1.setKilometre(TextilanimDuzenleKilometre.getText().toString());
                   aktifIlan1.setAzamiSurat(TextilanimDuzenleAzamiSurat.getText().toString());
                   aktifIlan1.setOrtalamaYakit(TextilanimDuzenleOrtYakit.getText().toString());
                   aktifIlan1.setDepoHacmi(TextilanimDuzenleDepoHacim.getText().toString());
                   aktifIlan1.setMotorHacmi(TextilanimDuzenleMotorHacmi.getText().toString());
                   aktifIlan1.setMotorTipi(TextilanimDuzenleMotorTipi.getText().toString());
                   aktifIlan1.setSehir(TextilanimDuzenleSehir.getText().toString());
                   aktifIlan1.setIlce(TextilanimDuzenleIlce.getText().toString());
                   aktifIlan1.setMahalle(TextilanimDuzenleMahalle.getText().toString());
                   aktifIlan1.setIlanFiyat(Integer.parseInt(TextilanimDuzenleFiyat.getText().toString()));

                   DbHelper helper = new DbHelper(IlanlarimDetayDuzenleActivity.this);

                   helper.AracIlanUpdate(aktifIlan1);

                   Toast.makeText(IlanlarimDetayDuzenleActivity.this, "İlanınız Başarıyla Güncellendi.", Toast.LENGTH_LONG).show();

                   Handler hndler= new Handler();
                   hndler.postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           Intent intent = new Intent(IlanlarimDetayDuzenleActivity.this, AnaMenuGirisActivity.class);
                           intent.putExtra("aktifKullanici", aktifKullanici);
                           startActivity(intent);
                       }
                   },1500);
               }

               }
        });
    }
}