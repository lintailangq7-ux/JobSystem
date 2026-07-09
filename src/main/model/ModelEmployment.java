package model;

import java.sql.Date;
import java.sql.Time;

/**
 * 就職情報テーブルに対応するモデルクラス
 */
public class ModelEmployment {

    // 主キー
    private int shushokuJohoId;        // 就職情報ID
    
    private int shidoId;               // 指導ID
    
    // 外部キー
    private int gakusekiBango;         // 学籍番号（学生テーブルと紐付け）
    private int kigyouId;              // 企業ID（企業テーブルと紐付け）
    
    // 選考状況
    private String senkoJokyo1;        // 選考状況1
    private String senkoJokyo2;        // 選考状況2
    private String senkoJokyo3;        // 選考状況3
    private String senkoJokyo4;        // 選考状況4
    private String senkoJokyo5;        // 選考状況5
    
    private Date yoteiNissu;           // 予定日数（日付）
    private String kinmuChi;           // 勤務地
    private String shikenJoho;         // 試験情報
    private int teishutsuJokyo;        // 提出状況
    private String shikenKaijo;        // 試験会場
    private Time shikenJikan;          // 試験時間
    
    private Date naiteiShodakuKigen;   // 内定承諾期限
    private String biko;               // 備考

    // デフォルトコンストラクタ
    public ModelEmployment() {}

    // Getter & Setter

    public int getShushokuJohoId() {
        return shushokuJohoId;
    }

    public void setShushokuJohoId(int shushokuJohoId) {
        this.shushokuJohoId = shushokuJohoId;
    }

    public int getShidoId() {
        return shidoId;
    }

    public void setShidoId(int shidoId) {
        this.shidoId = shidoId;
    }

    public int getGakusekiBango() {
        return gakusekiBango;
    }

    public void setGakusekiBango(int gakusekiBango) {
        this.gakusekiBango = gakusekiBango;
    }

    public int getKigyouId() {
        return kigyouId;
    }

    public void setKigyouId(int kigyouId) {
        this.kigyouId = kigyouId;
    }

    public String getSenkoJokyo1() {
        return senkoJokyo1;
    }

    public void setSenkoJokyo1(String senkoJokyo1) {
        this.senkoJokyo1 = senkoJokyo1;
    }

    public String getSenkoJokyo2() {
        return senkoJokyo2;
    }

    public void setSenkoJokyo2(String senkoJokyo2) {
        this.senkoJokyo2 = senkoJokyo2;
    }

    public String getSenkoJokyo3() {
        return senkoJokyo3;
    }

    public void setSenkoJokyo3(String senkoJokyo3) {
        this.senkoJokyo3 = senkoJokyo3;
    }

    public String getSenkoJokyo4() {
        return senkoJokyo4;
    }

    public void setSenkoJokyo4(String senkoJokyo4) {
        this.senkoJokyo4 = senkoJokyo4;
    }

    public String getSenkoJokyo5() {
        return senkoJokyo5;
    }

    public void setSenkoJokyo5(String senkoJokyo5) {
        this.senkoJokyo5 = senkoJokyo5;
    }

    public Date getYoteiNissu() {
        return yoteiNissu;
    }

    public void setYoteiNissu(Date yoteiNissu) {
        this.yoteiNissu = yoteiNissu;
    }

    public String getKinmuChi() {
        return kinmuChi;
    }

    public void setKinmuChi(String kinmuChi) {
        this.kinmuChi = kinmuChi;
    }

    public String getShikenJoho() {
        return shikenJoho;
    }

    public void setShikenJoho(String shikenJoho) {
        this.shikenJoho = shikenJoho;
    }

    public int getTeishutsuJokyo() {
        return teishutsuJokyo;
    }

    public void setTeishutsuJokyo(int teishutsuJokyo) {
        this.teishutsuJokyo = teishutsuJokyo;
    }

    public String getShikenKaijo() {
        return shikenKaijo;
    }

    public void setShikenKaijo(String shikenKaijo) {
        this.shikenKaijo = shikenKaijo;
    }

    public Time getShikenJikan() {
        return shikenJikan;
    }

    public void setShikenJikan(Time shikenJikan) {
        this.shikenJikan = shikenJikan;
    }

    public Date getNaiteiShodakuKigen() {
        return naiteiShodakuKigen;
    }

    public void setNaiteiShodakuKigen(Date naiteiShodakuKigen) {
        this.naiteiShodakuKigen = naiteiShodakuKigen;
    }

    public String getBiko() {
        return biko;
    }

    public void setBiko(String biko) {
        this.biko = biko;
    }
}