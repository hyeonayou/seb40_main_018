package project.danim.likes.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import project.danim.diary.domain.Diary;
import project.danim.likes.service.LikesService;
import project.danim.member.domain.Member;

import javax.validation.constraints.Positive;
import java.util.Objects;

@Api(tags = {"Likes API"})
@Slf4j
@RequestMapping("/likes")
@RestController
public class LikesController {

    private final LikesService likesService;

    public LikesController(LikesService likesService){
        this.likesService = likesService;
    }


    @GetMapping("/{diary-id}")
    public ResponseEntity getLikeMembers(@Positive @PathVariable("diary-id") long dairyId) {
        return new ResponseEntity<>(, HttpStatus.OK);
    }


    /*
    JWT를 이용한 로그인 정보 필요... .. 인증된 사용자 정보 가져요기
     */
    @ApiOperation(value = "좋아요 등록")
    @PostMapping("/{diary-id}")
    public ResponseEntity<String> addLike(@Positive @PathVariable("diary-id") long diaryId,
                                          @RequestParam("member") @Positive Member member
                                          ){

       log.info("===================좋아요 클릭=======================");
        boolean result = false;

        if (member != null) {
            result = likesService.addLike(member, diaryId);
        }

        return result ?
                new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    }

