package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.DailyOrderSummary;
import com.cart.smartcartfinal.Entity.UserTopCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from dailyordersummary")
    public List<DailyOrderSummary> getDailyOrderSummary();

    @Select("select * from usertopcategory")
    public List<UserTopCategory> getUserTopCategory();

}
