package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer p_ProductID;
    private String n_ProductName;
    private float n_PositiveRate;
    private String n_Description;
    private float n_Price;
    private String n_Category;
    private int n_Stock;
    private int n_TotalSales;
    private int f_StoreID;

}
