package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

class Cars {
    private final List<Car> values;

    private Cars(List<Car> cars) {
        this.values = Collections.unmodifiableList(cars);
    }

    static Cars fromInput(String line) {
        if (line == null) {
            throw new IllegalArgumentException("입력은 null일 수 없습니다.");
        }
        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름을 한 개 이상 입력해야 합니다.");
        }
        String[] tokens = trimmed.split(",");
        List<Car> cars = new ArrayList<>();
        for (String token : tokens) {
            cars.add(new Car(token.trim()));
        }
        return new Cars(cars);
    }

    void moveOnce(IntSupplier rng) {
        for (Car car : values) {
            car.tryMove(rng.getAsInt());
        }
    }

    List<String> statusLines() {
        List<String> lines = new ArrayList<>();
        for (Car car : values) {
            lines.add(car.statusLine());
        }
        return lines;
    }

    List<String> winnerNames() {
        int max = values.stream().max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
        return values.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
