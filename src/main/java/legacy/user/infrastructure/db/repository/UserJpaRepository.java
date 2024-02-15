package legacy.user.infrastructure.db.repository;


import legacy.user.entity.model.UserStatus;
import legacy.user.infrastructure.db.jpa.UserJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

  Optional<UserJpaEntity> findByIdAndStatus(Long id, UserStatus status);

  Optional<UserJpaEntity> findByEmailAndStatus(String email, UserStatus status);

  Optional<UserJpaEntity> findByEmail(String email);
}
