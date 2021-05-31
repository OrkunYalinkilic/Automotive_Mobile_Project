package com.info.otomotivmobilproje.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

public class KullaniciBilgilerimActivity extends AppCompatActivity {

    private TextView TextKullaniciDetayAd, TextKullaniciDetaySoyad, TextKullaniciDetayDogumTarih, TextKullaniciDetayEMailAdres,
            TextKullaniciDetayKullaniciAdi;

    private Button buttonBilgiGuncelle, buttonSifreGuncelle;
    private Kullanici aktifKullanici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_bilgilerim);

        TextKullaniciDetayAd = findViewById(R.id.TextKullaniciDetayAd);
        TextKullaniciDetaySoyad = findViewById(R.id.TextKullaniciDetaySoyad);
        TextKullaniciDetayDogumTarih = findViewById(R.id.TextKullaniciDetayDogumTarih);
        TextKullaniciDetayEMailAdres = findViewById(R.id.TextKullaniciDetayEMailAdres);
        TextKullaniciDetayKullaniciAdi = findViewById(R.id.TextKullaniciDetayKullaniciAdi);
        buttonBilgiGuncelle = findViewById(R.id.buttonBilgiGuncelle);
        buttonSifreGuncelle = findViewById(R.id.buttonSifreGuncelle);


        aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");

        TextKullaniciDetayAd.setText(aktifKullanici.getAd().toString());
        TextKullaniciDetaySoyad.setText(aktifKullanici.getSoyad().toString());
        TextKullaniciDetayDogumTarih.setText(aktifKullanici.getDogumTarih().toString());
        TextKullaniciDetayEMailAdres.setText(aktifKullanici.geteMailAdres().toString());
        TextKullaniciDetayKullaniciAdi.setText(aktifKullanici.getKullaniciAdi().toString());

        buttonBilgiGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bilgiintent = new Intent(KullaniciBilgilerimActivity.this, KullaniciBilgiGuncellemeActivity.class);
                bilgiintent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(bilgiintent);

            }
        });

        buttonSifreGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sifreintent = new Intent(KullaniciBilgilerimActivity.this, KullaniciSifreGuncellemeActivity.class);
                sifreintent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(sifreintent);

            }
        });


    }
}
