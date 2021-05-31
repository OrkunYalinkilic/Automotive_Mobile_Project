package com.info.otomotivmobilproje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.HelperClass;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;

//import com.info.otomotivmobilproje.dao.KullaniciDao;

public class KullaniciSifreGuncellemeActivity extends AppCompatActivity {

    private EditText TextKullaniciGuncelleEskiSifre, TextKullaniciGuncelleSifre, TextKullaniciGuncelleSifreTekrari;
    private Button buttonDetaySifreGuncelle;
    private Kullanici aktifKullanici;
    private HelperClass helperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_sifre_guncelleme);

        TextKullaniciGuncelleEskiSifre = findViewById(R.id.TextKullaniciGuncelleEskiSifre);
        TextKullaniciGuncelleSifre = findViewById(R.id.TextKullaniciGuncelleSifre);
        TextKullaniciGuncelleSifreTekrari = findViewById(R.id.TextKullaniciGuncelleSifreTekrari);
        buttonDetaySifreGuncelle = findViewById(R.id.buttonDetaySifreGuncelle);

        aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");
        helperClass = new HelperClass();

        buttonDetaySifreGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<EditText> kontrolList = new ArrayList<>();
                kontrolList.add(TextKullaniciGuncelleEskiSifre);
                kontrolList.add(TextKullaniciGuncelleSifre);
                kontrolList.add(TextKullaniciGuncelleSifreTekrari);

                boolean dolulukSonuc = helperClass.editTextDolulukKontrol(kontrolList, v);

                String yeniSifre = TextKullaniciGuncelleSifre.getText().toString();
                String yeniSifreTekrari = TextKullaniciGuncelleSifreTekrari.getText().toString();


                if (dolulukSonuc == true) {

                    if (yeniSifre.equals(yeniSifreTekrari) == false) {

                        Snackbar.make(v, "ŞİFRE VE ŞİFRE TEKRARI AYNI OLMALI!", Snackbar.LENGTH_LONG).show();

                    } else {

                        if (!aktifKullanici.getSifre().equals(TextKullaniciGuncelleEskiSifre.getText().toString())) {
                            TextKullaniciGuncelleEskiSifre.setText("");
                            TextKullaniciGuncelleSifre.setText("");
                            TextKullaniciGuncelleSifreTekrari.setText("");
                            TextKullaniciGuncelleEskiSifre.requestFocus();
                            Snackbar.make(v, "GİRDİĞİNİZ ESKİ ŞİFRE YANLIŞ!\nBilgilerinizi Kontrol Ediniz..", Snackbar.LENGTH_LONG).show();


                        } else {
                            try {

                                DbHelper helper = new DbHelper(KullaniciSifreGuncellemeActivity.this);

                                helper.KullaniciSifreUpdate(aktifKullanici.getKullaniciId(), yeniSifre);

                                Intent intent = new Intent(KullaniciSifreGuncellemeActivity.this, MainActivity.class);
                                finish();
                                startActivity(intent);
                                Snackbar.make(v, "Şifre Güncelleme Başarılı", Snackbar.LENGTH_LONG).show();
                                finish();

                            } catch (Exception e) {
                                Toast.makeText(KullaniciSifreGuncellemeActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}
