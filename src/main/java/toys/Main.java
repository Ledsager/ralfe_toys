package toys;

import persistense.*;
import persistense.FileIOImpl;
import persistense.Repository;
import ui.Console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileIO fileOperation = new FileIOImpl("toys.txt");
        FileIO fileOperation1 = new FileIOImpl("toys_win.txt");

        Repository repository = new RepositoryImpl(fileOperation);
//        Validate validate = new Validate();
//        UserController controller = new UserController(repository);
        Console view = new Console(repository);
        view.run();

    }
}