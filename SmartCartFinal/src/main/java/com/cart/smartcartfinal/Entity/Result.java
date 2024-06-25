package com.cart.smartcartfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private int status;
    private String message;
    private Object data;

    public static Result Success(Object data)
    {
        return new Result(200, "success", data);
    }
    public static Result Fail(int status, String message)
    {
        return new Result(status, message, null);
    }
}
