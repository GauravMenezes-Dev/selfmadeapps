package com.selfmadeapps.dailyneedsclone.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selfmadeapps.dailyneedsclone.model.CreateUserRequestModel;
import com.selfmadeapps.dailyneedsclone.model.CreateUserResponseModel;
import com.selfmadeapps.dailyneedsclone.model.LoginRequestModel;
import com.selfmadeapps.dailyneedsclone.service.UserService;
import com.selfmadeapps.dailyneedsclone.shared.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

	private ModelMapper mMap;
	
	private UserService uServ;
	
	@Autowired
	public UserController(ModelMapper mMap, UserService uServ) {
		this.mMap = mMap;
		this.uServ = uServ;
	}
	
	@GetMapping("/check")
	public String check() {
		return "Test URL Worked";
	}

	@PostMapping(
			path = "/register",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
						}, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE 
					 }
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel uCreate) {
		UserDTO uDTO = mMap.map(uCreate, UserDTO.class);
		UserDTO created = uServ.createUser(uDTO);
		CreateUserResponseModel crm = mMap.map(created, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(crm);
	}
	
	@PostMapping("/login")
	public ResponseEntity<CreateUserResponseModel> login(@RequestBody LoginRequestModel loginReq){
		UserDTO uCheck = mMap.map(loginReq, UserDTO.class);
		UserDTO resp = uServ.checkUserCreds(uCheck);
		if(resp == null)
		{
			resp = new UserDTO();
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mMap.map(resp, CreateUserResponseModel.class));
		}
		else
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(mMap.map(resp, CreateUserResponseModel.class));
	}
	
}
