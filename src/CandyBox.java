import java.util.ArrayList;

public class CandyBox {
    private final ArrayList<Sweets> sweets = new ArrayList<>();
    private int totalPrice = 0;
    private int totalWeight = 0;

    private void calcWeight() {
        this.totalWeight = 0;
        this.sweets.forEach(sweet -> this.totalWeight += sweet.getWeight());
    }
    private void calcPrice() {
        this.totalPrice = 0;
        this.sweets.forEach(sweet -> this.totalPrice += sweet.getPrice());
    }

    public void addSweet(Sweets candy) {
        this.sweets.add(candy);
        this.calcWeight();
        this.calcPrice();

        System.out.println("Конфеты " + candy.getName() +  " добавлены в подарок");
    }

    public void removeLastSweet() {
        this.removeSweetByIdx(this.sweets.size() - 1);
    }

    public void removeSweetByIdx(int idx) {
        this.sweets.remove(idx);
        this.calcWeight();
        this.calcPrice();
    }

    private void removeLastByWeight() {
        this.sweets.sort((o1, o2) -> {
            int w1 = o1.getWeight();
            int w2 = o2.getWeight();
            return Integer.compare(w2, w1);
        });
        this.removeLastSweet();
    }

    public void optimizeByWeight(int weight) {
        while (this.totalWeight >= weight) {
            this.removeLastByWeight();
        }
    }

    public void removeLastByPrice() {
        this.sweets.sort((o1, o2) -> {
            int p1 = o1.getPrice();
            int p2 = o2.getPrice();
            return Integer.compare(p2, p1);
        });
        this.removeLastSweet();
    }

    public void optimizeByPrice(int price) {
        while (this.totalPrice >= price) {
            this.removeLastByPrice();
        }
    }

    public void printGift() {
        int count = 0;
        System.out.println("\nПодарок состоит из:");
        for (Sweets sweet:this.sweets) {
            count++;
            System.out.println(count + ". " + sweet.getName() + " - " + sweet.getAdditionalInformation());
        }
        System.out.printf("\nОбщий вес подарка: %s гр.\nОбщая цена подарка: %s руб.%n", totalWeight, totalPrice);
    }
}