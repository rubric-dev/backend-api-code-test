package im.rubric.codetest.config;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataInitializer {
    void initialize();
}
