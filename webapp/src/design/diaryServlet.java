package design;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class diaryServlet
 */
@WebServlet("/diaryServlet")
public class diaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public diaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		calBean sb = new calBean();
		
		String id = (String) session.getAttribute("userid"); 
		ArrayList<calBean> record = sb.getDate(id);
		//デバック用
		//System.out.println(record.get(0).r_time());
		dispatcher = request.getRequestDispatcher("diary.jsp");
		
		/*
		// カロリーが0以上ならresult.jspへ、それ以外ならcal.htmlへ戻る
		if (id > 0) {
			dispatcher = request.getRequestDispatcher("result.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("cal.html");
		}*/
				 
		//値をjspに渡す
		request.setAttribute("record",record);
		
		// 最後に JSP へ処理を遷移させる
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
