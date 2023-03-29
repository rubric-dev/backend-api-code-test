# Rubric Labs Coding Test

### 개요
> 이 프로젝트는 루브릭 랩스에서 코딩 테스트를 진행하기 위한 목적으로 작성 되었습니다.
> 
> 간단한 게시판 구현 프로젝트 입니다.  
> 테스트는 게시글(Article) 의 CRUD(생성, 조회, 수정, 삭제) API 구현을 목적으로 합니다.   
> 구현 해야하는 API 들에 대한 Input/Output 은 ArticleController 에 이미 정의되어 있으며
> 호출하는 ArticleService 의 메서드를 비즈니스 로직을 작성해 주시면 되겠습니다. 
> 제한 사항으로 정의 되어있는 해당 dto 들은 필드를 변경하지 않고 진행되어야 합니다.
> 
> 
> DB는 H2를 이용하며 휘발성 메모리를 가졌기 때문에 어플리케이션을 새로이 구동할 때 마다 데이터가 초기화 됩니다.
> DB access는 기본적으로 JPA를 이용하되 원한다면 MyBatis를 사용해도 괜찮습니다.
> 프로젝트 패키지 구조를 확인하는데 어려움이 있다면 아래의 DB erd 링크 혹은 STRUCTURE.md 파일을 참조 부탁드립니다.
> 
> 테스트 진행 중에는 인터넷을 사용해도 무방합니다.
> 
> 참조 =>\
> [DB erd](https://file.rubric.im/assets/code-test-erd.png)   
> im.rubric.codetest.controller.ArticleController

---
