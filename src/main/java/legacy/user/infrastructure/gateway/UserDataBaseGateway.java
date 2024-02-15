package legacy.user.infrastructure.gateway;

import legacy.user.entity.model.User;
import legacy.user.entity.model.UserStatus;
import java.util.Optional;

public interface UserDataBaseGateway {

  User save(User user);

  Optional<User> findById(Long id);

  Optional<User> findByIdAndStatus(Long id, UserStatus status);

  Optional<User> findByEmail(String email);

  Optional<User> findByEmailAndStatus(String email, UserStatus status);


}
