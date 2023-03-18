package models;

public class ToyMapper {
    public String map(Toy toy) {
        return String.format("%s;%s;%s;%s", toy.getId(), toy.getTitle(), toy.getAmount(), toy.getWeight());
    }

    public Toy map(String line) {
        String[] lines = line.split(";");
        return new Toy(Integer.parseInt(lines[0]), lines[1], Integer.parseInt(lines[2]),
                Integer.parseInt(lines[3]));
    }
}