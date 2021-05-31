package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

public class AdresBilgileriActivity extends AppCompatActivity {
    private EditText editTextSehir, editTextIlce, editTextMahalle;
    private Button buttonAdresBilgi;
    private HelperClass helperClass = new HelperClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adres_bilgileri);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");

        editTextSehir = findViewById(R.id.editTextSehir);
        editTextIlce = findViewById(R.id.editTextilce);
        editTextMahalle = findViewById(R.id.editTextMahalle);
        buttonAdresBilgi = findViewById(R.id.buttonAdres);


        buttonAdresBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolListe = new ArrayList<>();
                kontrolListe.add(editTextSehir);
                kontrolListe.add(editTextIlce);
                kontrolListe.add(editTextMahalle);

                boolean sonuc = helperClass.editTextDolulukKontrol(kontrolListe, v);

                if (sonuc == true) {

                    aktifIlan.setSehir(editTextSehir.getText().toString());
                    aktifIlan.setIlce(editTextIlce.getText().toString());
                    aktifIlan.setMahalle(editTextMahalle.getText().toString());

                    Intent intent = new Intent(AdresBilgileriActivity.this, IlanResimlerActivity.class);
                    intent.putExtra("aktifKullanici", aktifKullanici);
                    intent.putExtra("aktifIlan", aktifIlan);
                    startActivity(intent);
                    finish();

                }


            }
        });
    }
}
