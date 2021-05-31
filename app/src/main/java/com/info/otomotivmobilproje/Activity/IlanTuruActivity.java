package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

public class IlanTuruActivity extends AppCompatActivity {
    private Spinner spinerKimden, spinerIlanTuru;
    private Button buttonIlanTuru;

    private ArrayList<String> arrayListIlanTuru = new ArrayList<>();
    private ArrayList<String> arrayListKimden = new ArrayList<>();

    private ArrayAdapter<String> ilanTurAdapter;
    private ArrayAdapter<String> KimdenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_turu);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        final Arac_ilan aktifIlan = (Arac_ilan) getIntent().getSerializableExtra("aktifIlan");

        buttonIlanTuru = findViewById(R.id.buttonIlanTuru);
        spinerKimden = findViewById(R.id.spinerKimden);
        spinerIlanTuru = findViewById(R.id.spinerIlanTuru);

        arrayListKimden.add("Sahibinden");
        arrayListKimden.add("Galeriden");

        arrayListIlanTuru.add("Satılık");
        arrayListIlanTuru.add("Kiralık");

        ilanTurAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, arrayListIlanTuru);
        spinerIlanTuru.setAdapter(ilanTurAdapter);

        KimdenAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, android.R.id.text1, arrayListKimden);
        spinerKimden.setAdapter(KimdenAdapter);

        buttonIlanTuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aktifIlan.setIlanTuruId(spinerIlanTuru.getSelectedItemPosition() + 1);
                aktifIlan.setIlanSahibiTuruId(spinerKimden.getSelectedItemPosition() + 1);

                Intent intent = new Intent(IlanTuruActivity.this, AdresBilgileriActivity.class);
                intent.putExtra("aktifKullanici", aktifKullanici);
                intent.putExtra("aktifIlan", aktifIlan);
                startActivity(intent);
                finish();

            }
        });
    }
}
