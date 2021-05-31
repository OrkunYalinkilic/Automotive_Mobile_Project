package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

public class DetayilanActivity extends AppCompatActivity {

    private TextView TextilanlarMarkaModelYil, TextilanlarKilometre, TextilanlarilanTuru, TextilanlarYakitTuru, TextilanlarYili,
            TextilanlarSehir, Textilanlarilce, TextilanlarFiyat;
    private Button buttonilanlarFavEkle, buttonilanlarAyrintilar;
    private ViewPager viewPagerIlanlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detayilan);

        final Arac_ilan_DbGelen aktifIlan = (Arac_ilan_DbGelen) getIntent().getSerializableExtra("secilenilan");
        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Integer mod = (Integer) getIntent().getSerializableExtra("mod");

        TextilanlarMarkaModelYil = findViewById(R.id.TextilanlarMarkaModelYil);
        TextilanlarKilometre = findViewById(R.id.TextilanlarKilometre);
        TextilanlarilanTuru = findViewById(R.id.TextilanlarilanTuru);
        TextilanlarYakitTuru = findViewById(R.id.TextilanlarYakitTuru);
        TextilanlarYili = findViewById(R.id.TextilanlarYili);
        TextilanlarSehir = findViewById(R.id.TextilanlarSehir);
        Textilanlarilce = findViewById(R.id.Textilanlarilce);
        TextilanlarFiyat = findViewById(R.id.TextilanlarFiyat);
        buttonilanlarFavEkle = findViewById(R.id.buttonilanlarFavEkle);
        buttonilanlarAyrintilar = findViewById(R.id.buttonilanlarAyrintilar);
        viewPagerIlanlar = findViewById(R.id.viewPagerIlanlar);

        TextilanlarMarkaModelYil.setText(aktifIlan.getMarka() + " " + aktifIlan.getModel() + " " + aktifIlan.getYil());
        TextilanlarKilometre.setText(aktifIlan.getKilometre());
        TextilanlarilanTuru.setText(aktifIlan.getIlanTuruAdi());
        TextilanlarYakitTuru.setText(aktifIlan.getYakitTuruAdi());
        TextilanlarYili.setText(aktifIlan.getYil());
        TextilanlarSehir.setText(aktifIlan.getSehir());
        Textilanlarilce.setText(aktifIlan.getIlce());
        TextilanlarFiyat.setText(String.valueOf(aktifIlan.getIlanFiyat()));

        if (mod == 1) buttonilanlarFavEkle.setVisibility(View.INVISIBLE);

        buttonilanlarFavEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbHelper helper = new DbHelper(DetayilanActivity.this);

                helper.FavoriEkle(aktifKullanici.getKullaniciId(), aktifIlan.getIlanAracIlanId());

                Toast.makeText(DetayilanActivity.this, "FAVORİLERİNE EKLENDİ..", Toast.LENGTH_SHORT).show();

            }
        });

        buttonilanlarAyrintilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetayilanActivity.this, DetayilanAyrintilarActivity.class);
                intent.putExtra("aktifIlan", aktifIlan);
                startActivity(intent);


            }
        });

    }
}
