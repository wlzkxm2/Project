package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lcheeditsource.DataBase.UserInfo;

import java.util.List;

/*
 *
 *      수정 정보 알려줄것
 *      수정한 Line도 상세히 적을것
 *
 *      211108 / 17:45 데이터 Dao 생성
 *      Line 23 ~ 43                   - 이지원
 *
 * */       // 코드 변경시 여기에 변경한 코드에 대한 정보 입력

// 데이터베이스에 엑세스 할 수 있는 개체
@Dao
public interface DataBaseDao {

    @Insert     // 데이터 삽입
    void setInsertUser(UserInfo userInfo);

    @Update     // 데이터 수정
    void setUpdateUser(UserInfo userInfo);

    @Delete     // 데이터 삭제
    void setDeleteUser(UserInfo userInfo);

    // 데이터 조회 쿼리
    // UserInfo의 모든 정보를 불러온다.
    @Query("SELECT * FROM UserInfo")
    List<UserInfo> getUserAll();

    // 데이터 삭제
    @Query("DELETE FROM UserInfo WHERE Name = :name")
    void DeleteUserInfomation(String name);
}
