package com.info.otomotivmobilproje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.info.otomotivmobilproje.Model.Arac_ilan;
import com.info.otomotivmobilproje.Model.Arac_ilan_DbGelen;
import com.info.otomotivmobilproje.Model.Duyuru;
import com.info.otomotivmobilproje.Model.Kullanici;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public Context cxt;

    public static final String DATABASE_NAME = "OtomotivApp";
    public static final int DATABASE_VERSION = 1;

    public static final String KULLANİCİ_TABLE_NAME = "Kullanici";
    public static final String KULLANİCİ_COLUMN_ID = "KullaniciId";
    public static final String KULLANİCİ_COLUMN_ADI = "Adi";
    public static final String KULLANİCİ_COLUMN_SOYADI = "Soyadi";
    public static final String KULLANİCİ_COLUMN_DOGUMTARIH = "DogumTarihi ";
    public static final String KULLANİCİ_COLUMN_EMAILADRES = "EMailAdres ";
    public static final String KULLANİCİ_COLUMN_KULLANICIADI = "KullaniciAdi ";
    public static final String KULLANİCİ_COLUMN_SIFRE = "Sifre ";
    public static final String KULLANİCİ_COLUMN_KULLANICITURUID = "KullaniciTuruId ";

    public static final String ARACILAN_TABLE_NAME = "AracIlan";
    public static final String ARACILAN_COLUMN_ID = "AracIlanId";
    public static final String ARACILAN_COLUMN_KULLANICIID = "IlanKullaniciId";
    public static final String ARACILAN_COLUMN_ILANTURUID = "IlanTuruId";
    public static final String ARACILAN_COLUMN_ILANSAHIBIID = "IlanSahibiId ";
    public static final String ARACILAN_COLUMN_YAKITTURUUD = "YakitTuruId ";
    public static final String ARACILAN_COLUMN_SEHIR = "Sehir ";
    public static final String ARACILAN_COLUMN_ILCE = "Ilce ";
    public static final String ARACILAN_COLUMN_MAHALLE = "Mahalle ";
    public static final String ARACILAN_COLUMN_MARKA = "Marka";
    public static final String ARACILAN_COLUMN_MODEL = "Model";
    public static final String ARACILAN_COLUMN_SERI = "Seri ";
    public static final String ARACILAN_COLUMN_YIL = "Yil ";
    public static final String ARACILAN_COLUMN_KILOMETRE = "Kilometre ";
    public static final String ARACILAN_COLUMN_MOTORTIPI = "MotorTipi ";
    public static final String ARACILAN_COLUMN_MOTORHACMI = "MotorHacmi ";
    public static final String ARACILAN_COLUMN_AZAMISURAT = "AzamiSurat";
    public static final String ARACILAN_COLUMN_ORTALAMAYAKIT = "OrtalamaYakit";
    public static final String ARACILAN_COLUMN_DEPOHACMI = "DepoHacmi ";
    public static final String ARACILAN_COLUMN_FOTOGRAF1 = "Fotograf1 ";
    public static final String ARACILAN_COLUMN_FOTOGRAF2 = "Fotograf2 ";
    public static final String ARACILAN_COLUMN_FOTOGRAF3 = "Fotograf3 ";
    public static final String ARACILAN_COLUMN_FOTOGRAF4 = "Fotograf4 ";
    public static final String ARACILAN_COLUMN_ILANAKTIFLIK = "ilanAktiflik ";
    public static final String ARACILAN_COLUMN_ILANFIYAT = "IlanFiyat ";
    public static final String ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK = "IlanKiralikHaftalikAylik ";

    public static final String FAVORIARACLAR_TABLE_NAME = "FavoriAraclar";
    public static final String FAVORIARACLAR_COLUMN_FAVORIARACID = "FavoriAracId";
    public static final String FAVORIARACLAR_COLUMN_FAVORIARACKULLANICIID = "FavoriAracKullaniciId";

    public static final String ILANTURU_TABLE_NAME = "IlanTuru";
    public static final String ILANTURU_COLUMN_ID = "IlanTuruId";
    public static final String ILANTURU_COLUMN_ILANTURUADI = "IlanTuruAdi";

    public static final String ILANSAHIBITURU_TABLE_NAME = "IlanSahibiTuru";
    public static final String ILANSAHIBITURU_COLUMN_ID = "IlanSahibiTurId";
    public static final String ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI = "IlanSahibiTurAdi";

    public static final String YAKITTURU_TABLE_NAME = "YakitTuru";
    public static final String YAKITTURU_COLUMN_ID = "YakitTuruId";
    public static final String YAKITTURU_COLUMN_YAKITTURADI = "YakitTuruAdi";

    public static final String DUYURU_TABLE_NAME = "Duyuru";
    public static final String DUYURU_COLUMN_ID = "DuyuruId";
    public static final String DUYURU_COLUMN_BASLIK = "Baslik";
    public static final String DUYURU_COLUMN_ICERIK = "Icerik";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.cxt = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String KULLANICI_CREATE_TABLE = "CREATE TABLE " + KULLANİCİ_TABLE_NAME + " ( " + KULLANİCİ_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + KULLANİCİ_COLUMN_ADI + " text, " +
                KULLANİCİ_COLUMN_SOYADI + " text, " + KULLANİCİ_COLUMN_DOGUMTARIH + " text, " +
                KULLANİCİ_COLUMN_EMAILADRES + " text, " + KULLANİCİ_COLUMN_KULLANICIADI + " text, " +
                KULLANİCİ_COLUMN_SIFRE + " text, " + " text, " + KULLANİCİ_COLUMN_KULLANICITURUID + " integer default 0);";

        db.execSQL(KULLANICI_CREATE_TABLE);

        String ILANTURU_CREATE_TABLE = "CREATE TABLE " + ILANTURU_TABLE_NAME + " ( " + ILANTURU_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + ILANTURU_COLUMN_ILANTURUADI + " text);";

        db.execSQL(ILANTURU_CREATE_TABLE);

        String ILANSAHIBITURU_CREATE_TABLE = "CREATE TABLE " + ILANSAHIBITURU_TABLE_NAME + " ( " + ILANSAHIBITURU_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI + " text);";

        db.execSQL(ILANSAHIBITURU_CREATE_TABLE);

        String YAKITTURU_CREATE_TABLE = "CREATE TABLE " + YAKITTURU_TABLE_NAME + " ( " + YAKITTURU_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + YAKITTURU_COLUMN_YAKITTURADI + " text);";

        db.execSQL(YAKITTURU_CREATE_TABLE);

        String ARACILAN_CREATE_TABLE = "CREATE TABLE " + ARACILAN_TABLE_NAME + " ( " + ARACILAN_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + ARACILAN_COLUMN_KULLANICIID + " integer, " +
                ARACILAN_COLUMN_ILANTURUID + " integer, " + ARACILAN_COLUMN_ILANSAHIBIID + " integer, " +
                ARACILAN_COLUMN_YAKITTURUUD + " integer, " + ARACILAN_COLUMN_SEHIR + " text, " +
                ARACILAN_COLUMN_ILCE + " text, " + ARACILAN_COLUMN_MAHALLE + " text, " +
                ARACILAN_COLUMN_MARKA + " text, " + ARACILAN_COLUMN_MODEL + " text, " +
                ARACILAN_COLUMN_SERI + " text, " + ARACILAN_COLUMN_YIL + " text, " +
                ARACILAN_COLUMN_KILOMETRE + " text, " + ARACILAN_COLUMN_MOTORTIPI + " text, " +
                ARACILAN_COLUMN_MOTORHACMI + " text, " + ARACILAN_COLUMN_AZAMISURAT + " text, " +
                ARACILAN_COLUMN_ORTALAMAYAKIT + " text, " + ARACILAN_COLUMN_DEPOHACMI + " text, " +
                ARACILAN_COLUMN_FOTOGRAF1 + " BLOB default null, " + ARACILAN_COLUMN_FOTOGRAF2 + " BLOB default null, " +
                ARACILAN_COLUMN_FOTOGRAF3 + " BLOB default null, " + ARACILAN_COLUMN_FOTOGRAF4 + " BLOB default null, " +
                ARACILAN_COLUMN_ILANAKTIFLIK + " integer default 0, " + ARACILAN_COLUMN_ILANFIYAT + " integer, " +
                ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK + " text, " +
                "FOREIGN KEY(\"IlanKullaniciId\") REFERENCES \"Kullanici\"(\"KullaniciId\")," +
                "FOREIGN KEY(\"IlanTuruId\") REFERENCES \"IlanTuru\"(\"IlanTuruId\")," +
                "FOREIGN KEY(\"IlanSahibiId\") REFERENCES \"IlanSahibiTuru\"(\"IlanSahibiTurId\")," +
                "FOREIGN KEY(\"YakitTuruId\") REFERENCES \"YakitTuru\"(\"YakitTuruId\") );";

        db.execSQL(ARACILAN_CREATE_TABLE);

