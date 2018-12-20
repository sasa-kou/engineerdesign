package design;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createServlet
 */
@WebServlet("/createServlet")
public class createServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;

		calBean sb = new calBean();
		//id・名前・性別の取得
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		name = new String( name.getBytes("ISO8859-1"), "UTF-8");
		String sex = request.getParameter("sex");
		sex = new String( sex.getBytes("ISO8859-1"), "UTF-8");
		
		// ユーザの生成が完了すればトップページへ失敗すればもう一度
		 if (sb.createUser(id, name, sex)) {
		     dispatcher = request.getRequestDispatcher("index.html");
		 } else {
		     dispatcher = request.getRequestDispatcher("create.html");
		 }
		// 処理を遷移させる
		 dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
