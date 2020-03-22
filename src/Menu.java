import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private View view;
    private List<Dish> menu;

    public Menu(View view){
        this.view = view;
    }

    public Food createFood(String foodTitle) {
        Food food = new Food();
        food.setName(foodTitle);
        return food;
    }

    public Price createPrice(int cost, String currency) {
        Price price = new Price();
        price.setCost(cost);
        price.setCurrency(currency);
        return price;
    }

    public Dish createNewDish(Food food, Price price) {
        Dish dish = new Dish();
        dish.setFood(food);
        dish.setPrice(price);
        return dish;
    }

    public List<Dish> populateListWithDishes() {
        Path path = Paths.get("src\\db\\menu[505].txt");
        menu = new ArrayList<>();
        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNext()) {
                Food food = createFood(sc.nextLine());
                Price price = createPrice(sc.nextInt(),sc.nextLine());
                Dish dish = createNewDish(food,price);
                String delimiter = sc.nextLine();
                menu.add(dish);
            }
        } catch (IOException e){
            System.out.println("No file found");
            e.printStackTrace();
        }
        return menu;
    }

    public void showMenu () {
        menu = populateListWithDishes();
        view.printMessage("The Menu: \n<---------------------------------->");
        menu.forEach(e -> view.printMessage(e.toString()));
    }

    public void sortListByPrice(List<Dish> menuList) {
        Collections.sort(menuList, Comparator.comparing(Dish::getCostOfDish));
    }

    public void showMenuSorted () {
        sortListByPrice(menu);
        view.printMessage("The Menu: \n<---------------------------------->");
        menu.forEach(e -> view.printMessage(e.toString()));
    }
}

