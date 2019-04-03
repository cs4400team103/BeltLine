package BeltLineApplication.java.model;

public class User {
    //initialization of variables
    private String username;
    private String password;
    private String fname;
    private String lname;

    /**
     * Get method for username
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get method for password
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get method for fname
     * @return String fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * Get method for lname
     * @return String lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * Set method for username
     * @param username a String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set method for password
     * @param password a String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set method for fname
     * @param fname a String
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Set method for lname
     * @param lname a String
     */
    public void setLname(String lname) {
        this.lname = lname;
    }
}
