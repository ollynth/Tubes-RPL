package Model;

public class OfflineState implements DriverStatusInterface {

    @Override
    public String update(Driver driver, String status) {
        driver.state = new AvailableState();
        return status = "AVAILABLE";
    }
}

