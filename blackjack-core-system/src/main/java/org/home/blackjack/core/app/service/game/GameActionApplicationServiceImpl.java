package org.home.blackjack.core.app.service.game;

import javax.annotation.Resource;
import javax.inject.Named;

import org.home.blackjack.core.domain.game.Game;
import org.home.blackjack.core.domain.game.GameRepository;
import org.home.blackjack.core.domain.game.core.GameID;
import org.home.blackjack.util.locking.aspect.WithPessimisticLock;

/**
 * Driven port. App service for player action use-case.
 * 
 * The EventStore should be flushed only after the aggregate has been persisted.
 * 
 * @author Mate
 * 
 */
@Named
public class GameActionApplicationServiceImpl implements GameActionApplicationService {

    @Resource
    private GameRepository gameRepository;

    @WithPessimisticLock(repository = GameRepository.class)
    @Override
    public void handlePlayerAction(final GameID gameID, final GameAction gameAction) {

        Game game = gameRepository.find(gameAction.getGameID());
        if (gameAction.getGameActionType() == GameActionType.HIT) {
            game.playerHits(gameAction.getPlayerID());
        } else if (gameAction.getGameActionType() == GameActionType.STAND) {
            game.playerStands(gameAction.getPlayerID());
        }
        gameRepository.update(game);
    }

}
