package dataobject;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import utils.Role;

@Getter
@Setter
public class User {

  private final String name;
  private final String surname;
  private final String birthDate;
  private final String username;
  private final String password;
  private Role role;
  private final LocalDate creationDate;

  public User(String name, String surname, String birthDate, String username,
      String password, Role role) {
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.username = username;
    this.password = password;
    this.role = role;
    this.creationDate = LocalDate.now();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof User) {
      User objUser = (User) obj;
      return objUser.getUsername().equals(this.username) &&
          objUser.getName().equals(this.name) &&
          objUser.getSurname().equals(this.surname);
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "\t- { " + this.name + " - " + this.surname + " }";
  }

}
