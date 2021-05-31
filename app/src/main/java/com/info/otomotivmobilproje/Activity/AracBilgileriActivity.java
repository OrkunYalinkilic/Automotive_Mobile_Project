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

public class AracBilgileriActivity extends AppCompatActivity {
    private EditText editTextMarka, editTextModel, editTextSeri, editTextYili, editTextKilometre;
    private Button buttonAracBilgi;
    private HelperClass helperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_bilgileri);

        editTextMarka = findViewById(R.id.editTextMarka);
        editTextModel = findViewById(R.id.editTextModel);
        editTextSeri = findViewById(R.id.editTextSeri);
        editTextYili = findViewById(R.id.editTextYili);
        editTextKilometre = findViewById(R.id.editTextKilometre);
        buttonAracBilgi = findViewById(R.id.buttonAracBilgi);

        helperClass = new HelperClass();

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");

        buttonAracBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolListe = new ArrayList<>();
                kontrolListe.add(editTextMarka);
                kontrolListe.add(editTextModel);
                kontrolListe.add(editTextSeri);
                kontrolListe.add(editTextYili);
                kontrolListe.add(editTextKilometre);

                boolean sonuc = helperClass.editTextDolulukKontrol(kontrolListe, v);

                if (sonuc == true) {
                    Arac_ilan temp = new Arac_ilan();
                    temp.setMarka(editTextMarka.getText().toString());
                    temp.setModel(editTextModel.getText().toString());
                    temp.setSeri(editTextSeri.getText().toString());
                    temp.setYil(editTextYili.getText().toString());
                    temp.setKilometre(editTextKilometre.getText().toString());
                    
                    temp.setIlanKullaniciId(aktifKullanici.getKullaniciId());

                    Intent intent = new Intent(AracBilgileriActivity.this, YakitActivity.class);
                    intent.putExtra("aktifKullanici", aktifKullanici);
                    intent.putExtra("aktifIlan", temp);

                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
