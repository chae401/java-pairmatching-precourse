package pairmatching.model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    EMPTY("EMPTY");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String info) {
        for (Course course : Course.values()) {
            if (course.name.equals(info)) {
                return course;
            }
        }
        return Course.EMPTY;
    }

    // 추가 기능 구현
}
