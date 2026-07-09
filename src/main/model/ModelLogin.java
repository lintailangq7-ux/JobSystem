package model;

public class ModelLogin {
    
    private int gakusekiBango;      // 学籍番号（FK）
    private String password;        // パスワード
    
    public ModelLogin() {}
    
    public int getGakusekiBango() { return gakusekiBango; }
    public void setGakusekiBango(int gakusekiBango) { this.gakusekiBango = gakusekiBango; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
