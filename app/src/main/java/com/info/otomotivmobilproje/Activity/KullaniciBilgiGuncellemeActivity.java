package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

public class KullaniciBilgiGuncellemeActivity extends AppCompatActivity {

    private EditText TextKullaniciDetayGuncelleAdi, TextKullaniciDetayGuncelleSoyadi, TextKullaniciDetayGuncelleDogumTarihi,
            TextKullaniciDetayGuncelleEMail, TextKullaniciDetayGuncelleKullaniciAdi;
    private Button buttonDetayBilgiGuncelle;
    private Kullanici aktifKullanici;
    private HelperClass helperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_bilgi_guncelleme);

        TextKullaniciDetayGuncelleAdi = findViewById(R.id.TextKullaniciDetayGuncelleAdi);
        TextKullaniciDetayGuncelleSoyadi = findViewById(R.id.TextKullaniciDetayGuncelleSoyadi);
        TextKullaniciDetayGuncelleDogumTarihi = findViewById(R.id.TextKullaniciDetayGuncelleDogumTarihi);
        TextKullaniciDetayGuncelleEMail = findViewById(R.id.TextKullaniciDetayGuncelleEMail);
        TextKullaniciDetayGuncelleKullaniciAdi = findViewById(R.id.TextKullaniciDetayGuncelleKullaniciAdi);
        buttonDetayBilgiGuncelle = findViewById(R.id.buttonDetayBilgiGuncelle);

        aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        helperClass = new HelperClass();

        TextKullaniciDetayGuncelleAdi.setText(aktifKullanici.getAd());
        TextKullaniciDetayGuncelleSoyadi.setText(aktifKullanici.getSoyad());
        TextKullaniciDetayGuncelleDogumTarihi.setText(aktifKullanici.getDogumTarih());
        TextKullaniciDetayGuncelleEMail.setText(aktifKullanici.geteMailAdres());
        TextKullaniciDetayGuncelleKullaniciAdi.setText(aktifKullanici.getKullaniciAdi());

        TextKullaniciDetayGuncelleAdi.requestFocus();

        buttonDetayBilgiGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolList = new ArrayList<>();
                kontrolList.add(TextKullaniciDetayGuncelleAdi);
                kontrolList.add(TextKullaniciDetayGuncelleSoyadi);
                kontrolList.add(TextKullaniciDetayGuncelleDogumTarihi);
                kontrolList.add(TextKullaniciDetayGuncelleEMail);
                kontrolList.add(TextKullaniciDetayGuncelleKullaniciAdi);

                boolean dolulukSonuc = helperClass.editTextDolulukKontrol(kontrolList, v);

                if (dolulukSonuc == true) {

                    aktifKullanici.setAd(TextKullaniciDetayGuncelleAdi.getText().toString());
                    aktifKullanici.setSoyad(TextKullaniciDetayGuncelleSoyadi.getText().toString());
                    aktifKullanici.setDogumTarih(TextKullaniciDetayGuncelleDogumTarihi.getText().toString());
                    aktifKullanici.seteMailAdres(TextKullaniciDetayGuncelleEMail.getText().toString());
                    aktifKullanici.setKullaniciAdi(TextKullaniciDetayGuncelleKullaniciAdi.getText().toString());

                    DbHelper helper = new DbHelper(KullaniciBilgiGuncellemeActivity.this);

                    try {

                        helper.KullaniciUpdate(aktifKullanici);

                        Intent intent = new Intent(KullaniciBilgiGuncellemeActivity.this, AnaMenuGirisActivity.class);
                        intent.putExtra("aktifKullanici", aktifKullanici);
                        startActivity(intent);

                        Toast.makeText(KullaniciBilgiGuncellemeActivity.this, "Güncelleme Başarılı", Toast.LENGTH_SHORT).show();
                        finish();


                    } catch (Exception e) {

                        Toast.makeText(KullaniciBilgiGuncellemeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
            }
        });


    }
}
