package DAO;
 
import java.util.List;

import model.ModelCompany;
import model.ModelEmployment;
import model.ModelStudent;
import model.OllData;
 
/**
 * 指導ID（shidoId）を起点に、指導情報・企業情報・学生情報の3つをまとめて
 * OllDataに詰めて返すDAO（サービス的な役割）。
 *
 * 指導一覧の「変更」ボタン押下時など、1件の指導記録の詳細画面を
 * 表示する場合に使う想定です。
 */
public class OlldataDAO {
 
    private final EmploymentDAO EmploymentDAO = new EmploymentDAO();
    private final CompanyDAO CompanyDAO = new CompanyDAO();
    private final StudentDAO StudentDAO = new StudentDAO();
 
    /**
     * 指導IDを指定して、指導情報・企業情報・学生情報をまとめて取得する。
     * 指導情報が見つからない場合は null を返す。
     */
    public OllData findAll(String shidoId) {
    	List<ModelEmployment> employment = EmploymentDAO.findAll();
        if (employment == null) {
            return null;
        }
 
        List<ModelCompany> company = CompanyDAO.findAll();
        List<ModelStudent> student = StudentDAO.findAll();
 
        return new OllData(company, employment, student);
    }
}

