// 상품비교 화면 최지욱//
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

public class goods_comparison extends Activity {
    private DataBaseDao mDataBaseDao;

    TextView VSText, ipadView, lenovoView, lowestView, GoodsExplainView, GoodsExplainView2,
             textView, textView2, textView3, textView4, textView5, textView6;
    ImageView loginLogo2, UserImage, imageView4;
    ImageButton back23;
    Button btn_FirstItemBuy, btn_SecondeItemBuy;

    Intent Page;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_comparison);

        VSText = (TextView) findViewById(R.id.VSText);
        ipadView = (TextView) findViewById(R.id.ipadView);
        lenovoView = (TextView) findViewById(R.id.lenovoView);
        lowestView = (TextView) findViewById(R.id.lowestView);
        GoodsExplainView = (TextView) findViewById(R.id.GoodsExplainView);
        GoodsExplainView2 = (TextView) findViewById(R.id.GoodsExplainView2);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        loginLogo2 = (ImageView) findViewById(R.id.loginLogo2);
        UserImage = (ImageView) findViewById(R.id.UserImage);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        back23 = (ImageButton) findViewById(R.id.back23);
        btn_FirstItemBuy = (Button) findViewById(R.id.btn_FirstItemBuy);
        btn_SecondeItemBuy = (Button) findViewById(R.id.btn_SecondeItemBuy);

        back23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뒤로가기
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });
        btn_FirstItemBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 구매하기 페이지로 이동
            }
        });
        btn_SecondeItemBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 구매하기 페이지로 이동
            }
        });


    }

}
