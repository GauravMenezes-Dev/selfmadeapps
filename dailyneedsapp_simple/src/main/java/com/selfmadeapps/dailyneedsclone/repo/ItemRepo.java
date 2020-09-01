package com.selfmadeapps.dailyneedsclone.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.selfmadeapps.dailyneedsclone.entity.ItemEntity;

public interface ItemRepo extends MongoRepository<ItemEntity, String> {
	
	@Query("{'item_name': '?0'}")
	ItemEntity findByItemName(String itemName);
	
	List<ItemEntity> findAll();
}
