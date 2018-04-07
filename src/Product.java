public class Product {
    int id;
    String name;
    double price;
    int amount;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
    public void persist(){
        String sqlInsert = "INSERT INTO tproduct (id,name, price, amount) VALUES ("+this.id+","+this.name+","+this.price+","+this.amount+");";

    }
}
