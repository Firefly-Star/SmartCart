package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyOrderSummary {

    private Date OrderDate;
    private int TotalOrders;
    private float TotalRevenue;

}
