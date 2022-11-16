# module-archive
서비스 구축시 필요한 여러 기능들을 모듈 형태로 저장해두는 프로젝트이며 아래 목적들을 위해 존재한다.
* 새로운 서비스 출시를 위해서 최대한 도메인 계층 구축에만 리소스를 사용하며 그 외에는 재활용 할 수 있도록 일종의 프로젝트 템플릿으로서 기능한다.
* 개발하며 마주해나가는 여러 구현 기술들을 코드 형태로 자산화 한다.

<br>

## 멀티모듈 구성
기본적으로 이 [포스팅](https://techblog.woowahan.com/2637/) 의 내용을 따라 모듈들을 분류하되 네이밍의 경우 내가 편한 형태로 약간 변경하였다.
해당 포스팅에서는 큰 분류로 inside the system, outside the system 을 사용하고 있는데, 나는 개인적으로 여기서 system 이라는 단어가 좀 혼란스러운 부분이 있었다.
왜냐하면 system 이라는 단어를 원래 포괄적인 의미로 사용해왔기 때문에 어떠한 모듈이 system 의 '밖'이라는 개념이 선명하게 와닿지 않았기 때문이다.
그래서 system 대신 service 라는 단어로 바꿔서 생각을 정리했다. 결국 service 에 속하지 않는다는 것은 service 가 무엇인지 하나도 모르는채 기능에만 충실하다는 의미로 소화하기로 했다.

결론적으로 module 들의 postfix 로 모듈의 역할을 분류하기로 결정했고, 아래와 같이 규칙을 세웠다.

#### service 내부
* -app : 독립적인 application 단위의 모듈로 domain 계층에 대한 역할을 포함한다. 위 포스팅에서는 application, domain 을 분리했는데, domain 계층은 결국 client 로 부터 전달되는 query, command 에서 자유로울 수 없는데 이를 분리하면 테스트코드 작성 등 여러모로 생산성이 오히려 더 떨어지는 것 같다는 생각이 들었다. 
* -support : service 를 알고 있지만 핵심적인 비즈니스 로직을 소화하지 않는 모듈이다. 여기서 service 를 안다는 의미는 service 내에서 사용되는 인프라의 정보를 알고 있다는 식의 의미이다. ex. core-web, event-publisher, web-client 등. 
* -shared : 모든 모듈에서 참조 할 수 있는 POJO 객체를 담고 있는 모듈이다. 대부분 모듈에서 사용될 만한 의존성이면서 어느 모듈이든 추가가 되어도 어플리케이션에 영향을 주지 않는 의존성이라면 여기에 추가해주고 노출시킨다. 

#### service 외부
* -library : service 밖의 모듈로 service 가 무엇이든지 신경쓰지도 않고, 알 수도 없다. 그저 기능 역할에 충실한 모듈이다. ex. r2dbc, jpa, jdbc, redis, sqs 등

<br>

## Commit Convention
기본적으로 [Angular JS 에서 정의한 것](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 따른다.
* feat (feature)
* fix (bug fix)
* docs (documentation)
* style (formatting, missing semi colons, …)
* refactor
* test (when adding missing tests)
* chore (maintain)

<br>
