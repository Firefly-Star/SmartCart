package com.cart.smartcartfinal.Filter;

import com.alibaba.fastjson.JSONObject;
import com.cart.smartcartfinal.Entity.Result;
import com.cart.smartcartfinal.Utils.JWTUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/Buyer/*")
public class BuyerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String jwt = request.getHeader("Buyertoken");

//        if(!StringUtils.hasLength(jwt))
//        {
//            Result result = Result.Fail(400, "缺乏token,买家未登录");
//            String returnJson = JSONObject.toJSONString(result);
//            response.getWriter().write(returnJson);
//           System.out.println("缺乏token");
//           return;
//        }
//
//        try{
//            JWTUtil.ParseJWT(jwt);
//        }catch(Exception e)
//        {
//            Result result = Result.Fail(400, "token不合法，重新登录");
//            String returnJson = JSONObject.toJSONString(result);
//            response.getWriter().write(returnJson);
//            System.out.println("token错误");
//            return;
//        }

        chain.doFilter(req, res);

    }

}
