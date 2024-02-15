package legacy.user.infrastructure.db.jpa;

import legacy.user.entity.model.User;
import legacy.user.entity.model.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "users")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String password;
  private String nickname;
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private UserStatus status;
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createdAt;

  public static UserJpaEntity fromModel(User user) {
    UserJpaEntity userJpaEntity = new UserJpaEntity();
    userJpaEntity.id = user.getId();
    userJpaEntity.email = user.getEmail();
    userJpaEntity.nickname = user.getNickname();
    userJpaEntity.password = user.getPassword();
    userJpaEntity.status = user.getStatus();
    return userJpaEntity;
  }

  public User toModel() {
    return User.builder()
        .id(id)
        .email(email)
        .password(password)
        .nickname(nickname)
        .status(status)
        .createdAt(createdAt)
        .build();
  }
}
