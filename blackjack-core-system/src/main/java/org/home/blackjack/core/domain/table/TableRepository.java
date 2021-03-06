package org.home.blackjack.core.domain.table;

import java.util.List;

import org.home.blackjack.core.domain.shared.TableID;
import org.home.blackjack.util.ddd.pattern.domain.model.Repository;

public interface TableRepository extends Repository<TableID, Table> {

	Table find(TableID tableID);

	List<Table> findAll();

	void update(Table table);

	void create(Table table);

	void clear();

	boolean isEmpty();


}
