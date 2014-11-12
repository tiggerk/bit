Gradle 프로젝트 폴더 구조
src/
src/main => 애플리케이션 기본 소스
src/main/java => 자바 소스
src/main/resources => .xml, .txt, .properties 등 파일
src/main/webapp => .html, .css, .js, .gif 등 웹 관련 파일

src/test => JUnit 등 단위 테스트를 수행할 소스
src/test/main
src/test/resources

build/ => 컴파일된 파일들

.gradle/ => 그래들 설정 파일 및 의존 라이브러리 파일

build.gradle => groovy로 작성된 빌드 설정 파일

* 주의!
.project 파일에 Gradle을 사용한다고 설정해야만
메뉴에서 그래들 관련 명령을 실행할 수 있다.
<nature>org.springsource.ide.eclipse.gradle.core.nature</nature>

[그래들 빌드하기]
1. 컴파일 하기
1) 프로젝트 > 컨텍스트 메뉴 > Run As > Gradle Build... 클릭