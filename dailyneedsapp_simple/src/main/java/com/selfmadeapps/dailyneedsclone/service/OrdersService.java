package com.selfmadeapps.dailyneedsclone.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.selfmadeapps.dailyneedsclone.entity.ItemEntity;
import com.selfmadeapps.dailyneedsclone.entity.OrderEntity;
import com.selfmadeapps.dailyneedsclone.model.BillModel;
import com.selfmadeapps.dailyneedsclone.repo.OrdersRepo;

@Service
public class OrdersService {

	private OrdersRepo oRepo;

	@Autowired
	public OrdersService(OrdersRepo oRepo) {
		this.oRepo = oRepo;
	}

	public OrderEntity createOrder(OrderEntity oEnt) {
		return oRepo.save(oEnt);
	}

	public List<OrderEntity> getAllOrders(String username) {
		List<OrderEntity> orderList = oRepo.findByUsername(username);
		Collections.sort(orderList, Collections.reverseOrder());
		return orderList;
	}

	public BillModel getBill(String username) throws Exception {
		List<OrderEntity> orderList = oRepo.getUnpaidOrders(username, false);
		BillModel bill = new BillModel();
		bill.setUsername(username);
		double total = 0.0;
		Map<String, Integer> itemMap = new HashMap<>();
		for (OrderEntity oEnt : orderList) {
			if (!oEnt.isPaid()) {
				for (ItemEntity item : oEnt.getItems()) {
					int qty = oEnt.getQtys().get(oEnt.getItems().indexOf(item));
					if (itemMap.containsKey(item.getItem_name())) {
						itemMap.replace(item.getItem_name(), itemMap.get(item.getItem_name()) + qty);
					} else {
						itemMap.put(item.getItem_name(), qty);
					}
					total += item.getPrice() * qty;
				}
			}
		}
		bill.setItemsOrdered(itemMap);
		bill.setTotal(total);
		System.out.println(bill);
		return bill;
	}

	public OrderEntity markAsPaid(String orderId, boolean status) {
		Optional<OrderEntity> oEntOpt = oRepo.findById(orderId);
		System.out.println(orderId+" , "+status);
		if(oEntOpt.isPresent()) {
			OrderEntity oEnt = oEntOpt.get();
			oEnt.setPaid(status);
			return oRepo.save(oEnt);
		}
		else {
			return null;
		}
	}

}
