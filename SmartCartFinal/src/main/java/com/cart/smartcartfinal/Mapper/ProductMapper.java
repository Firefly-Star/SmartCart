package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    public List<Product> GetProduct(Integer id, String name, Integer manner);

    @Select("select * from product where f_StoreID = #{id}")
    public List<Product> GetProductByStoreID(Integer id);

    @Insert("insert into product(p_ProductID, n_ProductName, n_PositiveRate, n_Description, n_Price, n_Category, n_Stock, n_TotalSales, f_StoreID) " +
            "values(#{p_ProductID}, #{n_ProductName}, #{n_PositiveRate}, #{n_Description}, #{n_Price}, #{n_Category}, #{n_Stock}, #{n_TotalSales}, #{f_StoreID})")
    public void insertProduct(Product product);
}
