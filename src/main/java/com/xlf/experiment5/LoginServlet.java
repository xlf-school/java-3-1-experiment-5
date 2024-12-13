package com.xlf.experiment5;

import com.xlf.experiment5.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // 密码应加密后比对
            rs = stmt.executeQuery();

            if (rs.next()) {
                response.getWriter().println("登录成功，欢迎 " + username + "！");
            } else {
                response.getWriter().println("用户名或密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("错误: " + e.getMessage());
        } finally {
            DBUtil.close(conn, stmt, rs);
        }
    }
}
