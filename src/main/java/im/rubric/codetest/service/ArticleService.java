package im.rubric.codetest.service;


import im.rubric.codetest.dto.ArticleDto;
import im.rubric.codetest.entity.Article;
import im.rubric.codetest.entity.Member;
import im.rubric.codetest.repository.jpa.ArticleRepository;
import im.rubric.codetest.repository.jpa.MemberRepository;
import im.rubric.codetest.repository.jpa.ReplyRepository;
import im.rubric.codetest.repository.mybatis.ArticleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/** Article 관련 로직을 처리하는 서비스 */
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final ReplyRepository replyRepository;
    private final ArticleDao articleDao;

    /**
     * 페이지 단위로 검색하는 기능
     * @param pageable 검색할 페이지의 정보
     * @return 검색할 대상의 Page 정보
     */
    public Page<ArticleDto.View> findPage(Pageable pageable) {
        // return null 을 지운 후 구현하면 됩니다
        return null;
    }

    /**
     단일 검색을 위한 기능

     @param id 검색할 대상의 id
     @return 검색된 대상
     */
    public Optional<Article> findOne(Long id) {
        Optional<Article> article1 = articleRepository.findById(id);
        if(article1.isEmpty()){
            throw new RuntimeException("없는 게시물 입니다.");
        }

        return article1;
    }

    /**
     객체 생성을 위한 기능

     @param dto 생성할 내용을 담은 객체
     @param userId 작성자 식별자
     @return 생성된 객체의 정보
     */
    public Article create(ArticleDto.Command dto, Long userId) {
        Optional<Member> user = memberRepository.findById(userId);
        String writerName = user.get().getUsername();
        if(user.isEmpty()){
            throw new RuntimeException("등록되지 않은 회원임");
        }
        Article article = Article.builder()
            .title(dto.getTitle())
            .contents(dto.getContents())
            .writer(memberRepository.findByUsername(writerName))
            .build();
        return article;
    }

    /**
     객체 수정을 위한 기능

     @param id 수정할 대상의 id
     @param dto 수정할 내용을 담은 객체
     @param userId 작성자 식별자
     @return 수정된 객체의 정보
     */
    public Optional<Article> update(Long id, ArticleDto.Command dto, Long userId) {
        Optional<Article> updateArticle = articleRepository.findById(id);
        Long writerId = updateArticle.get().getWriter().getId();
        if(userId==writerId){
           Article article = updateArticle.get();
           article.changeTitle(dto.getTitle());
           article.changeContents(dto.getContents());
        }else{
            throw new RuntimeException("회원정보가 일치하지 않음");
        }
        return updateArticle;
    }

    /**
     * 객체 삭제를 위한 기능
     * @param id 삭제할 대상의 id
     * @param userId 삭제 요청한 유저의 식별자 정보
     */
    public void delete(Long id, Long userId) {
        Optional<Member> member= memberRepository.findById(id);
        if(member.get().getId()==userId){
            memberRepository.deleteById(id);
        }else{
            throw new RuntimeException();
        }

    }

}
