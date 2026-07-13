package DAO;
 
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
public class OllDataDAO {
 
    private final ShidoDAO shidoDAO = new ShidoDAO();
    private final CompanyDAO CompanyDAO = new CompanyDAO();
    private final GakuseiDAO gakuseiDAO = new GakuseiDAO();
 
    /**
     * 指導IDを指定して、指導情報・企業情報・学生情報をまとめて取得する。
     * 指導情報が見つからない場合は null を返す。
     */
    public OllData findByShidoId(String shidoId) {
        ModelEmployment employment = shidoDAO.findById(shidoId);
        if (employment == null) {
            return null;
        }
 
        ModelCompany company = CompanyDAO.findById(employment.getKaishaId());
        ModelStudent student = gakuseiDAO.findById(employment.getGakusekiNo());
 
        return new OllData(company, employment, student);
    }
}