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

    private String ItemDetailStories;

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

    public String getSpec1() {
        return Spec1;
    }

    public void setSpec1(String spec1) {
        Spec1 = spec1;
    }

    public String getSpec2() {
        return Spec2;
    }

    public void setSpec2(String spec2) {
        Spec2 = spec2;
    }

    public String getSpec3() {
        return Spec3;
    }

    public void setSpec3(String spec3) {
        Spec3 = spec3;
    }

    public String getSpec4() {
        return Spec4;
    }

    public void setSpec4(String spec4) {
        Spec4 = spec4;
    }

    public String getSepc5() {
        return Sepc5;
    }

    public void setSepc5(String sepc5) {
        Sepc5 = sepc5;
    }

    public String getWashSpec() {
        return WashSpec;
    }

    public void setWashSpec(String washSpec) {
        WashSpec = washSpec;
    }

    public String getBleaching() {
        return Bleaching;
    }

    public void setBleaching(String bleaching) {
        Bleaching = bleaching;
    }

    public String getSteam() {
        return Steam;
    }

    public void setSteam(String steam) {
        Steam = steam;
    }

    public String getDry() {
        return Dry;
    }

    public void setDry(String dry) {
        Dry = dry;
    }

    public String getDryer() {
        return Dryer;
    }

    public void setDryer(String dryer) {
        Dryer = dryer;
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

    public String getItemDetailStories() {
        return ItemDetailStories;
    }

    public void setItemDetailStories(String itemDetailStories) {
        ItemDetailStories = itemDetailStories;
    }
}

