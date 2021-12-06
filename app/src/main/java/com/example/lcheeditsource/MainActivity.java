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
import android.util.Log;
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


    ImageButton MyPage, SearchBtn, notice, mib1, mib2, mib3, mib4, mib5, mib6, mib7;

    // 로그인 여부를 확인할 bool함수
    Boolean LoginCheack = false;
    Boolean AdminCheack = false;

    // 유저의 정보를 확인할수있는 유저 고유 번호
    int UserCode;

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

        // 메인 화면에 광고를 삽입 하는 코드
        // 네이티브 광고를 삽입해줌
        AdLoader adLoader = new AdLoader.Builder(MainActivity.this, "ca-app-pub-3940256099942544/2247696110")
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().build();      // 광고의 스타일을 정해줌
                        TemplateView template = findViewById(R.id.templead);        // 광고의 템플릿을 지정해준다
                        template.setStyles(styles);         // 지정한 템플릿에 지정한 스타일을 삽입
                        template.setNativeAd(nativeAd);     // 템블릿에 광고를 삽입
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

        // 프로젝트 단 한번도 실행 안했을 경우만 주석풀고 실행후에 바로 주석 해줄것
//        DefaultItemAdd();
//        addUserAdmin();


//
//        Toast.makeText(getApplicationContext(), "1번칸" + itemList.get(0).getItemName(), Toast.LENGTH_SHORT).show();

        // 각 버튼을 할당함
        MyPage = (ImageButton) findViewById(R.id.btn_MyPage);
        SearchBtn = (ImageButton) findViewById(R.id.btn_mainSearch);
        notice = (ImageButton) findViewById(R.id.btn_notice);
        mib1 = (ImageButton) findViewById(R.id.mib01);
        mib2 = (ImageButton) findViewById(R.id.mib02);
        mib3 = (ImageButton) findViewById(R.id.mib03);
        mib4 = (ImageButton) findViewById(R.id.mib04);
        mib5 = (ImageButton) findViewById(R.id.mib05);
        mib6 = (ImageButton) findViewById(R.id.mib06);
        mib7 = (ImageButton) findViewById(R.id.mib07);


        // 마이페이지를 클릭했을대 나오는 이벤트
        MyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인이 되어있는 상태인지 확인하는 분기
                if (LoginCheack == false) {   // 만약 로그인이 안되있다면

                    // 로그인이 되어있지 않다면 로그인 클래스로 이용자를 보내서
                    // 이용자의 로그인을 유도하고 로그인 클래스에서 로그인 체크 변수 LoginCheack 를 받아
                    // 로그인 여부를 확인한다
                    Page = new Intent(getApplicationContext(), Login.class);
                    Page.putExtra("Login", LoginCheack);
                    startActivityForResult(Page, 100);
//                    startActivity(Page);
                } else {
                    // 로그인이 됬었을때 어드민인지 일반 이용자인지 확인 하는 분기
                    if (AdminCheack == true) {        // 만약 어드민이라면
                        // 하단 팝업이 나오게끔
                        // 하단 팝업이 프로필과 상품추가 두개의 선택지를 제공하여
                        // 이동하기 쉽게 함
                        Mypageadminchoice itemaddchoice = new Mypageadminchoice();
                        itemaddchoice.show(getSupportFragmentManager(), "MyPageOrItemadd");
                    } else {
                        // 만약에 일반 사용자일경우에는 바로 마이프로필로 이동하게 끔함
                        Page = new Intent(getApplicationContext(), myprofile.class);
                        Page.putExtra("UserCodeCall", UserCode);
                        startActivity(Page);
                    }

                }

            }
        });

        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서치 버튼을 클릭했을때는 검색을 할 수 있도록 서치 클래스로 이동
                Page = new Intent(getApplicationContext(), search.class);
                startActivity(Page);
            }
        });

        // 미구현
