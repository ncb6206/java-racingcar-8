package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();

        // 파싱 및 검증
        Cars cars = Cars.fromInput(namesInput);
        int tries = parseTryCount(tryCountInput);

        // 진행
        System.out.println();
        System.out.println("실행 결과");
        IntSupplier rng = () -> Randoms.pickNumberInRange(0, 9);
        for (int i = 0; i < tries; i++) {
            cars.moveOnce(rng);
            printStatus(cars.statusLines());
            if (i < tries - 1) {
                System.out.println();
            }
        }

        // 결과
        List<String> winners = cars.winnerNames();
        String joined = winners.stream().collect(Collectors.joining(", "));
        System.out.println();
        System.out.println("최종 우승자 : " + joined);
    }

    private static int parseTryCount(String input) {
        if (input == null) {
            throw new IllegalArgumentException("시도 횟수는 null일 수 없습니다.");
        }
        String trimmed = input.trim();
        if (!trimmed.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
        int value = Integer.parseInt(trimmed);
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return value;
    }

    private static void printStatus(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
