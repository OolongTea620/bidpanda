package com.panda.back.domain.bid.controller;

import com.panda.back.domain.bid.dto.BidRequestDto;
import com.panda.back.domain.bid.service.BidService;
import com.panda.back.domain.member.jwt.MemberDetailsImpl;
import com.panda.back.global.dto.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bids")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;
    @PostMapping
    public BaseResponse createBid(
            @RequestBody BidRequestDto bidRequestDto,
            @AuthenticationPrincipal MemberDetailsImpl memberDetails) {
        return bidService.createBid(bidRequestDto, memberDetails.getMember());

    }

}