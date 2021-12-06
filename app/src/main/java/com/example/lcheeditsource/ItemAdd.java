package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ItemAdd extends AppCompatActivity implements ItemAddOne.ItemAddDoneListener {

    private DataBaseDao mDatabaseDao;
    public ProductionDAO mItemDao;

    Intent Page;

    ImageView _Itemimage;
    Button _picAdd, _itemSave, _itemCancel;
    EditText _itemName, _itemPrice, _itemProduction;

    String Tag;

    // 상품의 분류를 보여줄 배열 선언
    String[] itemTagArr = {"가전제품", "의류", "자동차", "반려동물",
            "도서음반", "스포츠", "아웃도어", "생화용품", "식품"};

    View.OnClickListener btn;

    String ImageName = "inputpic";

    Boolean ItemAddQus;


    // 의류일경우 입력받는 데이터의 값
    String _Wash, _Bleaching, _Steam, _Dry, _Dryer;
    Boolean ClothCheack = false;


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

        _Itemimage = findViewById(R.id.image_ItemImage);

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

        // 스피너 객체를 보여줌
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 선택됫을경우
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.WHITE);
                Tag = itemTagArr[position].toString();      // Tag 변수를 선택된 스피너 객체로 초기화
                Toast.makeText(getApplicationContext(), Tag, Toast.LENGTH_SHORT).show();    // 선택된 태그를 이용자에게 메세지로 전달함
            }

            // 아무것도 선택되지 않은 상태일 때
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 사용자에게 이미지를 선택받는 함수들~
        // 사용자에게 이미지를 입력받을코드
        try {
            String imgpath = getCacheDir() + "/" + ImageName;       // 내부 저장소에 저장되어있는 이미지경로
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            _Itemimage.setImageBitmap(bm);          // 내부 저장소애 저장된 이미지를 set
            Toast.makeText(getApplicationContext(), "파일 로드 성공", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "파일 로드 실패", Toast.LENGTH_SHORT).show();
        }

        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // 이미지 추가버튼
                    case R.id.btn_itemPictureAdd:
                        Page = new Intent();
                        Page.setType("image/*");
                        Page.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Page, 101);
                        break;

////                    // 저장버튼
                    case R.id.btn_ItemaddSave:
                        // 만약 태그가 의류라면 ClothDetails에서 옷에 대한 상세 정보를 기록 하게끔 함
                        if (Tag.equals("의류")) {
                            Page = new Intent(getApplicationContext(), ClothDetails.class);
                            startActivityForResult(Page, 201);
                        } else {
                            ItemAddOne itemAddQus = new ItemAddOne();
                            itemAddQus.show(getSupportFragmentManager(), "ItemAddQus");
                        }
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

    // 이미지 전달받은 값에 대한 반응
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
//                Uri fileUri = data.getData();
//                ContentResolver resolver = getContentResolver();
                try {
//                    InputStream instream = resolver.openInputStream(fileUri);
                    InputStream instream = getContentResolver().openInputStream(data.getData());
                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                    _Itemimage.setImageBitmap(imgBitmap);    // 선택한 이미지 이미지뷰에 셋
                    instream.close();   // 스트림 닫아주기
                    saveBitmapToJpeg(imgBitmap);    // 내부 저장소에 저장
                    Toast.makeText(getApplicationContext(), "파일 불러오기 성공", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일 불러오기 실패", Toast.LENGTH_SHORT).show();
                }
            }
            // ClothDetails에서 입력받은 값
        } else if (requestCode == 201) {
            if (resultCode == RESULT_OK) {
                _Wash = data.getStringExtra("Wash");
                _Bleaching = data.getStringExtra("Bleaching");
                _Steam = data.getStringExtra("Steam");
                _Dry = data.getStringExtra("Dry");
                _Dryer = data.getStringExtra("Dryer");
                ClothCheack = data.getBooleanExtra("ClothCheackBool", false);

                ItemAddOne itemAddQus = new ItemAddOne();
                itemAddQus.show(getSupportFragmentManager(), "ItemAddQus");

            }
        }
    }

    public String saveBitmapToJpeg(Bitmap bitmap) {   // 선택한 이미지 내부 저장소에 저장

        File storage = getCacheDir(); //  path = /data/user/0/YOUR_PACKAGE_NAME/cache
        String fileName = ImageName + ".jpg";
        File imgFile = new File(storage, fileName);
        try {
            imgFile.createNewFile();
            FileOutputStream out = new FileOutputStream(imgFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, out); //썸네일로 사용하므로 퀄리티를 낮게설정
            out.close();
        } catch (FileNotFoundException e) {
            Log.e("saveBitmapToJpg", "FileNotFoundException : " + e.getMessage());
        } catch (IOException e) {
            Log.e("saveBitmapToJpg", "IOException : " + e.getMessage());
        }
        Log.d("imgPath", getCacheDir() + "/" + fileName);
        return getCacheDir() + "/" + fileName;


    }


    @Override
    public void onButtonClicked(Boolean ItemAddQus) {
        this.ItemAddQus = ItemAddQus;

        // 만약에 아이템을 추가한다고 전달 받았을때
        if (this.ItemAddQus == true) {
            Page = new Intent(getApplicationContext(), MainActivity.class);
            Toast.makeText(getApplicationContext(), "아이템을 추가하였습니다", Toast.LENGTH_SHORT).show();

            String _ItemNameStr = _itemName.getText().toString();
            int _ItemPriceInt = Integer.parseInt(_itemPrice.getText().toString());
            String _ItemProductStr = _itemProduction.getText().toString();
            Production productionAdd = new Production();

            if(Tag.equals("의류")){
                productionAdd.setItemName(_ItemNameStr);
                productionAdd.setPrice(_ItemPriceInt);
                productionAdd.setItemProduction(_ItemProductStr);
                productionAdd.setWashSpec(_Wash);
                productionAdd.setBleaching(_Bleaching);
                productionAdd.setSteam(_Steam);
                productionAdd.setDry(_Dry);
                productionAdd.setDryer(_Dryer);
                productionAdd.setItemTag("clothes, " + Tag);

            }else {
                productionAdd.setItemName(_ItemNameStr);
                productionAdd.setPrice(_ItemPriceInt);
                productionAdd.setItemProduction(_ItemProductStr);
                productionAdd.setItemTag("electronic, " + Tag);
            }


            mItemDao.setInsertItem(productionAdd);

            startActivity(Page);
        } else if (this.ItemAddQus == false) {
//            finish();
        }

    }
}


