package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ModelStudent; 

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/jop_managment_system?useSSL=false&serverTimezone=Asia/Tokyo";
    private static final String USER = "root";
    private static final String PASS = "kcsf";


        public List<ModelStudent> findAll() {

            List<ModelStudent> list = new ArrayList<>();
            StudentChukanDAO studentChukanDAO = new StudentChukanDAO();

            String sql = "SELECT * FROM 学生 ORDER BY 学籍番号";

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    ModelStudent s = new ModelStudent();

                    int gakusekiNo = rs.getInt("学籍番号");

                    s.setGakusekiNo(gakusekiNo);
                    s.setClassName(rs.getString("クラス"));
                    s.setName(rs.getString("氏名"));
                    s.setAttendanceNo(rs.getInt("出席番号"));
                    s.setZaisekiJokyo(rs.getInt("在籍状況"));
                    s.setKenNaiGaiKibo(rs.getString("県内外希望"));
                    s.setSeibetsu(rs.getString("性別"));
                    s.setBiko(rs.getString("備考"));

                    s.setGakuseiChukanList(studentChukanDAO.findById(gakusekiNo));

                    list.add(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("学生情報取得エラー: " + e.getMessage());
            }
            return list;
        }
    
    /**
     * 学生情報と企業情報を企業IDで紐づけて取得（就職活動中の学生向け）
     * @return 学生＋企業情報のリスト
     */
    public List<ModelStudent> findAllWithCompany(int kigyouId) {
        List<ModelStudent> list = new ArrayList<>();

        String sql = """
                SELECT s.*
                FROM 就職情報 j
                INNER JOIN 学生 s ON j.学籍番号 = s.学籍番号
                WHERE j.企業ID = ?
                ORDER BY s.学籍番号 ASC
            """;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                    PreparedStatement ps = con.prepareStatement(sql)) {   // ← ここまででps作成

                   ps.setInt(1, kigyouId);   

                   try (ResultSet rs = ps.executeQuery()) {

                       while (rs.next()) {
                    ModelStudent s = new ModelStudent();

                    // 学生情報
                    s.setGakusekiBango(rs.getInt("学籍番号"));
                    s.setKurasu(rs.getString("クラス"));
                    s.setShussekiBango(rs.getInt("出席番号"));
                    s.setShimei(rs.getString("氏名"));
                    s.setZaisekiJokyo(rs.getInt("在籍状況"));
                    s.setDai1KibouShokushu(rs.getString("第1希望職種"));
                    s.setDai2KibouShokushu(rs.getString("第2希望職種"));
                    s.setDai3KibouShokushu(rs.getString("第3希望職種"));
                    s.setKenNaiGaiKibou(rs.getString("県内外の希望"));
                    s.setSeibetsu(rs.getString("性別"));
                    s.setBiko(rs.getString("備考"));

                    // 企業情報（Studentクラスに企業情報を入れる場合）
                    // ※企業情報は別フィールドとして持つか、必要に応じて拡張してください
                    // 例: s.setKaishaMei(rs.getString("会社名"));
                    //     s.setKigyouId(rs.getInt("企業ID"));

                    list.add(s);
                }
              }
           }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("学生＋企業情報取得エラー: " + e.getMessage());
        }
        return list;
    }
   
    
}