/*        String ARACILAN_CREATE_TABLE = "CREATE TABLE " + ARACILAN_TABLE_NAME + " ( " + ARACILAN_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + ARACILAN_COLUMN_KULLANICIID + " integer, " +
                ARACILAN_COLUMN_ILANTURUID + " integer, " + ARACILAN_COLUMN_ILANSAHIBIID + " integer, " +
                ARACILAN_COLUMN_YAKITTURUUD + " integer, " + ARACILAN_COLUMN_SEHIR + " text, " +
                ARACILAN_COLUMN_ILCE + " text, " + ARACILAN_COLUMN_MAHALLE + " text, " +
                ARACILAN_COLUMN_MARKA + " text, " + ARACILAN_COLUMN_MODEL + " text, " +
                ARACILAN_COLUMN_SERI + " text, " + ARACILAN_COLUMN_YIL + " text, " +
                ARACILAN_COLUMN_KILOMETRE + " text, " + ARACILAN_COLUMN_MOTORTIPI + " text, " +
                ARACILAN_COLUMN_MOTORHACMI + " text, " + ARACILAN_COLUMN_AZAMISURAT + " text, " +
                ARACILAN_COLUMN_ORTALAMAYAKIT + " text, " + ARACILAN_COLUMN_DEPOHACMI + " text, " +
                ARACILAN_COLUMN_FOTOGRAF1 + " text default null, " + ARACILAN_COLUMN_FOTOGRAF2 + " text default null, " +
                ARACILAN_COLUMN_FOTOGRAF3 + " text default null, " + ARACILAN_COLUMN_FOTOGRAF4 + " text default null, " +
                ARACILAN_COLUMN_ILANAKTIFLIK + " integer default 0, " + ARACILAN_COLUMN_ILANFIYAT + " integer, " +
                ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK + " text, " +
                "FOREIGN KEY(\"IlanKullaniciId\") REFERENCES \"Kullanici\"(\"KullaniciId\")," +
                "FOREIGN KEY(\"IlanTuruId\") REFERENCES \"IlanTuru\"(\"IlanTuruId\")," +
                "FOREIGN KEY(\"IlanSahibiId\") REFERENCES \"IlanSahibiTuru\"(\"IlanSahibiTurId\")," +
                "FOREIGN KEY(\"YakitTuruId\") REFERENCES \"YakitTuru\"(\"YakitTuruId\") );";

        db.execSQL(ARACILAN_CREATE_TABLE);*/


        String FAVORIARACLAR_CREATE_TABLE = "CREATE TABLE " + FAVORIARACLAR_TABLE_NAME + " ( " + FAVORIARACLAR_COLUMN_FAVORIARACID +
                " integer, " + FAVORIARACLAR_COLUMN_FAVORIARACKULLANICIID + " integer, " +
                "FOREIGN KEY(\"FavoriAracId\") REFERENCES \"AracIlan\"(\"AracIlanId\")," +
                "FOREIGN KEY(\"FavoriAracKullaniciId\") REFERENCES \"Kullanici\"(\"KullaniciId\") );";

        db.execSQL(FAVORIARACLAR_CREATE_TABLE);


        String DUYURU_CREATE_TABLE = "CREATE TABLE " + DUYURU_TABLE_NAME + " ( " + DUYURU_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + DUYURU_COLUMN_BASLIK + " text, " +
                DUYURU_COLUMN_ICERIK + " text);";

        db.execSQL(DUYURU_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String KULLANICI_DROP_TABLE = "DROP TABLE IF EXISTS " + KULLANİCİ_TABLE_NAME;
        onCreate(db);

        String ARACILAN_DROP_TABLE = "DROP TABLE IF EXISTS " + ARACILAN_TABLE_NAME;
        onCreate(db);

        String FAVORIARACLAR_DROP_TABLE = "DROP TABLE IF EXISTS " + FAVORIARACLAR_TABLE_NAME;
        onCreate(db);

        String ILANTURU_DROP_TABLE = "DROP TABLE IF EXISTS " + ILANTURU_TABLE_NAME;
        onCreate(db);

        String ILANSAHIBITURU_DROP_TABLE = "DROP TABLE IF EXISTS " + ILANSAHIBITURU_TABLE_NAME;
        onCreate(db);

        String YAKITTURU_DROP_TABLE = "DROP TABLE IF EXISTS " + YAKITTURU_TABLE_NAME;
        onCreate(db);

        String DUYURU_DROP_TABLE = "DROP TABLE IF EXISTS " + DUYURU_TABLE_NAME;
        onCreate(db);
    }

    public String KullaniciAdd(Kullanici gelenKullanici) {

        SQLiteDatabase db = this.getWritableDatabase(); // bu katmanda yok o yüzden oluşturuyoruz.

        ContentValues values = new ContentValues();
        values.put(KULLANİCİ_COLUMN_ADI, gelenKullanici.getAd());
        values.put(KULLANİCİ_COLUMN_SOYADI, gelenKullanici.getSoyad());
        values.put(KULLANİCİ_COLUMN_DOGUMTARIH, gelenKullanici.getDogumTarih());
        values.put(KULLANİCİ_COLUMN_EMAILADRES, gelenKullanici.geteMailAdres());
        values.put(KULLANİCİ_COLUMN_KULLANICIADI, gelenKullanici.getKullaniciAdi());
        values.put(KULLANİCİ_COLUMN_SIFRE, gelenKullanici.getSifre());

        long result = db.insert(KULLANİCİ_TABLE_NAME, null, values);

        String msg = "Not INSERTED";
        if (result > 0) {
            msg = "INSERTED Succesfuly";
        }
        return msg;

        // eğer eklemede hata varsa negatif,ekleme hiç yapmazsa sıfır, eğer ekleme başarılı ise pozitif döndürür.
    }

    public Kullanici kontrolKullanici(String kullaniciAd, String sifre) {

        String KullaniciAdi = "\"" + kullaniciAd + "\"";
        String Sifre = "\"" + sifre + "\"";

        Kullanici kullanici = new Kullanici();

        String selectQuery = "SELECT * FROM " + KULLANİCİ_TABLE_NAME + " WHERE " + KULLANİCİ_COLUMN_KULLANICIADI + " = "
                + KullaniciAdi + " and " + KULLANİCİ_COLUMN_SIFRE + " = " + Sifre;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        while (cursor.moveToNext()) {

            kullanici.setKullaniciId(Integer.parseInt(cursor.getString(0)));
            kullanici.setAd(cursor.getString(1));
            kullanici.setSoyad(cursor.getString(2));
            kullanici.setDogumTarih(cursor.getString(3));
            kullanici.seteMailAdres(cursor.getString(4));
            kullanici.setKullaniciAdi(cursor.getString(5));
            kullanici.setSifre(cursor.getString(6));

        }

        cursor.close();

        if (!(kullanici.getKullaniciId() > 0)) kullanici = null;

        return kullanici;
    }

    public String KullaniciUpdate(Kullanici guncelKullanici) {

        SQLiteDatabase db = this.getWritableDatabase(); // bu katmanda yok o yüzden oluşturuyoruz.

        String whereCalue = KULLANİCİ_COLUMN_ID + " = ? "; //*
        String whereArgs[] = new String[]{String.valueOf(guncelKullanici.getKullaniciId())};

        ContentValues values = new ContentValues();
        values.put(KULLANİCİ_COLUMN_ADI, guncelKullanici.getAd());
        values.put(KULLANİCİ_COLUMN_SOYADI, guncelKullanici.getSoyad());
        values.put(KULLANİCİ_COLUMN_DOGUMTARIH, guncelKullanici.getDogumTarih());
        values.put(KULLANİCİ_COLUMN_EMAILADRES, guncelKullanici.geteMailAdres());
        values.put(KULLANİCİ_COLUMN_KULLANICIADI, guncelKullanici.getKullaniciAdi());
        values.put(KULLANİCİ_COLUMN_SIFRE, guncelKullanici.getSifre());

        long result = db.update(KULLANİCİ_TABLE_NAME, values, whereCalue, whereArgs);

        String msg = "Not UPDATED";
        if (result > 0) {
            msg = "UPDATED Succesfuly";
        }
        return msg;
    }


    public String KullaniciSifreUpdate(int kullaniciId, String guncelSifre) {

        SQLiteDatabase db = this.getWritableDatabase();

        String whereCalue = KULLANİCİ_COLUMN_ID + " = ? ";
        String whereArgs[] = new String[]{String.valueOf(kullaniciId)};

        ContentValues values = new ContentValues();

        values.put(KULLANİCİ_COLUMN_SIFRE, guncelSifre);

        long result = db.update(KULLANİCİ_TABLE_NAME, values, whereCalue, whereArgs);

        String msg = "Not Password UPDATED";
        if (result > 0) {
            msg = "Password UPDATED Succesfuly";
        }
        return msg;
    }

    public String AracIlanAdd(Arac_ilan gelenArac) {

        SQLiteDatabase db = this.getWritableDatabase(); // bu katmanda yok o yüzden oluşturuyoruz.

        ContentValues values = new ContentValues();
        values.put(ARACILAN_COLUMN_KULLANICIID, gelenArac.getIlanKullaniciId());
        values.put(ARACILAN_COLUMN_ILANTURUID, gelenArac.getIlanTuruId());
        values.put(ARACILAN_COLUMN_ILANSAHIBIID, gelenArac.getIlanSahibiTuruId());
        values.put(ARACILAN_COLUMN_YAKITTURUUD, gelenArac.getYakitTuruId());
        values.put(ARACILAN_COLUMN_SEHIR, gelenArac.getSehir());
        values.put(ARACILAN_COLUMN_ILCE, gelenArac.getIlce());
        values.put(ARACILAN_COLUMN_MAHALLE, gelenArac.getMahalle());
        values.put(ARACILAN_COLUMN_MARKA, gelenArac.getMarka());
        values.put(ARACILAN_COLUMN_MODEL, gelenArac.getModel());
        values.put(ARACILAN_COLUMN_SERI, gelenArac.getSeri());
        values.put(ARACILAN_COLUMN_YIL, gelenArac.getYil());
        values.put(ARACILAN_COLUMN_KILOMETRE, gelenArac.getKilometre());
        values.put(ARACILAN_COLUMN_MOTORTIPI, gelenArac.getMotorTipi());
        values.put(ARACILAN_COLUMN_MOTORHACMI, gelenArac.getMotorHacmi());
        values.put(ARACILAN_COLUMN_AZAMISURAT, gelenArac.getAzamiSurat());
        values.put(ARACILAN_COLUMN_ORTALAMAYAKIT, gelenArac.getOrtalamaYakit());
        values.put(ARACILAN_COLUMN_DEPOHACMI, gelenArac.getDepoHacmi());
        values.put(ARACILAN_COLUMN_FOTOGRAF1, gelenArac.getFotoisim1());
        values.put(ARACILAN_COLUMN_FOTOGRAF2, gelenArac.getFotoisim2());
        values.put(ARACILAN_COLUMN_FOTOGRAF3, gelenArac.getFotoisim3());
        values.put(ARACILAN_COLUMN_FOTOGRAF4, gelenArac.getFotoisim4());
        values.put(ARACILAN_COLUMN_ILANFIYAT, gelenArac.getIlanFiyat());
        values.put(ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK, gelenArac.getIlanKiralikHaftalikAylik());

        long result = db.insert(ARACILAN_TABLE_NAME, null, values);

        String msg = "Not INSERTED";
        if (result > 0) {
            msg = "INSERTED Succesfuly";
        }
        return msg;

    }

    public String AracIlanUpdate(Arac_ilan guncelArac) {

        SQLiteDatabase db = this.getWritableDatabase(); // bu katmanda yok o yüzden oluşturuyoruz.

        String whereCalue = ARACILAN_COLUMN_ID + " = ? "; //*
        String whereArgs[] = new String[]{String.valueOf(guncelArac.getIlanAracIlanId())};

        ContentValues values = new ContentValues();
        values.put(ARACILAN_COLUMN_SEHIR, guncelArac.getSehir());
        values.put(ARACILAN_COLUMN_ILCE, guncelArac.getIlce());
        values.put(ARACILAN_COLUMN_MAHALLE, guncelArac.getMahalle());
        values.put(ARACILAN_COLUMN_MARKA, guncelArac.getMarka());
        values.put(ARACILAN_COLUMN_MODEL, guncelArac.getModel());
        values.put(ARACILAN_COLUMN_SERI, guncelArac.getSeri());
        values.put(ARACILAN_COLUMN_YIL, guncelArac.getYil());
        values.put(ARACILAN_COLUMN_KILOMETRE, guncelArac.getKilometre());
        values.put(ARACILAN_COLUMN_MOTORTIPI, guncelArac.getMotorTipi());
        values.put(ARACILAN_COLUMN_MOTORHACMI, guncelArac.getMotorHacmi());
        values.put(ARACILAN_COLUMN_AZAMISURAT, guncelArac.getAzamiSurat());
        values.put(ARACILAN_COLUMN_ORTALAMAYAKIT, guncelArac.getOrtalamaYakit());
        values.put(ARACILAN_COLUMN_DEPOHACMI, guncelArac.getDepoHacmi());
        values.put(ARACILAN_COLUMN_ILANFIYAT, guncelArac.getIlanFiyat());

        long result = db.update(ARACILAN_TABLE_NAME, values, whereCalue, whereArgs);

        String msg = "Not UPDATED";
        if (result > 0) {
            msg = "UPDATED Succesfuly";
        }
        return msg;
    }

    public String AracIlanDelete(int Id) {
        SQLiteDatabase db = this.getWritableDatabase();

        // String whereCalue = " WHERE "+STUDENT_COLUMN_ID + " = ? AND" + STUDENT_COLUMN_GENDER + " = ?" ;
        //String whereArgs [] = new String[]{String.valueOf(Id),"Male"};

        String whereCalue = ARACILAN_COLUMN_ID + " = ? "; // kendisi bizim için where ekliyor.
        String whereArgs[] = new String[]{String.valueOf(Id)};

        long result = db.delete(ARACILAN_TABLE_NAME, whereCalue, whereArgs);

        String msg = "Not DELETED";
        if (result > 0) {
            msg = "DELETED Succesfuly";
        }
        return msg;
    }

    public List<Arac_ilan_DbGelen> getAllAracIlan() {

        ArrayList<Arac_ilan_DbGelen> arac_ilanList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT "
                + ARACILAN_COLUMN_ID + ", " + KULLANİCİ_COLUMN_ADI + ", " + KULLANİCİ_COLUMN_SOYADI + ", " +
                ILANTURU_COLUMN_ILANTURUADI + ", " + ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI + ", " + YAKITTURU_COLUMN_YAKITTURADI + ", " +
                ARACILAN_COLUMN_SEHIR + ", " + ARACILAN_COLUMN_ILCE + ", " + ARACILAN_COLUMN_MAHALLE + ", " +
                ARACILAN_COLUMN_MARKA + ", " + ARACILAN_COLUMN_MODEL + ", " + ARACILAN_COLUMN_SERI + ", " +
                ARACILAN_COLUMN_YIL + ", " + ARACILAN_COLUMN_KILOMETRE + ", " + ARACILAN_COLUMN_MOTORTIPI + ", " +
                ARACILAN_COLUMN_MOTORHACMI + ", " + ARACILAN_COLUMN_AZAMISURAT + ", " + ARACILAN_COLUMN_ORTALAMAYAKIT + ", " +
                ARACILAN_COLUMN_DEPOHACMI + ", " + ARACILAN_COLUMN_FOTOGRAF1 + ", " + ARACILAN_COLUMN_FOTOGRAF2 + ", " +
                ARACILAN_COLUMN_FOTOGRAF3 + ", " + ARACILAN_COLUMN_FOTOGRAF4 + ", " + ARACILAN_COLUMN_ILANFIYAT + ", " +
                ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK + " FROM " + ARACILAN_TABLE_NAME +
                " INNER JOIN Kullanici ON AracIlan.IlanKullaniciId = Kullanici.KullaniciId " +
                "INNER JOIN IlanTuru ON AracIlan.IlanTuruId = IlanTuru.IlanTuruId " +
                "INNER JOIN IlanSahibiTuru ON AracIlan.IlanSahibiId = IlanSahibiTuru.IlanSahibiTurId " +
                "INNER JOIN YakitTuru ON AracIlan.yakitTuruId = YakitTuru.YakitTuruId";


        // WHERE " +
        //                ARACILAN_COLUMN_ILANAKTIFLIK + " =0


        Cursor cursor = db.rawQuery(selectQuery, null);


        Arac_ilan_DbGelen anlikGelen;


        while (cursor.moveToNext()) {


            anlikGelen = new Arac_ilan_DbGelen();

            anlikGelen.setIlanAracIlanId(Integer.parseInt(cursor.getString(0)));
            anlikGelen.setIlanSahibiAdi(cursor.getString(1));
            anlikGelen.setIlanSahibiSoyadi(cursor.getString(2));
            anlikGelen.setIlanTuruAdi(cursor.getString(3));
            anlikGelen.setIlanSahibiTuruAdi(cursor.getString(4));
            anlikGelen.setYakitTuruAdi(cursor.getString(5));
            anlikGelen.setSehir(cursor.getString(6));
            anlikGelen.setIlce(cursor.getString(7));
            anlikGelen.setMahalle(cursor.getString(8));
            anlikGelen.setMarka(cursor.getString(9));
            anlikGelen.setModel(cursor.getString(10));
            anlikGelen.setSeri(cursor.getString(11));
            anlikGelen.setYil(cursor.getString(12));
            anlikGelen.setKilometre(cursor.getString(13));
            anlikGelen.setMotorTipi(cursor.getString(14));
            anlikGelen.setMotorHacmi(cursor.getString(15));
            anlikGelen.setAzamiSurat(cursor.getString(16));
            anlikGelen.setOrtalamaYakit(cursor.getString(17));
            anlikGelen.setDepoHacmi(cursor.getString(18));
/*            anlikGelen.setFotoisim1(cursor.getString(19));
            anlikGelen.setFotoisim2(cursor.getString(20));
            anlikGelen.setFotoisim3(cursor.getString(21));
            anlikGelen.setFotoisim4(cursor.getString(22));*/
            anlikGelen.setIlanFiyat(Integer.parseInt(cursor.getString(23)));
            anlikGelen.setIlanKiralikHaftalikAylik(cursor.getString(24));

            arac_ilanList.add(anlikGelen);

        }
        cursor.close();

        Toast.makeText(cxt, String.valueOf(arac_ilanList.size() + " orkn"), Toast.LENGTH_LONG).show();

   /*     } catch (Exception e) {
            Toast.makeText(cxt, e.getMessage(), Toast.LENGTH_LONG).show();
        }*/

        return arac_ilanList;
    }

    public List<Arac_ilan_DbGelen> getAllKendiIlanlarim(int kullaniciId) {

        ArrayList<Arac_ilan_DbGelen> BenimArac_ilanList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT "
                + ARACILAN_COLUMN_ID + ", " + KULLANİCİ_COLUMN_ADI + ", " + KULLANİCİ_COLUMN_SOYADI + ", " +
                ILANTURU_COLUMN_ILANTURUADI + ", " + ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI + ", " + YAKITTURU_COLUMN_YAKITTURADI + ", " +
                ARACILAN_COLUMN_SEHIR + ", " + ARACILAN_COLUMN_ILCE + ", " + ARACILAN_COLUMN_MAHALLE + ", " +
                ARACILAN_COLUMN_MARKA + ", " + ARACILAN_COLUMN_MODEL + ", " + ARACILAN_COLUMN_SERI + ", " +
                ARACILAN_COLUMN_YIL + ", " + ARACILAN_COLUMN_KILOMETRE + ", " + ARACILAN_COLUMN_MOTORTIPI + ", " +
                ARACILAN_COLUMN_MOTORHACMI + ", " + ARACILAN_COLUMN_AZAMISURAT + ", " + ARACILAN_COLUMN_ORTALAMAYAKIT + ", " +
                ARACILAN_COLUMN_DEPOHACMI + ", " + ARACILAN_COLUMN_FOTOGRAF1 + ", " + ARACILAN_COLUMN_FOTOGRAF2 + ", " +
                ARACILAN_COLUMN_FOTOGRAF3 + ", " + ARACILAN_COLUMN_FOTOGRAF4 + ", " + ARACILAN_COLUMN_ILANFIYAT + ", " +
                ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK + " FROM " + ARACILAN_TABLE_NAME +
                " INNER JOIN Kullanici ON AracIlan.IlanKullaniciId = Kullanici.KullaniciId " +
                "INNER JOIN IlanTuru ON AracIlan.IlanTuruId = IlanTuru.IlanTuruId " +
                "INNER JOIN IlanSahibiTuru ON AracIlan.IlanSahibiId = IlanSahibiTuru.IlanSahibiTurId " +
                "INNER JOIN YakitTuru ON AracIlan.yakitTuruId = YakitTuru.YakitTuruId WHERE " + ARACILAN_COLUMN_KULLANICIID +
                "=" + String.valueOf(kullaniciId);


        // WHERE " +
        //                ARACILAN_COLUMN_ILANAKTIFLIK + " =0


        Cursor cursor = db.rawQuery(selectQuery, null);


        Arac_ilan_DbGelen anlikGelen;


        while (cursor.moveToNext()) {

            anlikGelen = new Arac_ilan_DbGelen();

            anlikGelen.setIlanAracIlanId(Integer.parseInt(cursor.getString(0)));
            anlikGelen.setIlanSahibiAdi(cursor.getString(1));
            anlikGelen.setIlanSahibiSoyadi(cursor.getString(2));
            anlikGelen.setIlanTuruAdi(cursor.getString(3));
            anlikGelen.setIlanSahibiTuruAdi(cursor.getString(4));
            anlikGelen.setYakitTuruAdi(cursor.getString(5));
            anlikGelen.setSehir(cursor.getString(6));
            anlikGelen.setIlce(cursor.getString(7));
            anlikGelen.setMahalle(cursor.getString(8));
            anlikGelen.setMarka(cursor.getString(9));
            anlikGelen.setModel(cursor.getString(10));
            anlikGelen.setSeri(cursor.getString(11));
            anlikGelen.setYil(cursor.getString(12));
            anlikGelen.setKilometre(cursor.getString(13));
            anlikGelen.setMotorTipi(cursor.getString(14));
            anlikGelen.setMotorHacmi(cursor.getString(15));
            anlikGelen.setAzamiSurat(cursor.getString(16));
            anlikGelen.setOrtalamaYakit(cursor.getString(17));
            anlikGelen.setDepoHacmi(cursor.getString(18));
/*            anlikGelen.setFotoisim1(cursor.getString(19));
            anlikGelen.setFotoisim2(cursor.getString(20));
            anlikGelen.setFotoisim3(cursor.getString(21));
            anlikGelen.setFotoisim4(cursor.getString(22));*/
            anlikGelen.setIlanFiyat(Integer.parseInt(cursor.getString(23)));
            anlikGelen.setIlanKiralikHaftalikAylik(cursor.getString(24));

            BenimArac_ilanList.add(anlikGelen);

        }
        cursor.close();

        Toast.makeText(cxt, String.valueOf(BenimArac_ilanList.size() + " orkn"), Toast.LENGTH_LONG).show();

        return BenimArac_ilanList;
    }

    public String FavoriEkle(int kullaniciId, int aracId) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FAVORIARACLAR_COLUMN_FAVORIARACKULLANICIID, kullaniciId);
        values.put(FAVORIARACLAR_COLUMN_FAVORIARACID, aracId);

        long result = db.insert(FAVORIARACLAR_TABLE_NAME, null, values);

        String msg = "Not INSERTED";
        if (result > 0) {
            msg = "INSERTED Succesfuly";
        }
        return msg;
    }

    public List<Arac_ilan_DbGelen> getAllFavoriAracIlan(int kulllaniciId) {

        ArrayList<Arac_ilan_DbGelen> FavArac_ilanList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

/*        String selectQuery = "SELECT "
                + ARACILAN_COLUMN_ID + ", " + KULLANİCİ_COLUMN_ADI + ", " + KULLANİCİ_COLUMN_SOYADI + ", " +
                ILANTURU_COLUMN_ILANTURUADI + ", " + ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI + ", " + YAKITTURU_COLUMN_YAKITTURADI + ", " +
                ARACILAN_COLUMN_SEHIR + ", " + ARACILAN_COLUMN_ILCE + ", " + ARACILAN_COLUMN_MAHALLE + ", " +
                ARACILAN_COLUMN_MARKA + ", " + ARACILAN_COLUMN_MODEL + ", " + ARACILAN_COLUMN_SERI + ", " +
                ARACILAN_COLUMN_YIL + ", " + ARACILAN_COLUMN_KILOMETRE + ", " + ARACILAN_COLUMN_MOTORTIPI + ", " +
                ARACILAN_COLUMN_MOTORHACMI + ", " + ARACILAN_COLUMN_AZAMISURAT + ", " + ARACILAN_COLUMN_ORTALAMAYAKIT + ", " +
                ARACILAN_COLUMN_DEPOHACMI + ", " + ARACILAN_COLUMN_FOTOGRAF1 + ", " + ARACILAN_COLUMN_FOTOGRAF2 + ", " +
                ARACILAN_COLUMN_FOTOGRAF3 + ", " + ARACILAN_COLUMN_FOTOGRAF4 + ", " + ARACILAN_COLUMN_ILANFIYAT + ", " +
                ARACILAN_COLUMN_ILANKIRALIKHAFTALIKAYLIK + " FROM " + FAVORIARACLAR_TABLE_NAME +
                " INNER JOIN AracIlan ON FavoriAraclar.FavoriAracId = AracIlan.AracIlanId " +
                "INNER JOIN Kullanici ON FavoriAraclar.FavoriAracKullaniciId = Kullanici.KullaniciId " +
                "INNER JOIN IlanTuru ON AracIlan.IlanTuruId = IlanTuru.IlanTuruId " +
                "INNER JOIN IlanSahibiTuru ON AracIlan.IlanSahibiId = IlanSahibiTuru.IlanSahibiTurId " +
                "INNER JOIN YakitTuru ON AracIlan.yakitTuruId = YakitTuru.YakitTuruId";*/

        String selectQuery = "SELECT  AracIlanId, Adi , Soyadi, IlanTuruAdi, IlanSahibiTurAdi, YakitTuruAdi ,Sehir, Ilce , Mahalle ," +
                "Marka, Model, Seri,Yil, Kilometre , MotorTipi,MotorHacmi, AzamiSurat,OrtalamaYakit," +
                "DepoHacmi, Fotograf1, Fotograf2, Fotograf3, Fotograf4, IlanFiyat,IlanKiralikHaftalikAylik " +
                "FROM FavoriAraclar" +
                " INNER JOIN AracIlan on FavoriAraclar.FavoriAracId = AracIlan.AracIlanId " +
                "INNER JOIN Kullanici ON FavoriAraclar.FavoriAracKullaniciId = Kullanici.KullaniciId " +
                "INNER JOIN IlanTuru ON AracIlan.IlanTuruId = IlanTuru.IlanTuruId " +
                "INNER JOIN IlanSahibiTuru ON AracIlan.IlanSahibiId = IlanSahibiTuru.IlanSahibiTurId " +
                "INNER JOIN YakitTuru ON AracIlan.yakitTuruId = YakitTuru.YakitTuruId WHERE " + FAVORIARACLAR_COLUMN_FAVORIARACKULLANICIID + "="
                + String.valueOf(kulllaniciId);


        // WHERE " +
        //                ARACILAN_COLUMN_ILANAKTIFLIK + " =0

        Cursor cursor = db.rawQuery(selectQuery, null);

        Arac_ilan_DbGelen anlikGelen;

        while (cursor.moveToNext()) {

            anlikGelen = new Arac_ilan_DbGelen();

            anlikGelen.setIlanAracIlanId(Integer.parseInt(cursor.getString(0)));
            anlikGelen.setIlanSahibiAdi(cursor.getString(1));
            anlikGelen.setIlanSahibiSoyadi(cursor.getString(2));
            anlikGelen.setIlanTuruAdi(cursor.getString(3));
            anlikGelen.setIlanSahibiTuruAdi(cursor.getString(4));
            anlikGelen.setYakitTuruAdi(cursor.getString(5));
            anlikGelen.setSehir(cursor.getString(6));
            anlikGelen.setIlce(cursor.getString(7));
            anlikGelen.setMahalle(cursor.getString(8));
            anlikGelen.setMarka(cursor.getString(9));
            anlikGelen.setModel(cursor.getString(10));
            anlikGelen.setSeri(cursor.getString(11));
            anlikGelen.setYil(cursor.getString(12));
            anlikGelen.setKilometre(cursor.getString(13));
            anlikGelen.setMotorTipi(cursor.getString(14));
            anlikGelen.setMotorHacmi(cursor.getString(15));
            anlikGelen.setAzamiSurat(cursor.getString(16));
            anlikGelen.setOrtalamaYakit(cursor.getString(17));
            anlikGelen.setDepoHacmi(cursor.getString(18));
/*            anlikGelen.setFotoisim1(cursor.getString(19));
            anlikGelen.setFotoisim2(cursor.getString(20));
            anlikGelen.setFotoisim3(cursor.getString(21));
            anlikGelen.setFotoisim4(cursor.getString(22));*/
            anlikGelen.setIlanFiyat(Integer.parseInt(cursor.getString(23)));
            anlikGelen.setIlanKiralikHaftalikAylik(cursor.getString(24));

            FavArac_ilanList.add(anlikGelen);

        }
        cursor.close();

        //Toast.makeText(cxt, String.valueOf(FavArac_ilanList.size() + " orkn"), Toast.LENGTH_LONG).show();

   /*     } catch (Exception e) {
            Toast.makeText(cxt, e.getMessage(), Toast.LENGTH_LONG).show();
        }*/

        return FavArac_ilanList;
    }

    //

    public String DuyuruAdd(Duyuru gelenDuyuru, Context context) {

        try {

            SQLiteDatabase db = this.getWritableDatabase(); // bu katmanda yok o yüzden oluşturuyoruz.

            ContentValues values = new ContentValues();
            values.put(DUYURU_COLUMN_BASLIK, gelenDuyuru.getDuyuruBasligi());
            values.put(DUYURU_COLUMN_ICERIK, gelenDuyuru.getDuyuruMetni());

            long result = db.insert(DUYURU_TABLE_NAME, null, values);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }


        String msg = "Not INSERTED";
    /*    if (result > 0) {
            msg = "INSERTED Succesfuly";
        }*/
        return msg;

        // eğer eklemede hata varsa negatif,ekleme hiç yapmazsa sıfır, eğer ekleme başarılı ise pozitif döndürür.
    }

    public ArrayList<Duyuru> getAllDuyurular(Context context) {

        ArrayList<Duyuru> duyuruList = new ArrayList<>();


        try {

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(DUYURU_TABLE_NAME, null, null, null, null, null, null);


            while (cursor.moveToNext()) {
                Duyuru d = new Duyuru();

                d.setDuyuruId(Integer.parseInt(cursor.getString(0)));
                d.setDuyuruBasligi(cursor.getString(1));
                d.setDuyuruMetni(cursor.getString(2));

                duyuruList.add(d);

            }

            cursor.close();


        } catch (Exception e) {

            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();

        }
        return duyuruList;

    }

    public String TabloHazirlikDegerleriniBas() {

        SQLiteDatabase db = this.getWritableDatabase(); // bu katmanda yok o yüzden oluşturuyoruz.

        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();

        ContentValues values3 = new ContentValues();
        ContentValues values4 = new ContentValues();

        ContentValues values5 = new ContentValues();
        ContentValues values6 = new ContentValues();
        ContentValues values7 = new ContentValues();
        ContentValues values8 = new ContentValues();

        values.put(ILANTURU_COLUMN_ILANTURUADI, "Satılık");
        values2.put(ILANTURU_COLUMN_ILANTURUADI, "Kiralık");

        values3.put(ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI, "Sahibinden");
        values4.put(ILANSAHIBITURU_COLUMN_ILANSAHIBITURADI, "Galeriden");

        values5.put(YAKITTURU_COLUMN_YAKITTURADI, "Dizel");
        values6.put(YAKITTURU_COLUMN_YAKITTURADI, "Benzinli");
        values7.put(YAKITTURU_COLUMN_YAKITTURADI, "Lpg");
        values8.put(YAKITTURU_COLUMN_YAKITTURADI, "Elektrikli");

        long result = db.insert(ILANTURU_TABLE_NAME, null, values);
        long result2 = db.insert(ILANTURU_TABLE_NAME, null, values2);

        long result3 = db.insert(ILANSAHIBITURU_TABLE_NAME, null, values3);
        long result4 = db.insert(ILANSAHIBITURU_TABLE_NAME, null, values4);

        long result5 = db.insert(YAKITTURU_TABLE_NAME, null, values5);
        long result6 = db.insert(YAKITTURU_TABLE_NAME, null, values6);
        long result7 = db.insert(YAKITTURU_TABLE_NAME, null, values7);
        long result8 = db.insert(YAKITTURU_TABLE_NAME, null, values8);

        String msg = "Not INSERTED";
        if (result > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0 && result6 > 0 && result7 > 0 && result8 > 0) {
            msg = "INSERTED Succesfuly";
        }
        return msg;
    }

    public int ilanSayisi() {

        int sonuc = 0;

        String selectQuery = "SELECT count(*) from AracIlan";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {

            sonuc = cursor.getInt(0);

        }

        cursor.close();
        return sonuc;
    }

    public int FavoriilanSayisi() {

        int sonuc = 0;

        String selectQuery = "SELECT count(*) from FavoriAraclar";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {

            sonuc = cursor.getInt(0);

        }
        cursor.close();
        return sonuc;
    }

    public int KullaniciSayisi() {

        int sonuc = 0;

        String selectQuery = "SELECT count(*) from Kullanici";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {

            sonuc = cursor.getInt(0);

        }
        cursor.close();
        return sonuc;
    }


}
