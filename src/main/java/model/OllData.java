package model;


public class OllData {
	
	ModelCompany Cm = new ModelCompany();
	ModelEmployment Em = new ModelEmployment();
	ModelStudent Sm = new ModelStudent();
	
	public OllData() {}

    // コンストラクタ（必要に応じて拡張）
    public OllData(ModelCompany Cm, ModelEmployment Em,ModelStudent Sm) {
        this.Cm = Cm;
        this.Em = Em;
        this.Sm = Sm;
    }
    
    // Getter & Setter
    public ModelCompany getKaishaId() { return  Cm; }
    public void setKaishaId(ModelCompany Cm) { this.Cm = Cm; }

    public ModelEmployment getKaishaName() { return Em; }
    public void setKaishaName(ModelEmployment Em) { this.Em = Em; }

    public ModelStudent ModelStudent() { return Sm; }
    public void setAddress(ModelStudent Sm) { this.Sm = Sm; }
}
