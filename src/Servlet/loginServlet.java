package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.Dao.BaseDao;


@WebServlet({"/login","/register"})
public class loginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		//��¼
		if(uri.endsWith("login")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Connection conn = null;
			PreparedStatement pStatement=null;
			ResultSet rs = null;
			try {
				//ȡ����
				String admin = request.getParameter("username");
			    String password = request.getParameter("password");
			    conn=BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from phoneNumber where number=?");
				pStatement.setString(1,admin);
				rs = pStatement.executeQuery();
				if(rs.next())
				{
					String truepass = rs.getString("password");
					if(truepass.equals(password)){
						BaseDao.close(conn, pStatement, rs);
						getServletContext().setAttribute("phonenumber", admin);
//						System.out.print("1");
						response.sendRedirect("allpeople");
					}
					else{
						BaseDao.close(conn, pStatement, rs);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ע��
		else if(uri.endsWith("register")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Connection conn = null;
			PreparedStatement pStatement=null;
			ResultSet rs = null;
			try {
				String name = request.getParameter("name");
				String admin = request.getParameter("logname");
			    String password = request.getParameter("password");
			    if(name=="null" || name=="" || admin=="" || admin==null || password==null ||password=="")
			    {
			    	response.sendRedirect("register.jsp");
			    }
			    conn=BaseDao.getConnection();//��������
				pStatement = conn.prepareStatement("select * from phone.phoneNumber where number=?");
				pStatement.setString(1,admin);
				rs = pStatement.executeQuery();
				if(rs.next())
				{
					BaseDao.close(conn, pStatement, rs);//�ر�����
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else{
//					System.out.print(admin);
					pStatement = conn.prepareStatement("insert into phone.phoneNumber values(?,?)");
					pStatement.setString(1,admin);
					pStatement.setString(2,password);
					pStatement.executeUpdate();
					pStatement = conn.prepareStatement("insert into phone.groups values(null,?,?)");
					pStatement.setString(1, admin);
					pStatement.setString(2, "默认分组");
					pStatement.executeUpdate();
					pStatement = conn.prepareStatement("insert into phone.information(id,pnumber,name,work,email,group1,host) values(null,?,?,?,?,?,?)");
					pStatement.setString(1, admin);
					pStatement.setString(2, name);
					pStatement.setString(3, null);
					pStatement.setString(4, null);
					pStatement.setString(5, "默认分组");
					pStatement.setString(6, admin);
					pStatement.executeUpdate();
					BaseDao.close(conn, pStatement, rs);//�ر�����
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}
