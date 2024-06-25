package com.cart.smartcartfinal.Controller;

import com.cart.smartcartfinal.Entity.Product;
import com.cart.smartcartfinal.Entity.Result;
import com.cart.smartcartfinal.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class ProductController
{

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/Buyer/Product")
    public ResponseEntity<Result> BrowseProduct(@RequestBody Map<String, Object> requestbody)
    {
        String name = (String)requestbody.get("name");
        Integer manner = (Integer)requestbody.get("manner");
        Integer id = (Integer)requestbody.get("id");

        List<Product> products = productMapper.GetProduct(id, name, manner);
        return new ResponseEntity<>(Result.Success(products), HttpStatus.OK);
    }

}
