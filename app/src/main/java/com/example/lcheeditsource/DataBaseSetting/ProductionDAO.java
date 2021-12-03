package com.example.lcheeditsource.DataBaseSetting;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lcheeditsource.DataBase.Production;
import com.example.lcheeditsource.DataBase.UserInfo;

import java.util.List;

@Dao
public interface ProductionDAO {

    // 데이터 조회 쿼리
    // UserInfo의 모든 정보를 불러온다.
    @Query("SELECT * FROM ItemTable")
    List<Production> getAllItemData();

    @Insert
        // 데이터 삽입
    void setInsertItem(Production production);

    @Update
        // 데이터 수정
    void setUpdateItem(Production production);

    @Delete
        // 데이터 삭제
    void setDeleteItem(Production production);

    @Query("SELECT * FROM itemTable WHERE ItemTag LIKE '%' || :finditem || '%'")
    List<Production> getItemFind(String finditem);

}
