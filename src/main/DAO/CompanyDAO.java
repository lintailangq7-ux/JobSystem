package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CompanyChukan;
import model.ModelCompany;   // 企業モデルクラス
import DAO.CompanyChukanDAO;

public class CompanyDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/jop_managment_system?useSSL=false&serverTimezone=Asia/Tokyo";
    private static final String USER = "root";
    private static final String PASS = "kcsf";

    /**
     * 企業テーブルから全件を取得
     */
    public List<ModelCompany> findAll() {
        List<ModelCompany> list = new ArrayList<>();
        CompanyChukan
        String sql = "SELECT * " +
                     "FROM 企業 " +
                     "ORDER BY 企業ID";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                	ModelCompany c = new ModelCompany();

                    c.setKaishaId(rs.getInt("企業ID"));
                    c.setKaishaName(rs.getString("会社名"));
                    c.setAddress(rs.getString("住所"));
                    c.setTel(rs.getString("電話番号"));
                    c.setEmail(rs.getString("メールアドレス"));
                    c.setSaiyoJisseki(rs.getInt("採用実績"));
                    c.setSaiyoJisseki(rs.getString("勤務地"));
                    
                    CChukanDAO.
                    
                    list.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("企業データ取得エラー: " + e.getMessage());
        }
        return list;
    }
}



