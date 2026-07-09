

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import model.ModelCompany; 

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        
        List<ModelCompany> companies = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
                SELECT 企業ID as kigyouId, 企業名 as kigyouMe, 勤務地 as jigyousho 
                FROM 企業テーブル 
                WHERE 企業名 LIKE ? 
                   OR 勤務地 LIKE ? 
                   OR 業界分類 LIKE ?
                ORDER BY 企業名 
                LIMIT 15
                """;
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                String like = "%" + keyword + "%";
                ps.setString(1, like);
                ps.setString(2, like);
                ps.setString(3, like);
                
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	ModelCompany c = new ModelCompany();
                    c.setKigyouId(rs.getString("kigyouId"));
                    c.setKigyouMe(rs.getString("kigyouMe"));
                    c.setJigyousho(rs.getString("jigyousho"));
                    companies.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // JSONで返す
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new Gson().toJson(companies, response.getWriter());  // Gson使用推奨
    }
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
