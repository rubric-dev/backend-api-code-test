package im.rubric.codetest.service;


import im.rubric.codetest.dto.ArticleDto;
import im.rubric.codetest.dto.io.CommonResponse;
import im.rubric.codetest.entity.Article;
import im.rubric.codetest.entity.Member;
import im.rubric.codetest.entity.Reply;
import im.rubric.codetest.repository.jpa.ArticleRepository;
import im.rubric.codetest.repository.jpa.MemberRepository;
import im.rubric.codetest.repository.jpa.ReplyRepository;
import im.rubric.codetest.repository.mybatis.ArticleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/** Article 관련 로직을 처리하는 서비스 */
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleDao articleDao;
    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;

    /**
     * 페이지 단위로 검색하는 기능
     * @param pageable 검색할 페이지의 정보
     * @return 검색할 대상의 Page 정보
     */
    public Page<ArticleDto.View> findPage(Pageable pageable) {
        Page<Article> entity = articleRepository.findAll(pageable);
        Page<ArticleDto.View> articleDto = entity.map(e->new ArticleDto.View(e, replyRepository.countByArticle(e)));

        return articleDto;
    }

    /**
     * 단일 검색을 위한 기능
     * @param id 검색할 대상의 id
     * @return 검색된 대상
     */
    public ArticleDto.Detail findOne(Long id) {
        Article entity = articleRepository.findById(id).orElseThrow(()-> new RuntimeException());
        List<Reply> reply = replyRepository.findTop3ByArticleOrderByCreatedAtDesc(entity);
        Integer cnt = replyRepository.countByArticle(entity);
        ArticleDto.Detail result = new ArticleDto.Detail(entity, reply, cnt);
        entity.upView();
        articleRepository.save(entity);
        // return null 을 지운 후 구현하면 됩니다
        return result;
    }

    /**
     * 객체 생성을 위한 기능
     * @param dto 생성할 내용을 담은 객체
     * @param userId 작성자 식별자
     * @return 생성된 객체의 정보
     */
    public CommonResponse create(ArticleDto.Command dto, Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(()->new RuntimeException());
        Article entity = new Article(dto.getTitle(), dto.getContents(), member);

        articleRepository.save(entity);
        ArticleDto.Detail result = new ArticleDto.Detail(entity);
        // return null 을 지운 후 구현하면 됩니다
        return new CommonResponse<ArticleDto.Detail>(result);
    }

    /**
     * 객체 수정을 위한 기능
     * @param id 수정할 대상의 id
     * @param dto 수정할 내용을 담은 객체
     * @param userId 작성자 식별자
     * @return 수정된 객체의 정보
     */
    public ArticleDto.Detail update(Long id, ArticleDto.Command dto, Long userId) {
        Article article = articleRepository.findById(id).orElseThrow(()->new RuntimeException());
        Member member = memberRepository.findById(userId).orElseThrow(()-> new RuntimeException());
        if(article.getWriter().getId()!=userId){
            throw new RuntimeException();
        }

        if(StringUtils.hasText(dto.getContents())){
            article.setContents((dto.getContents()));
        }
        if(StringUtils.hasText(dto.getTitle())){
            article.setTitle(dto.getTitle());
        }
        articleRepository.save(article);
        // return null 을 지운 후 구현하면 됩니다
        return new ArticleDto.Detail((article));
    }

    /**
     * 객체 삭제를 위한 기능
     * @param id 삭제할 대상의 id
     * @param userId 삭제 요청한 유저의 식별자 정보
     */
    public void delete(Long id, Long userId) {
        Article article = articleRepository.findById(id).orElseThrow(()->new RuntimeException());
        Member member = memberRepository.findById(userId).orElseThrow(()-> new RuntimeException());
        if(article.getWriter().getId()!=userId){
            throw new RuntimeException();
        }
        articleRepository.delete(article);
        // 여기에 구현하면 됩니다
    }

}
