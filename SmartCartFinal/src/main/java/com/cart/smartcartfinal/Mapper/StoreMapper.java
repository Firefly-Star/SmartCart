package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Options(keyProperty = "p_StoreID", useGeneratedKeys = true)
    @Insert("insert into store(p_StoreID, n_CreateDate, n_PositiveRate, n_TotalSales, f_SellerID, n_StoreName) " +
            "values(#{p_StoreID}, #{n_CreateDate}, #{n_PositiveRate}, #{n_TotalSales}, #{f_SellerID}, #{n_StoreName})")
    public void insertStore(Store store);

    @Select("select * from store where f_SellerID = #{id}")
    public List<Store> getStoreBySellerID(int id);

}
