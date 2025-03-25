package day2;

class Object {
    String name;
    double price;

    Object(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Object) {
            Object p = (Object) obj;
            return this.name.equals(p.name) && this.price == p.price;
        }
        return false;
    }

    public static void main(String[] args) {
        Object p1 = new Object("Laptop", 50000);
        Object p2 = new Object("Laptop", 50000);
        System.out.println(p1.equals(p2)); // true
    }
}
