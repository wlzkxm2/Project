package com.example.lcheeditsource.DataBase;

/*
*
*       수정 정보 알려줄것
*       수정한 Line도 상세히 적을것
*/

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ItemTable")
public class Production implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int ProducttionCode = 0;

    private String ItemName;        // 아이템 이름
    private int Price;              // 아이템 가격
    private String ItemProduction;  // 아이템 제작사

    // 전자제품일 경우의 스팩
    private String Spec1 = null;
    private String Spec2 = null;;
    private String Spec3 = null;;
    private String Spec4 = null;;
    private String Sepc5 = null;;

    //의류일경우의 스펙
    private String WashSpec = null;     // 세탁
    private String Bleaching = null;    // 표백
    private String Steam = null;        // 다림질
    private String Dry = null;          // 드라이
    private String Dryer = null;        // 건조방법

    private String ItemPicture;     // 아이템 사진

    private int ReviewCount;        // 리뷰수

    private int SellCount;          // 판매수
    private int EmptyItemCount;     // 잔량
    private int ItemDiscount;       // 아이템 할인

    private String ItemTag;

    private String ItemUploadDate;

    public String getItemTag() {
        return ItemTag;
    }

    public void setItemTag(String itemTag) {
        ItemTag = itemTag;
    }

    public int getProducttionCode() {
        return ProducttionCode;
    }

    public void setProducttionCode(int producttionCode) {
        ProducttionCode = producttionCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getItemProduction() {
        return ItemProduction;
    }

    public void setItemProduction(String itemProduction) {
        ItemProduction = itemProduction;
    }

    public String getItemPicture() {
        return ItemPicture;
    }

    public void setItemPicture(String itemPicture) {
        ItemPicture = itemPicture;
    }

    public int getReviewCount() {
        return ReviewCount;
    }

    public void setReviewCount(int reviewCount) {
        ReviewCount = reviewCount;
    }

    public int getSellCount() {
        return SellCount;
    }

    public void setSellCount(int sellCount) {
        SellCount = sellCount;
    }

    public int getEmptyItemCount() {
        return EmptyItemCount;
    }

    public void setEmptyItemCount(int emptyItemCount) {
        EmptyItemCount = emptyItemCount;
    }

    public int getItemDiscount() {
        return ItemDiscount;
    }

    public void setItemDiscount(int itemDiscount) {
        ItemDiscount = itemDiscount;
    }

    public String getItemUploadDate() {
        return ItemUploadDate;
    }

    public void setItemUploadDate(String itemUploadDate) {
        ItemUploadDate = itemUploadDate;
    }

}

