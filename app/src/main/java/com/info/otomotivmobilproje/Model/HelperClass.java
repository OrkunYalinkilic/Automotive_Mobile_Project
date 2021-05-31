package com.info.otomotivmobilproje.Model;

import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HelperClass  {

    public boolean editTextDolulukKontrol(ArrayList<EditText> textList, View gelenView) {

        EditText temp = null;
        boolean sonuc = true;

        for (int i = 0; i < textList.size(); i++) {

            if (textList.get(i).getText().toString().isEmpty()) {

                temp = textList.get(i);
                sonuc = false;
                break;
            }
        }

        if (temp != null) {
            Snackbar.make(gelenView, temp.getHint().toString() + " Alanını Boş Geçtiniz." + "\n" + "LÜTFEN TÜM ALANLARI DOLDURUNUZ!", Snackbar.LENGTH_LONG).show();
            temp.requestFocus();
        }
        return sonuc;
    }

    public boolean editTextDolulukKontrol2(ArrayList<EditText> textList) {

        EditText temp = null;
        boolean sonuc = true;

        for (int i = 0; i < textList.size(); i++) {

            if (textList.get(i).getText().toString().isEmpty()) {

                temp = textList.get(i);
                sonuc = false;
                break;
            }
        }

        return sonuc;
    }
}

