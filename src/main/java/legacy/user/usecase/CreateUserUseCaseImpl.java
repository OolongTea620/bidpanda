package legacy.user.usecase;

import legacy.user.entity.gateway.CreateUserUseCase;
import legacy.user.entity.model.User;
import legacy.user.infrastructure.dto.CreateUserUseCaseDto;
import legacy.user.infrastructure.gateway.UserDataBaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

  private final UserDataBaseGateway userDataBaseGateway;

  @Override
  @Transactional
  public User create(CreateUserUseCaseDto createUserUseCaseDto) {
    return userDataBaseGateway.save(User.from(createUserUseCaseDto));
  }
}
