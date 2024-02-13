package com.panda.back.user.entity.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.panda.back.user.infrastructure.dto.CreateUserUseCaseDto;
import com.panda.back.user.infrastructure.dto.DeleteUserDto;
import com.panda.back.user.infrastructure.dto.UpdateNickReqDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  public void User는_UserCreateUseCaseDto_객체로_생성_할_수_있다() {
    //given
    CreateUserUseCaseDto createUserUseCaseDto = CreateUserUseCaseDto.builder()
        .email("test1234@gmail.com")
        .nickname("test_human")
        .password("this_is_Fake")
        .build();
    //when
    User user = User.from(createUserUseCaseDto);

    //then
    assertThat(user.getId()).isNull();
    assertThat(user.getEmail()).isEqualTo("test1234@gmail.com");
    assertThat(user.getNickname()).isEqualTo("test_human");
    assertThat(user.getPassword()).isEqualTo("this_is_Fake");
    assertThat(user.getStatus()).isEqualTo(UserStatus.ACTIVE);
    assertThat(user.getCreatedAt()).isNull();
  }

  @Test
  public void User는_UpdateNickReqDto로_nickname을_수정_할_수_있다() {
    //given
    User user = User.builder()
        .id(1L)
        .email("test1234@gmail.com")
        .nickname("testNick")
        .password("this is test")
        .status(UserStatus.ACTIVE)
        .createdAt(LocalDateTime.of(2024, 2, 12, 12, 30))
        .build();

    UpdateNickReqDto updateNickReqDto = UpdateNickReqDto.builder()
        .nickname("changedNick")
        .build();

    //when
    user = user.updateNickname(updateNickReqDto);

    //then
    assertThat(user.getId()).isEqualTo(1);
    assertThat(user.getEmail()).isEqualTo("test1234@gmail.com");
    assertThat(user.getNickname()).isEqualTo("changedNick");
    assertThat(user.getPassword()).isEqualTo("this is test");
    assertThat(user.getStatus()).isEqualTo(UserStatus.ACTIVE);
    assertThat(user.getCreatedAt()).isEqualTo(LocalDateTime.of(2024, 2, 12, 12, 30));
  }

  @Test
  public void User는_DeleteUserDto로_가입을_취소_할_수있다() {
    //given
    User user = User.builder()
        .id(1L)
        .email("test1234@gmail.com")
        .nickname("testNick")
        .password("this is test")
        .status(UserStatus.ACTIVE)
        .createdAt(LocalDateTime.of(2024, 2, 12, 12, 30))
        .build();

    DeleteUserDto deleteUserDto = DeleteUserDto.builder()
        .id(1L)
        .email("test1234@gmail.com")
        .build();
    //when
    user = user.cancel(deleteUserDto);
    assertThat(user.getId()).isEqualTo(1);
    assertThat(user.getEmail()).isEqualTo("test1234@gmail.com");
    assertThat(user.getNickname()).isEqualTo("testNick");
    assertThat(user.getPassword()).isEqualTo("this is test");
    assertThat(user.getStatus()).isEqualTo(UserStatus.INACTIVE);
    assertThat(user.getCreatedAt()).isEqualTo(LocalDateTime.of(2024, 2, 12, 12, 30));
  }
}