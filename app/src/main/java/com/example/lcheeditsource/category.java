/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211115 카테고리 페이지 생성
 *      -- 김종원,최지욱
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;

import java.util.List;

public class category extends Activity {
    private DataBaseDao mDataBaseDao;

    TextView CategoryText;
    ImageView loginlogo2, imageView5;
    ImageButton back2, electronics, fashion, car, pet, books, sport, outdoor, dailynecessities,
            food;

    Intent Page;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        CategoryText = (TextView) findViewById(R.id.text_category);
        loginlogo2 = (ImageView) findViewById(R.id.loginLogo2);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        back2 = (ImageButton) findViewById(R.id.image_back);
        electronics = (ImageButton) findViewById(R.id.img_electronics);
        fashion = (ImageButton) findViewById(R.id.img_fashion);
        car = (ImageButton) findViewById(R.id.img_car);
        pet = (ImageButton) findViewById(R.id.img_pet);
        books = (ImageButton) findViewById(R.id.img_books);
        sport = (ImageButton) findViewById(R.id.img_sport);
        outdoor = (ImageButton) findViewById(R.id.img_outdoor);
        dailynecessities = (ImageButton) findViewById(R.id.img_dailynecessities);
        food = (ImageButton) findViewById(R.id.img_food);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });
        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //가전제품 화면으로 이동
            }
        });

        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //의류 화면으로 이동
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //차량 화면으로 이동
            }
        });
        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //애완용품 화면으로 이동
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //도서 화면으로 이동
            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //스포츠 화면으로 이동
            }
        });
        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //가전제품 화면으로 이동
            }
        });
        outdoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //아웃도어 화면으로 이동
            }
        });
        dailynecessities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //생활용품 화면으로 이동
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //식품 화면으로 이동
            }
        });
    }
}
