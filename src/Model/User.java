package Model;

public class User {
    private int ID;
    private String name;
    private String password;
    private String role;
    private float wallet;

    public User(int ID, String name, String password, String role, float wallet) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.role = role;
        this.wallet = wallet;
    }


    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    
}
