package pairmatching.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Crews {
    private final List<Crew> crews;

    public Crews() {
        crews = new ArrayList<>();
        crews.addAll(register(Course.FRONTEND));
        crews.addAll(register(Course.BACKEND));
    }

    private List<Crew> register(Course course) {
        List<Crew> crews = new ArrayList<>();
        String filePath = findFile(course);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line.trim();
                crews.add(new Crew(course, name));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return crews;
    }

    private String findFile(Course course) {
        if (course == Course.FRONTEND) {
            return "frontend-crew.md";
        } else if (course == Course.BACKEND) {
            return "backend-crew.md";
        } else {
            throw new RuntimeException("Invalid course");
        }
    }
}
