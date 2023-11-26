package pairmatching.model;

public enum Feature {
    MATCHING(1, "페어 매칭"),
    SELECT(2, "페어 조회"),
    INIT(3, "페어 초기화"),
    QUIT(0, "종료"),
    EMPTY(-1, "");
    private int featureId;
    private String title;
    private Feature(int featureId, String title) {
        this.featureId = featureId;
        this.title = title;
    }

    public static Feature from(int featureId) {
        for (Feature feature : Feature.values()) {
            if (feature.featureId == featureId) {
                return feature;
            }
        }
        return Feature.EMPTY;
    }
}
