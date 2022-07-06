package services;

import dataobject.User;
import exceptions.ForbiddenOperationException;
import exceptions.UsernameAlreadyExistsException;
import java.util.Collection;
import java.util.Optional;
import repository.IUserRepository;
import utils.Role;

public class UserService {

  private final IUserRepository userRepository;

  public UserService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createStandardUser(User authenticatedUser, String name, String surname, String birthDate, String username,
      String password) throws ForbiddenOperationException {
    validateAdminOperation(authenticatedUser);
    return new User(name, surname, birthDate, username, password, Role.STANDARD);
  }

  private void validateAdminOperation(User authenticatedUser) throws ForbiddenOperationException {
    if (!authenticatedUser.getRole().equals(Role.ADMIN)) {
      throw new ForbiddenOperationException();
    }
  }

  public User createAdminUser(User authenticatedUser, String name, String surname, String birthDate, String username,
      String password) throws ForbiddenOperationException {
    validateAdminOperation(authenticatedUser);
    return new User(name, surname, birthDate, username, password, Role.ADMIN);
  }

  public Collection<User> findAllUsers() {
    return userRepository.findAll();
  }

  public User insert(User authenticatedUser, User user)
      throws ForbiddenOperationException, UsernameAlreadyExistsException {
    validateAdminOperation(authenticatedUser);
    return userRepository.insert(user);
  }

  public User updateRole(User authenticatedUser, User user, Role newRole) throws ForbiddenOperationException {
    validateAdminOperation(authenticatedUser);
    user.setRole(newRole);
    return userRepository.update(user);
  }

  public Optional<User> authenticate(String username, String password) {
    return userRepository.findUserByUsernameAndPassword(username, password);
  }



}
