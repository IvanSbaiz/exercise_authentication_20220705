import dataobject.User;
import java.util.Collection;
import repository.IUserRepository;
import repository.UserRepository;
import services.UserService;

public class AuthenticationApp {

  private final UserService userService;
  private final IUserRepository userRepository;

  public AuthenticationApp() {
    this.userRepository = new UserRepository();
    this.userService = new UserService(this.userRepository);
  }

  public static void main(String[] args) {
    AuthenticationApp authenticationApp = new AuthenticationApp();
    Collection<User> users = authenticationApp.userService.findAllUsers();
    System.out.println(users);
  }


}
