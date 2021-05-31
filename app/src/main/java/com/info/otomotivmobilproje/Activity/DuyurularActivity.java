package com.info.otomotivmobilproje.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.info.otomotivmobilproje.Adapter.DuyurularAdapter;
import com.info.otomotivmobilproje.DbHelper;
import com.info.otomotivmobilproje.Model.Duyuru;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.ArrayList;
import java.util.List;

public class DuyurularActivity extends AppCompatActivity {

    private RecyclerView duyuruRv;
    private ArrayList<Duyuru> duyuruArrayList;
    private DuyurularAdapter duyurularAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyurular);

        final Kullanici aktifKullanici = (Kullanici) getIntent().getSerializableExtra("aktifKullanici");


        duyuruRv = findViewById(R.id.duyurularRv);

        duyuruRv.setHasFixedSize(true);

        duyuruRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

/*        Duyuru d1 = new Duyuru("Duyuru Başlığı Deneme 1", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");
        Duyuru d2 = new Duyuru("Duyuru Başlığı Deneme 2", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");
        Duyuru d3 = new Duyuru("Duyuru Başlığı Deneme 3", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");
        Duyuru d4 = new Duyuru("Duyuru Başlığı Deneme 4", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");
        Duyuru d5 = new Duyuru("Duyuru Başlığı Deneme 5", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");
        Duyuru d6 = new Duyuru("Duyuru Başlığı Deneme 6", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");
        Duyuru d7 = new Duyuru("Duyuru Başlığı Deneme 7", "orem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir. Eğer bir Lorem Ipsum pasajı kullanacaksanız, metin aralarına utandırıcı sözcükler gizlenmediğinden emin olmanız gerekir. ");

        duyuruArrayList = new ArrayList<>();

        duyuruArrayList.add(d1);
        duyuruArrayList.add(d2);
        duyuruArrayList.add(d3);
        duyuruArrayList.add(d4);
        duyuruArrayList.add(d5);
        duyuruArrayList.add(d6);
        duyuruArrayList.add(d7);*/

        DbHelper helper = new DbHelper(DuyurularActivity.this);
/*
        Duyuru d = new Duyuru();
        d.setDuyuruId(1);
        d.setDuyuruBasligi("denemee");
        d.setDuyuruMetni("sdafsa");

        helper.DuyuruAdd(d,DuyurularActivity.this);*/

        List<Duyuru> gelenDuyurular = helper.getAllDuyurular(DuyurularActivity.this);

        duyurularAdapter = new DuyurularAdapter(this, gelenDuyurular);

        duyuruRv.setAdapter(duyurularAdapter);

    }
}
