package com.hellojava.business;

import com.hellojava.web.entity.User;

public class UserService {
	public boolean checkUser(User user) {
		boolean bool=false;
		if(!user.getUserName().equals("")) {
			bool=true;
		}
		return bool;
	}
}
