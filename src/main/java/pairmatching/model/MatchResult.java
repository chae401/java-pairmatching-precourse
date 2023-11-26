package pairmatching.model;

import java.util.List;

public class MatchResult {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<String> crews;

    public List<String> getCrews() {
        return crews;
    }

    private MatchResult(Course course, Level level, Mission mission, List<String> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }

    public static MatchResult of(MatchInfo matchInfo, List<String> crewNames) {
        return new MatchResult(matchInfo.getCourse(), matchInfo.getLevel()
                , matchInfo.getMission(), crewNames);
    }

    public boolean isExists(MatchInfo matchInfo) {
        return this.course == matchInfo.getCourse()
                && this.level == matchInfo.getLevel()
                && this.mission == matchInfo.getMission();
    }

    public boolean sameLevel(Level level) {
        return this.level == level;
    }

    public boolean validMatching(List<String> crewNames) {
        for (int i = 0; i < crewNames.size(); i+=2) {
            if (i+1 == crewNames.size()) {
                if (crewNames.get(i-2).equals(findPair(i-2))
                        && crewNames.get(i-1).equals(findPair(i-1))) {
                    return false;
                }
                break;
            }
            if (crewNames.get(i+1).equals(findPair(i))) {
                return false;
            }
        }
        return true;
    }
    private String findPair(int index) {
        if (index % 2 == 0) {
            return this.crews.get(index+1);
        }
        return this.crews.get(index-1);
    }
}
