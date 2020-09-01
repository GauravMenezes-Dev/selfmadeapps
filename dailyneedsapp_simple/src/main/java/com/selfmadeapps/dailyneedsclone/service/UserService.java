package com.selfmadeapps.dailyneedsclone.service;

import com.selfmadeapps.dailyneedsclone.shared.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO uDetail);

	UserDTO checkUserCreds(UserDTO uCheck);
}
