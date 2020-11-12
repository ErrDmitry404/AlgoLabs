package lab1;

public class Shoes {

    private String name;

    private Float price;

    private Float size;

    private String color;

    public Shoes(String name, Float price, Float size, String color) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Shoes{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }

    public static String getHeaders() {
        return "name, price, size, color";
    }

    public String toCSV() {
        return name + ", " + price + ", " + size + ", " + color;
    }


}
