package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.OrderProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper {

    @Insert("insert into order_product(p_OrderID, p_ProductID, n_SalesCount, c_CommentTime, c_Comment, c_Rate) " +
            "values(#{p_OrderID}, #{p_ProductID}, #{n_SalesCount}, #{c_CommentTime}, #{c_Comment}, #{c_Rate})")
    public void insertOrderProduct(OrderProduct orderProduct);

}
