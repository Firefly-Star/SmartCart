package com.cart.smartcartfinal.Controller;

import com.cart.smartcartfinal.Entity.DailyOrderSummary;
import com.cart.smartcartfinal.Entity.Result;
import com.cart.smartcartfinal.Entity.UserTopCategory;
import com.cart.smartcartfinal.Mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/Admin/DailyOrderSummary")
    public ResponseEntity<Result> GetDaileOrderSummary()
    {
        List<DailyOrderSummary> dailyOrderSummary = adminMapper.getDailyOrderSummary();

        return new ResponseEntity<>(Result.Success(dailyOrderSummary), HttpStatus.OK);
    }

    @GetMapping("/Admin/UserTopCategory")
    public ResponseEntity<Result> GetUserTopCategory()
    {
        List<UserTopCategory> dailyOrderSummary = adminMapper.getUserTopCategory();

        return new ResponseEntity<>(Result.Success(dailyOrderSummary), HttpStatus.OK);
    }

}
