
public class Dish {

    private Food food;
    private Price price;

    public Dish() {
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Price getPrice(){
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getCostOfDish() {
        return this.price.getCost();
    }

    @Override
    public String toString() {
        return  "Food: " + food +
                "\nPrice: " + price + '\n';
    }
}
