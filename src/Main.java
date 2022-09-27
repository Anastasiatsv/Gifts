import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        prepareGift();
    }

    public static void prepareGift() throws IOException {
        CandyBox box = new CandyBox();
        boolean formed = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Нажмите соответствующую цифру, чтобы добавить сладость в подарок:");
        System.out.println("'1' - шоколад \"Милка\"");
        System.out.println("'2' - конфеты \"Степ\"");
        System.out.println("'3' - леденец \"Петушок\"");
        System.out.println("'4' - подарочек");
        System.out.println("'5' - оптимизировать по весу");
        System.out.println("'6' - оптимизировать по цене");
        System.out.println("'9' - закончить выбор");
        while (!formed) {
            String choice = reader.readLine();
            switch (choice) {
                case "1" -> {
                    Candy candy1 = new Candy("Шоколад \"Милка\"", 200, 1000, "Нежность внутри");
                    box.addSweet(candy1);
                }
                case "2" -> {
                    Candy candy2 = new Candy("Конфеты \"Степ\"", 119, 150, "С орешками");
                    box.addSweet(candy2);
                }
                case "3" -> {
                    Lollypop candy3 = new Lollypop("Леденец \"Петушок\"", 59, 50, "Как в детстве");
                    box.addSweet(candy3);
                }
                case "4" -> box.printGift();
                case "5" -> {
                    box.optimizeByWeight(1100);
                    box.printGift();
                }
                case "6" -> {
                    box.optimizeByPrice(320);
                    box.printGift();
                }
                case "9" -> formed = true;
            }
        }
        box.printGift();
    }

}
