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
	    if ("adduser".equalsIgnoreCase(actionType)) {
	      addUser(req);
	    } else if ("deleteuser".equalsIgnoreCase(actionType)) {
	      deleteUser(req);
	    } else if ("updateuser".equalsIgnoreCase(actionType)) {
	      updateUser(req);
	    }
	    resp.sendRedirect("user.jsp");
	  }

	private void updateUser(HttpServletRequest req) {
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

	private void deleteUser(HttpServletRequest req) {
		String userIdString = req.getParameter("userid");
	    Long userId = Long.parseLong(userIdString);
	    DeleteUser.deleteUserById(userId);
	}

	private void addUser(HttpServletRequest req) {
		if(true) throw new ClassCastException();
		String userFirstName = req.getParameter("userfirstname").trim();
	    String userLastName = req.getParameter("userlastname").trim();
	    String userEmail = req.getParameter("useremail").trim();
	    String userAgeString = req.getParameter("userage").trim();
	    int userAge = Integer.parseInt(userAgeString);
	    User user = new User();
	    user.setFirstName(userFirstName);
	    user.setLastName(userLastName);
	    user.setEmail(userEmail);
	    user.setAge(userAge);
	    InsertUser.addUser(user);
	}
}
