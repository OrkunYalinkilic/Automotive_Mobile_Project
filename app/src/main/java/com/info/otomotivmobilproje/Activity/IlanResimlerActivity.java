package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;
//import com.info.otomotivmobilproje.dao.Veritabani;

public class IlanResimlerActivity extends AppCompatActivity {
    private Button buttonForografSec, buttonResimler;
    public TextView textViewKalanHak;
    private ImageView imageViewSecilenIlanResim;
    static final int SELECT_IMAGE = 12;
    Uri imageUri;
    public Kullanici aktifKullanici;
    public Arac_ilan aktifIlan;
    public int sayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_resimler);

        aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");

        buttonForografSec = findViewById(R.id.buttonForografSec);
        buttonResimler = findViewById(R.id.buttonResimler);
        imageViewSecilenIlanResim = findViewById(R.id.imageViewSecilenIlanResim);
        textViewKalanHak = findViewById(R.id.textViewKalanHak);

        buttonForografSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_IMAGE);
            }
        });

        buttonResimler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Toast.makeText(IlanResimlerActivity.this, aktifIlan.getFotoisim1(), Toast.LENGTH_SHORT).show();

                if (aktifIlan.getIlanTuruId() == 1) {

                    Intent intent = new Intent(IlanResimlerActivity.this, IlanFiyatSatilikActivity.class);
                    intent.putExtra("aktifKullanici", aktifKullanici);
                    intent.putExtra("aktifIlan", aktifIlan);
                    startActivity(intent);
                    finish();

                } else if (aktifIlan.getIlanTuruId() == 2) {

                    Intent intent2 = new Intent(IlanResimlerActivity.this, IlanKiralikFiyat.class);
                    intent2.putExtra("aktifKullanici", aktifKullanici);
                    intent2.putExtra("aktifIlan", aktifIlan);
                    startActivity(intent2);
                    finish();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK) {

            sayac++;
            textViewKalanHak.setText("Kalan Fotoğraf Seçme Hakkınız: " + String.valueOf(4 - sayac));

            imageUri = data.getData();

            imageViewSecilenIlanResim.setImageURI(imageUri);

/*
            switch (sayac) {
                case 0:
                    return;
                case 1:
                    aktifIlan.setFotoisim1(imageUri.toString());
                    return;
                case 2:
                    aktifIlan.setFotoisim2(imageUri.toString());
                    return;
                case 3:
                    aktifIlan.setFotoisim3(imageUri.toString());
                    return;
                case 4:
                    aktifIlan.setFotoisim4(imageUri.toString());
                    buttonForografSec.setText("SEÇİM İŞLEMİNİZ BİTTİ!");
                    buttonForografSec.setEnabled(false);
                    return;
                default:
                    return;
            }
        }*/
            //   super.onActivityResult(requestCode, resultCode, data);
        }
    }
}