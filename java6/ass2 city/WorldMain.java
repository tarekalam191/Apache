import java.util.*;
public class WorldMain {

    public static void main(String[] args) {
        List<Country> countries = readCountriesFromFile("Countries.csv");
        List<City> cities = readCitiesFromFile("Cities.csv");

        // --------------- highest populated city of each country -------------------------//
        Map<Country, City> high_populated_cityBy_country = findHighestPopulatedCityByCountry(countries);
        System.out.println("This Is The Highest Populated City by Country: " + high_populated_cityBy_country);

        //-------------------- most populated country of each continent ---------------------//
        Map<String, Country> most_populated_countryBy_continent = findMostPopulatedCountryByContinent(countries);
        System.out.println("This Is The Most Populated Country by Continent: " + most_populated_countryBy_continent);

        //----------------------------- highest populated capital city -----------------------//
        City highest_populated_capital = findHighestPopulatedCapital(countries);
        System.out.println("This Is The Highest Populated Capital City: " + highest_populated_capital);
    }

    private static Map<Country, City> findHighestPopulatedCityByCountry(List<Country> countries) {
        Map<Country, City> result = new HashMap<>();
        for (Country country : countries) {
            Optional<City> highestPopulatedCity = country.getCities().stream()
                    .filter(City::isCapital)
                    .max(Comparator.comparingInt(City::getPopulation));

            highestPopulatedCity.ifPresent(city -> result.put(country, city));
        }
        return result;
    }

    private static Map<String, Country> findMostPopulatedCountryByContinent(List<Country> countries) {
        Map<String, Country> result = new HashMap<>();
        for (Country country : countries) {
            result.compute(country.getContinent(), (key, existingCountry) -> {
                if (existingCountry == null || country.getPopulation() > existingCountry.getPopulation()) {
                    return country;
                } else {
                    return existingCountry;
                }
            });
        }
        return result;
    }

    private static City findHighestPopulatedCapital(List<Country> countries) {
        return countries.stream()
                .flatMap(country -> country.getCities().stream())
                .filter(City::isCapital)
                .max(Comparator.comparingInt(City::getPopulation))
                .orElse(null);
    }

    private static List<Country> readCountriesFromFile(String filename) {
        // Implement this method to read countries from a file
        return new ArrayList<>();  // Placeholder, replace with actual implementation
    }

    private static List<City> readCitiesFromFile(String filename) {
        // Implement this method to read cities from a file
        return new ArrayList<>();  // Placeholder, replace with actual implementation
    }
        }
        