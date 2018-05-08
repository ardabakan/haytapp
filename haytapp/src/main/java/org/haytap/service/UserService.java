package org.haytap.service;

import org.haytap.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
