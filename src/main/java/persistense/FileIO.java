package persistense;

import java.util.List;

public interface FileIO {
        List<String> readAllLines();
        void saveAllLines(List<String> lines);

}
