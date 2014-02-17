package org.home.blackjack.domain.player;

import org.home.blackjack.domain.ValueObject;

/**
 * The score of a player playing Black Jack.
 * 
 * @author michele.sollecito
 */
public final class PlayerScore extends ValueObject {

	private final int wonGamesCount;

	protected PlayerScore increment() {

		return new PlayerScore(wonGamesCount + 1);
	}

	protected PlayerScore() {

		this.wonGamesCount = 0;
	}

	private PlayerScore(final int wonGamesCount) {

		this.wonGamesCount = wonGamesCount;
	}

	public int wonGamesCount() {

		return wonGamesCount;
	}
}
