package legacy.user.entity.gateway;

import legacy.user.entity.model.User;
import legacy.user.infrastructure.dto.DeleteUserDto;
import legacy.user.infrastructure.dto.UpdateNickReqDto;

public interface UserUseCase {

  User updateNickname(UpdateNickReqDto updateNickReqDto);

  User delete(DeleteUserDto deleteUserDto);
}
