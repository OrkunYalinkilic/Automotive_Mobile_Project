package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.info.otomotivmobilproje.Adapter.IlanlarimAdapter;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.List;

public class IlanlarimActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<Arac_ilan_DbGelen> aracIlanlarim;
    private IlanlarimAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlarim);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");


        rv = findViewById(R.id.ilanlarimRv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        DbHelper helper = new DbHelper(this);


        aracIlanlarim = helper.getAllKendiIlanlarim(aktifKullanici.getKullaniciId());

        adapter = new IlanlarimAdapter(this, aracIlanlarim,aktifKullanici);

        rv.setAdapter(adapter);



    }
}
