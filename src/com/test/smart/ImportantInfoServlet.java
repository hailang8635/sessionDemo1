package com.test.smart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class ImportantInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportantInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * https://www.cnblogs.com/cgli/p/7920573.html
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(request.getSession().getId());
            
        Object isLogin = request.getSession().getAttribute("isLogin");
        String username = (String)request.getSession().getAttribute("username");
        System.out.println("/info, importantInfo, userName:" + username);
        
        if (isLogin != null && (Boolean)isLogin == true) {
            response.getWriter().append("welcome " + username + "! \r\nthis is something important...");
        } else {
            response.getWriter().append("not login");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
