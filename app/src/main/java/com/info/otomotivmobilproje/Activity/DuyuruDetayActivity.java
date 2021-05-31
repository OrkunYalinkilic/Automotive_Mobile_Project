package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.Model.Duyuru;
import com.info.otomotivmobilproje.R;

public class DuyuruDetayActivity extends AppCompatActivity {

    private TextView duyuruBaslik, duyuruIcerik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyuru_detay);

        final Duyuru aktifDuyuru;

        aktifDuyuru = (Duyuru) getIntent().getSerializableExtra("aktifDuyuru");

        duyuruBaslik = findViewById(R.id.etDuyuruBaslik);
        duyuruIcerik = findViewById(R.id.etDuyuruIcerik);

        duyuruBaslik.setText(aktifDuyuru.getDuyuruBasligi().toUpperCase());
        duyuruIcerik.setText(aktifDuyuru.getDuyuruMetni());
    }
}
