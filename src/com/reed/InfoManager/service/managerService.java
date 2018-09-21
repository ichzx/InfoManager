package com.reed.InfoManager.service;

import com.reed.InfoManager.dao.managerDao;
import com.reed.InfoManager.model.User;

import java.util.List;

public class managerService {

  managerDao dao = new managerDao();

  public int add(User user){
      return dao.add(user);
  }

  public int delete(int id){
      return dao.delete(id);
  }

  public List<User> search(String username, String address, String phone){
      return dao.search(username, address, phone);
  }

  public int update(User user){
      return dao.update(user);
  }

  public User get(int id){
      return dao.get(id);
  }

  public List<User> getAll(){
      return dao.getAll();
  }

  public int getCount(String username){
      return dao.getCount(username);
  }

  public User login(String username, String password){
      return dao.login(username, password);
  }
}
