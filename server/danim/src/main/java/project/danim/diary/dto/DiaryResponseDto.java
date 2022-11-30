package project.danim.diary.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class DiaryResponseDto {
    private long diaryId;
    private String title;
    private String content;
    private String weather;
    private String area;
    private int cost;
    private long memberId;
    private long likeCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDate travelDate;
}
