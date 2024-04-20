package Model;

import java.sql.Date;

public class Promo {
    private int ID;
    private String code;
    private float value;
    private Date expired;
    
    public Promo(String code, float value, Date expired) {
        this.code = code;
        this.value = value;
        this.expired = expired;
    }
    public Promo() {
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    public Date getExpired() {
        return expired;
    }
    public void setExpired(Date expired) {
        this.expired = expired;
    }


}
