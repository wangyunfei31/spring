package com.luban.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author 12803
 * @Date 2020/7/9 14:52
 */
@Repository
public class UserDao implements  Dao{
	@Override
	public void query() {
		System.out.println("用户查询");
	}
}
