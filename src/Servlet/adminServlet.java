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
import admin.bean.Group;
import admin.bean.Superfindresult;
import admin.bean.user;


@WebServlet({"/allpeople","/findgroup","/findbyid","/superfind","/findbyid1","/findbyid2"})
	public class adminServlet extends HttpServlet {
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			String host = (String) getServletContext().getAttribute("phonenumber");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			List<Group> groups = new ArrayList<Group>();
			conn = BaseDao.getConnection();//�������ݿ�
			try {
				pStatement = conn.prepareStatement("select distinct group1 from phone.groups where host=? order by group1 desc");
				pStatement.setString(1,host);
				rs = pStatement.executeQuery();
				while(rs.next()){
	//				System.out.print("3");
					String group1 = rs.getString("group1");
					Group group = new Group(host, group1);
					groups.add(group);   
				}
				getServletContext().setAttribute("groups", groups);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��������
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String host = (String) getServletContext().getAttribute("phonenumber");
		//�������б�
		if(uri.endsWith("allpeople")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			List<user> users = new ArrayList<user>();
			try {
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where host=? order by name desc");//��������
				pStatement.setString(1,host);
				rs = pStatement.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt("id");
					String pnumber = rs.getString("pnumber");
					String name = rs.getString("name");
					String work = rs.getString("work");
					String email = rs.getString("email");
					String group = rs.getString("group1");
					user user = new user(id, pnumber, name, work, email, group, host);
					users.add(user);   //加
				}
				getServletContext().setAttribute("Users", users);
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("main1/main.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//���·���
		else if(uri.endsWith("findgroup")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			List<Group> groups = new ArrayList<Group>();
			conn = BaseDao.getConnection();//�������ݿ�
			try {
				pStatement = conn.prepareStatement("select distinct group1 from phone.groups where host=? order by group1 desc");
				pStatement.setString(1,host);
				rs = pStatement.executeQuery();
				while(rs.next()){
//					System.out.print("3");
					String group1 = rs.getString("group1");
					Group group = new Group(host, group1);
					groups.add(group);  //加
				}
				getServletContext().setAttribute("groups", groups);
				response.sendRedirect("main1/group.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��������
		}
		
		//����mainҳ���ڵ���
		else if(uri.endsWith("findbyid")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String findid = request.getParameter("id");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where host=? and id=?");//��������
				pStatement.setString(1,host);
				pStatement.setString(2,findid);
				rs = pStatement.executeQuery();
				if(rs.next())
				{
					int id = rs.getInt("id");
					String pnumber = rs.getString("pnumber");
					String name = rs.getString("name");
					String work = rs.getString("work");
					String email = rs.getString("email");
					String group = rs.getString("group1");
					user user = new user(id, pnumber, name, work, email, group, host);
					getServletContext().setAttribute("User", user);
					getServletContext().setAttribute("xingshi", user.getName().charAt(0));
				}
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("person/person.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("findbyid1")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String findid = request.getParameter("id");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where host=? and id=?");//��������
				pStatement.setString(1,host);
				pStatement.setString(2,findid);
				rs = pStatement.executeQuery();
				if(rs.next())
				{
					int id = rs.getInt("id");
					String pnumber = rs.getString("pnumber");
					String name = rs.getString("name");
					String work = rs.getString("work");
					String email = rs.getString("email");
					String group = rs.getString("group1");
					user user = new user(id, pnumber, name, work, email, group, host);
					getServletContext().setAttribute("User", user);
					getServletContext().setAttribute("xingshi", user.getName().charAt(0));
				}
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("person/personoth.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("findbyid2")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String findid = request.getParameter("id");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where host=? and pnumber=?");//��������
				pStatement.setString(1,host);
				pStatement.setString(2,host);
				rs = pStatement.executeQuery();
				if(rs.next())
				{
					int id = rs.getInt("id");
					String pnumber = rs.getString("pnumber");
					String name = rs.getString("name");
					String work = rs.getString("work");
					String email = rs.getString("email");
					String group = rs.getString("group1");
					user user = new user(id, pnumber, name, work, email, group, host);
					getServletContext().setAttribute("User", user);
					getServletContext().setAttribute("xingshi", user.getName().charAt(0));
				}
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("person/own.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uri.endsWith("/superfind")){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String search = request.getParameter("search");
			Connection conn = null;
			PreparedStatement pStatement = null;
			ResultSet rs = null;
			List<Superfindresult> superfindresults = new ArrayList<Superfindresult>();
			try {
				conn = BaseDao.getConnection();//�������ݿ�
				pStatement = conn.prepareStatement("select * from information where host=? and name like '%"+ search +"%' order by name desc");//������������
				pStatement.setString(1,host);
				rs = pStatement.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Superfindresult superfindresult = new Superfindresult(id,name, null);
					superfindresults.add(superfindresult);
				}
				pStatement = conn.prepareStatement("select * from information where host=? and work like '%"+ search +"%' order by work desc");//�������ݹ�����λ
				pStatement.setString(1,host);
				rs = pStatement.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String work = rs.getString("work");
					Superfindresult superfindresult = new Superfindresult(id,name, work);
					superfindresults.add(superfindresult);
				}
				pStatement = conn.prepareStatement("select * from information where host=? and pnumber like '%"+ search +"%' order by pnumber desc");//���������ֻ���
				pStatement.setString(1,host);
				rs = pStatement.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String pnumber = rs.getString("pnumber");
					Superfindresult superfindresult = new Superfindresult(id,name, pnumber);
					superfindresults.add(superfindresult);
				}
				getServletContext().setAttribute("superfindresults", superfindresults);
				BaseDao.close(conn, pStatement, rs);
				response.sendRedirect("main1/mainoth.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



}
