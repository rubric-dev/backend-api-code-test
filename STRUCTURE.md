# 프로젝트 구조 설명

> ### java
> 
> im.rubric.recruit - 베이스 패키지
>
>> .config - 설정 관련 패키지. 테스트 진행 중 수정할 사항이 없습니다.
>>
>> .controller - 컨트롤러 관련 패키지
>> 
>> .entity - JPA 엔티티 패키지
>>
>> .service - 로직 구현을 위한 서비스 패키지
>>
> 
>> .dto - 단순 정보 전달을 위한 패키지
>>> .io - api 응답에 공통적으로 사용되는 컨테이너 클래스 패키지
>
>> .repository - 영속성 접근을 위한 패키지
>>> .jpa - JPA repository들을 모아둔 패키지
>>> 
>>> .mybatis - mybatis repository들을 모아둔 패키지
>> 
> 
> ### resources
> 
> mapper - MyBatis mapper xml 파일들을 모아둔 패키지
> 