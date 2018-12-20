package design;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class calServlet
 */
@WebServlet("/calServlet")
public class calServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;
		//HttpSession session = request.getSession();
		calBean sb = new calBean();
		int sumcal=0;
		
		response.setContentType("text/html;charset=UTF-8");
		//メニューをそれぞれ取得
		String shushoku = request.getParameter("shushoku");
		shushoku = new String( shushoku.getBytes("ISO8859-1"), "UTF-8");
		String  shusai = request.getParameter("shusai");
		shusai = new String( shusai.getBytes("ISO8859-1"), "UTF-8");
		String drink = request.getParameter("drink");
		drink = new String( drink.getBytes("ISO8859-1"), "UTF-8");
		String dessert = request.getParameter("dessert");
		dessert = new String( dessert.getBytes("ISO8859-1"), "UTF-8");
		
		//カロリーをそれぞれ取得
		int shushokucal = sb.getCal(shushoku);
		int shusaical = sb.getCal(shusai);
		int drinkcal = sb.getCal(drink);
		int dessertcal = sb.getCal(dessert);
		
		//合計の計算
		sumcal=shushokucal+shusaical+drinkcal+dessertcal;
		
		//ユーザー名をセッションで管理
		//session.setAttribute("username",username);
		
		// カロリーが0以上ならresult.jspへ、それ以外ならcal.htmlへ戻る
		 if (sumcal > 0) {
		     dispatcher = request.getRequestDispatcher("result.jsp");
		 } else {
		     dispatcher = request.getRequestDispatcher("cal.html");
		 }
		 
		 //メニュー名とカロリーの値をjspに渡す
		 request.setAttribute("sumcal",sumcal);
		 request.setAttribute("shushoku",shushoku);
		 request.setAttribute("shushokucal", shushokucal);
		 request.setAttribute("shushoku",shusai);
		 request.setAttribute("shushokucal", shusaical);
		 request.setAttribute("shushoku",drink);
		 request.setAttribute("shushokucal", drinkcal);
		 request.setAttribute("shushoku",dessert);
		 request.setAttribute("shushokucal", dessertcal);
		 
		 // 最後に JSP へ処理を遷移させる
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
