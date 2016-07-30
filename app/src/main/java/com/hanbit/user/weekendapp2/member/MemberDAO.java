package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

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
        String sql = "create table if not exists guest( _id integer primary key autoincrement "
                + ", name text, phone text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists member");
        db.execSQL("drop table if exists guest");
        onCreate(db);
    }

    /*insert into member*/
    public void insert(/*SQLiteDatabase db,*/ MemberBean bean) {
        String query = "insert into " + TABLE_NAME
                + String.format("(%s,%s,%s,%s,%s,%s,%s)"
                , ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDRESS)
                + String.format(" values('%s','%s','%s','%s','%s','%s','%s'); "
                , bean.getID(), bean.getPW(), bean.getName(), bean.getEmail(), bean.getPhone(), bean.getPhoto(), bean.getAddress());
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(query);
        db.close();
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

    public int count() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select count(*) as count from " + TABLE_NAME + ";";
        Cursor cur = db.rawQuery(query, null);
        int result = 0;
        if (cur.moveToNext()) {
            result = cur.getInt(cur.getColumnIndex("count"));
        }
        return result;
    }

    public ArrayList<MemberBean> list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select "
                + String.format("%s, %s, %s, %s, %s, %s, %s"
                , ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDRESS)
                + " from " + TABLE_NAME + ";";
        Cursor cur = db.rawQuery(query, null);
        ArrayList<MemberBean> list = new ArrayList<>();

        while (cur.moveToNext()) {
            MemberBean bean = new MemberBean();
            bean.setID(cur.getString(cur.getColumnIndex(ID)));
            bean.setPW(cur.getString(cur.getColumnIndex(PW)));
            bean.setName(cur.getString(cur.getColumnIndex(NAME)));
            bean.setEmail(cur.getString(cur.getColumnIndex(EMAIL)));
            bean.setPhone(cur.getString(cur.getColumnIndex(PHONE)));
            bean.setPhoto(cur.getString(cur.getColumnIndex(PHOTO)));
            bean.setAddress(cur.getString(cur.getColumnIndex(ADDRESS)));

            list.add(bean);
        }
        return list;
    }

    public ArrayList<MemberBean> findByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select "
                + String.format("%s, %s, %s, %s, %s, %s, %s"
                , ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDRESS)
                + " from " + TABLE_NAME
                + String.format(" where " + NAME + " like '%s%%';", name);
        Cursor cur = db.rawQuery(query, null);
        ArrayList<MemberBean> list = new ArrayList<>();
        while (cur.moveToNext()) {
            MemberBean bean = new MemberBean();
            bean.setID(cur.getString(cur.getColumnIndex(ID)));
            bean.setPW(cur.getString(cur.getColumnIndex(PW)));
            bean.setName(cur.getString(cur.getColumnIndex(NAME)));
            bean.setEmail(cur.getString(cur.getColumnIndex(EMAIL)));
            bean.setPhone(cur.getString(cur.getColumnIndex(PHONE)));
            bean.setPhoto(cur.getString(cur.getColumnIndex(PHOTO)));
            bean.setAddress(cur.getString(cur.getColumnIndex(ADDRESS)));

            list.add(bean);
        }
        return list;
    }

    public MemberBean findByID(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select "
                + String.format("%s, %s, %s, %s, %s, %s, %s"
                , ID, PW, NAME, EMAIL, PHONE, PHOTO, ADDRESS)
                + " from " + TABLE_NAME
                + String.format(" where " + ID + "='%s';", id);
        Cursor cur = db.rawQuery(query, null);
        MemberBean bean = null;
        if (cur.moveToNext()) {
            bean = new MemberBean();
            bean.setID(cur.getString(cur.getColumnIndex(ID)));
            bean.setPW(cur.getString(cur.getColumnIndex(PW)));
            bean.setName(cur.getString(cur.getColumnIndex(NAME)));
            bean.setEmail(cur.getString(cur.getColumnIndex(EMAIL)));
            bean.setPhone(cur.getString(cur.getColumnIndex(PHONE)));
            bean.setPhoto(cur.getString(cur.getColumnIndex(PHOTO)));
            bean.setAddress(cur.getString(cur.getColumnIndex(ADDRESS)));
        }
        return bean;
    }

    public void update(MemberBean bean) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " update " + TABLE_NAME + " set "
                + String.format(" %s='%s'", PW, bean.getPW())
                + String.format(", %s='%s'", EMAIL, bean.getEmail())
                + String.format(", %s='%s'", PHOTO, bean.getPhoto())
                + String.format(", %s='%s'", ADDRESS, bean.getAddress())
                + String.format(" where %s='%s';", ID, bean.getID());
        Cursor cur = db.rawQuery(query, null);
        db.execSQL(query);
        db.close();
    }

    public void delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " delete from " + TABLE_NAME
                + String.format(" where %s='%s';", ID, id);
        Cursor cur = db.rawQuery(query, null);
        db.execSQL(query);
        db.close();
    }
}
