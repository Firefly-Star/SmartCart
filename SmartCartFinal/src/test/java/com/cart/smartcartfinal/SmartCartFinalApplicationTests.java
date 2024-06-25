package com.cart.smartcartfinal;

import com.cart.smartcartfinal.Entity.Buyer;
import com.cart.smartcartfinal.Mapper.BuyerMapper;
import com.cart.smartcartfinal.Utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SmartCartFinalApplicationTests {

    @Autowired
    private BuyerMapper buyerMapper;

    @Test
    void contextLoads() {
        List<Buyer> buyers = buyerMapper.GetAllBuyers();
        for (Buyer buyer : buyers) {
            System.out.println(buyer);
        }
    }

    @Test
    void TestJWT()
    {
        Claims cliams = JWTUtil.ParseJWT("eyJhbGciOiJIUzI1NiJ9.eyJwX0J1eWVySUQiOjE4LCJuX1Bhc3N3b3JkIjoicGFzc3dvcmQ1IiwiZXhwIjoxNzE5MTU1MzYyLCJuX1VzZXJOYW1lIjoiYnV5ZXI1In0.r2CL4QWDizAWx-YnkI15KejlAiF5jmmfXHt16oOun3E");
        for(Map.Entry<String, Object> claim : cliams.entrySet())
        {
            System.out.println(claim.getKey() + " : " + claim.getValue());
        }
    }


}
