package com.example.lcheeditsource.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
* 
*       수정 정보 알려줄것
*       수정한 Line도 상세히 적을것
* 
*       211108 / 17:30 데이터 테이블 생성
*       Line 19 ~ 141                  - 이지원
* 
* */         // 코드 변경시 여기에 변경한 코드에 대한 정보 입력




// 유저 정보 테이블
@Entity
public class UserInfo {
    @PrimaryKey(autoGenerate = true)
    private int DefaultUserCode = 0;

    private String UserId;          // 유저의 아이디
    
    private String Password;        // 유저의 비밀번호
    
    private String Email;           // 복구할 이메일
    private String Name;            // 유저의 이름
    
    // 유저 생년월일
    private String birth_Year;      // 태어난해
    private String birth_Month;     // 태어난 월
    private String birth_Day;       // 태어난 일
    
    private String PhoneNumber;     // 개인 전화번호
    private String UserAddressNumber;     // 우편번호
    private String UserAddressDefault;      // 기본주소
    private String UserAddressMore;         // 상세주소


    // 여기서부터 유저의 정보를 받아오는 Getter & Setter

    public int getDefaultUserCode() {
        return DefaultUserCode;
    }

    public void setDefaultUserCode(int defaultUserCode) {
        DefaultUserCode = defaultUserCode;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirth_Year() {
        return birth_Year;
    }

    public void setBirth_Year(String birth_Year) {
        this.birth_Year = birth_Year;
    }

    public String getBirth_Month() {
        return birth_Month;
    }

    public void setBirth_Month(String birth_Month) {
        this.birth_Month = birth_Month;
    }

    public String getBirth_Day() {
        return birth_Day;
    }

    public void setBirth_Day(String birth_Day) {
        this.birth_Day = birth_Day;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserAddressNumber() {
        return UserAddressNumber;
    }

    public void setUserAddressNumber(String userAddressNumber) {
        UserAddressNumber = userAddressNumber;
    }

    public String getUserAddressDefault() {
        return UserAddressDefault;
    }

    public void setUserAddressDefault(String userAddressDefault) {
        UserAddressDefault = userAddressDefault;
    }

    public String getUserAddressMore() {
        return UserAddressMore;
    }

    public void setUserAddressMore(String userAddressMore) {
        UserAddressMore = userAddressMore;
    }






    // 데이터 내부 데이터를 출력하는 함수입니다.
    @NonNull
    @Override
    public String toString() {
        final StringBuffer DBOutput = new StringBuffer("");
        DBOutput.append(" ID : ").append(UserId);
        DBOutput.append(" Password : ").append(Password);
        DBOutput.append(" Email : ").append(Email);
        DBOutput.append(" Name : ").append(Name);
        DBOutput.append(" birth_Year : ").append(birth_Year);
        DBOutput.append(" birth_Month : ").append(birth_Month);
        DBOutput.append(" birth_Day : ").append(birth_Day);
        DBOutput.append(" PhoneNumber : ").append(PhoneNumber);
        DBOutput.append(" UserAddress : ").append("우편번호" + UserAddressNumber + "/" + UserAddressDefault + "/" + UserAddressMore);
        DBOutput.append("\n-----------------------------------\n");
        return DBOutput.toString();

    }
}
