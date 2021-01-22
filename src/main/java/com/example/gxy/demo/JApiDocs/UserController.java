package com.example.gxy.demo.JApiDocs;

import com.example.gxy.entity.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 */
@RequestMapping("/api/user")
@RestController
@Slf4j
public class UserController {

//    /**
//     * 查询用户
//     * @return
//     */
//    @RequestMapping("/hello")
//    public String helloworld(){
//        log.debug("访问hello");
//        return "Hello world GXY!";
//    }


    /**
     * 用户列表
     * @param userVO
     */
    @RequestMapping(path = "list", method = {RequestMethod.GET,  RequestMethod.POST}  )
    public List<UserVO> list(UserVO userVO){
        return null;
    }

    /**
     * 保存用户
     * @param userForm
     */
    @PostMapping(path = "save")
    public UserVO saveUser(@RequestBody UserVO userForm){
        return null;
    }

}
