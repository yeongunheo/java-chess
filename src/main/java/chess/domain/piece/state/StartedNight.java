package chess.domain.piece.state;

import java.util.List;

import chess.domain.ChessBoard;
import chess.domain.piece.position.Position;

public class StartedNight implements State {
    @Override
    public List<Position> getMovablePositions(Position source, ChessBoard board) {
        return null;
    }

    @Override
    public State killed() {
        return null;
    }

    @Override
    public State updateState() {
        return null;
    }
}
