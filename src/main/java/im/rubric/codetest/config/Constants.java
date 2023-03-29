package im.rubric.codetest.config;

public interface Constants {
    String[] RESOURCE_URI = {"/webjars/**", "/css/**", "/img/**", "/js/**"};
    String[] RESOURCE_LOCATION = {
            "classpath:/META-INF/resources/webjars/",
            "classpath:/static/css/",
            "classpath:/static/img/",
            "classpath:/static/js/"
    };
}
