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

import java.util.List;

public class IlanlarActivity extends AppCompatActivity {
    private RecyclerView rv;
    private IlanlarAdapter adapter;
    private List<Arac_ilan_DbGelen> aracList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlar);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        try {
            DbHelper helper = new DbHelper(IlanlarActivity.this);

            aracList = helper.getAllAracIlan();

            Toast.makeText(this, String.valueOf(aracList.size()), Toast.LENGTH_SHORT).show();

            //List<Arac_ilan_DbGelen> test = new ArrayList<>();
            /*Arac_ilan_DbGelen d = new Arac_ilan_DbGelen();
            d.setIlanFiyat(213);
            test.add(d);*/
            //adapter = new IlanlarAdapter(this, test);
            // aracList = helper.getAllAracIlan2();

            adapter = new IlanlarAdapter(this, aracList,aktifKullanici,0);
            rv.setAdapter(adapter);



        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
