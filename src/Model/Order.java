package Model;

import java.sql.Date;

public class Order {

    private int order_id;
    private int cust_id;
    private int promo_id;
    private int driver_id;
    private Date order_date;
    private String order_pickup;
    private String order_destination;
    private float order_price;
    private float order_final_price;
    private String order_vehicle_name;
    private String order_vehicle_plate;
    private OrderStatusEnum order_status;

    public Order(int cust_id, int promo_id, int driver_id, Date order_date, String order_pickup, String order_destination, float order_price, float order_final_price, String order_vehicle_name, String order_vehicle_plate, OrderStatusEnum order_status) {
        this.cust_id = cust_id;
        this.promo_id = promo_id;
        this.driver_id = driver_id;
        this.order_date = order_date;
        this.order_pickup = order_pickup;
        this.order_destination = order_destination;
        this.order_price = order_price;
        this.order_final_price = order_final_price;
        this.order_vehicle_name = order_vehicle_name;
        this.order_vehicle_plate = order_vehicle_plate;
        this.order_status = order_status;
    }

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getOrder_pickup() {
        return order_pickup;
    }

    public void setOrder_pickup(String order_pickup) {
        this.order_pickup = order_pickup;
    }

    public String getOrder_destination() {
        return order_destination;
    }

    public void setOrder_destination(String order_destination) {
        this.order_destination = order_destination;
    }

    public float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(float order_price) {
        this.order_price = order_price;
    }

    public float getOrder_final_price() {
        return order_final_price;
    }

    public void setOrder_final_price(float order_final_price) {
        this.order_final_price = order_final_price;
    }

    public String getOrder_vehicle_name() {
        return order_vehicle_name;
    }

    public void setOrder_vehicle_name(String order_vehicle_name) {
        this.order_vehicle_name = order_vehicle_name;
    }

    public String getOrder_vehicle_plate() {
        return order_vehicle_plate;
    }

    public void setOrder_vehicle_plate(String order_vehicle_plate) {
        this.order_vehicle_plate = order_vehicle_plate;
    }

    public OrderStatusEnum getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatusEnum order_status) {
        this.order_status = order_status;
    }

    
}
