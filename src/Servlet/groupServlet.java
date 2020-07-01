package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.Dao.BaseDao;
import admin.bean.user;


@WebServlet({"/entergroup","/deletegroup","/addgroup"})
public class groupServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String host = (String) getServletContext().getAttribute("phonenumber");
		//ɾ������
		if(uri.endsWith("deletegroup")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String group = request.getParameter("group");
			Connection conn = null;
			PreparedStatement pStatement = null;
			try{
				conn = BaseDao.getConnection();//�������ݿ�
				if(group.equals("默认分组"));
				else{
					pStatement = conn.prepareStatement("update information set group1='默认分组' where host=? and group1=?");//��������
					pStatement.setString(1,host);
					pStatement.setString(2,group);
					pStatement.executeUpdate();
					pStatement = conn.prepareStatement("delete from phone.groups where host=? and group1=?");//��������
					pStatement.setString(1, host);
					pStatement.setString(2, group);
					pStatement.executeUpdate();
				}
				BaseDao.close(conn, pStatement, null);
				request.getRequestDispatcher("findgroup").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("entergroup")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String group = request.getParameter("group");
//			System.out.print(group);
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			List<user> users = new ArrayList<user>();
			try{
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where host=? and group1=? order by group1 desc");//��������
				pStatement.setString(1,host);
				pStatement.setString(2, group);
				rs = pStatement.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt("id");
					String pnumber = rs.getString("pnumber");
					String name = rs.getString("name");
					String work = rs.getString("work");
					String email = rs.getString("email");
					String group1 = rs.getString("group1");
					user user = new user(id, pnumber, name, work, email, group1, host);
					users.add(user);  //加
			}
			getServletContext().setAttribute("Users", users);
			getServletContext().setAttribute("thisgroup", group);
			BaseDao.close(conn, pStatement, rs);
			response.sendRedirect("main1/members.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("addgroup")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String group = request.getParameter("group");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			try{
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from phone.groups where group1=? and host=?");//
				pStatement.setString(1,group);
				pStatement.setString(2,host);
				rs = pStatement.executeQuery();
				if(rs.next()){
					BaseDao.close(conn, pStatement, null);
					response.sendRedirect("findgroup");
					}
				pStatement = conn.prepareStatement("insert into phone.groups values(0,?,?)");//��������
				pStatement.setString(1,host);
				pStatement.setString(2,group);
				pStatement.executeUpdate();
				BaseDao.close(conn, pStatement, null);
				response.sendRedirect("findgroup");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
