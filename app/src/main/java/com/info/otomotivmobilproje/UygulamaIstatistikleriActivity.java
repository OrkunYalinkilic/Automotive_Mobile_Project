package com.info.otomotivmobilproje;

import android.os.Bundle;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class UygulamaIstatistikleriActivity extends AppCompatActivity {

    TextView textViewIlanSayisi, textViewFavSayisi, textViewKullaniciSayisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uygulama_istatistikleri);

        textViewFavSayisi = findViewById(R.id.twFavoriSayisi);
        textViewIlanSayisi = findViewById(R.id.twilanSayisi);
        textViewKullaniciSayisi = findViewById(R.id.twKullaniciSayisi);

        DbHelper helper = new DbHelper(UygulamaIstatistikleriActivity.this);

        textViewKullaniciSayisi.setText(String.valueOf(helper.KullaniciSayisi()));
        textViewIlanSayisi.setText(String.valueOf(helper.ilanSayisi()));
        textViewFavSayisi.setText(String.valueOf(helper.FavoriilanSayisi()));


    }
}
