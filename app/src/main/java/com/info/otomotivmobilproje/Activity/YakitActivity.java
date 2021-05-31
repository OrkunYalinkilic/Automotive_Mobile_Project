package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

public class YakitActivity extends AppCompatActivity {
    private EditText editTextOrtalamaYakit, editTextDepoHacmi;
    private Button buttonYakitBilgi;
    private Spinner spinnerYakitTuru;
    private HelperClass helperClass;

    private ArrayList<String> arrayListYakitTur;
    private ArrayAdapter<String> arrayAdapterYakitTur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yakit);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");

        editTextOrtalamaYakit = findViewById(R.id.editTextOrtalamaYakit);
        editTextDepoHacmi = findViewById(R.id.editTextDepoHacmi);
        buttonYakitBilgi = findViewById(R.id.buttonYakitBilgi);
        spinnerYakitTuru = findViewById(R.id.spinerYakitTuru);

        helperClass = new HelperClass();

        arrayListYakitTur = new ArrayList<>();

        arrayListYakitTur.add("Dizel");
        arrayListYakitTur.add("Benzinli");
        arrayListYakitTur.add("Lpg");
        arrayListYakitTur.add("Elektrikli");

        arrayAdapterYakitTur = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_checked, android.R.id.text1, arrayListYakitTur);
        spinnerYakitTuru.setAdapter(arrayAdapterYakitTur);

        buttonYakitBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolListe = new ArrayList<>();
                kontrolListe.add(editTextDepoHacmi);
                kontrolListe.add(editTextOrtalamaYakit);

                boolean sonuc = helperClass.editTextDolulukKontrol(kontrolListe, v);

                if (sonuc == true) {
                    aktifIlan.setYakitTuruId(spinnerYakitTuru.getSelectedItemPosition()+1);
                    aktifIlan.setOrtalamaYakit(editTextOrtalamaYakit.getText().toString());
                    aktifIlan.setDepoHacmi(editTextDepoHacmi.getText().toString());

                    Intent intent = new Intent(YakitActivity.this, MotorPerformansActivity.class);
                    intent.putExtra("aktifKullanici", aktifKullanici);
                    intent.putExtra("aktifIlan", aktifIlan);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
