package com.panda.back.domain.notification.controller;

import com.panda.back.domain.job.dto.AuctionEndEvent;
import com.panda.back.domain.member.jwt.MemberDetailsImpl;
import com.panda.back.domain.notification.dto.NotificationResponseDto;
import com.panda.back.domain.notification.service.NotifyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotifyService notifyService;
    // MIME TYPE - text/event-stream 형태로 받아야함.
    // 클라이어트로부터 오는 알림 구독 요청을 받는다.
    // 로그인한 유저는 SSE 연결
    // lAST_EVENT_ID = 이전에 받지 못한 이벤트가 존재하는 경우 [ SSE 시간 만료 혹은 종료 ]
    // 전달받은 마지막 ID 값을 넘겨 그 이후의 데이터[ 받지 못한 데이터 ]부터 받을 수 있게 한다

    @Operation(summary = "사용자 SSE 연결 API")
    @GetMapping(value = "/subscribe", produces = "text/event-stream")
    public SseEmitter sseConnect(@AuthenticationPrincipal MemberDetailsImpl memberDetails,
                                 @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId,
                                 HttpServletResponse response) {
        return notifyService.subscribeAlarm(memberDetails.getUsername(), lastEventId, response);
    }

    @Operation(summary = "전체 알림 조회 API")
    @GetMapping
    public List<NotificationResponseDto> getNotifications(@AuthenticationPrincipal MemberDetailsImpl memberDetails) {
        return notifyService.getNotifications(memberDetails.getMember());
    }

    @Operation(summary = "단일 알림 조회 시 읽음 처리 API")
    @PutMapping("/{notificationId}")
    public NotificationResponseDto readNotification(@AuthenticationPrincipal MemberDetailsImpl memberDetails,
                                 @PathVariable Long notificationId) {
        return notifyService.readNotification(memberDetails.getMember(), notificationId);
    }

}
