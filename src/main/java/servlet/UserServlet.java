package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.DeleteUser;
import JDBC.InsertUser;
import JDBC.SelectUser;
import JDBC.UpdateUser;
import domain.User;

public class UserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	    throws ServletException, IOException {
	    String actionType = req.getParameter("actiontype");
	    //������� ������ �� ������� ��������
	    if ("adduser".equalsIgnoreCase(actionType)) {
	      String userFirstName = req.getParameter("userfirstname");
	      String userLastName = req.getParameter("userlastname");
	      String userAgeString = req.getParameter("userage");
	      int userAge = Integer.parseInt(userAgeString);
	      User user = new User();
	      user.setFirstName(userFirstName);
	      user.setLastName(userLastName);
	      user.setAge(userAge);
	      InsertUser.addUser(user);
	    //������� ������ �� ��������� ��������
	    } else if ("deleteuser".equalsIgnoreCase(actionType)) {
	      String userIdString = req.getParameter("userid");
	      Long userId = Long.parseLong(userIdString);
	      DeleteUser.deleteUserById(userId);
	    //������� ������ �� ��������� ��������
	    } else if ("updateuser".equalsIgnoreCase(actionType)) {
	      String userIdString = req.getParameter("userid");
	      Long userId = Long.parseLong(userIdString);
	      String userFirstName = req.getParameter("userfirstname");
	      String userLastName = req.getParameter("userlastname");
	      String userAgeString = req.getParameter("userage");
	      int userAge = Integer.parseInt(userAgeString);
	      User user = SelectUser.getUserById(userId);
	      user.setFirstName(userFirstName);
		  user.setLastName(userLastName);
		  user.setAge(userAge);
	      UpdateUser.updateUser(user);
	    }
	    //ϳ��� ������� ������ ������� �� ������� ��������
	    resp.sendRedirect("user.jsp");
	  }
}
