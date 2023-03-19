package persistense;

import models.Toy;

import java.util.List;

public interface FileIO {
        List<String> readAllLines();
        void saveAllLines(List<String> lines);
        void saveWinToy(Toy toy, String path);

}
