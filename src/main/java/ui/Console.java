package ui;

import services.ToyLottery;

import java.util.Scanner;

public class Console {
    private final ToyLottery toysService;

    public Console(ToyLottery toysService) {

        this.toysService = toysService;
    }

    public void run() {
        Scanner in = new Scanner(System.in);

        while (true) {
//            String command = prompt("Input you command: ", in).toUpperCase();
            int user_choice = Integer.valueOf(prompt("How many toys?", in));

            Lottery lottery = new Lottery();
//            controller.addToys(lottery, 30);
            switch (user_choice) {

                case 1:
                    System.out.print('');
//                    controller.addToys(lottery, size);
//                    for(Toy toy : lottery.getToysList()) {
//                        System.out.println(toy);
//                    }
//                    break;
                case 2:
                case 3:
                case 4:

            }
        }
//        '1 - добавить новую игрушку\n'
//        '2 - поменять вероятность выпадения игрушки\n'
//        '3 - лотерея\n'
//        '4 - \n'
//        '5 - \n'
//        '6 - \n'
//        '7 - выход\n'))
//
//        if (user_choice) == 1:
//        c.create_note(get_add_note())
//        elif user_choice == 2:
//        if c.file_null:
//        read_note = int(note_number())
//        print(c.read_one_note(read_note))
//        enter_in()
//        elif user_choice == 3:
//        if c.file_null:
//        update_note_number = int(note_number())
//        c.update_note(update_note_number, get_add_note())
//        enter_in()
//        elif user_choice == 4:
//        if c.file_null:
//        del_note = int(note_number())
//        c.del_one_notes(del_note)
//        enter_in()

//            while (true) {
//            String command = prompt("Input you command: ", in).toUpperCase();
//            Commands com = Commands.valueOf(command);
//            ToyLottery lottery = new ToyLottery();
//            controller.addToys(lottery, 30);
//            switch (com) {
//                case ADD:
//                    int size = Integer.valueOf(prompt("How many toys?", in));
//                    controller.addToys(lottery, size);
//                    for(Toy toy : lottery.getToysList()) {
//                        System.out.println(toy);
//                    }
//                    break;
//                case LOTTERY:
//                    Toy prize = controller.showPrize(lottery);
//                    System.out.println(prize);
//                    break;
//                case PRIZES:
//                    controller.showAll().forEach(System.out::println);
//                    break;
//                case EXIT:
//                    in.close();
//                    System.exit(0);
//                    break;
//            }
    }


    private String prompt(String menu, Scanner in) {
        System.out.print(menu);
        return in.nextLine();
    }
}

