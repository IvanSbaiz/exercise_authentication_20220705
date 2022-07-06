package repository;

import dataobject.User;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import utils.Role;

public class UserRepository implements IUserRepository {

  private final Map<String, User> database;

  public UserRepository() {
    this.database = new HashMap<>();
    User user = new User("", "", "", "admin", "password", Role.ADMIN);
    database.put(user.getUsername(), user);
  }

  @Override
  public Optional<User> findUserByUsernameAndPassword(String username, String password) {
    return Optional.empty();
  }

  @Override
  public User insert(User user) {
    return null;
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public Collection<User> findAll() {
    return database.values();
  }
}
