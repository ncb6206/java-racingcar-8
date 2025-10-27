package racingcar;

import java.util.function.IntSupplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;

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

    // 모든 자동차 1회 이동(난수 생성은 Cars에서)
    void moveOnce(IntSupplier rng) {
        for (Car car : values) {
            car.tryMove(rng.getAsInt());
        }
    }

    // 현재 상태 라인 목록
    public List<String> statusLines() {
        List<String> lines = new ArrayList<>();
        for (Car car : values) {
            lines.add(car.statusLine());
        }
        return lines;
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(values);
    }
}