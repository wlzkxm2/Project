package com.example.lcheeditsource;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBase.UserInfo;
import com.example.lcheeditsource.DataBaseSetting.DataBaseAbs;
import com.example.lcheeditsource.DataBaseSetting.DataBaseDao;
import com.example.lcheeditsource.DataBaseSetting.ProductionAbs;
import com.example.lcheeditsource.DataBaseSetting.ProductionDAO;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;

import java.util.List;




public class MainActivity extends AppCompatActivity implements Mypageadminchoice.MypagePageChoiceListener {

    public DataBaseDao mDatabaseDao;       // Dao 객체 생성
    public ProductionDAO mItemDao;

    Intent Page;


    ImageButton MyPage, SearchBtn, notice, mib1, mib2 ,mib3, mib4, mib5, mib6, mib7;
    
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

        notice = (ImageButton) findViewById(R.id.btn_notice);
        mib1 = (ImageButton) findViewById(R.id.mib01);
        mib2 = (ImageButton) findViewById(R.id.mib02);
        mib3 = (ImageButton) findViewById(R.id.mib03);
        mib4 = (ImageButton) findViewById(R.id.mib04);
        mib5 = (ImageButton) findViewById(R.id.mib05);
        mib6 = (ImageButton) findViewById(R.id.mib06);
        mib7 = (ImageButton) findViewById(R.id.mib07);

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //알림 페이지로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템1번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템2번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템3번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템4번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템5번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템6번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        mib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인페이지 아이템7번으로 가기.
                Page = new Intent(getApplicationContext(), Register.class);
                startActivity(Page);
            }
        });

        // 광고 삽입
//        MobileAds.initialize(this);
//        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
//                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//                    @Override
//                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
//                        NativeTemplateStyle styles = new
//                                NativeTemplateStyle.Builder().withMainBackgroundColor(0xFFFFFFFF).build();
//                        TemplateView template = findViewById(R.id.templead);
//                        template.setStyles(styles);
//                        template.setNativeAd(nativeAd);
//                    }
//                });
//        adLoader.loadAd(new AdRequest.Builder().build());

        AdLoader adLoader = new AdLoader.Builder(MainActivity.this, "ca-app-pub-3940256099942544/2247696110")
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().build();
                        TemplateView template = findViewById(R.id.templead);
                        template.setStyles(styles);
                        template.setNativeAd(nativeAd);
                    }
                })
                .withAdListener(new AdListener() {
                    private void onAdFailedToLoad(int errorCode) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());


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
        List<Production> itemList = mItemDao.getAllItemData();

//        Toast.makeText(getApplicationContext(), "1번칸" + itemList.get(0).getItemName(), Toast.LENGTH_SHORT).show();

        MyPage = (ImageButton) findViewById(R.id.btn_MyPage);
        SearchBtn = (ImageButton) findViewById(R.id.btn_mainSearch);

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

        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Page = new Intent(getApplicationContext(), search.class);
                Page = new Intent(getApplicationContext(), search.class);
                startActivity(Page);
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

 */
// 최초 어드민 어카운트

//        Production production = new Production();
//        production.setItemName("Lenovo P11 64GB");          // 상품이름
//        production.setPrice(320000);                    // 상품 가격
//        production.setItemProduction("Lenovo");        // 상품 제조사
//        production.setSpec1("스냅드래곤662");
//        production.setSpec2("램 4GB");
//        production.setSpec3("11인치");
//        mItemDao.setInsertItem(production);

//        Production editpro = new Production();
//        editpro.setProducttionCode(1);
//        editpro.setPrice(320000);
//        mItemDao.setUpdateItem(editpro);

//        Production delpro = new Production();
//        delpro.setProducttionCode(1);
//        mItemDao.setDeleteItem(delpro);


 // 상품 추가코드


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

 */


        // 데이터 삭제
//        UserInfo user3 = new UserInfo();
//        user3.setDefaultUserCode(3);
//        mDatabaseDao.setDeleteUser(user3);


         // 데이터 베이스의 기본형

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


