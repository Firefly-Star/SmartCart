package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.Order;
import com.cart.smartcartfinal.Entity.OrderReturn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Options(keyProperty = "p_OrderID", useGeneratedKeys = true)
    @Insert("insert into orders(p_OrderID, n_TotalPrice, n_OrderTime, n_LogisticID, n_LogisticStatus, c_ShipmentTime, n_EstimateArriveTime, c_ActualArriveTime, f_BuyerID, f_LogisticCompanyID) " +
            "values (#{p_OrderID}, #{n_TotalPrice}, #{n_OrderTime}, #{n_LogisticID}, #{n_LogisticStatus}, #{c_ShipmentTime}, #{n_EstimateArriveTime}, #{c_ActualArriveTime}, #{f_BuyerID}, #{f_LogisticCompanyID})")
    public void InsertOrder(Order order);

    @Select("select o.p_OrderID, o.n_TotalPrice, o.n_OrderTime, o.n_LogisticID, o.n_LogisticStatus, o.c_ShipmentTime, o.c_ActualArriveTime, o.f_BuyerID, o.f_LogisticCompanyID, op.p_ProductId, op.n_SalesCount, p.n_ProductName " +
            "from orders o inner join order_product op on o.p_OrderID = op.p_OrderID inner join product p on op.p_ProductID = p.p_ProductID " +
            "where o.f_BuyerID = #{id}")
    public List<OrderReturn> GetOrdersByBuyer(int buyerID);

}
