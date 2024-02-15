package legacy.user.entity.exception;

public class UnAuthorizedUserException extends RuntimeException {

  public UnAuthorizedUserException() {
    super("유효하지 않은 유저입니다");
  }
}
