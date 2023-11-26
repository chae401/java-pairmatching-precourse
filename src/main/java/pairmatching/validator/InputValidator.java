package pairmatching.validator;

import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.MatchInfo;
import pairmatching.model.Mission;

public class InputValidator {
    private static final String SEPARATOR = ", ";
    private static final String TRUE = "예";
    private static final String FALSE = "아니오";

    public int validateFeature(String s) {
        if (s.equals("Q")) {
            return 0;
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public MatchInfo validateMatchInfo(String s) {
        String[] infos = s.split(SEPARATOR);
        if (infos.length != 3) {
            throw new IllegalArgumentException();
        }
        Course course = validateCourse(infos[0]);
        Level level = validateLevel(infos[1]);
        Mission mission = validateMission(infos[2]);
        return new MatchInfo(course, level, mission);
    }

    private Mission validateMission(String info) {
        Mission mission = Mission.from(info);
        if (mission == Mission.EMPTY) {
            throw new IllegalArgumentException();
        }
        return mission;
    }

    private Level validateLevel(String info) {
        Level level = Level.from(info);
        if (level == Level.EMPTY) {
            throw new IllegalArgumentException();
        }
        return level;
    }

    private Course validateCourse(String info) {
        Course course = Course.from(info);
        if (course == Course.EMPTY) {
            throw new IllegalArgumentException();
        }
        return course;
    }

    public boolean validateBool(String s) {
        if (s.equals(TRUE)) {
            return true;
        } else if (s.equals(FALSE)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
