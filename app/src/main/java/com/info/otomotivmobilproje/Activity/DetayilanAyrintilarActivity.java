package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.R;

public class DetayilanAyrintilarActivity extends AppCompatActivity {

    private TextView TextilanlarAyrintiMarkaModelYil, TextilanlarAyrintiilanSahibi, TextilanlarAyrintiIlanTuru, TextilanlarAyrintiMarka, TextilanlarAyrintiModel,
            TextilanlarAyrintiYil, TextilanlarAyrintiKilometre, TextilanlarAyrintiOrtalamaYakit, TextilanlarAyrintiDepoHacmi,
            TextilanlarAyrintiYakitTuru, TextilanlarAyrintiilanSahibiTuru, TextilanlarAyrintiSehir, TextilanlarAyrintiilce,
            TextilanlarAyrintiMahalle, TextilanlarAyrintiFiyatBilgi;
    private Button ButtonilanlarAyrintiGeriDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detayilan_ayrintilar);

        final Arac_ilan_DbGelen aktifIlan = (Arac_ilan_DbGelen) getIntent().getSerializableExtra("aktifIlan");

        TextilanlarAyrintiMarkaModelYil = findViewById(R.id.TextilanlarAyrintiMarkaModelYil);
        TextilanlarAyrintiilanSahibi = findViewById(R.id.TextilanlarAyrintiilanSahibi);
        TextilanlarAyrintiIlanTuru = findViewById(R.id.TextilanlarAyrintiIlanTuru);
        TextilanlarAyrintiMarka = findViewById(R.id.TextilanlarAyrintiMarka);
        TextilanlarAyrintiModel = findViewById(R.id.TextilanlarAyrintiModel);
        TextilanlarAyrintiYil = findViewById(R.id.TextilanlarAyrintiYil);
        TextilanlarAyrintiKilometre = findViewById(R.id.TextilanlarAyrintiKilometre);
        TextilanlarAyrintiOrtalamaYakit = findViewById(R.id.TextilanlarAyrintiOrtalamaYakit);
        TextilanlarAyrintiDepoHacmi = findViewById(R.id.TextilanlarAyrintiDepoHacmi);
        TextilanlarAyrintiYakitTuru = findViewById(R.id.TextilanlarAyrintiYakitTuru);
        TextilanlarAyrintiilanSahibiTuru = findViewById(R.id.TextilanlarAyrintiilanSahibiTuru);
        TextilanlarAyrintiSehir = findViewById(R.id.TextilanlarAyrintiSehir);
        TextilanlarAyrintiilce = findViewById(R.id.TextilanlarAyrintiilce);
        TextilanlarAyrintiMahalle = findViewById(R.id.TextilanlarAyrintiMahalle);
        TextilanlarAyrintiFiyatBilgi = findViewById(R.id.TextilanlarAyrintiFiyatBilgi);
        ButtonilanlarAyrintiGeriDon = findViewById(R.id.ButtonilanlarAyrintiGeriDon);

        TextilanlarAyrintiMarkaModelYil.setText(aktifIlan.getMarka() + " " + aktifIlan.getModel() + " " + aktifIlan.getYil());
        TextilanlarAyrintiilanSahibi.setText(aktifIlan.getIlanSahibiAdi() + " " + aktifIlan.getIlanSahibiSoyadi());
        TextilanlarAyrintiIlanTuru.setText(aktifIlan.getIlanTuruAdi());
        TextilanlarAyrintiMarka.setText(aktifIlan.getMarka());
        TextilanlarAyrintiModel.setText(aktifIlan.getModel());
        TextilanlarAyrintiYil.setText(aktifIlan.getYil());
        TextilanlarAyrintiKilometre.setText(aktifIlan.getKilometre());
        TextilanlarAyrintiOrtalamaYakit.setText(aktifIlan.getOrtalamaYakit());
        TextilanlarAyrintiDepoHacmi.setText(aktifIlan.getDepoHacmi());
        TextilanlarAyrintiYakitTuru.setText(aktifIlan.getYakitTuruAdi());
        TextilanlarAyrintiilanSahibiTuru.setText(aktifIlan.getIlanSahibiTuruAdi());
        TextilanlarAyrintiSehir.setText(aktifIlan.getSehir());
        TextilanlarAyrintiilce.setText(aktifIlan.getIlce());
        TextilanlarAyrintiMahalle.setText(aktifIlan.getMahalle());
        TextilanlarAyrintiFiyatBilgi.setText(String.valueOf(aktifIlan.getIlanFiyat()) + " TL");

        ButtonilanlarAyrintiGeriDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetayilanAyrintilarActivity.this, DetayilanActivity.class);
                intent.putExtra("secilenilan", aktifIlan);
                startActivity(intent);
                finish();

            }
        });


    }
}
