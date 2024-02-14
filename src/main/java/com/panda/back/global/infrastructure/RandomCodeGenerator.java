package com.panda.back.global.infrastructure;

import com.panda.back.global.usercase.port.RandomCodeHolder;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomCodeGenerator implements RandomCodeHolder {

  // Bean으로 수동 주입함
  private final Random random;

  @Override
  public String generateRandomCode() {
    return String.valueOf(random.nextInt(888888) + 111111);// 범위 : 111111 ~ 999999
  }
}
