package challenges.playof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playoff {

    List<Team> teamList;
    Map<String, Integer> teamsScores;

    public Playoff(String[] qualificationsResults) {
        teamsScores = new HashMap<>();
        teamList = new ArrayList<>();
        for (String match : qualificationsResults
        ) {
            String[] result = match.split(" ");
            String winner = result[0];
            String loser = result[1];
            if (!teamsScores.containsKey(winner)) {
                teamsScores.put(winner, 1);
            } else {
                teamsScores.replace(winner, teamsScores.get(winner) + 1);
            }
            if (!teamsScores.containsKey(loser)) {
                teamsScores.put(loser, 0);
            } else if (teamsScores.containsKey(loser)) {
                teamsScores.replace(loser, teamsScores.get(loser));
            }
        }
        teamsScores.forEach((team, score) -> {
            Team newTeam = new Team(team, score);
            this.teamList.add(newTeam);
        });
    }

    public String[] layout() {
        this.teamList.sort((o1, o2) -> {
            return Integer.compare(o2.getScore(), o1.getScore());
        });
        return new String[]{teamList.get(0).getName()+" vs "
                +teamList.get(3).getName(),teamList.get(1).getName()+" vs "
                +teamList.get(2).getName()
        };
    }
}
