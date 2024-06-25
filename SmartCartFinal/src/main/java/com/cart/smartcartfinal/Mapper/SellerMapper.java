package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.Seller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SellerMapper {

    @Options(keyProperty = "p_SellerID", useGeneratedKeys = true)
    @Insert("insert into seller(p_SellerID, n_UserName, n_Password, n_PositiveRate, n_JoinDate) " +
            "values (#{p_SellerID}, #{n_UserName}, #{n_Password}, #{n_PositiveRate}, #{n_JoinDate})")
    public void InsertSeller(Seller seller);

    @Select("select * from seller where n_UserName = #{userName} and n_Password = #{password}")
    public Seller GetSellerByUserNameAndPassWord(String userName, String password);

    @Select("select * from seller where p_SellerID = #{id}")
    public Seller GetSellerById(int id);

}
