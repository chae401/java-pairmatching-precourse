package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import sun.security.rsa.RSAKeyFactory.Legacy;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.BASKET, Mission.PATMENT, Mission.SUBWAY)),
    LEVEL3("레벨3", null),
    LEVEL4("레벨4", Arrays.asList(Mission.IMPROVE, Mission.DEPLOY)),
    LEVEL5("레벨5", null),
    EMPTY("EMPTY", null);

    private String title;
    private List<Mission> missions;

    Level(String title, List<Mission> missions) {
        this.title = title;
        this.missions = missions;
    }

    public static Level from(String info) {
        for (Level level : Level.values()) {
            if (level.title.equals(info)) {
                return level;
            }
        }
        return Level.EMPTY;
    }

    // 추가 기능 구현
}
