package Model;

import java.sql.Date;

public class Order {

    private int id;
    private int cust_id;
    private int promo_id;
    private int driver_id;
    private Date date;
    private String pickup;
    private String destination;
    private float price;
    private float final_price;
    private String vehicle_name;
    private String vehicle_plate;
    private OrderStatusEnum status;

    public Order(int cust_id, int promo_id, int driver_id, Date date, String pickup, String destination, float price, float final_price, String vehicle_name, String vehicle_plate, OrderStatusEnum status) {
        this.cust_id = cust_id;
        this.promo_id = promo_id;
        this.driver_id = driver_id;
        this.date = date;
        this.pickup = pickup;
        this.destination = destination;
        this.price = price;
        this.final_price = final_price;
        this.vehicle_name = vehicle_name;
        this.vehicle_plate = vehicle_plate;
        this.status = status;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFinal_Price() {
        return final_price;
    }

    public void setFinal_Price(float final_price) {
        this.final_price = final_price;
    }

    public String getVehicle_Name() {
        return vehicle_name;
    }

    public void setVehicle_Name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_Plate() {
        return vehicle_plate;
    }

    public void setVehicle_Plate(String vehicle_plate) {
        this.vehicle_plate = vehicle_plate;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    
}
