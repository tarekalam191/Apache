import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
public class Country {

 private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private List<City> cities = new ArrayList<>(); // Add this line
    private double gnp;
    private int population;
    private String capital;

          /*public Country(String code, String name,String content,double surfaceArea,int population,int capetail) {
          this.code = Code;
          this.name = Name;
          this.content = Content;
          this.surfaceArea = SurfaceArea;
          this.population = Population;
          this.capetail = Capetail;
          this.cities = new ArrayList<>();
    }*/
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getPopulation() {
        return cities.stream().mapToInt(City::getPopulation).sum();
    }

    public double getGnp() {
        return gnp;
    }

    public String getCapital() {
        return capital;
    }

    public List<City> getCities() {
        return cities;
    }
public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setPopulation(int population) {
        // Assuming you have a list of cities
        // This method should be adapted based on your data structure
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }
    


  public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", surfaceArea=" + surfaceArea +
               ", population=" + population +
                ", gnp=" + gnp +
                ", capital=" + capital +
                '}';
    }
}



