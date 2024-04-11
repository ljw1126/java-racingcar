package view;

import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputView {
    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Car> askCarNames() {
        LOGGER.info("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        try {
            return toCars(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            LOGGER.info(e.getMessage());
        }

        return askCarNames();
    }

    private List<Car> toCars(String input) {
        String[] names = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int askRacingTurn() {
        LOGGER.info("시도할 회수는 몇 회 인가요?");

        try {
            return toInt(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            LOGGER.info(e.getMessage());
        }

        return askRacingTurn();
    }

    private int toInt(String input) {
        int value = Integer.parseInt(input);

        assertOneOrMore(value);

        return value;
    }

    private void assertOneOrMore(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("1 이상의 수를 입력하세요");
        }
    }
}
