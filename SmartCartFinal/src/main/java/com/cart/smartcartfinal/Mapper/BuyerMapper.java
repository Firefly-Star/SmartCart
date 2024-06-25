package com.cart.smartcartfinal.Mapper;

import com.cart.smartcartfinal.Entity.Buyer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuyerMapper {

    public List<Buyer> GetAllBuyers();

    @Select("select * from buyer where p_BuyerID = #{id}")
    public Buyer GetBuyerById(int id);

    @Delete("delete from buyer where p_BuyerID = #{id}")
    public void DeleteBuyerById(int id);

    public Buyer GetBuyerByUsernameAndPassword(String username, String password);

    @Options(keyProperty = "p_BuyerID", useGeneratedKeys = true)
    @Insert("insert into buyer(p_BuyerID, n_UserName, n_Password, n_JoinDate, c_Name, c_Sex, c_Address, c_PhoneNumber) " +
            "values(#{p_BuyerID}, #{n_UserName}, #{n_Password}, #{n_JoinDate}, #{c_Name}, #{c_Sex}, #{c_Address}, #{c_PhoneNumber})")
    public void InsertBuyer(Buyer buyer);

    @Update("update buyer set n_UserName = #{n_UserName}, n_Password = #{n_Password}, n_JoinDate = #{n_JoinDate}, c_Name = #{c_Name}, " +
            "c_Sex = #{c_Sex}, c_Address = #{c_Address}, c_PhoneNumber = #{c_PhoneNumber} where p_BuyerID = #{p_BuyerID}")
    public void UpdateBuyer(Buyer buyer);
}
