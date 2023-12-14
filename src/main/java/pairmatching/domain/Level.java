package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private final String name;
    private final List<String> mission;

    Level(String name, List<String> mission) {
        this.name = name;
        this.mission = mission;
    }

    public String getName() {
        return name;
    }

    public List<String> getMission() {
        return mission;
    }

}