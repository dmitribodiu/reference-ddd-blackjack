package org.home.blackjack.core.infrastructure.persistence.shared;

public interface PersistenceStore<DOMAIN, PO extends PersistenceObject<DOMAIN>, POID extends PersistenceObjectId> {
	
	<PA extends PersistenceAssembler<DOMAIN, PO>> PA  assembler();
	PO find(POID id);
	void update(PO po);
	void create(PO po);
	void clear();
}