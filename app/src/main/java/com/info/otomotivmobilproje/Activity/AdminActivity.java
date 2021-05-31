package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.R;
import com.info.otomotivmobilproje.UygulamaIstatistikleriActivity;

//import com.info.otomotivmobilproje.dao.DatabaseCopyHelper;
//import com.info.otomotivmobilproje.dao.Veritabani;

public class AdminActivity extends AppCompatActivity {
    private TextView TextAdminAdi;
    private Button buttonAppistatistik, buttonAdminCikis, buttonDuyuruEkle;
    //public Veritabani vt = new Veritabani(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // databaseEkle();

//        String aktifAdmin = getIntent().getStringExtra("aktifKullanici");


        TextAdminAdi = findViewById(R.id.TextAdminAdi);
        buttonAppistatistik = findViewById(R.id.buttonAppistatistik);
        buttonAdminCikis = findViewById(R.id.buttonAdminCikis);
        buttonDuyuruEkle = findViewById(R.id.buttonDuyuruEkle);

        DbHelper helper = new DbHelper(this);

        Toast.makeText(this,

                String.valueOf(helper.ilanSayisi()) + " " +
                        String.valueOf(helper.KullaniciSayisi()) + " " +
                        String.valueOf(helper.FavoriilanSayisi())


                , Toast.LENGTH_LONG).show();

       /* if (aktifAdmin=="orkun")

            TextAdminAdi.setText("ORKUN YALINKILIÇ");

        if (aktifAdmin.equals("berkay"))

            TextAdminAdi.setText("BERKAY MUMCU");*/

        //  Toast.makeText(this, aktifAdmin, Toast.LENGTH_SHORT).show();

        buttonAppistatistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this, UygulamaIstatistikleriActivity.class);
                startActivity(intent);
            }
        });

        buttonDuyuruEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this, DuyuruEklemeActivity.class);
                startActivity(intent);

            }
        });


        buttonAdminCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(AdminActivity.this, "Çıkış yapıldı..", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
