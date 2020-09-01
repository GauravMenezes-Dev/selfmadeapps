package com.selfmadeapps.dailyneedsclone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selfmadeapps.dailyneedsclone.entity.UserEntity;
import com.selfmadeapps.dailyneedsclone.repo.UserRepo;
import com.selfmadeapps.dailyneedsclone.shared.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	UserRepo uRepo;
	ModelMapper mMap;
	Pbkdf2Service pbdf;

	@Autowired
	public UserServiceImpl(UserRepo uRepo, ModelMapper mMap, Pbkdf2Service pbdf) {
		this.uRepo = uRepo;
		this.mMap = mMap;
		this.pbdf = pbdf;
	}
	
	@Override
	public UserDTO createUser(UserDTO uDetail) {
		uDetail.setEncPass(pbdf.encodeIt(uDetail.getPassword()));
		uDetail.setRole("ADMIN");
		UserEntity uEnt = mMap.map(uDetail, UserEntity.class);
		UserEntity created = uRepo.save(uEnt);
		System.out.println(created);
		return mMap.map(created, UserDTO.class);
	}

	@Override
	public UserDTO checkUserCreds(UserDTO loginReq) {
		UserEntity uEnt = uRepo.findByUsername(loginReq.getUsername());
		return ((uEnt != null) && (pbdf.compare(loginReq.getPassword(), uEnt.getEncPass()))? mMap.map(uEnt, UserDTO.class): null);
	}

}
