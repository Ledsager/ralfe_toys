package persistense;

import models.Toy;

import java.util.List;

public interface Repository {
    public Toy createNote();
    public Toy getNoteById();
    public List<Toy> getAllNotes();
    public Toy delNote();

}
