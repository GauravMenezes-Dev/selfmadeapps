package com.selfmadeapps.dailyneedsclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selfmadeapps.dailyneedsclone.entity.OrderEntity;
import com.selfmadeapps.dailyneedsclone.entity.UserEntity;
import com.selfmadeapps.dailyneedsclone.model.BillModel;
import com.selfmadeapps.dailyneedsclone.model.MarkOrderAsPaidModel;
import com.selfmadeapps.dailyneedsclone.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrderController{
	
	private OrdersService oServ;

	@Autowired
	public OrderController(OrdersService oServ) {
		this.oServ = oServ;
	}
	
	@PostMapping(
			path = "/createOrder",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
						}, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
					 }
			)
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity oEnt)
	{
		System.out.println(oEnt);
		OrderEntity createdOrder = oServ.createOrder(oEnt);
		if(createdOrder == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(oEnt);
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(oEnt);
		}
	}
	
	@GetMapping("/allOrdersForUser")
	public ResponseEntity<List<OrderEntity>> allOrders(@RequestBody UserEntity user) 
	{
		List<OrderEntity> orderList = oServ.getAllOrders(user.getUsername());
		return ResponseEntity.status(HttpStatus.OK).body(orderList);
	}
	
	@GetMapping("/billForUser")
	public ResponseEntity<BillModel> billedAmount(@RequestBody UserEntity user) throws Exception{
		BillModel bill = oServ.getBill(user.getUsername());
		if(bill != null)
			return ResponseEntity.status(HttpStatus.OK).body(bill);
		else
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new BillModel());
	}
	
	@PostMapping(
			path = "/setPayStatus",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
						}, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
					 })
	public ResponseEntity<OrderEntity> markStatusOfOrder(@RequestBody MarkOrderAsPaidModel oEnt){
		System.out.println(oEnt);
		OrderEntity markedAsPaid = oServ.markAsPaid(oEnt.getId(), oEnt.isPaid());
		if(markedAsPaid == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new OrderEntity());
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(markedAsPaid);
		}
	}
}
