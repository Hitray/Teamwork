import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        String products[] = {"Хлеб", "Каша", "Сок", "Макароны"};
        int prices[] = {110, 60, 90, 70};
        int productsCount[] = new int[products.length];

        while (true) {
            System.out.println("Выберите номер продукта из списка ниже и количество через пробел. Для завершения программы и вывода итогов введите end:");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " руб.");
            }
            String choice = scanner.nextLine();
            ;
            if (choice.equals("end")) {
                break;
            }
            String parts[] = choice.split(" ");
            int productNumber;
            int productCount;
            try {
                productNumber = Integer.parseInt(parts[0]) - 1;
                productCount = Integer.parseInt(parts[1]);
            } catch (Exception e) {
                System.out.println("Вы ввели что-то совсем непонятное");
                continue;
            }
            if (parts.length != 2) {
                System.out.println("Введите корректные значения");
                continue;
            }
            if (productNumber < 0 || productNumber >= products.length) {
                System.out.println("Выберите порядковый номер в соответствии с представленным списком");
                continue;
            } else if (productCount < 0) {
                System.out.println("Мы не можем положить в корзину " + productCount + " " + products[productNumber]);
                continue;
            } else if (productCount == 0) {
                System.out.println("Мы конечно можем представить что положили в корзину невидимый товар, но лучше введите корректные значения");
                continue;
            }
            productsCount[productNumber] += productCount;
            System.out.println("Вы положили в корзину " + products[productNumber] + ", " + productCount + ", шт");
        }
        int bill = 0;
        for (int i1 = 0; i1 < products.length; i1++) {
            if (productsCount[i1] != 0) {
                bill += productsCount[i1] * prices[i1];
                System.out.println(products[i1] + " - " + productsCount[i1] + " шт., " + prices[i1] + " руб/шт., " + productsCount[i1] * prices[i1] + " руб. в сумме");
            }
        }
        System.out.println("Общая сумма покупок: " + bill + " руб.");
    }
}