package com.study.Spring.case04.mvc.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.study.Spring.case04.mvc.entity.User;

@Component
public class UserDB implements Serializable{ 
	private static final long serialVersionUID = 1L; 
	
	private List<User> users; 
	{
		
	}
	
	// 新增
	public void save(User user) { 	
		if(users == null) { 
			users = new ArrayList<>();
		}
		users.add(user);
		DBUtil.writeJsonFile(this);
	}
	
	// update 方法
	public void update(String name, int age) {
		if(users == null || users.size() == 0) {
			System.out.println("修改失敗: 資料庫不存在或無資料");
			return; 
		}
		Optional<User> opt = get(name);
		if(opt.isPresent()) { // 是否有找到
			User user = opt.get();
			user.setAge(age); 
			DBUtil.writeJsonFile(this);
			System.out.println("修改成功");
		} else { 
			System.out.println("修改失敗: 找不到此人");
		}
	}
	
	public Optional<User> get(String name) { 
		Optional<User> opt = users.stream().filter(u -> u.getName().equals(name)).findFirst();
		return opt; 
	}
	
	// 刪除
	public void delete(String name) {

		Optional<User> opt = get(name);
		if(opt.isPresent()) { 
			User user = opt.get();
			users.remove(user); 
			DBUtil.writeJsonFile(this); 
			System.out.println("刪除成功");
		} else { 
			System.out.println("修改失敗: 找不到此人");
		}		
	}
	
	public List<User> queryAll(){ // 查詢所有
		return users;
	}
	
	// 測試 1
	public static void main(String[] args) { 
		UserDB userDB = DBUtil.readJsonFile(); 
		userDB.save(new User("Bobo", 15));
		// userDB.update("Bobo", 30);
		// userDB.delete("Bobo");
		System.out.println(userDB.users);
	}
}

 



















