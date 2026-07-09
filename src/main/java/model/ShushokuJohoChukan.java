package model;

public class ShushokuJohoChukan {
    private String shidoId;         // 指導ID
    private String shikenNichiji;   // 試験日時
    private String shikenNaiyo;     // 試験内容
    private int teishutsuShoruiJokyo; // 提出書類状況
    private String shikenKaijo;     // 試験会場

    public ShushokuJohoChukan() {}

    public ShushokuJohoChukan(String shidoId, String shikenNichiji, String shikenNaiyo,
                              int teishutsuShoruiJokyo, String shikenKaijo) {
        this.shidoId = shidoId;
        this.shikenNichiji = shikenNichiji;
        this.shikenNaiyo = shikenNaiyo;
        this.teishutsuShoruiJokyo = teishutsuShoruiJokyo;
        this.shikenKaijo = shikenKaijo;
    }

    public String getShidoId() { return shidoId; }
    public void setShidoId(String shidoId) { this.shidoId = shidoId; }

    public String getShikenNichiji() { return shikenNichiji; }
    public void setShikenNichiji(String shikenNichiji) { this.shikenNichiji = shikenNichiji; }

    public String getShikenNaiyo() { return shikenNaiyo; }
    public void setShikenNaiyo(String shikenNaiyo) { this.shikenNaiyo = shikenNaiyo; }

    public int getTeishutsuShoruiJokyo() { return teishutsuShoruiJokyo; }
    public void setTeishutsuShoruiJokyo(int teishutsuShoruiJokyo) { this.teishutsuShoruiJokyo = teishutsuShoruiJokyo; }

    public String getShikenKaijo() { return shikenKaijo; }
    public void setShikenKaijo(String shikenKaijo) { this.shikenKaijo = shikenKaijo; }
}
