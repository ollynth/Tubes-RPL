package Model;

public class Driver extends User {
    private int id;
    private String phonNum;
    private String vehicle_name;
    private String vehicle_type;
    private String vehicle_plate;
    private DriverStatEnum statusDriver;

    DriverStatusInterface state;
    
    public String updateState(String status) {
        status = state.update(this, status);
        return status;
    }
    
    public void setStateDriver(String status) {
        if(status.equalsIgnoreCase("AVAILABLE")){
            this.state = new AvailableState();
        } else {
            this.state = new OfflineState();
        }
        
    }

    public Driver(int id, String phonNum, String vehicle_name, String vehicle_type, String vehicle_plate, int user_id, String user_name, String user_pass, String user_role, float user_wallet) {
        super(user_id, user_name, user_pass, user_role, user_wallet);
        this.id = id;
        this.phonNum = phonNum;
        this.vehicle_name = vehicle_name;
        this.vehicle_type = vehicle_type;
        this.vehicle_plate = vehicle_plate;
    }

    public Driver(int id, String phonNum, String vehicle_name, String vehicle_type, String vehicle_plate) {
        this.id = id;
        this.phonNum = phonNum;
        this.vehicle_name = vehicle_name;
        this.vehicle_type = vehicle_type;
        this.vehicle_plate = vehicle_plate;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonNum() {
        return phonNum;
    }

    public void setPhonNum(String phonNum) {
        this.phonNum = phonNum;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_plate() {
        return vehicle_plate;
    }

    public void setVehicle_plate(String vehicle_plate) {
        this.vehicle_plate = vehicle_plate;
    }

    public DriverStatEnum getStatusDriver() {
        return statusDriver;
    }

    public void setStatusDriver(DriverStatEnum statusDriver) {
        this.statusDriver = statusDriver;
    }

    @Override
    public String toString() {
        return "Driver [id=" + id + ", phonNum=" + phonNum + ", vehicle_name="
                + vehicle_name + ", vehicle_type=" + vehicle_type + ", vehicle_plate=" + vehicle_plate
                + ", statusDriver=" + statusDriver + "]";
    }

    public void setUser_pass(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUser_pass'");
    }

}
