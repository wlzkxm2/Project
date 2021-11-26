package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;

public class ItemAdd extends Activity {

    private DataBaseDao mDatabaseDao;
    public ProductionDAO mItemDao;

    Intent Page;
    
    ImageView _userimage;
    Button _picAdd, _itemSave, _itemCancel;
    EditText _itemName, _itemPrice, _itemProduction;
    
    String Tag;
    
    String[] itemTagArr = {"가전제품", "의류", "자동차", "반려동물",
            "도서음반", "스포츠", "아웃도어", "생화용품", "식품"};

    View.OnClickListener btn;
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemadd);


        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();

        ProductionAbs itemDB = Room.databaseBuilder(getApplicationContext(), ProductionAbs.class, "Item.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mItemDao = itemDB.productionDAO();

        _userimage = findViewById(R.id.UserImage);

        _picAdd = findViewById(R.id.btn_itemPictureAdd);
        _itemSave = findViewById(R.id.btn_ItemaddSave);
        _itemCancel = findViewById(R.id.btn_itemaddCancel);

        _itemName = findViewById(R.id.edit_ItemName);
        _itemPrice = findViewById(R.id.edit_ItemPrice);
        _itemProduction = findViewById(R.id.edit_ItemProduction);
        
        // Spinner 선언
        Spinner spinner = findViewById(R.id.box_ItemTag);
        
        // Spinner 배열선언으로 simple_spinner_item API사용하여 어댑터 선언
        ArrayAdapter<String> ItemTag = 
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemTagArr);
        
        // 미리 정의된 레이아웃 사용
        ItemTag.setDropDownViewResource(android.R.layout.simple_spinner_item);
        
        // 스피너 객체에 어댑터 삽입
        spinner.setAdapter(ItemTag);
        
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 선택되면
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Tag = itemTagArr[position].toString() ;
                Toast.makeText(getApplicationContext(), Tag, Toast.LENGTH_SHORT).show();
            }

            // 아무것도 선택되지 않은 상태일 때
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    // 이미지 추가버튼
                    case R.id.btn_itemPictureAdd:
                        break;

                    // 저장버튼
                    case R.id.btn_ItemaddSave:
                        break;

                    // 최소 버튼
                    case R.id.btn_itemaddCancel:
                        Page = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(Page);
                        break;
                }
            }
        };

        _picAdd.setOnClickListener(btn);
        _itemSave.setOnClickListener(btn);
        _itemCancel.setOnClickListener(btn);

    }
}
