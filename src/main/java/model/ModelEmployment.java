package model;

/**
 * 就職情報テーブルに対応するモデルクラス
 */
public class ModelEmployment {
    private String shidoId;           // 指導ID
    private int gakusekiNo;           // 学籍番号
    private String kaishaId;          // 企業ID
    private String naiteiKakuteiBi;   // 内定確定日
    private int naiteiKakutei;        // 内定確定
    private String biko;              // 備考

    public ModelEmployment() {}

    public ModelEmployment(String shidoId, int gakusekiNo, String kaishaId,
                        String naiteiKakuteiBi, int naiteiKakutei, String biko) {
        this.shidoId = shidoId;
        this.gakusekiNo = gakusekiNo;
        this.kaishaId = kaishaId;
        this.naiteiKakuteiBi = naiteiKakuteiBi;
        this.naiteiKakutei = naiteiKakutei;
        this.biko = biko;
    }

    // Getter & Setter
    public String getShidoId() { return shidoId; }
    public void setShidoId(String shidoId) { this.shidoId = shidoId; }

    public int getGakusekiNo() { return gakusekiNo; }
    public void setGakusekiNo(int gakusekiNo) { this.gakusekiNo = gakusekiNo; }

    public String getKaishaId() { return kaishaId; }
    public void setKaishaId(String kaishaId) { this.kaishaId = kaishaId; }

    public String getNaiteiKakuteiBi() { return naiteiKakuteiBi; }
    public void setNaiteiKakuteiBi(String naiteiKakuteiBi) { this.naiteiKakuteiBi = naiteiKakuteiBi; }

    public int getNaiteiKakutei() { return naiteiKakutei; }
    public void setNaiteiKakutei(int naiteiKakutei) { this.naiteiKakutei = naiteiKakutei; }

    public String getBiko() { return biko; }
    public void setBiko(String biko) { this.biko = biko; }
}