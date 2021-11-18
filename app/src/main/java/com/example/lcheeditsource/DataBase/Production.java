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

    private String ItemName;
    private int Price;
    private String ItemProduction;

    private String ItemPicture;     // 아이템 사진

    private int ReviewCount;

    private int SellCount;
    private int EmptyItemCount;
    private int ItemDiscount;

    private String ItemUploadDate;

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
