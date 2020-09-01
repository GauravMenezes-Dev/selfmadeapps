package com.selfmadeapps.dailyneedsclone.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.selfmadeapps.dailyneedsclone.entity.OrderEntity;

public interface OrdersRepo extends MongoRepository<OrderEntity, String>{
	
	@Query(value = "{'username':'?0'}", sort = "{'orderDate': -1}")
	List<OrderEntity> findByUsername(String username);
	
	List<OrderEntity> findAll(Sort s);

	@Query(value = "{'username': '?0', 'paid': ?1}", sort = "{'orderDate': -1}")
	List<OrderEntity> getUnpaidOrders(String username, boolean b);
}
