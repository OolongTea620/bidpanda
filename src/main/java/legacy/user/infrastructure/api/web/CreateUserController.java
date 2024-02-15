package legacy.user.infrastructure.api.web;

import legacy.user.entity.gateway.CreateUserUseCase;
import legacy.user.entity.model.User;
import legacy.user.infrastructure.dto.CreateUserReqDto;
import legacy.user.infrastructure.dto.CreateUserResDto;
import legacy.user.infrastructure.dto.CreateUserUseCaseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class CreateUserController {

  private final CreateUserUseCase createUserUseCase;

  @GetMapping("/email/{email}/")
  public ResponseEntity<?> emailAvailable(@PathVariable String email) {
    return ResponseEntity.ok().body("");
  }

  @PostMapping("/web")
  public ResponseEntity<CreateUserResDto> create(@RequestBody CreateUserReqDto createUserReqDto) {
    User user = createUserUseCase.create(CreateUserUseCaseDto.from(createUserReqDto));
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(CreateUserResDto.from(user));
  }
}
