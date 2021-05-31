package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

public class IlanlarimDetayActivity extends AppCompatActivity {

    private TextView TextilanimDetayMarkaModelYil, TextilanimDetayMarka, TextilanimDetayModel, TextilanimDetayYil, TextilanimDetayKilometre,
            TextilanimDetayAzamiSurat, TextilanimDetayOrtYakit, TextilanimDetayDepoHacmi, TextilanimDetayMotorHacim,
            TextilanimDetayMotorTip, TextilanimDetaySehir, TextilanimDetayilce, TextilanimDetayMahalle, TextilanimDetayFiyat;

    private Button ButtonilanimDetayDuzenle, ButtonilanimDetaySil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlarim_detay);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan_DbGelen aktifIlan = (Arac_ilan_DbGelen) getIntent().getSerializableExtra("aktifIlan");

        TextilanimDetayMarkaModelYil = findViewById(R.id.TextilanimDetayMarkaModelYil);
        TextilanimDetayMarka = findViewById(R.id.TextilanimDetayMarka);
        TextilanimDetayModel = findViewById(R.id.TextilanimDetayModel);
        TextilanimDetayYil = findViewById(R.id.TextilanimDetayYil);
        TextilanimDetayKilometre = findViewById(R.id.TextilanimDetayKilometre);
        TextilanimDetayAzamiSurat = findViewById(R.id.TextilanimDetayAzamiSurat);
        TextilanimDetayOrtYakit = findViewById(R.id.TextilanimDetayOrtYakit);
        TextilanimDetayDepoHacmi = findViewById(R.id.TextilanimDetayDepoHacmi);
        TextilanimDetayMotorHacim = findViewById(R.id.TextilanimDetayMotorHacim);
        TextilanimDetayMotorTip = findViewById(R.id.TextilanimDetayMotorTip);
        TextilanimDetaySehir = findViewById(R.id.TextilanimDetaySehir);
        TextilanimDetayilce = findViewById(R.id.TextilanimDetayilce);
        TextilanimDetayMahalle = findViewById(R.id.TextilanimDetayMahalle);
        TextilanimDetayFiyat = findViewById(R.id.TextilanimDetayFiyat);
        ButtonilanimDetayDuzenle = findViewById(R.id.ButtonilanimDetayDuzenle);
        ButtonilanimDetaySil = findViewById(R.id.ButtonilanimDetaySil);

        TextilanimDetayMarkaModelYil.setText(aktifIlan.getMarka() + " " + aktifIlan.getModel() + " " + aktifIlan.getYil());
        TextilanimDetayMarka.setText(aktifIlan.getMarka());
        TextilanimDetayModel.setText(aktifIlan.getModel());
        TextilanimDetayYil.setText(aktifIlan.getYil());
        TextilanimDetayKilometre.setText(aktifIlan.getKilometre());
        TextilanimDetayAzamiSurat.setText(aktifIlan.getAzamiSurat());
        TextilanimDetayOrtYakit.setText(aktifIlan.getOrtalamaYakit());
        TextilanimDetayDepoHacmi.setText(aktifIlan.getDepoHacmi());
        TextilanimDetayMotorHacim.setText(aktifIlan.getMotorHacmi());
        TextilanimDetayMotorTip.setText(aktifIlan.getMotorTipi());
        TextilanimDetaySehir.setText(aktifIlan.getSehir());
        TextilanimDetayilce.setText(aktifIlan.getIlce());
        TextilanimDetayMahalle.setText(aktifIlan.getMahalle());
        TextilanimDetayFiyat.setText(aktifIlan.getIlanFiyat() + " TL");

        ButtonilanimDetayDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IlanlarimDetayActivity.this, IlanlarimDetayDuzenleActivity.class);
                intent.putExtra("aktifIlan", aktifIlan);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);
                finish();

            }
        });

        ButtonilanimDetaySil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbHelper helper = new DbHelper(IlanlarimDetayActivity.this);
                helper.AracIlanDelete(aktifIlan.getIlanAracIlanId());

                Toast.makeText(IlanlarimDetayActivity.this, "İlanınız Yayından Kaldırıldı..", Toast.LENGTH_LONG).show();
             //   finish();

                Handler hndler = new Handler();
                hndler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(IlanlarimDetayActivity.this, AnaMenuGirisActivity.class);
                        intent.putExtra("aktifKullanici", aktifKullanici);
                        startActivity(intent);

                    }
                }, 1200);


            }
        });

    }
}
