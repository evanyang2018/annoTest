package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author: 杨飞
 * @Description:  用户服务
 * @Date: Create in ${TIME} ${DATE}
 * @Modificd By:
 */

@RestController
@RequestMapping("/users/")
public class TestController {


    /**
     * @Author: 杨飞
     * @Description: 通过id查询用户
     * @Date: 15:56 2018/7/4
     * @Modificd By: Evan
     * @Param: [id,主键]
     * @return: com.example.demo.Users
     * @throw: 请描述异常信息
     */
    @RequestMapping(value = "getUsrById",method = RequestMethod.POST)
    public String getUserById(@RequestParam("id")String id,String name){
        return "123123123123123123123";
    }
}
