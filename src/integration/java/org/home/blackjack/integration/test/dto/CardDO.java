package org.home.blackjack.integration.test.dto;

import java.util.Map;

import org.home.blackjack.domain.game.core.Card;
import org.home.blackjack.domain.game.core.Card.Rank;
import org.home.blackjack.domain.game.core.Card.Suite;

import com.google.common.collect.Maps;

public class CardDO {
	
	private static Map<String, Suite> suiteMap = Maps.newHashMap();
	private static Map<String, Rank> rankMap = Maps.newHashMap();
	
	static {
		suiteMap.put("s", Suite.SPADE);
		suiteMap.put("c", Suite.CLUB);
		suiteMap.put("d", Suite.DIAMOND);
		suiteMap.put("h", Suite.HEART);
		
		rankMap.put("2", Rank.TWO);
		rankMap.put("3", Rank.THREE);
		rankMap.put("4", Rank.FOUR);
		rankMap.put("5", Rank.FIVE);
		rankMap.put("6", Rank.SIX);
		rankMap.put("7", Rank.SEVEN);
		rankMap.put("8", Rank.EIGHT);
		rankMap.put("9", Rank.NINE);
		rankMap.put("10", Rank.TEN);
		rankMap.put("J", Rank.JACK);
		rankMap.put("Q", Rank.QUEEN);
		rankMap.put("K", Rank.KING);
		rankMap.put("A", Rank.ACE);
	}
	public String cards;
	
	public Card card() {
		Suite suite = suiteMap.get(cards.charAt(1));
		Rank rank = rankMap.get(cards.charAt(0));
		return new Card(suite, rank);
	}

}
