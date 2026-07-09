package model;

//2. Kaisha.java（企業テーブル）
public class ModelCompany {
 private String kaishaId;      // 企業ID
 private String kaishaName;    // 企業名
 private String address;       // 住所
 private String tel;           // 電話番号
 private String email;         // メールアドレス
 private int saiyoJisseki;     // 採用実績
 private String kinmuChi;      // 勤務地

 public ModelCompany() {}
 
 public ModelCompany(String kaishaId, String kaishaName, String address, String tel, 
               String email, int saiyoJisseki, String kinmuChi) {
     this.kaishaId = kaishaId;
     this.kaishaName = kaishaName;
     this.address = address;
     this.tel = tel;
     this.email = email;
     this.saiyoJisseki = saiyoJisseki;
     this.kinmuChi = kinmuChi;
 }

 // Getter & Setter（省略せずに全部記載）
 public String getKaishaId() { return kaishaId; }
 public void setKaishaId(String kaishaId) { this.kaishaId = kaishaId; }

 public String getKaishaName() { return kaishaName; }
 public void setKaishaName(String kaishaName) { this.kaishaName = kaishaName; }

 public String getAddress() { return address; }
 public void setAddress(String address) { this.address = address; }

 public String getTel() { return tel; }
 public void setTel(String tel) { this.tel = tel; }

 public String getEmail() { return email; }
 public void setEmail(String email) { this.email = email; }

 public int getSaiyoJisseki() { return saiyoJisseki; }
 public void setSaiyoJisseki(int saiyoJisseki) { this.saiyoJisseki = saiyoJisseki; }

 public String getKinmuChi() { return kinmuChi; }
 public void setKinmuChi(String kinmuChi) { this.kinmuChi = kinmuChi; }
}