package Model;

import java.sql.Date;

public class Promo {
    private int promoID;
    private String promoCode;
    private float promoValue;
    private Date expired;
    
    public Promo(String promoCode, float promoValue, Date expired) {
        this.promoCode = promoCode;
        this.promoValue = promoValue;
        this.expired = expired;
    }
    public Promo() {
    }
    public int getPromoID() {
        return promoID;
    }
    public void setPromoID(int promoID) {
        this.promoID = promoID;
    }
    public String getPromoCode() {
        return promoCode;
    }
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
    public float getPromoValue() {
        return promoValue;
    }
    public void setPromoValue(float promoValue) {
        this.promoValue = promoValue;
    }
    public Date getExpired() {
        return expired;
    }
    public void setExpired(Date expired) {
        this.expired = expired;
    }


}
