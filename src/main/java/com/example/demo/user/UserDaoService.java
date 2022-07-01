package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	private static List<user> users = new ArrayList<>();

	private static int usersCount = 3;
	static {
		users.add(new user(1, "Kenneth", new Date(), "pass1", "701010-1111111"));
		users.add(new user(2, "Alice", new Date(), "pass2", "801010-1111111"));
		users.add(new user(3, "Elena", new Date(), "pass3", "901010-1111111"));

	}

	public List<user> findAll() {
		return users;
	}

	public user save(user user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public user findOne(int id) {
		for (user user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public user deleteById(int id) {
		Iterator<user> iterator = users.iterator();

		while (iterator.hasNext()) {
			user user = iterator.next();

			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}

		return null;
	}
}
