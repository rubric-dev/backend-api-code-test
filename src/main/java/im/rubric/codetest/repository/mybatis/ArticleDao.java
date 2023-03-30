package im.rubric.codetest.repository.mybatis;

import im.rubric.codetest.dto.ArticleDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * Article 관련 기능을 처리하는 mybatis 매퍼.
 * /resources/mapper/ArticleMapper.xml 참조.
 */
@Mapper
public interface ArticleDao {
    ArticleDto.Detail create(ArticleDto.Command dto, Long userId);

    ArticleDto.Detail update(Long id, ArticleDto.Command dto, Long userId);
}
