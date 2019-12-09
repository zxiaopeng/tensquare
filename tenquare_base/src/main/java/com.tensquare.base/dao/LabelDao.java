/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LabelDao
 * Author:   15028
 * Date:     2019/12/8 15:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15028
 * @create 2019/12/8
 * @since 1.0.0
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label>{

}