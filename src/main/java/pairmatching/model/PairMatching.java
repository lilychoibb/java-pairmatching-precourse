package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;
import org.omg.CORBA.PRIVATE_MEMBER;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class PairMatching {
    private String course;
    private String level;
    private String mission;

    public PairMatching(String course, String level, String mission) {
        validateCourse(course);
        validateLevel(level);
        validateMission(mission);

        this.course = course;
        this.level = level;
        this.mission = mission;

        matchPairs();
    }

    private void validateCourse(String course) {
        if (!Course.BACKEND.getName().equals(course) && !Course.FRONTEND.getName().equals(course)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLevel(String level) {
        boolean levelData = false;
        for (Level levelName : Level.values()) {
            if (levelName.getName().equals(level)) {
                levelData = true;
                break;
            }
        }
        if (!levelData) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMission(String mission) {
        boolean missionData = false;
        for (Level missions : Level.values()) {
            if (missions.getMission().contains(mission)) {
                missionData = true;
                break;
            }
        }
        if (!missionData) {
            throw new IllegalArgumentException();
        }
    }

    public List<List<String>> matchPairs() {
        try {
//            TODO : 백엔드, 프론트엔드 구분
            File file;
            String filePath = "";

            if (Objects.equals(course, Course.BACKEND.getName())) {
                filePath = "/Users/lily/java-pairmatching-precourse/src/main/resources/backend-crew.md";
            }

            if (Objects.equals(course, Course.FRONTEND.getName())) {
                filePath = "/Users/lily/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
            }

            file = new File(filePath);

            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            List<String> crew = new ArrayList<>();
            while ((line = bufReader.readLine()) != null) {
                crew.add(line);
            }
            List<String> shuffledCrew = Randoms.shuffle(crew);
            List<List<String>> result = new ArrayList<>();

            for (int i = 0; i < shuffledCrew.size(); i += 2) {
                List<String> matchingCrew = new ArrayList<>();

                if (shuffledCrew.get(i + 1) == null) {
                    result.get(result.size() - 1).add(shuffledCrew.get(i));
                    break;
                }

                matchingCrew.add(shuffledCrew.get(i));
                matchingCrew.add(shuffledCrew.get(i + 1));
                result.add(matchingCrew);
            }

            bufReader.close();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
