package tw.hibernatedemocontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.hibernatedemo.model.Member;
import tw.hibernatedemoService.MemberService;

@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> errorMsgMap = new HashMap<String,String>();
		request.setAttribute("errorMsgMap", errorMsgMap);
		
		HttpSession httpSession = request.getSession();
		
		//抓到request parameter
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		
		//給Service 驗證
		
		Member member = new MemberService().checkLogin(username, password);
		if(member != null) {
			httpSession.setAttribute("memberName", username);
			
		}else {
			errorMsgMap.put("errorMsg", "login again");			
		}
		
		if(errorMsgMap.isEmpty()) {
			
			request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
			
		}else {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//有找到Member,回傳成功頁面,顯示登入者 memberName
		
		//沒有找到,跳回login.jsp,印出錯誤訊息
	}

}
