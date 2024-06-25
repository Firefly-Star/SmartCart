package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    private Integer p_StoreID;
    private Date n_CreateDate;
    private float n_PositiveRate;
    private Integer n_TotalSales;
    private Integer f_SellerID;
    private String n_StoreName;

}
