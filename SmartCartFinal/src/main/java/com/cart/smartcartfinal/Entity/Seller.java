package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    private Integer p_SellerID;
    private String n_UserName;
    private String n_Password;
    private float n_PositiveRate;
    private Date n_JoinDate;

}
