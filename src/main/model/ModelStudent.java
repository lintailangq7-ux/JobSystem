package model;

public class ModelStudent {
	    
	    private int gakusekiBango;      // 学籍番号（主キー）
	    private String kurasu;          // クラス
	    private int shussekiBango;      // 出席番号
	    private String shimei;          // 氏名
	    private int zaisekiJokyo;       // 在籍状況
	    private String dai1KibouShokushu; // 第1希望職種
	    private String dai2KibouShokushu; // 第2希望職種
	    private String dai3KibouShokushu; // 第3希望職種
	    private String kenNaiGaiKibou;  // 県内外の希望
	    private String seibetsu;        // 性別
	    private String biko;            // 備考
	    
	    public ModelStudent() {}
	    
	    // Getter & Setter（省略可ですが一通り記載）
	    public int getGakusekiBango() { return gakusekiBango; }
	    public void setGakusekiBango(int gakusekiBango) { this.gakusekiBango = gakusekiBango; }
	    
	    public String getKurasu() { return kurasu; }
	    public void setKurasu(String kurasu) { this.kurasu = kurasu; }
	    
	    public int getShussekiBango() { return shussekiBango; }
	    public void setShussekiBango(int shussekiBango) { this.shussekiBango = shussekiBango; }
	    
	    public String getShimei() { return shimei; }
	    public void setShimei(String shimei) { this.shimei = shimei; }
	    
	    public int getZaisekiJokyo() { return zaisekiJokyo; }
	    public void setZaisekiJokyo(int zaisekiJokyo) { this.zaisekiJokyo = zaisekiJokyo; }
	    
	    public String getDai1KibouShokushu() { return dai1KibouShokushu; }
	    public void setDai1KibouShokushu(String dai1KibouShokushu) { this.dai1KibouShokushu = dai1KibouShokushu; }
	    
	    public String getDai2KibouShokushu() { return dai2KibouShokushu; }
	    public void setDai2KibouShokushu(String dai2KibouShokushu) { this.dai2KibouShokushu = dai2KibouShokushu; }
	    
	    public String getDai3KibouShokushu() { return dai3KibouShokushu; }
	    public void setDai3KibouShokushu(String dai3KibouShokushu) { this.dai3KibouShokushu = dai3KibouShokushu; }
	    
	    public String getKenNaiGaiKibou() { return kenNaiGaiKibou; }
	    public void setKenNaiGaiKibou(String kenNaiGaiKibou) { this.kenNaiGaiKibou = kenNaiGaiKibou; }
	    
	    public String getSeibetsu() { return seibetsu; }
	    public void setSeibetsu(String seibetsu) { this.seibetsu = seibetsu; }
	    
	    public String getBiko() { return biko; }
	    public void setBiko(String biko) { this.biko = biko; }
	}