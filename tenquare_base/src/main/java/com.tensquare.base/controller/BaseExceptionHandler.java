/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseExceptionHandler
 * Author:   15028
 * Date:     2019/12/8 16:45
 * Description: 异常处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tensquare.base.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import entity.Result;
import entity.StatusCode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈异常处理〉
 *
 * @author 15028
 * @create 2019/12/8
 * @since 1.0.0
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}