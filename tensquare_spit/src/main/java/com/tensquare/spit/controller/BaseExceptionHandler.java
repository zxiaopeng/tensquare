/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseExceptionHandler
 * Author:   15028
 * Date:     2019/12/12 22:22
 * Description: 异常类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tensquare.spit.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 〈一句话功能简述〉<br> 
 * 〈异常类〉
 *
 * @author 15028
 * @create 2019/12/12
 * @since 1.0.0
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return new Result(true, StatusCode.ERROR,e.getMessage());
    }
}