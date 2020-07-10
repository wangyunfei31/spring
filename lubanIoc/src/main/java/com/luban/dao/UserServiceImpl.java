package com.luban.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 12803
 * @Date 2020/7/9 20:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private Dao dao;
	@Override
	public void query() {
		dao.query();
	}

	@Override
	public String queryByName(String name) {
		return dao.queryByName(name);
	}
}
