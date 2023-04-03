package im.rubric.codetest.repository.jpa;

import im.rubric.codetest.entity.Article;
import im.rubric.codetest.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/** Reply 관련 기능을 처리하는 JPA repository */
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findTop3ByArticleOrderByCreatedAtDesc(Article article);
    Integer countByArticle(Article entity);
}
