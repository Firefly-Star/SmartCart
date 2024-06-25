package com.cart.smartcartfinal.Controller;


import com.cart.smartcartfinal.Entity.OrderReturn;
import com.cart.smartcartfinal.Entity.Result;
import com.cart.smartcartfinal.Mapper.OrderMapper;
import com.cart.smartcartfinal.Utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:7000")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/Buyer/GetOrder")
    public ResponseEntity<Result> getOrder(@RequestHeader("Buyertoken") String buyertoken) {
        Claims claims = JWTUtil.ParseJWT(buyertoken);
        Integer id = (Integer) claims.get("p_BuyerID");

        if (id == null) {
            return new ResponseEntity<>(Result.Fail(400,"缺乏token"), HttpStatus.BAD_REQUEST);
        }

        List<OrderReturn> orderreturn = orderMapper.GetOrdersByBuyer(id);

        return new ResponseEntity<>(Result.Success(orderreturn), HttpStatus.OK);
    }

}
