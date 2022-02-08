package com.study.Spring.case04.mvc.dao;

import java.util.List;
import java.util.Optional;

import com.study.Spring.case04.mvc.entity.User;

public interface UserDao {
	void add(User user); // 新增
	void update(User user); // 修改
	void delete(String name); // 刪除
	List<User> queryUsers(); // 查詢
	Optional<User> getUser(String name); 
}

