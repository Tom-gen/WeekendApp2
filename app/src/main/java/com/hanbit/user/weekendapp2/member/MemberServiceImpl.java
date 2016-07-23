package com.hanbit.user.weekendapp2.member;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by 1027 on 2016-07-09.
 */
public class MemberServiceImpl implements MemberService {
    private static MemberDAO dao;
    Context context;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
        this.context=context;
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

        dao.insert(bean);

    }

    @Override
    public void add(MemberBean bean) {
        dao.insert(bean);

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
        return dao.count();
    }

    @Override
    public List<MemberBean> list() {
        return dao.list();
    }

    @Override
    public MemberBean findByID(String id) {
        return dao.findByID(id);
    }

    @Override
    public List<MemberBean> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void update(MemberBean bean) {
        dao.update(bean);

    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
