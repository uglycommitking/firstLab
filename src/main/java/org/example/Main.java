import java.util.Scanner;

public class Main {

    static IntContainer container = new IntContainer();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Ваш выбор: ");
            switch (choice) {
                case 1 -> menuAdd();
                case 2 -> menuAddByIndex();
                case 3 -> menuGet();
                case 4 -> menuRemoveLast();
                case 5 -> menuRemoveByIndex();
                case 6 -> menuRemoveByValue();
                case 7 -> menuPrintAll();
                case 8 -> menuSize();
                case 0 -> {
                    running = false;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println();
        System.out.println("МЕНЮ");
        System.out.println("1. Добавить число (в конец)");
        System.out.println("2. Добавить по индексу");
        System.out.println("3. Получить по индексу");
        System.out.println("4. Удалить последний");
        System.out.println("5. Удалить по индексу");
        System.out.println("6. Удалить по значению");
        System.out.println("7. Вывести все");
        System.out.println("8. Размер");
        System.out.println("0. Выход");
    }

    static void menuAdd() {
        int value = readInt("Введите число: ");
        container.add(value);
        System.out.println("Добавлено: " + value);
        System.out.println("Контейнер: " + container);
    }

    static void menuAddByIndex() {
        int index = readInt("Введите индекс (0.." + container.size() + "): ");
        int value = readInt("Введите число: ");
        try {
            container.add(index, value);
            System.out.println("Вставлено " + value + " на индекс " + index);
            System.out.println("Контейнер: " + container);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static void menuGet() {
        if (container.isEmpty()) { System.out.println("Контейнер пуст!"); return; }
        int index = readInt("Введите индекс (0.." + (container.size() - 1) + "): ");
        try {
            System.out.println("Элемент [" + index + "] = " + container.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static void menuRemoveLast() {
        if (container.isEmpty()) { System.out.println("Контейнер пуст!"); return; }
        int removed = container.removeLast();
        System.out.println("Удалён последний: " + removed);
        System.out.println("Контейнер: " + container);
    }

    static void menuRemoveByIndex() {
        if (container.isEmpty()) { System.out.println("Контейнер пуст!"); return; }
        int index = readInt("Введите индекс (0.." + (container.size() - 1) + "): ");
        try {
            int removed = container.remove(index);
            System.out.println("Удалён [" + index + "] = " + removed);
            System.out.println("Контейнер: " + container);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static void menuRemoveByValue() {
        int value = readInt("Введите значение для удаления: ");
        boolean found = container.removeByValue(value);
        System.out.println(found ? "Все " + value + " удалены." : "Значение " + value + " не найдено.");
        System.out.println("Контейнер: " + container);
    }

    static void menuPrintAll() {
        System.out.println("Контейнер: " + container);
        System.out.println("Размер: " + container.size());
    }

    static void menuSize() {
        System.out.println("Размер: " + container.size());
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите целое число!");
            }
        }
    }
}