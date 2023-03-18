package toys;

import models.Toy;
import ui.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        List<Toy> toys = new Toy();
        PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();
        Toy drawnToy;
        List<Toy> Toys = new ArrayList<>();

        new Console(new Scanner(System.in)).run();
//        Repository notesrepository = new RepositoryImpl();
//        NotesService notesService = new NotesService(notesrepository);



    }
}