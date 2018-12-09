package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("NOT");
        m = new Not(new HasAtLeast(1, "goals"));

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("OR");
        m = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists"),
                new HasAtLeast(85, "points")
        );
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("HAS FEWER THAN");
        m = new HasFewerThan(1, "goals");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
