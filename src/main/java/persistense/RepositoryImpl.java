package persistense;

import models.Toy;
import models.ToyMapper;

import java.util.List;
import java.util.ArrayList;
import java.util.List;


public class RepositoryImpl implements Repository{
    private FileIO fileOperation;
    private ToyMapper mapper = new ToyMapper();

    public RepositoryImpl(FileIO fileOperation) {
        this.fileOperation = fileOperation;
    }
    @Override
    public List<Toy> getAllToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map(line));
        }
        return toys;
    }
    @Override
    public void UpdateToyWeigth(Toy toy, int id, int weigth) {
        toy.setWeight(weigth);
        saveToy(toy, id);
    }
    @Override
    public void saveToy(Toy toy, int id) {
        List<String> lines = new ArrayList<>();
        List<Toy> toys = getAllToys();
        System.out.println(toy);
        for (Toy item: toys) {
            if(id==item.getId()) {
                lines.add(mapper.map(toy));
            }
            else {
                lines.add(mapper.map(item));
            }
        }
        System.out.println(lines);
        fileOperation.saveAllLines(lines);
    }
//    public void updateToy(Toy toy, int id, int weigth) throws Exception {
//        if(field == Fields.TELEPHONE) {
//            validate.checkNumber(param);
//        }
//        repository.UpdateUser(user, field, param);
    @Override
    public Toy readToy(String ToyId) throws Exception {
        List<Toy> toys = getAllToys();
        for (Toy toy : toys) {
            if (String.format("%d", toy.getId()).equals(ToyId)) {
                return toy;
            }
        }
        throw new Exception("User not found");
    }
    @Override
    public String createToy(Toy toy) {

        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map(line));
        }

        int max = 0;
        for (Toy item : toys) {
            int id = item.getId();
            if (max < id){
                max = id;
            }
        }
//        int newId = max + 1;
        int id = max+1;
        toy.setId(id);
        toys.add(toy);
        List<String> lines1 = new ArrayList<>();
        for (Toy item: toys) {
            lines1.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines1);
        return String.format("%d",id);

    }
}
