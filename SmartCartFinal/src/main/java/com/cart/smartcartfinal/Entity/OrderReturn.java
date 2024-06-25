package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReturn {

    private Integer p_OrderID;
    private float n_TotalPrice;
    private Timestamp n_OrderTime;
    private Integer n_LogisticID;
    private String n_LogisticStatus;
    private Timestamp c_ShipmentTime;
    private Timestamp n_EstimateArriveTime;
    private Timestamp c_ActualArriveTime;
    private Integer f_BuyerID;
    private Integer f_LogisticCompanyID;
    private Integer p_ProductID;
    private Integer n_SalesCount;
    private String n_ProductName;

}
