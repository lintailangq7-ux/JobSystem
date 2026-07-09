package model;


import java.util.List;
//シンプル版 ModelEmploymentSimple.java
public class ModelEmploymentSimple {
 
 private ModelEmployment ModelEmployment;                    // 指導メイン情報
 private List<ShushokuJohoChukan> chukanList;         // 試験情報（複数）

 public ModelEmploymentSimple() {}

 public ModelEmployment getShushokuJoho() { return ModelEmployment; }
 public void setShushokuJoho(ModelEmployment ModelEmployment) {
     this.ModelEmployment = ModelEmployment;
 }

 public List<ShushokuJohoChukan> getChukanList() { return chukanList; }
 public void setChukanList(ShushokuJohoChukan ShushokuJohoChukan) {
     this.chukanList.add(ShushokuJohoChukan);
 }
}