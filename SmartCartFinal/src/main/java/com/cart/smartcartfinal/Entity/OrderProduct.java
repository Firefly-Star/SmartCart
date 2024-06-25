package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    private Integer p_OrderID;
    private Integer p_ProductID;
    private Integer n_SalesCount;
    private Timestamp c_CommentTime;
    private String c_Comment;
    private Integer c_Rate;

}
