package im.rubric.codetest.repository.jpa;

import im.rubric.codetest.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/** Article 관련 기능을 처리하는 JPA repository */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
