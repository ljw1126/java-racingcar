package model;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = new Cars(cars);
        this.moveStrategy = moveStrategy;
    }

    public RacingRecord run(int turn) {
        if (turn < 1) {
            throw new IllegalArgumentException("1이상 입력해주세요");
        }

        RacingRecord racingRecord = new RacingRecord(turn);
        for (int i = 1; i <= turn; i++) {
            Cars movedCars = this.cars.move(this.moveStrategy);
            racingRecord.save(movedCars);
        }

        return racingRecord;
    }
}
