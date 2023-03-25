/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.*/

package Java.DZ6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Eva", List.of("8 (555) 862 57 12", "8 (555) 563 95 10"));
        phonBook.put("Oleg", List.of("8 (555) 156 44 96", "8 (555) 623 10 00"));
        phonBook.put("Maxim", List.of("8 (555) 123 88 96", "8 (555) 485 74 74"));
        phonBook.put("Natalya", List.of("8 (555) 455 89 74", "8 (555) 452 45 15"));
        phonBook.put("Igor", List.of("8 (555) 956 45 10", "8 (555) 785 96 32"));

        menu(phonBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Если хотите перестать вводить номера введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите номер команды из списка: 1 - найти контакт, 2 - добавить контакт, 3 - показать всю телефонную книгу, 4 - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("4")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        find(phonBook);
                        break;
                    case "2":
                        add(phonBook);
                        break;
                    case "3":
                        allBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}

