package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Result;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

    private Integer p_BuyerID;
    private String n_UserName;
    private String n_Password;
    private Date n_JoinDate;
    private String c_Name;
    private String c_Sex;
    private String c_Address;
    private String c_PhoneNumber;

}
