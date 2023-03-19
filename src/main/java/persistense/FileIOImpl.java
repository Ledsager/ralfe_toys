package persistense;

import models.Toy;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class FileIOImpl implements FileIO{

    private String fileName;

    public FileIOImpl(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void saveAllLines(List<String> lines) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                // запись всей строки
                writer.write(line);
                // запись по символам
//                writer.append('\n');
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    @Override
    public void saveWinToy(Toy toy, String pathResult) {
        try (FileWriter writer = new FileWriter(pathResult, true)) {
//            for (Toy item : toy) {
                writer.append(String.format("%d  ", toy.getId()));
                writer.append(String.format("%s  ", toy.getTitle()));
                writer.append(String.format("%d  ", toy.getAmount()));
                writer.append(String.format("%d  ", toy.getWeight()));
                writer.append("\n");
                writer.flush();
            } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

