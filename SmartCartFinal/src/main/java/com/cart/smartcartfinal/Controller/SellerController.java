package com.cart.smartcartfinal.Controller;

import com.cart.smartcartfinal.Entity.Product;
import com.cart.smartcartfinal.Entity.Result;
import com.cart.smartcartfinal.Entity.Seller;
import com.cart.smartcartfinal.Entity.Store;
import com.cart.smartcartfinal.Mapper.ProductMapper;
import com.cart.smartcartfinal.Mapper.SellerMapper;
import com.cart.smartcartfinal.Mapper.StoreMapper;
import com.cart.smartcartfinal.Utils.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class SellerController {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/SellerLogin")
    public ResponseEntity<Result> SellerLogin(@RequestBody Seller seller)
    {
        String password = seller.getN_Password();
        String username = seller.getN_UserName();

        Seller returnseller = sellerMapper.GetSellerByUserNameAndPassWord(username, password);

        if(returnseller != null)
        {
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put("n_Username", username);
            claims.put("n_Password", password);
            claims.put("p_SellerID", returnseller.getP_SellerID());

            String jwt = JWTUtil.CreateJWT(claims);
            return new ResponseEntity<>(Result.Success(jwt), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(Result.Fail(400, "login failed"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/SellerRegist")
    public ResponseEntity<Result> SellerRegist(@RequestBody Seller seller)
    {
        seller.setP_SellerID(null);
        seller.setN_JoinDate(Date.valueOf(LocalDate.now()));
        seller.setN_PositiveRate(0.0f);

        sellerMapper.InsertSeller(seller);

        if(seller.getP_SellerID() != null)
        {
            return new ResponseEntity<>(Result.Success(null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(Result.Fail(400, "regist failed"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Seller/GetStoreInfo")
    public ResponseEntity<Result> GetStoreInfo(@RequestHeader("SellerToken") String sellerToken)
    {
        Claims cliams = JWTUtil.ParseJWT((sellerToken));
        Integer id = (Integer) cliams.get("p_SellerID");

        if(id == null)
        {
            System.out.println("缺乏token");
            return new ResponseEntity<>(Result.Fail(400, "Invalid Sellertoken"), HttpStatus.BAD_REQUEST);
        }

        List<Store> sotres = storeMapper.getStoreBySellerID(id);

        return new ResponseEntity<>(Result.Success(sotres), HttpStatus.OK);
    }

    @PostMapping("/Seller/GetProductsByStoreId")
    public ResponseEntity<Result> GetProducts(@RequestBody StoreRequest storeRequest)
    {
        Integer storeID = storeRequest.getStoreId();

        List<Product> products = productMapper.GetProductByStoreID(storeID);

        return new ResponseEntity<>(Result.Success(products), HttpStatus.OK);
    }

    @PostMapping("/Seller/AddProduct")
    public ResponseEntity<Result> AddProduct(@RequestBody Product product)
    {
        product.setP_ProductID(null);
        product.setN_PositiveRate(0.0f);
        product.setN_TotalSales(0);

        productMapper.insertProduct(product);

        return new ResponseEntity<>(Result.Success(product), HttpStatus.OK);
    }

    @PostMapping("/Seller/AddStore")
    public ResponseEntity<Result> AddStore(@RequestHeader("SellerToken") String sellerToken, @RequestBody Store store)
    {
        Claims cliams = JWTUtil.ParseJWT((sellerToken));
        Integer sellerID = (Integer) cliams.get("p_SellerID");

        Store insertStore = new Store(null, Date.valueOf(LocalDate.now()), 0.0f, 0, sellerID, store.getN_StoreName());
        storeMapper.insertStore(insertStore);

        if(insertStore.getP_StoreID() != null)
        {
            return new ResponseEntity<>(Result.Success(null), HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(Result.Fail(400, "insert failed"), HttpStatus.BAD_REQUEST);
        }
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class StoreRequest {

    private Integer storeId;

}
