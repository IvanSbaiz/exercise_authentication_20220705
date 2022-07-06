package repository;

import dataobject.User;
import java.util.Collection;
import java.util.Optional;

public interface IUserRepository {

  Optional<User> findUserByUsernameAndPassword(String username, String password);
  User insert(User user);
  User update(User user);
  Collection<User> findAll();
}
