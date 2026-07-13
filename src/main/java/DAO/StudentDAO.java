package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ModelStudent;

public class StudentDAO {
	//データベースに接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost/disaster";
	private final String DB_USER ="root";
	private final String DB_PASS ="kcsf";
	
	public List<Student> findAll(){
		 List<Student> StuList = new  ArrayList<>(); 
			
			InitialContext initCtx;
			DataSource ds =null;
			
			try {
				initCtx = new InitialContext();
				ds =(DataSource)initCtx.lookup("java:comp/env/jdbc/disaster");
				

			FROM 学生テーブル;
			}catch(NamingException e) {
				e.printStackTrace();
			}
			
			try(Connection conn = ds.getConnection()){
				String SQL =("SELECT 学籍番号, クラス, 氏名, 出席番号, 在籍状況, 県内外の希望, 性別, 備考");
				PreparedStatement pStmt = conn.prepareStatement(SQL);
				ResultSet rs = pStmt.executeQuery();
			
				while(rs.next()) {
					
				}
			}catch (Exception e) {
				e.printStackTrace()
			}
			}
	
	
	
	
	
}
