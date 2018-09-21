package com.reed.InfoManager.controller;

import com.reed.InfoManager.model.User;
import com.reed.InfoManager.service.managerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class managerServlet extends HttpServlet{
    managerService service = new managerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String str = req.getServletPath();
        str = str.substring(1,str.length()-4);      //获取到"."前面的内容
        try {
            Method method = this.getClass().getDeclaredMethod(str, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据用户名和密码验证登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = service.login(username, password);

        if (user != null){
            session.setAttribute("username", username);
          req.getRequestDispatcher("/manage.jsp").forward(req, resp);
        }else {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    /**
     * 注册用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String info = req.getParameter("info");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setAddress(address);
        user.setInfo(info);
        int rows = service.add(user);
        if (rows > 0){
            req.setAttribute("message","注册成功，请登录");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","注册失败，再试一次");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    /**
     * 实现模糊查询用户
     * @param req
     * @param resp
     */
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        List<User> usersList = service.search(username, address, phone);
        req.setAttribute("users", usersList);
        req.getRequestDispatcher("/manage.jsp").forward(req, resp);
    }

    /**
     * 添加新用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String info = req.getParameter("info");

        int count = service.getCount(username);
        if (count > 0){
            req.setAttribute("message", "该用户名已被占用，请换一个");
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setPhone(phone);
        user.setInfo(info);

        int rows = service.add(user);
        if (rows > 0) {
            req.getRequestDispatcher("/manage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        }
    }

    /**
     * 根据用户id删除用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int rows = service.delete(id);
        if (rows > 0) {
            req.getRequestDispatcher("/manage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    /**
     * 根据id获取用户信息并显示在更新界面上
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.get(id);
        req.setAttribute("userInfo", user);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    /**
     * 更新用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void updateDone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.get(id);
        String oldName = user.getUsername();
        String username = req.getParameter("username");

        int count = service.getCount(username);
        if (!oldName.equals(username) && count > 0) {
            req.setAttribute("message", "该用户名已被占用，请换一个");
            req.getRequestDispatcher("/update.udo?id="+id).forward(req, resp);
            return;
        }

        user.setUsername(username);
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        user.setInfo(req.getParameter("info"));

        int rows = service.update(user);
        if (rows > 0) {
            req.getRequestDispatcher("/manage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
