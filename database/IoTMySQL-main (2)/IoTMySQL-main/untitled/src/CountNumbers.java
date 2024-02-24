import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[100];
        System.out.println("Введіть 100 чисел:");
        for (int i = 0; i < 100; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Виклик функції для обрахунку кількості чисел
        Map<Integer, Integer> counts = countNumbers(numbers);

        // Виведення результатів
        System.out.println("Кількість кожного числа:");
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            System.out.println(number + ": " + count);
        }
    }

    public static Map<Integer, Integer> countNumbers(int[] numbers) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : numbers) {
            // Перевірка, чи число вже присутнє в мапі
            if (counts.containsKey(number)) {
                // Якщо так, збільшуємо лічильник на 1
                int count = counts.get(number);
                counts.put(number, count + 1);
            } else {
                // Якщо немає, додаємо число до мапи з лічильником 1
                counts.put(number, 1);
            }
        }

        return counts;
    }
}
