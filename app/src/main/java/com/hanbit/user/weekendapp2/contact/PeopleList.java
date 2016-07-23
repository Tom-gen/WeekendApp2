package com.hanbit.user.weekendapp2.contact;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-07-16.
 */
public class PeopleList {
    private final static String[][] arrPeople = {
            {"컵케이크", "cup@text.com", "010-3789-6018", "0"/*image index value*/}
            , {"도넷", "donut@text.com", "010-3789-6018", "1"/*image index value*/}
            , {"이클레어", "eclare@text.com", "010-3789-6018", "2"/*image index value*/}
            , {"프로요", "froyo@text.com", "010-3789-6018", "3"/*image index value*/}
            , {"진저", "jin@text.com", "010-3789-6018", "4"/*image index value*/}
            , {"허니컴", "honey@text.com", "010-3789-6018", "5"/*image index value*/}
            , {"아이스크림", "icecream@text.com", "010-3789-6018", "6"/*image index value*/}
            , {"젤리빈", "jelly@text.com", "010-3789-6018", "7"/*image index value*/}
            , {"킷캣", "kit@text.com", "010-3789-6018", "8"/*image index value*/}
            , {"롤리팝", "lol@text.com", "010-3789-6018", "9"/*image index value*/}
    };

    private enum INDEX_ARRPeople {
        NAME(0), EMAIL(1), PHONENO(2), IDXPHOTO(3);

        private int idx;

        private INDEX_ARRPeople(int idx) {
            this.idx = idx;
        }

        public int getIdx() {
            return idx;
        }
        }

    public static ArrayList<Person> getList() {
        ArrayList<Person> list = new ArrayList<>();

        for (String[] arr : arrPeople) {
            Person person = new Person();

            person.setName(arr[INDEX_ARRPeople.NAME.getIdx()]);
            person.setEmail(arr[INDEX_ARRPeople.EMAIL.getIdx()]);
            person.setPhoneNo(arr[INDEX_ARRPeople.PHONENO.getIdx()]);
            person.setIdxPhoto(Integer.parseInt(arr[INDEX_ARRPeople.IDXPHOTO.getIdx()]));

            list.add(person);
        }

        return list;
    }
//    private PeopleList() {
//        this.list = list;
//    }
}
