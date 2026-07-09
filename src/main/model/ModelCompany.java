package model;

public class ModelCompany {


	    private int kigyouId;           // 企業ID
	    private String kaishaMei;       // 会社名
	    private String jusho;           // 住所
	    private String denwaBangou;     // 電話番号
	    private String mailAddress;     // メールアドレス
	    private int saiyoJisseki;       // 採用実績
	    
	    // コンストラクタ
	    public ModelCompany() {}
	    
	    // Getter & Setter
	    public int getKigyouId() { return kigyouId; }
	    public void setKigyouId(int kigyouId) { this.kigyouId = kigyouId; }
	    
	    public String getKaishaMei() { return kaishaMei; }
	    public void setKaishaMei(String kaishaMei) { this.kaishaMei = kaishaMei; }
	    
	    public String getJusho() { return jusho; }
	    public void setJusho(String jusho) { this.jusho = jusho; }
	    
	    public String getDenwaBangou() { return denwaBangou; }
	    public void setDenwaBangou(String denwaBangou) { this.denwaBangou = denwaBangou; }
	    
	    public String getMailAddress() { return mailAddress; }
	    public void setMailAddress(String mailAddress) { this.mailAddress = mailAddress; }
	    
	    public int getSaiyoJisseki() { return saiyoJisseki; }
	    public void setSaiyoJisseki(int saiyoJisseki) { this.saiyoJisseki = saiyoJisseki; }
}