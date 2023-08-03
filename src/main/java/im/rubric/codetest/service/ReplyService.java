package im.rubric.codetest.service;


import im.rubric.codetest.dto.ReplyDto;
import im.rubric.codetest.entity.Article;
import im.rubric.codetest.repository.jpa.ReplyRepository;
import im.rubric.codetest.repository.mybatis.ReplyDao;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** Reply 관련 로직을 처리하는 서비스 */
@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final ReplyDao replyDao;

    public Page<ReplyDto.View> findPage(Pageable pageable) {
        return replyRepository.findAll(pageable)
            .map(ReplyDto.View::newInstance);
    }

    public int getCount(Article article) {
        return replyRepository.countByArticle(article);
    }
}
