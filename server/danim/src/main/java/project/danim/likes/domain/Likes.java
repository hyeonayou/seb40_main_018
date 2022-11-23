package project.danim.likes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.danim.diary.domain.Diary;
import project.danim.member.domain.Member;

import javax.persistence.*;
import javax.validation.constraints.Positive;



@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "LIKES")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Likes_ID;




    @ManyToOne   // (1)
    @JoinColumn(name = "MEMBER_ID", nullable = false )  // (2)
    private Member member;


    @ManyToOne
    @JoinColumn(name = "Diary_ID" , nullable = false)
    private Diary diary;


    public Likes(Member member, Diary diary){
        this.diary = diary;
        this.member = member;
    }

}
