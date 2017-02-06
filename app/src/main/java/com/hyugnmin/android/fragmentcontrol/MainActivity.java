package com.hyugnmin.android.fragmentcontrol;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment list;
    DetailFragment detail;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. fragment 생성
        list = new ListFragment();
        detail = new DetailFragment();

        //2. fragment 매니저 가져오기
        //getFragmentManager(); - 앱 호환성이 없는 함수
         manager = getSupportFragmentManager();//앱 호환성이 있는 매니저 함수

        //3. fragment를 실행하기 위한 transaction 시작

        //4. fragment를 레이아웃에 add한다.

        //5. git의 commit과 같은 기능

        // 이 다섯 단계는 layout xml에서 frgment에 android:name="com.hyugnmin.android.fragmentcontrol.ListFragment" 태그를
        // 달아주면 자동으로 시스템에서 실행해준다.


        //list fragment에 자신을 넘겨준다
        list.setActivity(this);
        detail.setActivity(this);

        setList();

    }

    //액티비티에 처음 목록이 세팅될 때
    public void setList() {

        //3. fragment를 실행하기 위한 transaction 시작
        FragmentTransaction transaction = manager.beginTransaction();

        //4. fragment를 레이아웃에 add한다.
        transaction.add(R.id.fragment, list);

        //4.1 commit 전에  transaction 전체를 stack에 저장한다.
        //transaction.addToBackStack(null);

        //5. git의 commit과 같은 기능
        transaction.commit();
    }

    //List에서 Detail로 이동할 때
    public void goDetail() {

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.fragment, detail);

        transaction.addToBackStack(null);

        transaction.commit();
    }

    //DetailFragment에서 List로 돌아갈 때
    public void backToList() {

//       스택을 빼내면 된다.
        super.onBackPressed();
//
//        FragmentTransaction transaction = manager.beginTransaction();
//
//        //4. detial fragment를 stack에서 제거한다.
//        transaction.remove(detail);
//
//        transaction.commit();

    }

}
