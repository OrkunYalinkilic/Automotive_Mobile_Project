package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.info.otomotivmobilproje.Adapter.ImageAdapter;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnaMenuGirisActivity extends AppCompatActivity {

    private Button buttonDuyurular, buttonilanVer, buttonFavoriilanlarım, buttonilanlar, buttonilanlarim, buttonKullaniciBilgilerim;
    // private TextView textViewKullaniciAdi;
    private ViewPager viewPagerAna;
    private int[] pagerIds;
    private Kullanici aktifKullanici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ana_menu_giris);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Otomotiv Alım-Satım Uygulaması");

        DbHelper helper = new DbHelper(this);
        String msg = helper.TabloHazirlikDegerleriniBas();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        // "content://com.android.providers.media.documents/document/image%3A20";

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level  estinations.

        buttonilanlar = findViewById(R.id.buttonilanlar);
        buttonilanVer = findViewById(R.id.buttonilanVer);
        buttonFavoriilanlarım = findViewById(R.id.buttonFavoriilanlar);
        buttonDuyurular = findViewById(R.id.buttonDuyurular);
        buttonilanlarim = findViewById(R.id.buttonilanlarım);
        viewPagerAna = findViewById(R.id.viewPagerAna);
        buttonKullaniciBilgilerim = findViewById(R.id.buttonKullaniciBilgilerim);



        pagerIds = new int[]{R.drawable.testt, R.drawable.anaekraniconn, R.drawable.testt};

        ImageAdapter imageAdapter = new ImageAdapter(this, pagerIds);
        viewPagerAna.setAdapter(imageAdapter);


        // textViewKullaniciAdi = findViewById(R.id.textViewKullaniciAdi);
        //  textViewMailAdres = findViewById(R.id.textViewKullaniciMailAdres);

        aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");

        buttonilanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaMenuGirisActivity.this, IlanlarActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);

            }
        });

        buttonilanVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaMenuGirisActivity.this, AracBilgileriActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);

            }
        });

        buttonFavoriilanlarım.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaMenuGirisActivity.this, FavorilerimActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);

            }
        });

        buttonDuyurular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaMenuGirisActivity.this, DuyurularActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);

            }
        });

        buttonilanlarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnaMenuGirisActivity.this, IlanlarimActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);
            }
        });

        buttonKullaniciBilgilerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaMenuGirisActivity.this, KullaniciBilgilerimActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_anasayfa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_kullanici_bilgilerim:
                Intent intent = new Intent(AnaMenuGirisActivity.this, KullaniciBilgilerimActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent);
                return true;

            case R.id.action_sifremi_degistir:
                Intent intent2 = new Intent(AnaMenuGirisActivity.this, KullaniciSifreGuncellemeActivity.class);
                intent2.putExtra("aktifKullanici", aktifKullanici);
                startActivity(intent2);
                return true;

            case R.id.action_hakkimizda:
                Intent intent4 = new Intent(AnaMenuGirisActivity.this, HakkimizdaActivity.class);
                startActivity(intent4);
                return true;

            case R.id.action_cikis:
                Toast.makeText(getApplicationContext(), "Çıkış yapıldı..", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(AnaMenuGirisActivity.this, MainActivity.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
