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
//import com.info.otomotivmobilproje.dao.Veritabani;

public class KayitActivity extends AppCompatActivity {
    private EditText editTextAd, editTextSoyad, editTextDogumTarih, editTextEMail, editTextKullaniciAdi, editTextSifre, editTextSifreTekrar;
    private Button buttonKayit;
    private ArrayList<EditText> textList;
    private HelperClass helperClass = new HelperClass();
    //public Veritabani vt;
    private Kullanici yeniKullanici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        yeniKullanici = new Kullanici();
        editTextAd = findViewById(R.id.edittextAd);
        editTextSoyad = findViewById(R.id.edittextSoyad);
        editTextDogumTarih = findViewById(R.id.editTextDogumTarihi);
        editTextEMail = findViewById(R.id.editTextEMail);
        editTextKullaniciAdi = findViewById(R.id.editTextKullaniciAdiniz);
        editTextSifre = findViewById(R.id.edittextSifre);
        editTextSifreTekrar = findViewById(R.id.edittextSifreTekrari);
        buttonKayit = findViewById(R.id.buttonKayitOl);

        editTextAd.requestFocus();

        buttonKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yeniKullanici.setAd(editTextAd.getText().toString());
                yeniKullanici.setSoyad(editTextSoyad.getText().toString());
                yeniKullanici.setDogumTarih(editTextDogumTarih.getText().toString());
                yeniKullanici.seteMailAdres(editTextEMail.getText().toString());
                yeniKullanici.setKullaniciAdi(editTextKullaniciAdi.getText().toString());
                yeniKullanici.setSifre(editTextSifre.getText().toString());

                String sifre = editTextSifre.getText().toString();
                String sifreTekrari = editTextSifreTekrar.getText().toString();

                boolean dolulukSonuc;

                ArrayList<EditText> kontrolEdilecekListe = new ArrayList<>();

                kontrolEdilecekListe.add(editTextAd);
                kontrolEdilecekListe.add(editTextSoyad);
                kontrolEdilecekListe.add(editTextDogumTarih);
                kontrolEdilecekListe.add(editTextEMail);
                kontrolEdilecekListe.add(editTextKullaniciAdi);
                kontrolEdilecekListe.add(editTextSifre);
                kontrolEdilecekListe.add(editTextSifreTekrar);

                dolulukSonuc = helperClass.editTextDolulukKontrol(kontrolEdilecekListe, v);

                if (dolulukSonuc == true) {

                    if (sifre.equals(sifreTekrari) == false) {

                        Snackbar.make(v, "ŞİFRE VE ŞİFRE TEKRARI AYNI OLMALI!", Snackbar.LENGTH_LONG).show();

                    } else {
                        if (sifre.length() < 5) {
                            Snackbar.make(v, "ŞİFRENİZ EN AZ 5 KARAKTERDEN OLUŞMALIDIR!", Snackbar.LENGTH_LONG).show();
                            editTextSifre.setText("");
                            editTextSifreTekrar.setText("");
                            editTextSifre.requestFocus();
                        } else {

                            try {
                                DbHelper helper = new DbHelper(KayitActivity.this);
                                helper.KullaniciAdd(yeniKullanici);
                                Toast.makeText(KayitActivity.this, "Kaydınız Başarıyla Gerçekleşti..", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(KayitActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                                Toast.makeText(KayitActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}
