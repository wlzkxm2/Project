package com.example.lcheeditsource;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ClothDetails extends AppCompatActivity {



    Intent Page;

    Button DetailsOK, DetailsNo;

    Spinner Wash, Bleaching, Steam, Dry, Dryer;

    String[] WashArr = {"95도 세탁",
            "60도 세탁",
            "40도 세탁",
            "40도 약하게세탁",
            "30도 약하게세탁",
            "30도 세탁기 불가",
            "물세탁 안됨"};

    String[] BleachingArr = {"염소, 산소표백제 사용가능",
            "염소표백제 사용가능능",
            "염소표백제 불가",
            "산소표백제 사용",
            "산소표백제 불가",
            "염소, 산소표백제 사용불가"};

    String[] SteamArr = {"180~210도 다림질",
            "천을 덮고 180~210도 다림질",
            "140~160도 다림질",
            "천을 덮고 140~160도 다림질",
            "80~120도 다림질",
            "천을 덮고 80~120도 다림질",
            "다림질 불가"};

    String[] DryArr = {"드라이클리닝가능",
            "석유제 드라이클리닝 가능",
            "드라이클리닝은 가능하나 셀프 불가",
            "드라이클리닝 불가"};

    String[] DryerArr = {"햇빛에 건조",
            "옷걸이에 걸어 그늘건조",
            "바닥에 뉘어서 햇빛 건조",
            "바닥에 뉘어서 그늘건조",
            "기계건조가능",
            "기계건조불가",
            "손으로 약하게 짬",
            "손으로 짜면안됨"};

    String Wash_C, Bleaching_C, Steam_C, Dry_C, Dryer_C;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.clothesdettails);

        DetailsOK = findViewById(R.id.btn_ClothDetailOK);
        DetailsNo = findViewById(R.id.btn_ClothDetailNO);
        Wash = findViewById(R.id.box_ClothWash);
        Bleaching = findViewById(R.id.box_ClothBleaching);
        Steam = findViewById(R.id.box_ClothSteam);
        Dry = findViewById(R.id.box_ClothDry);
        Dryer = findViewById(R.id.box_ClothDryer);

        Page = getIntent();






        // 세탁 방법 스피터 객체 생성
        ArrayAdapter<String> WashAdap =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WashArr);
        WashAdap.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Wash.setAdapter(WashAdap);

        ArrayAdapter<String> BleachingAdap =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, BleachingArr);
        WashAdap.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Bleaching.setAdapter(BleachingAdap);

        ArrayAdapter<String> SteamAdap =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SteamArr);
        WashAdap.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Steam.setAdapter(SteamAdap);

        ArrayAdapter<String> DryAdap =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DryArr);
        WashAdap.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Dry.setAdapter(DryAdap);

        ArrayAdapter<String> DryerAdap =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DryerArr);
        WashAdap.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Dryer.setAdapter(DryerAdap);


        Wash.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 선택될경우
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Wash_C = WashArr[position].toString();
                Toast.makeText(getApplicationContext(), Wash_C, Toast.LENGTH_SHORT).show();
            }

            // 선택되지 않을경우
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Bleaching.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Bleaching_C = BleachingArr[position].toString();
                Toast.makeText(getApplicationContext(), Bleaching_C, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Steam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Steam_C = SteamArr[position].toString();
                Toast.makeText(getApplicationContext(), Steam_C, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Dry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Dry_C = DryArr[position].toString();
                Toast.makeText(getApplicationContext(), Dry_C, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Dryer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Dryer_C = DryerArr[position].toString();
                Toast.makeText(getApplicationContext(), Dryer_C, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 선택이 완료되면 데이터를 보낸다
        DetailsOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Page = new Intent();
                Page.putExtra("Wash", Wash_C);
                Page.putExtra("Bleaching", Bleaching_C);
                Page.putExtra("Steam", Steam_C);
                Page.putExtra("Dry", Dry_C);
                Page.putExtra("Dryer", Dryer_C);
                Page.putExtra("ClothCheackBool", true);
                setResult(RESULT_OK, Page);
                finish();
            }
        });

        // 취소를 누르면 데이터 입력이 안됨
        DetailsNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
}
