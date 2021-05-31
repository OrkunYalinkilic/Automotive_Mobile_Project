package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.info.otomotivmobilproje.Adapter.IlanlarAdapter;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;
import java.util.List;

public class FavorilerimActivity extends AppCompatActivity {

    private RecyclerView favorilerRv;
    private List<Arac_ilan_DbGelen> aracList;
    private IlanlarAdapter adapterFavoriler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorilerim);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");

        favorilerRv = findViewById(R.id.favorilerimRv);
        favorilerRv.setHasFixedSize(true);

        favorilerRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        DbHelper helper = new DbHelper(this);

        aracList = new ArrayList<>();
        aracList = helper.getAllFavoriAracIlan(aktifKullanici.getKullaniciId());

        Toast.makeText(this,String.valueOf(aracList.size()),Toast.LENGTH_LONG).show();

        adapterFavoriler = new IlanlarAdapter(this, aracList, aktifKullanici, 1);

        favorilerRv.setAdapter(adapterFavoriler);


    }
}
