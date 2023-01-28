package ru.polunin.PP_3_1_2_springbootCRUD.service;



import ru.polunin.PP_3_1_2_springbootCRUD.model.User;

import java.util.List;

public interface UserService {
   void save(User user);
   List<User> findAll();
   User findById(Long id);
   void update(Long id, User user);
   void delete(Long id);
}
