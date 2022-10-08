package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        2.调用XxxService.xxx()处理业务(userService.login()登录)
        User login = userService.login(new User(null, username, password, null));
//        3.根据login()方法返回结果判断登录是否成功
//        如果登录null说明登录失败
        if (login == null){
//             失败
//        跳回登录页面
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        } else {
//             成功
//        跳到成功登录页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
    }
}
