package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

//import com.info.otomotivmobilproje.dao.DatabaseCopyHelper;
//import com.info.otomotivmobilproje.dao.KullaniciDao;
//import com.info.otomotivmobilproje.dao.Veritabani;
//import com.info.otomotivmobilproje.dao.YakitDao;

public class MainActivity extends AppCompatActivity {
    private EditText editTextKullaniciAdi, editTextSifre;
    private Button buttonGiris, btnAna;
    private TextView textViewKayit;
    //  public Veritabani vt = new Veritabani(this);
/*
    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        return super.getCallingActivity();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //   ArrayList<String> yakitArrayList = new YakitDao().tumYakitTurleri(vt);

        // GÖZÜMÜZ AYDIN. ZOR ŞARTLAR GÜÇLÜ İNSANLARDA OLUR!!..

        editTextKullaniciAdi = findViewById(R.id.editTextKullaniciAd);
        editTextSifre = findViewById(R.id.editTextSifre);
        buttonGiris = findViewById(R.id.buttonGiris);
        textViewKayit = findViewById(R.id.textViewKayit);
        btnAna = findViewById(R.id.buttonana);

        editTextKullaniciAdi.requestFocus();

        btnAna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent anaInt = new Intent(MainActivity.this, IlanKiralikFiyat.class);
                startActivity(anaInt);

                // Arac_ilan deneme = new Arac_ilan();
                // deneme.setMahalle("orkun yk mahallesiii");
                // deneme.setIlanKullaniciId(15);
                // new Arac_ilanDao().arac_ilan_Ekle(vt, deneme);
            }
        });

        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String KullaniciAdi = editTextKullaniciAdi.getText().toString();
                String Sifre = editTextSifre.getText().toString();

                if (KullaniciAdi.isEmpty()) {
                    Snackbar.make(v, "KULLANICI ADI VEYA ŞİFRE BOŞ GEÇİLEMEZ!", Snackbar.LENGTH_SHORT).show();
                    editTextKullaniciAdi.setText("");
                    editTextSifre.setText("");
                    editTextKullaniciAdi.requestFocus();
                } else if (Sifre.isEmpty()) {

                    Snackbar.make(v, "KULLANICI ADI VEYA ŞİFRE BOŞ GEÇİLEMEZ!", Snackbar.LENGTH_SHORT).show();
                    editTextSifre.setText("");
                    editTextSifre.requestFocus();

                } else {

                    DbHelper helper = new DbHelper(MainActivity.this);

                    String kullaniciAdi = editTextKullaniciAdi.getText().toString();
                    String sifre = editTextSifre.getText().toString();

                    Kullanici res = helper.kontrolKullanici(kullaniciAdi, sifre);


                    if (kullaniciAdi.equals("orkun") && sifre.equals("orkun")) {

                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                        Kullanici tmp = new Kullanici();
                        tmp.setKullaniciAdi("orkun");
                        tmp.setSifre("orkun");
                        tmp.seteMailAdres("fdgsd");
                        tmp.setKullaniciId(2);
                        intent.putExtra("aktifKullanici", tmp);
                        startActivity(intent);

                    }

                    if (res == null) {
                        Snackbar.make(v, "HATALI GİRİŞ YAPTINIZ!", Snackbar.LENGTH_SHORT).show();
                        editTextKullaniciAdi.setText("");
                        editTextSifre.setText("");
                        editTextKullaniciAdi.requestFocus();

                    } else {

                        //  Kullanici aktifKullanici = new KullaniciDao().KullaniciGetir(vt, KullaniciAdi, Sifre);

                        //  FavoriAraclar aktifFavori = new KullaniciDao().KullaniciFavAraclar(vt, aktifKullanici.getKullaniciId());
                        //Snackbar.make(v, aktifKullanici.getAd() + " " + aktifKullanici.getSoyad() + " " + String.valueOf(aktifKullanici.getKullaniciId()), Snackbar.LENGTH_LONG).show();

                        if (kullaniciAdi.equals("orkun") && sifre.equals("orkun")) {

                            Intent AdminSayfasi = new Intent(MainActivity.this, AdminActivity.class);

                            AdminSayfasi.putExtra("aktifKullanici", kullaniciAdi);

                            startActivity(AdminSayfasi);
                            if (kullaniciAdi.equals("berkay") && sifre.equals("berkay")){

                                Intent AdminSayfasi2 = new Intent(MainActivity.this, AdminActivity.class);

                                AdminSayfasi.putExtra("aktifKullanici", kullaniciAdi);

                                startActivity(AdminSayfasi);

                            }

                        } else {

                            Intent intent = new Intent(MainActivity.this, AnaMenuGirisActivity.class);
                            intent.putExtra("aktifKullanici", res);
                            startActivity(intent);


                        }
                    }
                }
            }
        });

        textViewKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayitSayfasi = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(kayitSayfasi);
            }
        });
    }

}
