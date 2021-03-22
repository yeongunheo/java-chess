package chess.domain.piece;

import chess.domain.PieceDirection;
import chess.domain.Position;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvailableDirectionsTest {

    @Test
    @DisplayName("계속해서 위로 올라갈 수 있는 말의 움직일 수 있는 자리를 테스트")
    void movablePositions_iterable() {
        List<Position> expectedMovablePositions =
            Arrays.asList(
                Position.of(0, 1),
                Position.of(0, 2),
                Position.of(0, 3),
                Position.of(0, 4)
            );

        AvailableDirections availableDirections = new AvailableDirections(
            Collections.singletonList(PieceDirection.UP),
            Collections.singletonList(PieceDirection.UP)
        );

        Position currentPosition = Position.of(0, 0);
        List<Position> existPiecePositions = Collections.singletonList(Position.of(0, 5));
        boolean iterable = true;

        List<Position> movablePositions = availableDirections.movablePositions(
            existPiecePositions,
            currentPosition,
            iterable
        );

        Assertions.assertThat(movablePositions).hasSameElementsAs(expectedMovablePositions);
    }

    @Test
    @DisplayName("딱 한 번만 위로 올라갈 수 있는 말의 움직일 수 있는 자리를 테스트")
    void movablePositions_notIterable() {
        List<Position> expectedMovablePositions = Collections.singletonList(Position.of(0, 1));

        AvailableDirections availableDirections = new AvailableDirections(
            Collections.singletonList(PieceDirection.UP),
            Collections.singletonList(PieceDirection.UP)
        );

        Position currentPosition = Position.of(0, 0);
        List<Position> existPiecePositions = Collections.singletonList(Position.of(0, 5));
        boolean iterable = false;

        List<Position> movablePositions = availableDirections.movablePositions(
            existPiecePositions,
            currentPosition,
            iterable
        );

        Assertions.assertThat(movablePositions).hasSameElementsAs(expectedMovablePositions);
    }

    @Test
    @DisplayName("계속해서 위로 올라갈 수 있는 말의 죽일 수 있는 자리를 테스트")
    void killablePositions_iterable() {
        List<Position> expectedMovablePositions = Collections.singletonList(Position.of(0, 5));

        AvailableDirections availableDirections = new AvailableDirections(
            Collections.singletonList(PieceDirection.UP),
            Collections.singletonList(PieceDirection.UP)
        );

        Position currentPosition = Position.of(0, 0);
        List<Position> existPiecePositions = Collections.singletonList(Position.of(0, 5));
        boolean iterable = true;

        List<Position> movablePositions = availableDirections.killablePositions(
            existPiecePositions,
            currentPosition,
            iterable
        );

        Assertions.assertThat(movablePositions).hasSameElementsAs(expectedMovablePositions);
    }

    @Test
    @DisplayName("딱 한 번만 위로 올라갈 수 있는 말의 죽일 수 있는 자리를 테스트")
    void killablePositions_notIterable() {
        List<Position> expectedMovablePositions = Collections.emptyList();

        AvailableDirections availableDirections = new AvailableDirections(
            Collections.singletonList(PieceDirection.UP),
            Collections.singletonList(PieceDirection.UP)
        );

        Position currentPosition = Position.of(0, 0);
        List<Position> existPiecePositions = Collections.singletonList(Position.of(0, 5));
        boolean iterable = false;

        List<Position> movablePositions = availableDirections.killablePositions(
            existPiecePositions,
            currentPosition,
            iterable
        );

        Assertions.assertThat(movablePositions).hasSameElementsAs(expectedMovablePositions);
    }


}