package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1027 on 2016-07-30.
 */
public class MemberServiceImpl_Guest implements MemberService {
    private static GuestDAO dao;
    Context context;

    public MemberServiceImpl_Guest(Context context) {
        try {
            dao = new GuestDAO(context);
            this.context = context;
        } catch (Exception ex) {
            Log.d("ERROR:", ex.getMessage());
        }
    }

    @Override
    public void join(MemberBean bean) {

    }

    @Override
    public void add(MemberBean bean) {
        dao.add(bean);
    }

    @Override
    public Boolean login(MemberBean bean) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public ArrayList<MemberBean> list() {
        return dao.list();
    }

    @Override
    public MemberBean findByID(String id) {
        return null;
    }

    @Override
    public List<MemberBean> findByName(String name) {
        return null;
    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(String id) {

    }
}
