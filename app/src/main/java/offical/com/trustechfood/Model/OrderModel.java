package offical.com.trustechfood.Model;

public class OrderModel {
    String status;
    Restaurnant restaurnant;
    Food food;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Restaurnant getRestaurnant() {
        return restaurnant;
    }

    public void setRestaurnant(Restaurnant restaurnant) {
        this.restaurnant = restaurnant;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
