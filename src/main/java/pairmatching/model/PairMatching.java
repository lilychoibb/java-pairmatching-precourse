package pairmatching.model;

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
    }

    private void validateCourse(String course) {
        if (!Course.BACKEND.name().equals(course) && !Course.FRONTEND.name().equals(course)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLevel(String level) {
        boolean levelData = false;
        for (Level levelName : Level.values()) {
            if (levelName.name().equals(level)) {
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

}
