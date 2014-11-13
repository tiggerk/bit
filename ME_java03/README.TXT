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
1. 그래들 빌드 실행
1) 프로젝트 > 컨텍스트 메뉴 > Run As > Gradle Build... 클릭

2. build.gradle 설정
1) java 그래들 플로그인 임포트
apply plugin: 'java'

[그래들 java 플러그인 명령어]
1. clean
- build 폴더를 제거한다.

2. compileJava 
- /src/main/java 소스파일 컴파일
- /build/classes/main 폴더에 클래스 파일 복사

3. compileTestJava
- /src/test/java 소스파일 컴파일
- /build/classes/test 폴더에 클래스 파일 복사

4. processResources
- /src/main/resouces 폴더의 모든 파일을 /build/resources/main 폴더에 복사한다.

5. processTestResources
- /src/test/resouces 폴더의 모든 파일을 /build/resources/test 폴더에 복사한다.

6. classes
- compileJava와 processResources 작업을 모두 실행
- 기타 컴파일 관련 작업을 추가

7. jar
- classes 작업을 수행한 후, 클래스 파일과 기타 자원 파일을 묶어서 .jar 파일로 만든다.

8. build
- 모든 작업 수행!





