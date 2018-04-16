package com.test.smart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        String p1 = request.getParameter("type");
        String username = request.getParameter("username");
        System.out.println(p1 + " , userName:" + username);
        if ("logout".equals(p1)) {
            request.getSession().invalidate();
            response.getWriter().append(" logout... ");
            return ;
        } else if (username != null){
	        request.getSession().setAttribute("isLogin", true);
	        request.getSession().setAttribute("username", username);
	        response.getWriter().append("success " + username);
	        return ;
        }
        response.getWriter().append("请输入用户名 ");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
