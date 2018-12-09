package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Querybuilder query = new Querybuilder();

//        Matcher m = query.oneOf(
//                query.playsIn("PHI")
//                        .hasAtLeast(10, "goals")
//                        .hasFewerThan(20, "assists").build(),
//                query.playsIn("EDM")
//                        .hasAtLeast(60, "points").build()
//        ).build();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m = query.oneOf(m1, m2).build();
        System.out.println("printtaa m1");
        for (Player player : stats.matches(m1)) {
            System.out.println(player);
        }
        System.out.println("printtaa m2");
        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }

}
