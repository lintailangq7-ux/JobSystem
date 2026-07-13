package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.ModelEmployment;

public class EmploymentDAO {   // 指導＋就職情報

    private static final String URL = "jdbc:mysql://localhost:3306/jop_managment_system?useSSL=false&serverTimezone=Asia/Tokyo";
    private static final String USER = "root";
    private static final String PASS = "kcsf";

    /**
     * 就職情報（指導含む）を全件取得
     */
    public List<ModelEmployment> findAll() {
        List<ModelEmployment> list = new ArrayList<>();
        EmploymentChukanDAO EmploymentChukanDAO = new EmploymentChukanDAO();

        String sql = "SELECT * FROM 就職情報 ORDER BY 就職情報ID";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                	ModelEmployment e = new ModelEmployment();

                    e.setShidoId(rs.getString("指導ID"));
                    e.setGakusekiNo(rs.getInt("学籍番号"));
                    e.setKaishaId(rs.getString("企業ID"));
                    Timestamp ts = rs.getTimestamp("内定確定日");
                    if (ts != null) {
                        e.setNaiteiKakuteiBi(ts.toLocalDateTime());
                    }
                    e.setNaiteiKakutei(rs.getInt("内定確定"));
                    e.setBiko(rs.getString("備考"));
                    e.setShushokuJohoChukanList(EmploymentChukanDAO.findById(rs.getString("指導ID")));

                    list.add(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("就職情報取得エラー: " + e.getMessage());
        }
        return list;
    }
    
    /**
     * 指定した学籍番号の指導情報（就職情報）を取得
     * @param gakusekiBango 学籍番号
     * @return 就職情報リスト（1人の学生が複数の企業に応募している場合を考慮）
     */
    public List<Guidance> findByStudentId(int studentId) {
        String sql =
                "SELECT g.guidance_id, g.student_id, g.company_id, g.offer_date, g.offer_status, g.remarks, "
              + "       c.company_name, "
              + "       (SELECT jt.job_type FROM company_job_type jt "
              + "         WHERE jt.company_id = c.company_id LIMIT 1) AS job_type "
              + "FROM guidance g "
              + "INNER JOIN company c ON g.company_id = c.company_id "
              + "WHERE g.student_id = ? "
              + "ORDER BY g.guidance_id";

        Map<String, Guidance> guidanceMap = new LinkedHashMap<>();

        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Guidance guidance = mapGuidance(rs);
                    guidanceMap.put(guidance.getGuidanceId(), guidance);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("指導情報の取得に失敗しました。studentId=" + studentId, e);
        }

        if (!guidanceMap.isEmpty()) {
            setExamHistories(guidanceMap);
        }

        return new ArrayList<>(guidanceMap.values());
    }

    /** 指導IDを指定して1件取得（選考履歴も含む） */
    public Guidance findById(String guidanceId) {
        String sql =
                "SELECT g.guidance_id, g.student_id, g.company_id, g.offer_date, g.offer_status, g.remarks, "
              + "       c.company_name, "
              + "       (SELECT jt.job_type FROM company_job_type jt "
              + "         WHERE jt.company_id = c.company_id LIMIT 1) AS job_type "
              + "FROM guidance g "
              + "INNER JOIN company c ON g.company_id = c.company_id "
              + "WHERE g.guidance_id = ?";

        Guidance guidance = null;

        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, guidanceId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    guidance = mapGuidance(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("指導情報の取得に失敗しました。guidanceId=" + guidanceId, e);
        }

        if (guidance != null) {
            guidance.setExamHistories(findExamHistories(guidance.getGuidanceId()));
        }

        return guidance;
    }
}
