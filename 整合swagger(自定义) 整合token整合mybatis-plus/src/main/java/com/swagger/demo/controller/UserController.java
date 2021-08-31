package com.swagger.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swagger.demo.model.bo.UserDetailBO;
import com.swagger.demo.model.vo.DeleteUserVO;
import com.swagger.demo.model.vo.UpdateUserVO;
import com.swagger.demo.response.BaseResponse;
import com.swagger.demo.response.RespGenerator;
import com.swagger.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * UserController类
 *
 * <p>
 * <b>History:</b>
 * <table border="1">
 * <tr>
 * <th>Date</th>
 * <th>Operator</th>
 * <th>Memo</th>
 * </tr>
 * <tr>
 * <td>2021/8/25 17:51</td>
 * <td>zrc</td>
 * <td>Create</td>
 * </tr>
 * </table>
 *
 * @author zrc
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("userController")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "修改用户信息")
    @PostMapping("/updateUserMessage")
    public BaseResponse<Integer> updateUserMessage(@RequestBody UpdateUserVO updateUserVO) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "获取用户列表信息")
    @PostMapping("/getUserList")
    public BaseResponse<List<UserDetailBO>> getUserList() {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "删除用户信息")
    @PostMapping("/deleteUser")
    public BaseResponse<Integer> deleteUser(@RequestBody DeleteUserVO deleteUserVO) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "String")
    })
    public BaseResponse<HashMap> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return RespGenerator.returnOK(userService.login(username,password));
    }

    @ApiOperation(value = "退出")
    @PostMapping("/logout")
    public BaseResponse<Integer> logout() {
        return RespGenerator.returnOK("退出成功");
    }

}