//        notice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(LoginCheack == false){
//                    Page = new Intent(getApplicationContext(), Login.class);
//                    Page.putExtra("Login", LoginCheack);
//                    startActivityForResult(Page, 100);
////                    startActivity(Page);
//                } else{
//                    if(AdminCheack == true){
//                        // 하단 팝업이 나오게끔
//                        Mypageadminchoice itemaddchoice = new Mypageadminchoice();
//                        itemaddchoice.show(getSupportFragmentManager(), "MyPageOrItemadd");
//                    }else{
//                        Page = new Intent(getApplicationContext(), notice.class);
//                        startActivity(Page);
//                    }
//
//                }
//
//            }
//        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == 101) {
                // 로그인 클래스에서 전달한 변수의 키를 확인하고 대입한다
                // 기본값은 false로 설정하여 로그인 하지 않았는데 로그인되는 경우를 차단
                LoginCheack = data.getBooleanExtra("Bool_LoginCheack", false);
                AdminCheack = data.getBooleanExtra("Bool_AdminCheack", false);

                // 유저 코드를 삽입 받아 메인프로필로 이동할때 유저의 프로필을 서치 하여 해당 유저의 프로필을 보여줌
                UserCode = data.getIntExtra("UserCode", 0);
                Log.v("로그", "메인에서 받은 user Code : " + UserCode);
                if (AdminCheack.equals(true))
                    Toast.makeText(getApplicationContext(), "어드민로그인", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onButtonClicked(int _Page) {
//        Toast.makeText(getApplicationContext(), "페이지 선택 " + Page, Toast.LENGTH_SHORT).show();
        wherePage = _Page;

        // 페이지 이동
        if (wherePage == 1) {

            // 하단 팝업에서 전달받은 수를 확인하여 1이면 상품 추가 클래스로 이동
            Page = new Intent(getApplicationContext(), ItemAdd.class);
            startActivity(Page);
        } else if (wherePage == 0) {

            // 하단 팝업에서 전달반은 수를 확인하여 0이면 프로필 클래스로 이동
            Page = new Intent(getApplicationContext(), myprofile.class);
            Page.putExtra("UserCodeCall", UserCode);
            startActivity(Page);
        }

    }

    private void DefaultItemAdd() {

        // 앱 실행시 기본적으로 추가할 데이터 베이스
        ProductionAbs itemDB = Room.databaseBuilder(getApplicationContext(), ProductionAbs.class, "Item.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mItemDao = itemDB.productionDAO();

        // Production 객체를 생성하여 이름과 가격 제조사 스펙 태그를 set하여 Insert한다.
        Production production = new Production();
        production.setItemName("Lenovo P11 64GB");          // 상품이름
        production.setPrice(320000);                    // 상품 가격
        production.setItemProduction("Lenovo");        // 상품 제조사
        production.setSpec1("스냅드래곤662");            // 스펙
        production.setSpec2("램 4GB");
        production.setSpec3("11인치");
        production.setItemTag("tablet, 태블릿");       // 아이템 태그
        mItemDao.setInsertItem(production);

        Production production2 = new Production();
        production2.setItemName("IPadPro 11인치 3세대");          // 상품이름
        production2.setPrice(920000);                  // 상품 가격
        production2.setItemProduction("Apple");        // 상품 제조사
        production2.setSpec1("APPLE M1");              // 스펙
        production2.setSpec2("램 8GB");
        production2.setSpec3("11인치");
        production2.setItemTag("tablet, 태블릿");      // 아이템 태그
        mItemDao.setInsertItem(production2);

        Production production3 = new Production();
        production3.setItemName("마블 후드티");            // 상품이름
        production3.setPrice(120000);                   // 상품 가격
        production3.setItemProduction("ABC");           // 상품 제조사
        production3.setWashSpec("95도");                 // 세탁할때 온도
        production3.setBleaching("염소산소표백");         // 세탁할때 사용할 세제
        production3.setSteam("210도");                  // 스팀시 온도
        production3.setDry("전문드라이");                // 드라이 여부
        production3.setDryer("햇빛건조");               // 건조 방법
        production3.setItemTag("cloths, 의류");         // 상품의 태그
        mItemDao.setInsertItem(production3);
    }

    private void DeleteItem(int i) {
        // 아이템을 삭제하는 클래스
        // i 값에 해당하는 id의 아이템을 지운다
        ProductionAbs itemDB = Room.databaseBuilder(getApplicationContext(), ProductionAbs.class, "Item.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mItemDao = itemDB.productionDAO();

        Production delpro = new Production();
        delpro.setProducttionCode(i);
        mItemDao.setDeleteItem(delpro);

    }

    private void addUserAdmin() {

        // 앱실행시 저장되는 기본적인 어드민 어카운트
        // 어드민 어카운트 설정에서 어드민 여부를 True 로 주어서 어드민인것을 알림
        DataBaseAbs dataBase = Room.databaseBuilder(getApplicationContext(), DataBaseAbs.class, "UserInformation.db")
                .fallbackToDestructiveMigration()           // 데이터 베이스 버전에 대해 변경 가능
                .allowMainThreadQueries()                   // MainThread 에서 DB에 Input Output이 가능함
                .build();

        // 데이터베이스 객체 생성
        mDatabaseDao = dataBase.dataBaseDao();
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

    }
}


// 하단 부분은 예시 코드이므로 참고
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

// 상품추가 데이터베이스
// 실행시 한번 실행해주길 바람
//        DefaultItemAdd();

// 상품 삭제 데이터베이스
//        삭제하고싶을땐 i대신 숫자를 넣을것
//        DeleteItem(i);

//        Production editpro = new Production();
//        editpro.setProducttionCode(1);
//        editpro.setPrice(320000);
//        mItemDao.setUpdateItem(editpro);


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


// !! 여기까지 수정금지 !!




