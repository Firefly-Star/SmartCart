package com.cart.smartcartfinal.Controller;

import com.cart.smartcartfinal.Entity.*;
import com.cart.smartcartfinal.Mapper.BuyerMapper;
import com.cart.smartcartfinal.Mapper.OrderMapper;
import com.cart.smartcartfinal.Mapper.OrderProductMapper;
import com.cart.smartcartfinal.Mapper.ProductMapper;
import com.cart.smartcartfinal.Utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class BuyerController {

    @Autowired
    private BuyerMapper buyerMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @PostMapping("/BuyerRegist")
    public ResponseEntity<Result> BuyerRegist(@RequestBody Buyer buyer) {
        buyer.setP_BuyerID(null);
        buyer.setN_JoinDate(Date.valueOf(LocalDate.now()));

        if(buyer.getC_Sex() == null)
        {
            buyer.setC_Sex("U");
        }
        switch (buyer.getC_Sex())
        {
            case "男": buyer.setC_Sex("M"); break;
            case "女": buyer.setC_Sex("F"); break;
            default:  buyer.setC_Sex("U"); break;
        }
        buyerMapper.InsertBuyer(buyer);
        if(buyer.getP_BuyerID()!=null){
            return new ResponseEntity<>(Result.Success(null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(Result.Fail(400, "Registration failed"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/BuyerLogin")
    public ResponseEntity<Result> BuyerLogin(@RequestBody Buyer buyer) {
        String userName = buyer.getN_UserName();
        String password = buyer.getN_Password();

        Buyer returnBuyer = buyerMapper.GetBuyerByUsernameAndPassword(userName, password);

        if(returnBuyer!=null)
        {
            Map<String, Object> claims = new HashMap<>();
            claims.put("p_BuyerID", returnBuyer.getP_BuyerID());
            claims.put("n_UserName", returnBuyer.getN_UserName());
            claims.put("n_Password", returnBuyer.getN_Password());
            String jwt = JWTUtil.CreateJWT(claims);

            return new ResponseEntity<>(Result.Success(jwt), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(Result.Fail(400, "Login failed"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Buyer/PlaceOrder")
    public ResponseEntity<Result> PlaceOrder(@RequestHeader("Buyertoken") String buyerToken, @RequestBody Map<String, Object> requestbody)
    {
        Claims claims = JWTUtil.ParseJWT(buyerToken);
        Integer id = (Integer) claims.get("p_BuyerID");
        Integer productID = (Integer) requestbody.get("productID");
        Integer quantity = (Integer) requestbody.get("quantity");


        Product product = productMapper.GetProduct(productID, null, 0).get(0);

        if(id == null || productID == null || quantity == null)
        {
            return new ResponseEntity<>(Result.Fail(400, "请求不完整"), HttpStatus.BAD_REQUEST);
        }

        if(product == null)
        {
            return new ResponseEntity<>(Result.Fail(400, "无效的商品编码"), HttpStatus.BAD_REQUEST);
        }

        Order order = new Order(null, product.getN_Price() * quantity, new Timestamp(System.currentTimeMillis())
                                , 10, "Yet to be shipped", null, new Timestamp(System.currentTimeMillis() + 3600 * 48 * 1000),
                                null, id, 1);

        orderMapper.InsertOrder(order);

        if(order.getP_OrderID()==null)
        {
            return new ResponseEntity<>(Result.Fail(500, "生成订单失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        OrderProduct orderProduct = new OrderProduct(order.getP_OrderID(), productID, quantity, null, null, null);
        orderProductMapper.insertOrderProduct(orderProduct);
        return new ResponseEntity<>(Result.Success(null), HttpStatus.OK);
    }

}
