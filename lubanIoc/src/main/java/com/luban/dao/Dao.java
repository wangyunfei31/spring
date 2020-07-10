package com.luban.dao;

import com.luban.anno.MySelect;

public interface Dao {

	@MySelect("select * from so_main")
	public void query();

	@MySelect("select * from so_main where name = ${}")
	public String queryByName(String name);
}
