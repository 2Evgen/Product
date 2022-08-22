package domain;

public class Smartphone extends Product {
    private String constructor;


    public Smartphone(int id, String name, int price, String constructor) {
        super(id, name, price);
        this.constructor = constructor;
    }
    public String getConstructor() {
        return constructor;
    }
}
