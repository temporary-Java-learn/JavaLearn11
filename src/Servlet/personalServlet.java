package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.Dao.BaseDao;
import admin.bean.user;


@WebServlet({"/fixtopage","/addperple","/editpeople","/deleteperson"})
public class personalServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String username = (String) getServletContext().getAttribute("phonenumber");
		//�����ϵ��
		if(uri.endsWith("fixtopage")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Integer id = Integer.valueOf(request.getParameter("id"));
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where id=?");
				pStatement.setInt(1, id);
				rs = pStatement.executeQuery();
				if(rs.next()){
					String pnumber = rs.getString("pnumber");
					String name = rs.getString("name");
					String work = rs.getString("work");
					String email = rs.getString("email");
					String group = rs.getString("group1");
					String host = rs.getString("host");
					user user = new user(id, pnumber, name, work, email, group, host);
					getServletContext().setAttribute("user", user);
				}
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("edit/edit.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("addperple")){
			request.setCharacterEncoding("UTF-8");     //请求字符集设为UTF-8
			response.setCharacterEncoding("UTF-8");    //响应字符集设为UTF-8
			String pnumber = request.getParameter("pnumber");    //获取请求中的各自段的值
			String name = request.getParameter("name");
			String work = request.getParameter("work");
			String email = request.getParameter("email");
			String group = request.getParameter("group");
			Connection conn = null;    //连接
			PreparedStatement pStatement = null;    //查询语句
			ResultSet rs = null;  //结果集
			try {
				conn = BaseDao.getConnection();    
				pStatement = conn.prepareStatement("select * from information where host=? and name=?");
				pStatement.setString(1, username);
				pStatement.setString(2, name);
				rs=pStatement.executeQuery();    //executeQuery()
												//executeUpdate()
				while(rs.next()){
					if(rs.getString("pnumber").equals(pnumber)){
						BaseDao.close(conn, pStatement, rs);
						response.sendRedirect("main1/main.jsp"); 		//重定向
					}
				}
				pStatement = conn.prepareStatement("insert into information(id,pnumber,name,work,email,group1,host) values(null,?,?,?,?,?,?)");
				pStatement.setString(1, pnumber);
				pStatement.setString(2, name);
				pStatement.setString(3, work);
				pStatement.setString(4, email);
				pStatement.setString(5, group);
				pStatement.setString(6, username);
				
				pStatement.executeUpdate();
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("allpeople");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("deleteperson")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int id =Integer.valueOf(request.getParameter("id"));
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();//连接数据库
				pStatement = conn.prepareStatement("select * from information where id=? and host=?");
				pStatement.setInt(1, id);
				pStatement.setString(2, username);
				rs = pStatement.executeQuery();
				rs.next();
				if (rs.getString("pnumber").equals(username)) {
					BaseDao.close(conn, pStatement, rs);
					response.sendRedirect("allpeople");
					}
				pStatement = conn.prepareStatement("delete from information where id=?");
				pStatement.setInt(1, id);
				pStatement.executeUpdate();
				BaseDao.close(conn, pStatement, null);
				response.sendRedirect("allpeople");
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�޸���Ϣ�ύ
		else if(uri.endsWith("editpeople")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int id = Integer.valueOf(request.getParameter("id"));
			String pnumber = request.getParameter("pnumber");
			String name = request.getParameter("name");
			String work = request.getParameter("work");
			String email = request.getParameter("email");
			String group = request.getParameter("group");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			List<user> users = new ArrayList<user>();
			try {
				conn = BaseDao.getConnection();//连接数据库
				pStatement = conn.prepareStatement("select * from information where id=? and host=?");
				pStatement.setInt(1, id);
				pStatement.setString(2, username);
				rs = pStatement.executeQuery();
				rs.next();
				if (rs.getString("pnumber").equals(username)) {
					pStatement = conn.prepareStatement("update information set host=? where host=?");
					pStatement.setString(1, pnumber);
					pStatement.setString(2, username);
					pStatement.executeUpdate();
					pStatement = conn.prepareStatement("update phoneNumber set number=? where number=?");
					pStatement.setString(1, pnumber);
					pStatement.setString(2, username);
					pStatement.executeUpdate();
					pStatement = conn.prepareStatement("update phone.groups set host=? where host=?");
					pStatement.setString(1, pnumber);
					pStatement.setString(2, username);
					pStatement.executeUpdate();
					getServletContext().setAttribute("phonenumber", pnumber);
				}
				pStatement = conn.prepareStatement("update information set pnumber=?,name=?,work=?,email=?,group1=? where id=?");
				pStatement.setInt(6, id);
				pStatement.setString(1, pnumber);
				pStatement.setString(2, name);
				pStatement.setString(3, work);
				pStatement.setString(4, email);
				pStatement.setString(5, group);
				pStatement.executeUpdate();
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("findgroup");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
