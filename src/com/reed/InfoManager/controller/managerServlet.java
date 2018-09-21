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
        str = str.substring(1,str.length()-4);      //��ȡ��"."ǰ�������
        try {
            Method method = this.getClass().getDeclaredMethod(str, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * �����û�����������֤��¼
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
            req.setAttribute("message", "�û������������");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    /**
     * ע���û�
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
            req.setAttribute("message","ע��ɹ������¼");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","ע��ʧ�ܣ�����һ��");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    /**
     * ʵ��ģ����ѯ�û�
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
     * ������û�
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
            req.setAttribute("message", "���û����ѱ�ռ�ã��뻻һ��");
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
     * �����û�idɾ���û�
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
     * ����id��ȡ�û���Ϣ����ʾ�ڸ��½�����
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
     * �����û�
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
            req.setAttribute("message", "���û����ѱ�ռ�ã��뻻һ��");
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
