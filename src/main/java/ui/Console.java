package ui;

import models.Toy;
import persistense.Repository;

import java.util.Scanner;

public class Console {
        private final Repository repository;
        private final Scanner scanner;
//        private final UserController userController;
        public Console(Repository repository, Scanner scanner) {
            this.repository = repository;
            this.scanner = scanner;
        }

        private void printMenu() {
            System.out.println("1. Добавить новые игрушки");
            System.out.println("2. Добавить игрушку в розыгрыш");
            System.out.println("3. Игрушка для победителя");
            System.out.println("4. Просмотреть все игрушки");
            System.out.println("5. Изменить вес(вероятность выпадения) игрушки");
            System.out.println("6. Выход из приложения");
        }

        public void run() {
            if (this.scanner != null) {
                try {
                    int key;
                    do {
                        printMenu();
                        System.out.print("Введите номер меню: ");
                        key = this.scanner.nextInt();
                        switch (key) {
                            case 1:

                                create();
    //                            System.out.println(" ");
                                break;
                            case 2:

    //                            System.out.println(" ");
                                break;
                            case 3:

    //                            System.out.println("");
                                break;
                            case 4:
                                list();
                                break;
                            case 5:
                                update();
                                break;
                            case 6:
                                System.out.println("Завершение программы...");
                                break;
                            default:
                                System.out.println("Вы ввели неверное значение меню...\n");
                        }
                    } while (key != 6);
                }
                catch(Exception ex) {
                    System.out.println("Произошла ошибка " + ex.toString());
                }
            }
        }
    private void update() throws Exception {
        int id = Integer.parseInt(prompt("введите id игрушки которой меняем вероятность: "));
        int weight = Integer.parseInt(prompt("Введите новый вес(частоту выпадения) игрушки: "));

        Toy _toy = repository.readToy(String.format("%d",id));
//        System.out.println(_toy);
        repository.UpdateToyWeigth(_toy, id, weight);
    }
    private void create() throws Exception {
//        int id = Integer.parseInt(prompt("id: "));
        String title = prompt("Название игрушки: ");
        int amount = Integer.parseInt(prompt("количество игрушек: "));
        int weight = Integer.parseInt(prompt("Вес(частота выпадения): "));
        repository.createToy(new Toy(title, amount, weight));
    }
    private void list() throws Exception {
        for (Toy toy : repository.getAllToys()) {
            System.out.println(toy);
        }
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}


