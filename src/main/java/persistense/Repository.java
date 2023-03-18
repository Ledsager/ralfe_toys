package persistense;

import models.Toy;

import java.util.List;

public interface Repository {
    public List<Toy> getAllToys();
    public String createToy(Toy toy);
    public Toy readToy(String ToyId) throws Exception;
    public void UpdateToyWeigth(Toy toy, int id, int weigth);
    public void saveToy(Toy toy, int id );

}
