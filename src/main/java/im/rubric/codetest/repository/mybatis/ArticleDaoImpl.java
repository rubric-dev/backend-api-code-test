package im.rubric.codetest.repository.mybatis;

import im.rubric.codetest.dto.ArticleDto;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements ArticleDao{
    @Override
    public ArticleDto.Detail create(ArticleDto.Command dto, Long userId) {
        return im.rubric.codetest.repository.mybatis.ArticleDao.insert("");
    }

    @Override
    public ArticleDto.Detail update(Long id, ArticleDto.Command dto, Long userId) {
        return null;
    }
}
