package services;

import dataobject.User;
import exceptions.DefaultUserAlreadyCreatedException;
import exceptions.UsernameAlreadyExistsException;
import repository.IUserRepository;
import utils.Role;

public class DefaultUserService {

  private static boolean isAlreadyCreated = false;

  private final IUserRepository userRepository;

  public DefaultUserService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createDefaultUser()
      throws DefaultUserAlreadyCreatedException, UsernameAlreadyExistsException {
    User user = new User("admin", "admin", "", "admin", "password", Role.ADMIN);
    if (!isAlreadyCreated) {
      isAlreadyCreated = true;
      return userRepository.insert(user);
    } else {
      throw new DefaultUserAlreadyCreatedException();
    }
  }

}
