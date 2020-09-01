package com.selfmadeapps.dailyneedsclone.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.selfmadeapps.dailyneedsclone.entity.UserEntity;

public interface UserRepo extends MongoRepository<UserEntity, String> {
	UserEntity findByUsername(String username);
}
