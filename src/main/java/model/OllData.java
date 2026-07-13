package model;

/**
 * 企業情報・指導情報・学生情報をまとめて保持するデータクラス。
 *
 * JSPのEL式（${ollData.company.kaishaName} など）で参照できるよう、
 * フィールド名と対応する正しいgetter/setter名に修正しています。
 * （元コードは getKaishaId() が ModelCompany を返す等、名前と中身が
 *   一致しておらず、JavaBean規約上EL式から正しく参照できませんでした）
 */
public class OllData {

    private ModelCompany company;       // 企業情報
    private ModelEmployment employment; // 指導情報（就職情報）
    private ModelStudent student;       // 学生情報

    public OllData() {}

    public OllData(ModelCompany company, ModelEmployment employment, ModelStudent student) {
        this.company = company;
        this.employment = employment;
        this.student = student;
    }

    public ModelCompany getCompany() { return company; }
    public void setCompany(ModelCompany company) { this.company = company; }

    public ModelEmployment getEmployment() { return employment; }
    public void setEmployment(ModelEmployment employment) { this.employment = employment; }

    public ModelStudent getStudent() { return student; }
    public void setStudent(ModelStudent student) { this.student = student; }
}
