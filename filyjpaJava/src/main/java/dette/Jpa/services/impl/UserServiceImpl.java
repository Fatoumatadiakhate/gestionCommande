package dette.Jpa.services.impl;

import java.util.List;

import dette.Jpa.data.entities.User;
import dette.Jpa.data.repository.UserRepository;
import dette.Jpa.services.UserService;

public class UserServiceImpl implements UserService {
  // Couplage Faible
  private UserRepository userRepository;

  // Injection de Dependance
  // Constructeur

  // Setters

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(User user) {
    userRepository.insert(user);
  }

  @Override
  public List<User> findAllUser() {
    return userRepository.selectAll();
  }

}
