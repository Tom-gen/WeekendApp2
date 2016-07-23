package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 1027 on 2016-07-16.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        //super(context, name, factory, version);
        super(context, "test.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.openOrCreateDatabase()
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public MemberBean login(MemberBean param) {
        MemberBean member = new MemberBean();
        SQLiteDatabase db = this.getReadableDatabase();


        String query = String.format("select * from member where id='%s' and pw='%s' "
                , param.getID(), param.getPW());
        try {
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToNext()) {
                //db index: 1-base
                member.setID(cursor.getString(0));
                member.setPW(cursor.getString(1));
                Log.d("db result-id", member.getID());
            }
            else {
                member=null;
            }
        }catch (Exception ex) {
            Log.d("db error",ex.getMessage());
        }

        db.close();
        return member;
    }
}
