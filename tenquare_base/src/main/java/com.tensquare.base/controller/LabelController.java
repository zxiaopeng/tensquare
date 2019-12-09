/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LabelController
 * Author:   15028
 * Date:     2019/12/8 15:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import entity.Result;
import entity.StatusCode;
import entity.PageResult;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15028
 * @create 2019/12/8
 * @since 1.0.0
 */
@RestController
@RequestMapping("label")//spring能自动加上“/”
@CrossOrigin //跨域注解
public class LabelController {

    @Autowired
    private LabelService labelService;

    //标签条件查询
    @RequestMapping(value = "search/{page}/{size}",method = RequestMethod.POST)
    public Result findPageBywhere(@RequestBody Label label,@PathVariable Integer page,@PathVariable Integer size){
        Page<Label> page1 = labelService.findPageBywhere(label,page,size);
        PageResult<Label> pageResult = new PageResult(page1.getTotalElements(),page1.getContent());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    //标签条件查询
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public Result findByWhere(@RequestBody Label label){
        List<Label> list = labelService.findBywhere(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    //查询
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        Label label = labelService.fingById(id);
        return  new Result(true, StatusCode.OK,"查询成功",label);
    }
    //查询所有
    @RequestMapping(method= RequestMethod.GET)
    public Result findById(){
        List<Label> labels = labelService.fingByAll();
        return  new Result(true, StatusCode.OK,"查询成功",labels);
    }
    //新增
    @RequestMapping(method= RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.saveLabel(label);
        return  new Result(true, StatusCode.OK,"新增成功");
    }
    //修改
    @RequestMapping(value="{id}",method= RequestMethod.PUT)
    public Result save(@PathVariable String id,@RequestBody Label label){
        label.setId(id);
        labelService.updateById(label);
        return  new Result(true, StatusCode.OK,"修改成功");
    }
    //删除
    @RequestMapping(value="{id}",method= RequestMethod.DELETE)
    public Result save(@PathVariable String id){
        labelService.deleteById(id);
        return  new Result(true, StatusCode.OK,"删除成功");
    }
}