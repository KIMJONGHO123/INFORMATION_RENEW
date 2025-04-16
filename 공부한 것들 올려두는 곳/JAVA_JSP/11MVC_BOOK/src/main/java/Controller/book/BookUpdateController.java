package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;

public class BookUpdateController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String method = req.getMethod();
		if(method.equals("GET")) {
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/update.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
