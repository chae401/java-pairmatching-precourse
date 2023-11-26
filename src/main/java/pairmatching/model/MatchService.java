package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchService {
    private List<MatchResult> matchResults;
    public MatchService() {
        matchResults = new ArrayList<>();
    }

    public void execute(Feature feature) {

    }

    public boolean isExist(MatchInfo matchInfo) {
        for (MatchResult matchResult : matchResults) {
            if (matchResult.isExists(matchInfo)) {
                return true;
            }
        }
        return false;
    }

    public void match(MatchInfo matchInfo) {
        List<String> crewNames = randomCrews(matchInfo.getCourse());
        if (validMatching(matchInfo.getLevel(), crewNames)) {
            matchResults.add(MatchResult.of(matchInfo, crewNames));
            return;
        }
        match(matchInfo);
    }

    private List<String> randomCrews(Course course) {
        List<String> crewNames = new ArrayList<>();
        String filePath = "";
        if (course == Course.BACKEND) {
            filePath = "src/main/resources/backend-crew.md";
        } else if (course == Course.FRONTEND) {
            filePath = "src/main/resources/frontend-crew.md";
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                crewNames.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Randoms.shuffle(crewNames);
    }

    private boolean validMatching(Level level, List<String> crewNames) {
        List<MatchResult> results = matchResults.stream()
                .filter(matchResult -> matchResult.sameLevel(level))
                .collect(Collectors.toList());
        for (MatchResult result : results) {
            if (!result.validMatching(crewNames)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getMatchInfo(MatchInfo matchInfo) {
        for (MatchResult result : matchResults) {
            if (result.isExists(matchInfo)) {
                return result.getCrews();
            }
        }
        return null;
    }

    public void init() {
        matchResults.clear();
    }
}
