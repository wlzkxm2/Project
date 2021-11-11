package com.example.lcheeditsource.DataBase;

/*
*
*       수정 정보 알려줄것
*       수정한 Line도 상세히 적을것
*/

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Production {
    @PrimaryKey(autoGenerate = true)
    private int ProducttionCode = 0;



}
