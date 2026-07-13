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

            String sql = "SELECT * FROM 学生テーブル ORDER BY 学籍番号";

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
                    s.setKenNaiGaiKibo(rs.getString("県内外の希望"));
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
    
        public StudentSummaryDTO findSummaryByGakusekiNo(int gakusekiNo) {
            String sql =
                "SELECT s.氏名, s.クラス, s.出席番号, s.性別, s.県内外希望, s.備考, " +
                "       GROUP_CONCAT(DISTINCT sc.希望職種 SEPARATOR '・') AS kibo_shokushu, " +
                "       EXISTS( " +
                "           SELECT 1 FROM 就職情報 j " +
                "           WHERE j.学籍番号 = s.学籍番号 AND j.内定確定 = 1 " +
                "       ) AS naitei " +
                "FROM 学生 s " +
                "LEFT JOIN 学生中間 sc ON s.学籍番号 = sc.学籍番号 " +
                "WHERE s.学籍番号 = ? " +
                "GROUP BY s.学籍番号";

            StudentSummaryDTO dto = null;

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, gakusekiNo);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        dto = new StudentSummaryDTO();
                        dto.setName(rs.getString("氏名"));
                        dto.setClassName(rs.getString("クラス"));
                        dto.setAttendanceNo(rs.getInt("出席番号"));
                        dto.setSeibetsu(rs.getString("性別"));
                        dto.setKiboChiiki(rs.getString("県内外希望"));
                        dto.setBiko(rs.getString("備考"));
                        dto.setKiboShokushu(rs.getString("kibo_shokushu"));
                        dto.setNaitei(rs.getBoolean("naitei"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("生徒サマリー取得エラー: " + e.getMessage());
            }
            return dto;
        }
   
   
    
}




