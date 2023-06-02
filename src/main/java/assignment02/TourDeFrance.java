package assignment02;

import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dieter Holz
 */
public class TourDeFrance {
    private static final List<Champ> CHAMPS = Arrays.asList(
            new Champ(2006, "Spain"        , "Oscar Pereiro"   , "Caisse Epargne Illes Balears"  , 3657, Duration.parse("PT89H40M27S"), 8),
            new Champ(2007, "Spain"        , "Alberto Contador", "Discovery Channel"             , 3570, Duration.parse("PT91H00M26S"), 4),
            new Champ(2008, "Spain"        , "Carlos Sastre"   , "Team CSC"                      , 3559, Duration.parse("PT87H52M52S"), 5),
            new Champ(2009, "Spain"        , "Alberto Contador", "Astana"                        , 3459, Duration.parse("PT85H48M35S"), 7),
            new Champ(2010, "Luxembourg"   , "Andy Schleck"    , "Team Saxo Bank"                , 3642, Duration.parse("PT91H59M27S"), 12),
            new Champ(2011, "Australia"    , "Cadel Evans"     , "BMC Racing Team"               , 3430, Duration.parse("PT86H12M22S"), 2),
            new Champ(2012, "Great Britain", "Bradley Wiggins" , "Team Sky"                      , 3496, Duration.parse("PT87H34M47S"), 14),
            new Champ(2013, "Great Britain", "Chris Froome"    , "Team Sky"                      , 3404, Duration.parse("PT83H56M20S"), 14),
            new Champ(2014, "Italy"        , "Vincenzo Nibali" , "Astana"                        , 3661, Duration.parse("PT89H59M06S"), 19),
            new Champ(2015, "Great Britain", "Chris Froome"    , "Team Sky"                      , 3360, Duration.parse("PT84H46M14S"), 16),
            new Champ(2016, "Great Britain", "Chris Froome"    , "Team Sky"                      , 3529, Duration.parse("PT89H04M48S"), 14));

    private List<Champ> allChamps() {
        return CHAMPS;
    }

    /**
     * Returns the winner of a given year.
     *
     * @param year the year to inspect
     * @return the winner of the given year
     */
    public Champ champ(int year) {
        return allChamps().stream()
                           .filter(champ -> champ.getYear() == year)
                           .findAny()
                           .orElse(null);
    }

    /**
     * Returns how many tours were longer than a given length.
     *
     * @param length the given length in km
     * @return the number of tours that were longer than the given length
     */
    public int distanceGreaterThan(int length) {
        return (int) allChamps().stream()
                                 .map(Champ::getLengthKm)
                                 .filter(l -> l > length)
                                 .count();
    }

    /**
     * Returns a sorted list of winners.
     *
     * @return the whole list of winners, sorted by the length of the tour in
     * ascending order
     */
    public List<Champ> champsSortedByDistance(){
        return allChamps().stream()
                           .sorted(Comparator.comparingInt(Champ::getLengthKm))
                           .collect(Collectors.toList());
    }

    /**
     * Returns a sorted list of winner names. Every winner is only listed once.
     *
     * @return a list of unique winner names, sorted in in alphabetical order
     */
    public List<String> champNames() {
        return allChamps().stream()
                           .map(Champ::getName)
                           .distinct()
                           .sorted()
                           .collect(Collectors.toList());
    }

    /**
     * Returns a list of all team names. Every team name is only listed once.
     *
     * @return a list of unique team names
     */
    public List<String> teamNames() {
        return allChamps().stream()
                           .map(Champ::getTeam)
                           .distinct()
                           .collect(Collectors.toList());
    }

    /**
     * Returns if there is a winner with a given nationality.
     *
     * @param nationality the nationality to search for
     * @return <tt>true</tt> if there is a winner of the given nationality,
     * <tt>false</tt> otherwise
     */
    public boolean hasChamp(String nationality) {
        return allChamps().stream()
                           .anyMatch(winner -> winner.getNationality().equals(nationality));
    }

    /**
     * Returns the longest period a winner wore the yellow jersey.
     *
     * @return the longest period a winner wore the "maillot jaune", given in
     * days
     */
    public int maxDaysInYellow() {
        return allChamps().stream()
                           .mapToInt(Champ::getDaysInYellow)
                           .max()
                           .orElse(0);
    }

    /**
     * Returns a Map of all winners.
     *
     * @return a Map with the team name as key and a list of all winners of
     * this team as value
     */
    public Map<String, List<Champ>> champsByTeam() {
        return allChamps().stream()
                           .collect(Collectors.groupingBy(Champ::getTeam));
    }

    /**
     * Returns the average distance of all tours.
     *
     * @return the average of the distances of all tours
     */
    public double averageDistance(){
        return allChamps().stream()
                           .mapToInt(Champ::getLengthKm)
                           .average()
                           .orElse(0.0);
    }

    /**
     * Returns the slowest champ.
     *
     * The average speed is available on Champ through method 'getAveSpeed'
     *
     * @return the champ with the lowest average speed
     */
    public Champ slowestWinner(){
        return allChamps().stream()
                           .min(Comparator.comparingDouble(Champ::getAveSpeed))
                           .orElse(null);
    }
}
