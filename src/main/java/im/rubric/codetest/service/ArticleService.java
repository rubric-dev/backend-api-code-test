package im.rubric.codetest.service;

import im.rubric.codetest.dto.ArticleDto;
import im.rubric.codetest.entity.Article;
import im.rubric.codetest.entity.Member;
import im.rubric.codetest.repository.jpa.ArticleRepository;
import im.rubric.codetest.repository.jpa.MemberRepository;
import im.rubric.codetest.repository.mybatis.ArticleDao;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** Article 관련 로직을 처리하는 서비스 */
@Service
@RequiredArgsConstructor
public class ArticleService {

	private final ArticleRepository articleRepository;
	private final MemberRepository memberRepository;
	private final ReplyService replyService;
	private final ArticleDao articleDao;

	/**
	 * 페이지 단위로 검색하는 기능
	 * @param pageable 검색할 페이지의 정보
	 * @return 검색할 대상의 Page 정보
	 */
	public Page<ArticleDto.View> findPage(Pageable pageable) {
		// return null 을 지운 후 구현하면 됩니다
		return articleRepository.findAll(pageable)
			.map(article -> ArticleDto.View.newInstance(article,
				replyService.getCount(article)));
	}

	/**
	 * 단일 검색을 위한 기능
	 * @param id 검색할 대상의 id
	 * @return 검색된 대상
	 */
	public ArticleDto.Detail findOne(Long id) {
		// return null 을 지운 후 구현하면 됩니다
        return articleRepository.findById(id)
            .map(article -> ArticleDto.Detail.newInstance(article,
                replyService.findPage(PageRequest.of(0, 3)
                )))
            .orElseThrow(() -> new RuntimeException("id에 해당하는 게시글이 없습니다. id: " + id));
	}

	/**
	 * 객체 생성을 위한 기능
	 * @param dto 생성할 내용을 담은 객체
	 * @param userId 작성자 식별자
	 * @return 생성된 객체의 정보
	 */
	public ArticleDto.Detail create(ArticleDto.Command dto, Long userId) {
		// return null 을 지운 후 구현하면 됩니다
		Member writer = memberRepository.findById(userId)
			.get();

		Article savedArticle = articleRepository.save(dto.toEntity(writer));
		return ArticleDto.Detail.newInstance(savedArticle, replyService.findPage(PageRequest.of(0, 3)));
	}

	/**
	 * 객체 수정을 위한 기능
	 * @param id 수정할 대상의 id
	 * @param dto 수정할 내용을 담은 객체
	 * @param userId 작성자 식별자
	 * @return 수정된 객체의 정보
	 */
	public ArticleDto.Detail update(Long id, ArticleDto.Command dto, Long userId) {
		// return null 을 지운 후 구현하면 됩니다
		return null;
	}

	/**
	 * 객체 삭제를 위한 기능
	 * @param id 삭제할 대상의 id
	 * @param userId 삭제 요청한 유저의 식별자 정보
	 */
	public void delete(Long id, Long userId) {
		// 여기에 구현하면 됩니다
	}

}
