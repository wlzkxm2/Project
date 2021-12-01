/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211119 검색 페이지 생성
 *      -- 김종원
 *      211123 검색 페이지 XML 수정
 *      -- 김종원
 *      211123 검색 자바 코드 추가
 *      -- 김종원
 */

package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.alexanderwang;

import java.util.List;


public class search extends Activity {
    private DataBaseDao mDataBaseDao;

    Button sb1, sb2, sb3, sb4, sb5, sb6;
    ImageButton back;
    EditText st;

    SearchView Sv;

    Intent Page;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        back = (ImageButton) findViewById(R.id.back);
        sb1 = (Button) findViewById(R.id.searchbutton1);
        sb2 = (Button) findViewById(R.id.searchbutton2);
        sb3 = (Button) findViewById(R.id.searchbutton3);
        sb4 = (Button) findViewById(R.id.searchbutton4);
        sb5 = (Button) findViewById(R.id.searchbutton5);
        sb6 = (Button) findViewById(R.id.searchbutton6);

        // 서치뷰 추가 이지원
        Sv = findViewById(R.id.searchv_SearchBtn);
        Sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서치뷰의 어떤 부분이든 출력되는 함수
                Sv.setIconified(false);
            }
        });

        Sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 입력받은 문자열 처리
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 입력란의 문자열이 바뀔때 처리
                return true;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                Page = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Page);
            }
        });
        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Page = new Intent(getApplicationContext(), alexanderwang.class);
                startActivity(Page);
                //검색 순위 1위 화면으로 이동
            }
        });
        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색 순위 2위 화면으로 이동
            }
        });
        sb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색 순위 3위 화면으로 이동
            }
        });
        sb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색 순위 4위 화면으로 이동
            }
        });
        sb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색 순위 5위 화면으로 이동
            }
        });
        sb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색 순위 6위 화면으로 이동
            }
        });
    }
}