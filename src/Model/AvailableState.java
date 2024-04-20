package Model;

public class AvailableState implements DriverStatusInterface {

    @Override
    public String update(Driver driver, String status) {
        driver.state = new OfflineState();
        return status = "OFFLINE";

    }

}
