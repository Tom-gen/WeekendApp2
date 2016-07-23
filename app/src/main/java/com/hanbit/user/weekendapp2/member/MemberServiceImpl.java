package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Member;
import java.util.List;

/**
 * Created by 1027 on 2016-07-09.
 */
public class MemberServiceImpl implements MemberService {

    private static MemberDAO dao;

    public MemberServiceImpl(Context context) {

        dao = new MemberDAO(context);
    }

    @Override
    public void join(MemberBean bean) {
        String id = bean.getID();
        String pw = bean.getPW();
        String name = bean.getName();
        String email = bean.getEmail();

        Log.d("입력한 ID:", id);
        Log.d("입력한 PW:", pw);
        Log.d("입력한 name:", name);
        Log.d("입력한 email:", email);

    }

    @Override
    public void add(Member bean) {

    }

    @Override
    public Boolean login(MemberBean bean) {
        Boolean loginOK = false;

        MemberBean resultBean = dao.login(bean);
        if (resultBean != null)
            loginOK = true;

        return loginOK;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<MemberBean> list() {
        return null;
    }

    @Override
    public MemberBean findByID(String id) {
        return null;
    }

    @Override
    public List<MemberBean> findByName(SQLiteDatabase db, String name) {
        return null;
    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {

    }
}
