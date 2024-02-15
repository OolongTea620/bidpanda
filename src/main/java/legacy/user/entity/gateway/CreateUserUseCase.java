package legacy.user.entity.gateway;

import legacy.user.entity.model.User;
import legacy.user.infrastructure.dto.CreateUserUseCaseDto;

public interface CreateUserUseCase {

  User create(CreateUserUseCaseDto createUserUseCaseDto);

}
