package top.halo.shiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Halo
 * @create 2021/09/24 下午 07:48
 * @description 订单列表
 */
@WebServlet(urlPatterns = "/order-list")
public class OrderListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();
        // 判断当前角色
        boolean flag = subject.hasRole("admin");
        if (flag) {
            req.getRequestDispatcher("order-list.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}