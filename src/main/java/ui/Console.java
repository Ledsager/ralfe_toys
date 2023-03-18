package ui;

import services.ToyLottery;

import java.util.Scanner;

public class Console {

        private final Scanner scanner;

        public Console(Scanner scanner) {

            this.scanner = scanner;
        }

        private void printMenu() {
            System.out.println("1. Добавить новые игрушки");
            System.out.println("2. Добавить игрушку в розыгрыш");
            System.out.println("3. Игрушка для победителя");
            System.out.println("4. Выход из приложения");
        }

        public void run() {
            if (this.scanner != null) {
                int key;
                do {
                    printMenu();
                    System.out.print("Введите номер меню: ");
                    key = this.scanner.nextInt();
                    switch (key) {
                        case 1:
//                            System.out.println(" ");

                            break;
                        case 2:
//                            System.out.println(" ");

                            break;
                        case 3:
//                            System.out.println("");

                            break;
                        case 4:
                            System.out.println("Завершение программы...");
                            break;
                        default:
                            System.out.println("Вы ввели неверное значение меню...\n");
                    }
                } while (key != 4);
            }
        }
}


