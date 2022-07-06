import dataobject.User;
import exceptions.DefaultUserAlreadyCreatedException;
import java.util.Collection;
import repository.IUserRepository;
import repository.UserRepository;
import repository.UserRepositoryV2;
import services.DefaultUserService;
import services.UserService;

public class AuthenticationApp {

  private final UserService userService;
  private final IUserRepository userRepository;
  private final DefaultUserService defaultUserService;

  public AuthenticationApp() {
    this.userRepository = new UserRepositoryV2();
    this.userService = new UserService(this.userRepository);
    this.defaultUserService = new DefaultUserService(this.userRepository);
  }

  public static void main(String[] args) {
    AuthenticationApp authenticationApp = new AuthenticationApp();
    try {
      authenticationApp.defaultUserService.createDefaultUser();
      Collection<User> users = authenticationApp.userService.findAllUsers();
      System.out.println(users);
    } catch (Exception e) {

    }
  }


}
