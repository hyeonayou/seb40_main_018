
package project.danim.likes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.danim.diary.domain.Diary;
import project.danim.diary.repository.DiaryRepository;
import project.danim.likes.domain.Likes;
import project.danim.likes.repository.LikesRepository;
import project.danim.member.domain.Member;

import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
@Service
public class LikesService {

    private final LikesRepository likesRepository;
    private final DiaryRepository diaryRepository;

    public LikesService(LikesRepository likesRepository, DiaryRepository diaryRepository){
        this.likesRepository = likesRepository;
        this.diaryRepository = diaryRepository;
    }

    public boolean addLike(Member member, Long diaryId){
        Diary diary = diaryRepository.findById(diaryId).orElseThrow();

        if(isNotAlreadyLike(member,diary)) {
            likesRepository.save(new Likes(member,diary));
            return true;
        }
        else {
            likesRepository.delete(findLikes(diary,member));
        }
        return false;
    }



    public boolean isNotAlreadyLike(Member member, Diary diary) {
        return likesRepository.findByMemberAndDiary(member, diary).isEmpty();
    }

    public Likes findLikes(Diary diary, Member member){
        return likesRepository.findByMemberAndDiary(member,diary).orElse(null);
    }

}


    //@Transactional(readOnly = true)

