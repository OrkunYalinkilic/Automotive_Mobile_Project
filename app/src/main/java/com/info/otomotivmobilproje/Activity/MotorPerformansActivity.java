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

public class MotorPerformansActivity extends AppCompatActivity {

    private EditText editTextMotorTipi, editTextMotorHacmi, editTextAzamiSurat;
    private Button buttonMotorBilgi;
    private HelperClass helperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_performans);


        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");


        editTextMotorTipi = findViewById(R.id.editTextMotorTipi);
        editTextMotorHacmi = findViewById(R.id.editTextMotorHacmi);
        editTextAzamiSurat = findViewById(R.id.editTextAzamiSurat);
        buttonMotorBilgi = findViewById(R.id.buttonMotorBilgi);

        helperClass = new HelperClass();

        buttonMotorBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> boslukKontrolListe = new ArrayList<>();
                boslukKontrolListe.add(editTextAzamiSurat);
                boslukKontrolListe.add(editTextMotorHacmi);
                boslukKontrolListe.add(editTextMotorTipi);

                boolean sonuc = helperClass.editTextDolulukKontrol(boslukKontrolListe, v);

                if (sonuc == true) {
                    aktifIlan.setMotorTipi(editTextMotorTipi.getText().toString());
                    aktifIlan.setMotorHacmi(editTextMotorHacmi.getText().toString());
                    aktifIlan.setAzamiSurat(editTextAzamiSurat.getText().toString());

                    Intent intent = new Intent(MotorPerformansActivity.this, IlanTuruActivity.class);
                    intent.putExtra("aktifKullanici", aktifKullanici);
                    intent.putExtra("aktifIlan", aktifIlan);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
