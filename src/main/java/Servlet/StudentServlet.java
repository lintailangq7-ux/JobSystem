package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ModelStudent;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object [][] testStudent={
				{1001,"S1A1",21,"和田剛","男","継続","在学","福岡","SE","PG","A","ああああああああ！"},
			    {2001,"P2A2",5,"女","辞退","休学","県外","運送","飲食","インフラ","くぁｗせでｄｒふじこ"},
				{5001,"S5A4",17,"大谷翔平","不明","辞退","休学","県外","運送","飲食","インフラ","どどどどどおどどどどどどおどどどどどどおどど"},
				{5002,"S5A4",17,"小久保裕紀","不明","辞退","退学","県外","運送","飲食","インフラ","どどどどどおどどどどどどおどどどどどどおどど"},
			};
        request.setAttribute("matrix", testStudent);

        // JSP にフォワード
        request.getRequestDispatcher("/WEB-INF/views/showAnyArray.jsp").forward(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/StudentList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
