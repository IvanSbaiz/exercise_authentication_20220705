package repository;

import dataobject.User;
import exceptions.UsernameAlreadyExistsException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements IUserRepository {

  private final Map<String, User> database;

  public UserRepository() {
    this.database = new HashMap<>();
  }

  @Override
  public Optional<User> findUserByUsernameAndPassword(String username, String password) {
    return Optional.empty();
  }

  @Override
  public User insert(User user) throws UsernameAlreadyExistsException {
    if (!database.containsKey(user.getUsername())) {
      return database.put(user.getUsername(), user);
    }
    throw new UsernameAlreadyExistsException();
  }

  @Override
  public User update(User user) {
    return database.put(user.getUsername(), user);
  }

  @Override
  public Collection<User> findAll() {
    return database.values();
  }
}
