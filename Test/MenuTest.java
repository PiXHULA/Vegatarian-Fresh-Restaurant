

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    Path path = Paths.get("Test\\db\\menu[505].txt");
    Scanner sc = new Scanner(path);
    Food food = new Food();
    Price price  = new Price();
    View view = new View();
    Menu menu = new Menu(view);
    List<Dish> menuList = new ArrayList<>();
    public MenuTest() throws IOException {}

    @Test
    public void returnTheFirstFoodFromFile(){
        food = menu.createFood(sc.nextLine());
        assertTrue(food.getName().equals("Deliciouscly homemade falafel"));
        assertFalse(food.getName().equals("Vegan Hotdog"));
    }

    @Test
    public void returnTheFirstPriceFromFile(){
        food = menu.createFood(sc.nextLine());
        price = menu.createPrice(sc.nextInt(),sc.next());
        assertTrue(price.getCost() == 147);
        assertTrue(price.getCurrency().equals("kr"));
        assertFalse(price.getCurrency().equals("Kr"));
        assertFalse(price.getCost() == 140);
    }

    @Test
    public void returnTheFirstFullDishFromFile(){
        food = menu.createFood(sc.nextLine());
        price = menu.createPrice(sc.nextInt(),sc.next());
        Dish dish = new Dish();
        dish = menu.createNewDish(food,price);
        assertTrue(dish.getFood().getName().equals("Deliciouscly homemade falafel"));
        assertTrue(dish.getPrice().getCost() == 147);
        assertTrue(dish.getPrice().getCurrency().equals("kr"));
        assertFalse(dish.getFood().getName().equals("Vegan hotdog"));
        assertFalse(dish.getFood().getName().equals(""));
        assertFalse(dish.getPrice().getCost() == 130);
        assertFalse(dish.getPrice().getCost() == 0);
        assertFalse(dish.getPrice().getCurrency().equals("sek"));
        assertFalse(dish.getPrice().getCurrency().equals(""));
    }
    @Test
    public void returnAllDishesFromFile(){
        menuList = menu.populateListWithDishes();
        assertTrue(menuList.size() > 0);
        assertFalse(menuList.size()== 0);
    }
    @Test
    public void getAllDishesSortedByPriceLowToHigh () {
        menuList = menu.populateListWithDishes();
        menu.sortListByPrice(menuList);
        assertTrue(menuList.get((menuList.size()-1)).getCostOfDish()>= menuList.get(0).getCostOfDish());
        assertTrue(menuList.get((menuList.size()-2)).getCostOfDish()>= menuList.get(1).getCostOfDish());
        assertFalse(menuList.get(0).getCostOfDish() > menuList.get((menuList.size()-1)).getCostOfDish());
        assertFalse(menuList.get(1).getCostOfDish() > menuList.get((menuList.size()-2)).getCostOfDish());
    }
}