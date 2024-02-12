package com.panda.back.user.entity.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.panda.back.user.infrastructure.dto.UserCreateVo;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  public void User는_UserCreateVo_객체로_생성_할_수_있다() {
    //given
    UserCreateVo userCreateVo = UserCreateVo.builder()
        .email("test1234@gmail.com")
        .nickname("test_human")
        .password("this_is_Fake")
        .build();
    //when
    User user = User.from(userCreateVo);

    //then
    assertThat(user.getId()).isNull();
    assertThat(user.getEmail()).isEqualTo("test1234@gmail.com");
    assertThat(user.getNickname()).isEqualTo("test_human");
    assertThat(user.getPassword()).isEqualTo("this_is_Fake");
    assertThat(user.getStatus()).isEqualTo(UserStatus.ACTIVE);
    assertThat(user.getCreatedAt()).isNull();
  }
}