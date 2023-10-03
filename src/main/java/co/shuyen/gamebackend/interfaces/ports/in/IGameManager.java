package co.shuyen.gamebackend.interfaces.ports.in;

import java.time.LocalDateTime;

public interface IGameManager {
    void CreateGame(String id, LocalDateTime createTime, double currentPrice);
}
