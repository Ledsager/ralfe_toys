package ui;

import models.Toy;
import models.ToyMapper;
import persistense.FileIO;
import persistense.FileIOImpl;
import persistense.Repository;
import services.RandomCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
        private final Repository repository;

        FileIO fileOperation1 = new FileIOImpl("toys_win.txt");
        List<Toy> toys = new ArrayList<>();
        RandomCollection<Object> rc = new RandomCollection<>();
//        private final Scanner scanner;
//        private final UserController userController;
        public Console(Repository repository) {
            this.repository = repository;
//            this.scanner = scanner;
        }

        private void printMenu() {
            System.out.println("1. Добавить новые игрушки");
            System.out.println("2. Добавить игрушку в розыгрыш");
            System.out.println("3. Игрушка для победителя");
            System.out.println("4. Просмотреть все игрушки");
            System.out.println("5. Изменить вес(вероятность выпадения) игрушки");
            System.out.println("6. Выход из программы");
        }

        public void run() {
            Scanner scanner =new Scanner(System.in);
            if (scanner != null) {
                try {
                    int key;
                    do {
                        printMenu();
                        System.out.print("Введите номер меню: ");
                        key = scanner.nextInt();
                        switch (key) {
                            case 1:
                                create();
                                break;
                            case 2:
                                listToyPlay();
                                break;
                            case 3:
                                winToyFile();
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

        private void listToyPlay()throws Exception {
            int id = Integer.parseInt(prompt("введите id игрушки которую хотите добавить в розыгрыш: "));
            toys.add(repository.readToy(id));

        }
        private void winToyFile() throws Exception {

            for (Toy toy : toys) {
//                System.out.println(toy);
                if (toy.getAmount() > 0) {
                    rc.add(toy.getWeight(), toy.getId());
                }
            }
            for (int i = 0; i < 1; i++) {
//                System.out.println(rc.next());
                    int idwin= (int) rc.next();

                Toy _toywin = repository.readToy(idwin);
                System.out.println(idwin);

                repository.UpdateToyAmount(_toywin, idwin);
                System.out.println(_toywin);

                fileOperation1.saveWinToy(_toywin, "toys_win.txt");

//                if (_toywin.getAmount() == 0){
//                    System.out.println(_toywin);
//                    rc.del(_toywin.getWeight(), idwin);
//                }
            }

        }
    private void update() throws Exception {
        int id = Integer.parseInt(prompt("введите id игрушки которой меняем вероятность: "));
        int weight = Integer.parseInt(prompt("Введите новый вес(частоту выпадения) игрушки: "));

        Toy _toy = repository.readToy(id);
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


