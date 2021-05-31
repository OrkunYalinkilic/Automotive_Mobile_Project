package com.info.otomotivmobilproje.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.info.otomotivmobilproje.Activity.IlanlarimDetayActivity;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.List;

public class IlanlarimAdapter extends RecyclerView.Adapter<IlanlarimAdapter.CardViewTasarimTutucu> {

    private Context mContext;
    private List<Arac_ilan_DbGelen> aracIlanListim;
    private Kullanici aktifKullanici;

    public IlanlarimAdapter(Context mContext, List<Arac_ilan_DbGelen> aracIlanListim, Kullanici aktifKullanici) {
        this.mContext = mContext;
        this.aracIlanListim = aracIlanListim;
        this.aktifKullanici = aktifKullanici;
    }

    public class CardViewTasarimTutucu extends RecyclerView.ViewHolder {
        public ImageView imageViewAracFotom;
        public TextView textViewAracMarkaBilgim, textViewKimdenBilgim, textViewFiyatim, textViewGenelBilgim;
        public CardView cardViewilanim;


        public CardViewTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            imageViewAracFotom = itemView.findViewById(R.id.imageViewAracFotom);
            textViewAracMarkaBilgim = itemView.findViewById(R.id.textViewMarkamBilgi);
            textViewKimdenBilgim = itemView.findViewById(R.id.textViewKimdenBilgim);
            textViewFiyatim = itemView.findViewById(R.id.textViewFiyatim);
            cardViewilanim = itemView.findViewById(R.id.cardViewilanim);
            textViewGenelBilgim = itemView.findViewById(R.id.textViewGenelBilgim);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim_ilanlarim, parent, false);
        return new CardViewTasarimTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucu holder, int position) {

        final Arac_ilan_DbGelen arac_ilanim = aracIlanListim.get(position);

        holder.textViewFiyatim.setText(String.valueOf(arac_ilanim.getIlanFiyat()) + " TL");
        holder.textViewAracMarkaBilgim.setText(String.valueOf(arac_ilanim.getYil()) + " " + arac_ilanim.getModel() + " " + arac_ilanim.getMarka());
        holder.textViewKimdenBilgim.setText(String.valueOf(arac_ilanim.getIlanSahibiAdi()));
        holder.imageViewAracFotom.setImageResource(R.drawable.testt);
        holder.textViewGenelBilgim.setText("deneme deneme test ");

        //

        holder.cardViewilanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, IlanlarimDetayActivity.class);
                intent.putExtra("aktifIlan", arac_ilanim);
                intent.putExtra("aktifKullanici",aktifKullanici);
                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return aracIlanListim.size();
    }


}
