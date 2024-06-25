package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTopCategory {

    private Integer p_BuyerId;
    private String n_UserName;
    private String n_Category;

}
