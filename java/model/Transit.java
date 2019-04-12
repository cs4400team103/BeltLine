package BeltLineApplication.java.model;

public class Transit {
    private String type;
    private String route;
    private double price;

    public String getType() {
        return this.type;
    }

    public String getRoute() {
        return this.route;
    }

    public double getPrice() {
        return this.price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
