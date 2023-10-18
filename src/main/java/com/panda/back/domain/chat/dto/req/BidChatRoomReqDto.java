package com.panda.back.domain.chat.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.panda.back.domain.chat.type.UserType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BidChatRoomReqDto {
    @Getter
    public static class Get{
        @Schema(name = "user", type = "String", nullable = false, description = "")
        private String user;
        public Get(String user) {
            this.user = user;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Open {
        @Schema(type = "Number", nullable = false, description = "아이템 아이디", example="1")
        @JsonProperty("item_id")
        private Long itemId;
        public Open(Long itemId) {
            this.itemId = itemId;
        }
    }
}
