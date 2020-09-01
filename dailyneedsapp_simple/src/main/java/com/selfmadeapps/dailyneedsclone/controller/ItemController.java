package com.selfmadeapps.dailyneedsclone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selfmadeapps.dailyneedsclone.entity.ItemEntity;
import com.selfmadeapps.dailyneedsclone.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController{

	private ItemService iServ;
	
	public ItemController(ItemService iServ) {
		this.iServ = iServ;
	}
	
	@PostMapping(
			path = "/addItem",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
						}, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
					 }
			)
	public ResponseEntity<ItemEntity> addItem(@RequestBody ItemEntity item){
		ItemEntity addedItem = iServ.addItem(item);
		if(addedItem != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(item);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(item);
		}
	}
	
	@GetMapping("/allItems")
	public ResponseEntity<List<ItemEntity>> getAllItems(){
		List<ItemEntity> itemList = iServ.getAllItems();
		return ResponseEntity.status(HttpStatus.OK).body(itemList);
	}
}
