package com.santanatextiles.exp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.exp.domain.ItemTrackOS;

@Repository
public interface ItemTrackOSRepository extends JpaRepository<ItemTrackOS , Double> {
	
	@Transactional
	ItemTrackOS findByIdSGS(Double idsgs);
	
}
