package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

/**
 * Created by 1027 on 2016-07-16.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public static String ID = "id";
    public static String PW = "pw";
    public static String NAME = "name";
    public static String EMAIL = "email";
    public static String PHONE = "phone";
    public static String PHOTO = "photo";
    public static String ADDRESS = "address";
    public static String TABLE_NAME = "member";

    public MemberDAO(Context context) {
        //super(context, name, factory, version);
        super(context, "test.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.openOrCreateDatabase()
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append("create table if not exists " + TABLE_NAME + "(");
        sb.append("  id text primary key");
        sb.append(", pw text");
        sb.append(", name text");
        sb.append(", email text");
        sb.append(", phone text");
        sb.append(", photo text");
        sb.append(", address text);");
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*insert into member*/
    public void insert(SQLiteDatabase db, MemberBean bean) {

        String query = "insert into " + TABLE_NAME
                + String.format("(%s,%s,%s,%s,%s,%s,%s)"
                , ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDRESS)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s'); "
                , bean.getID(), bean.getPW(), bean.getName(), bean.getEmail(), bean.getPhone(), bean.getPhoto(), bean.getAddress());
        db.execSQL(query);

    }

    public MemberBean login(MemberBean param) {
        MemberBean member = new MemberBean();
        SQLiteDatabase db = this.getReadableDatabase();


        String query = String.format("select * from " + TABLE_NAME + " where id='%s' and pw='%s' "
                , param.getID(), param.getPW());
        try {
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToNext()) {
                //db index: 1-base
                member.setID(cursor.getString(0));
                member.setPW(cursor.getString(1));
                Log.d("db result-id", member.getID());
            } else {
                member = null;
            }
        } catch (Exception ex) {
            Log.d("db error", ex.getMessage());
        }

        db.close();
        return member;
    }

    public int count(SQLiteDatabase db, MemberBean bean) {

        String query = "select count(*) from " + TABLE_NAME + ";";
        Cursor cur = db.rawQuery(query, null);
        return 0;
    }

    public List<MemberBean> list(SQLiteDatabase db) {
        String query = "select * from " + TABLE_NAME + ";";
        Cursor cur = db.rawQuery(query, null);
        return null;
    }

    public List<MemberBean> findByName(SQLiteDatabase db, String name) {
        String query = "select * from " + TABLE_NAME
                + String.format(" where " + NAME + " like '%s%%';", name);
        Cursor cur = db.rawQuery(query, null);
        return null;
    }

    public MemberBean findByID(SQLiteDatabase db, String id) {
        String query = "select * from " + TABLE_NAME
                + String.format(" where " + ID + "='%s';", id);
        Cursor cur = db.rawQuery(query, null);
        //if(cur.moveToNext())

        return null;
    }

    public void update(SQLiteDatabase db, MemberBean bean) {
        String query = " update " + TABLE_NAME + " set "
                + String.format(" %s='%s'", PW, bean.getPW())
                + String.format(", %s='%s'", EMAIL, bean.getEmail())
                + String.format(", %s='%s'", PHOTO, bean.getPhoto())
                + String.format(", %s='%s'", ADDRESS, bean.getAddress())
                + String.format(" where %s='%s';", ID, bean.getID());
        Cursor cur = db.rawQuery(query, null);
    }

    public void delete(SQLiteDatabase db, MemberBean bean) {
        String query = " delete from " + TABLE_NAME
                + String.format(" where %s='%s';", ID, bean.getID());
        Cursor cur = db.rawQuery(query, null);
    }
}
