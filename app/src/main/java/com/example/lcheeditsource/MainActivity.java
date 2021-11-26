package com.example.lcheeditsource;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;

import java.util.List;


/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211108 / 18:00 데이터베이스 접근함수 생성
 *      Line 25 Dao객체 생성
 *      Line 32 ~ 76 데이터베이스 접근 함수 생성
 *      -- 이지원
 *
 *      211111 / 메인페이지 XML완성
 *      -- 김종원
 *
 *      211123 / 로그인 페이지로 이동하는 분기생성
 *      -- 이지원
 *
 * */

public class MainActivity extends AppCompatActivity implements Mypageadminchoice.MypagePageChoiceListener {

    public DataBaseDao mDatabaseDao;       // Dao 객체 생성
    public ProductionDAO mItemDao;

    Intent Page;

    ImageButton MyPage;
    
    // 로그인 여부를 확인할 bool함수
    Boolean LoginCheack = false;
    Boolean AdminCheack = false;
    private int wherePage = 3;

    
    // 이미지를 불러오는데 필요한 권한을 유저에게 요청함
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 데이터 베이스삽입
        // !! 수정 금지 !!
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


        List<UserInfo> userList = mDatabaseDao.getUserAll();

        MyPage = (ImageButton) findViewById(R.id.btn_MyPage);

        MyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginCheack == false){
                    Page = new Intent(getApplicationContext(), Login.class);
                    Page.putExtra("Login", LoginCheack);
                    startActivityForResult(Page, 100);
//                    startActivity(Page);
                } else{
                    if(AdminCheack == true){
                        // 하단 팝업이 나오게끔
                        Mypageadminchoice itemaddchoice = new Mypageadminchoice();
                        itemaddchoice.show(getSupportFragmentManager(), "MyPageOrItemadd");
                    }else{
                        Page = new Intent(getApplicationContext(), mypage.class);
                        startActivity(Page);
                    }

                }

            }
        });
/*
        UserInfo user = new UserInfo();
        user.setUserId("Admin2");          // 유저의 아이디
        user.setPassword("admin2");        // 유저의 비밀번호
        user.setEmail("admin@gmail.com");           // 복구할 이메일
        user.setName("Admin2");            // 유저의 이름
        user.setSex("Male");             // 유저의 성별
        user.setRigisterDate("2021-11-19");    // 가입 날짜
        user.setBirth_Year("0000-00-00");      // 태어난해
        user.setBirth_Month("0000-00-00");     // 태어난 월
        user.setBirth_Day("0000-00-00");       // 태어난 일
        user.setPhoneNumber("000-0000-000");     // 개인 전화번호
        user.setUserAddressNumber("0000-00-00");     // 우편번호
        user.setUserAddressDefault("0000-00-00");      // 기본주소
        user.setUserAddressMore("0000-00-00");         // 상세주소
        user.setAdmin(true);
        mDatabaseDao.setInsertUser(user);
*/// 최초 어드민 어카운트
/*
        Production production = new Production();
        production.setItemName("testItem");          // 유저의 아이디
        production.setPrice(12000);        // 유저의 비밀번호
        production.setItemProduction("shingu");           // 복구할 이메일
        mItemDao.setInsertItem(production);

 */ // 상품 추가코드

/*

        // 데이터 삽입
        User user = new User();     //  객체 인스턴스
        user.setName("입력할 이름");
        user.setAge("나이");
        user.setPhoneNumber("010-1234-5678");
        mUserDao.setInsertUser(user);

        // UserDao에 만든 데이터 조회 쿼리
        // 결과값이 list User에 저장됨
        List<User> userList = mUserDao.getUserAll();
        // 데이터 조회
        for (int i = 0; i < userList.size(); i++) {
            Log.d("Test", userList.get(i).getName() + "\n"
                    + userList.get(i).getAge() + "\n"
                    + userList.get(i).getPhoneNumber() + "\n");
        }

//         데이터 수정
        User user2 = new User();     //  객체 인스턴스
        user2.setId(1);              // 데이터베이스의 id
        user2.setName("지원_수정");
        user2.setAge("25");
        user2.setPhoneNumber("010-1234-0000");
        mUserDao.setUpdateUser(user2);      // 데이터 수정


        // 데이터 삭제
        User user3 = new User();
        user3.setId(4);
        mUserDao.setDeleteUser(user3);
        */ // 데이터 베이스의 기본형

// !! 여기까지 수정금지 !!




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            if(resultCode == 101){
                LoginCheack = data.getBooleanExtra("Bool_LoginCheack", false);
                AdminCheack = data.getBooleanExtra("Bool_AdminCheack", false);
                if(AdminCheack.equals(true))
                    Toast.makeText(getApplicationContext(), "어드민로그인", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onButtonClicked(int _Page) {
//        Toast.makeText(getApplicationContext(), "페이지 선택 " + Page, Toast.LENGTH_SHORT).show();
        wherePage = _Page;

        // 페이지 이동
        if(wherePage == 1){
            Page = new Intent(getApplicationContext(), ItemAdd.class);
            startActivity(Page);
        }else if(wherePage == 0){
            Page = new Intent(getApplicationContext(), mypage.class);
            startActivity(Page);
        }

    }
}


