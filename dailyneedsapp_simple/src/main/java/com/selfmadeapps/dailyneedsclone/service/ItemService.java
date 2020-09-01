package com.selfmadeapps.dailyneedsclone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selfmadeapps.dailyneedsclone.entity.ItemEntity;
import com.selfmadeapps.dailyneedsclone.repo.ItemRepo;

@Service
public class ItemService {
	
	private ItemRepo iRepo;

	@Autowired
	public ItemService(ItemRepo iRepo) {
		this.iRepo = iRepo;
	}

	public ItemEntity addItem(ItemEntity item) {
		return iRepo.save(item);
	}
	
	public List<ItemEntity> getAllItems() {
		return iRepo.findAll();
	}
}
