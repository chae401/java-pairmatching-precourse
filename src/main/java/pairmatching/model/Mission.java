package pairmatching.model;

public enum Mission {
    RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PATMENT("결제"),
    SUBWAY("지하철노선도"),
    IMPROVE("성능개선"),
    DEPLOY("배포"),
    EMPTY("EMPTY");
    private String title;
    private Mission(String title) {
        this.title = title;
    }

    public static Mission from(String info) {
        for (Mission mission : Mission.values()) {
            if (mission.title.equals(info)) {
                return mission;
            }
        }
        return Mission.EMPTY;
    }
}
