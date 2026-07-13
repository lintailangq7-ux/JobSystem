package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ModelCompany;   // 企業モデルクラス

public class CompanyDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/jop_managment_system?useSSL=false&serverTimezone=Asia/Tokyo";
    private static final String USER = "root";
    private static final String PASS = "kcsf";

    /**
     * 企業テーブルから全件を取得
     */
    public List<ModelCompany> findAll() {
        List<ModelCompany> list = new ArrayList<>();

        String sql = "SELECT 企業ID, 会社名, 住所, 電話番号, メールアドレス, 採用実績 " +
                     "FROM 企業 " +
                     "ORDER BY 企業ID";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                	ModelCompany c = new ModelCompany();

                    c.setKigyouId(rs.getInt("企業ID"));
                    c.setKaishaMei(rs.getString("会社名"));
                    c.setJusho(rs.getString("住所"));
                    c.setDenwaBangou(rs.getString("電話番号"));
                    c.setMailAddress(rs.getString("メールアドレス"));
                    c.setSaiyoJisseki(rs.getInt("採用実績"));

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

