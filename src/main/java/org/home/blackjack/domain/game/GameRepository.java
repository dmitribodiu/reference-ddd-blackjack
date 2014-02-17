package org.home.blackjack.domain.game;

import org.home.blackjack.domain.game.core.GameId;
import org.home.blackjack.util.marker.hexagonal.DrivingPort;

public interface GameRepository extends DrivingPort {

	Game find(GameId gameId);

	void update(Game game);

}
