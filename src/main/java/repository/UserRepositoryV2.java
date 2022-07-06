package repository;

import dataobject.User;
import exceptions.UsernameAlreadyExistsException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepositoryV2 implements IUserRepository {

  private final Set<User> database;

  public UserRepositoryV2() {
    this.database = new HashSet<>();
  }

  @Override
  public Optional<User> findUserByUsernameAndPassword(String username, String password) {
    for (User user : database) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return Optional.of(user);
      }
    }
    return Optional.empty();
  }

  @Override
  public User insert(User user) throws UsernameAlreadyExistsException {
    if (database.add(user)) {
      return user;
    } else {
      throw new UsernameAlreadyExistsException();
    }
  }

  @Override
  public User update(User user) {
    database.add(user);
    return user;
  }

  @Override
  public Collection<User> findAll() {
    return database;
  }
}
