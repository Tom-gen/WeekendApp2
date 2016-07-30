package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-07-30.
 */
public class GuestDAO extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "guest";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";

    public GuestDAO(Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append("create table if not exists member(");
            sb.append("  id text primary key");
            sb.append(", pw text");
            sb.append(", name text");
            sb.append(", email text");
            sb.append(", phone text");
            sb.append(", photo text");
            sb.append(", address text);");
            db.execSQL(sb.toString());
            String sql = "create table if not exists " + TABLE_NAME + "( _id integer primary key autoincrement "
                    + ", name text, phone text);";
            db.execSQL(sql);
        } catch (Exception ex) {
            Log.d("ERROR:", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists member");
        db.execSQL("drop table if exists guest");
        onCreate(db);
    }

    public void add(MemberBean guest) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String query = "insert into " + TABLE_NAME
                    + String.format("(%s,%s)", NAME, PHONE)
                    + String.format(" values('%s','%s'); ", guest.getName(), guest.getPhone());
//            String query = "insert into guest(name,phone) values('lotus','010'); ";

            Log.d("query: ", query);


            db.execSQL(query);
        } catch (Exception ex) {
            Log.d("error!! ", ex.getMessage());
        }

    }

    public ArrayList<MemberBean> list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query
                = String.format("select %s, %s, %s", ID, NAME, PHONE)
                + " from " + TABLE_NAME + ";";
        Cursor cur = db.rawQuery(query, null);

        ArrayList<MemberBean> list = new ArrayList<>();
        while (cur.moveToNext()) {
            MemberBean bean = new MemberBean();
            bean.setID(cur.getString(cur.getColumnIndex(ID)));
            //bean.setID(String.valueOf(cur.getInt(cur.getColumnIndex(ID))));
            bean.setName(cur.getString(cur.getColumnIndex(NAME)));
            bean.setPhone(cur.getString(cur.getColumnIndex(PHONE)));
            list.add(bean);
        }
        return list;
    }
}
