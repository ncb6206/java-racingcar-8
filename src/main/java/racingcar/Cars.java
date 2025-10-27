package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> values;

    private Cars(List<Car> cars) {
        this.values = new ArrayList<>(cars);
    }

    public static Cars fromNamesLine(String line) {
        List<String> names = parseNames(line);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    private static List<String> parseNames(String line) {
        if (line == null) {
            throw new IllegalArgumentException("이름 입력은 null일 수 없습니다.");
        }
        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름을 한 개 이상 입력해야 합니다.");
        }
        String[] tokens = trimmed.split(",");
        List<String> names = new ArrayList<>();
        for (String token : tokens) {
            String name = token.trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }
            names.add(name);
        }
        return names;
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(values);
    }
}