import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class City {
private String name;
    private int Id;
    private int population;

    /*public City(int id, String name, int population) {
        this.id = Id;
        this.name = Name;
        this.population = Population;
    }*/
       public boolean isCapital() {
        return true; 
    }
public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public int getPopulation() {
        return population;
    }


  public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Other Methods
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", population=" + population +
                '}';
    }

}