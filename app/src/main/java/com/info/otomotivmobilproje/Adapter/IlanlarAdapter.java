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

import com.info.otomotivmobilproje.Activity.DetayilanActivity;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Kullanici;
import com.info.otomotivmobilproje.R;

import java.util.List;

public class IlanlarAdapter extends RecyclerView.Adapter<IlanlarAdapter.CardViewTasarimTutucu> {

    private Context mContext;
    private List<Arac_ilan_DbGelen> aracIlanList;
    private Kullanici aktifKullanici;
    private int mod;

    public IlanlarAdapter(Context mContext, List<Arac_ilan_DbGelen> aracIlanList, Kullanici aktifKullanici, int mod) {
        this.mContext = mContext;
        this.aracIlanList = aracIlanList;
        this.aktifKullanici = aktifKullanici;
        this.mod = mod;
    }

    public class CardViewTasarimTutucu extends RecyclerView.ViewHolder {

        public ImageView imageViewAracFoto;
        public TextView textViewAracMarkaBilgi, textViewKullaniciBilgi, textViewKimdenBilgi, textViewFiyat;
        public CardView cardViewilan;

        public CardViewTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewAracFoto = itemView.findViewById(R.id.imageViewAracFoto);
            textViewAracMarkaBilgi = itemView.findViewById(R.id.textViewMarkaBilgi);
            textViewKullaniciBilgi = itemView.findViewById(R.id.textViewKullaniciBilgi);
            textViewFiyat = itemView.findViewById(R.id.textViewFiyatim);
            textViewKimdenBilgi = itemView.findViewById(R.id.textViewGenelBilgim);
            cardViewilan = itemView.findViewById(R.id.cardViewilan);

        }
    }

    @NonNull
    @Override
    public CardViewTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim_ilanlar, parent, false);
        return new CardViewTasarimTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewTasarimTutucu holder, int position) {

        final Arac_ilan_DbGelen ilan = aracIlanList.get(position);

        holder.textViewKimdenBilgi.setText(ilan.getIlanSahibiTuruAdi().toUpperCase() + " " + ilan.getIlanTuruAdi().toUpperCase());
        holder.textViewAracMarkaBilgi.setText(String.valueOf(ilan.getYil()) + " " + ilan.getMarka() + " " + ilan.getModel());
        holder.textViewKullaniciBilgi.setText(ilan.getIlanSahibiAdi() + " " + ilan.getIlanSahibiSoyadi() + "\n" + ilan.getSehir() + " " + ilan.getIlce());
        holder.textViewFiyat.setText(String.valueOf(ilan.getIlanFiyat()) + " TL");
        holder.imageViewAracFoto.setImageResource(R.drawable.testt);

        //if (ilan.getFotoisim1()!=null ){
        // Uri uri = Uri.parse(ilan.getFotoisim1());
        //holder.imageViewAracFoto.setImageURI(uri);

        holder.cardViewilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayilanActivity.class);
                intent.putExtra("secilenilan", ilan);
                intent.putExtra("aktifKullanici", aktifKullanici);
                intent.putExtra("mod", mod);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aracIlanList.size();
    }
}
