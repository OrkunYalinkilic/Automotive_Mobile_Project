package com.info.otomotivmobilproje.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.info.otomotivmobilproje.Activity.DuyuruDetayActivity;
import com.info.otomotivmobilproje.Model.Duyuru;
import com.info.otomotivmobilproje.R;

import java.util.List;

public class DuyurularAdapter extends RecyclerView.Adapter<DuyurularAdapter.CardViewTasarimTutucu> {

    private Context mContext;
    private List<Duyuru> duyuruList;

    public DuyurularAdapter(Context mContext, List<Duyuru> duyuruList) {
        this.mContext = mContext;
        this.duyuruList = duyuruList;
    }

    public class CardViewTasarimTutucu extends RecyclerView.ViewHolder {

        private Button buttonDuyuru;
        private CardView cardDuyuru;

        public CardViewTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            buttonDuyuru = itemView.findViewById(R.id.buttonDuyuru);
            cardDuyuru = itemView.findViewById(R.id.cardViewDuyuru);

        }
    }


    @NonNull
    @Override
    public CardViewTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim_duyurular, parent, false);
        return new CardViewTasarimTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucu holder, int position) {

        final Duyuru gelenDuyuru = duyuruList.get(position);

        holder.buttonDuyuru.setText(gelenDuyuru.getDuyuruBasligi());

        holder.buttonDuyuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DuyuruDetayActivity.class);
                intent.putExtra("aktifDuyuru", gelenDuyuru);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return duyuruList.size();
    }


}
