package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Duyuru;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

public class DuyuruEklemeActivity extends AppCompatActivity {

    private EditText editTextDuyuruBaslik, editTextDuyuruIcerik;
    private Button buttonDuyuruyuEkle;
    HelperClass helperClass = new HelperClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyuru_ekleme);

        editTextDuyuruBaslik = findViewById(R.id.editTextDuyuruBaslik);
        editTextDuyuruIcerik = findViewById(R.id.editTextDuyuruIcerik);
        buttonDuyuruyuEkle = findViewById(R.id.buttonDuyuruyuEkle);

        editTextDuyuruBaslik.requestFocus();

        buttonDuyuruyuEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolList = new ArrayList<>();
                kontrolList.add(editTextDuyuruBaslik);
                kontrolList.add(editTextDuyuruIcerik);

                helperClass.editTextDolulukKontrol(kontrolList, v);

                Duyuru yeniDuyuru = new Duyuru();
                yeniDuyuru.setDuyuruBasligi(editTextDuyuruBaslik.getText().toString());
                yeniDuyuru.setDuyuruMetni(editTextDuyuruIcerik.getText().toString());

                DbHelper helper = new DbHelper(DuyuruEklemeActivity.this);
                helper.DuyuruAdd(yeniDuyuru, DuyuruEklemeActivity.this);

                Toast.makeText(DuyuruEklemeActivity.this, "DUYURU YAYINLANDI..", Toast.LENGTH_SHORT).show();

                try {

                } catch (Exception e) {

                    Toast.makeText(DuyuruEklemeActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
