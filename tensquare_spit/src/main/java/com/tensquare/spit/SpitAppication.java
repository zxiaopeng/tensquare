/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SpitAppication
 * Author:   15028
 * Date:     2019/12/12 22:18
 * Description: spit启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * 〈一句话功能简述〉<br> 
 * 〈spit启动类〉
 *
 * @author 15028
 * @create 2019/12/12
 * @since 1.0.0
 */
@SpringBootApplication
public class SpitAppication {

    public static void main(String [] args){
        SpringApplication.run(SpitAppication.class);
    }

    @Bean
    public IdWorker createIdWorker(){
        return new IdWorker(1,1);
    }

}