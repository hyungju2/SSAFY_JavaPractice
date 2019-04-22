package dI1;

/*
 * 스프링 x 1. STS(Spring Tool Suite) 2. Eclipse에 플러그인 설치, Eclipse EE Photon 버전을 받음
 * (open-jdk와 호환을 위해) Help - Eclipse MarketPlace .. - STS 검색 ( STS 3.9.7 설치 )
 * 
 * Perspective 꺼내기 이클립스 우측상단 - Spring Perspective 꺼냄
 * 
 * Maven Repositories 뷰 꺼내기 ( window -> show view -> other -> Maven Repositories )
 * 
 * 
 * 향후 프로젝트 진행시 Repositories 서버에서 필요한 파일검색하는 시간을 줄이기위해 인덱싱 작업을 미리 해주자. 
 * Maven Repositories 탭 - Global Repositories - central 우클릭 - Rebuild index (인덱싱 시간 오래걸림)
 * 
 * ==========================================
 * 
 * 프로젝트 생성
 * 
 * Spring Legacy Project => Simple spring Maven 로 생성 pom.xml 에서 java.version / spring-framework.version
 * 
 * overview 탭에서 Java.version -> 18 / spring-framework.version 4.2.5.RELEASE로 변경
 * 
 * properties -> Java build path -> Libraies 에서 JDK 1.8.0으로 변경.
 */
public class Test {
/*
 * spring : 오픈 소스 프레임워크, 2004년부터 공식버전 발표.
 * 국내에서는 전자정부 프레임워크(스프링, 톰캣) 와 맞물려서 많이 사용됨.
 * 기존 프로젝트에서 객체를 생성, 관리하는 작업들의 의존성을 제거해보자.
 * DI (Dependency Injection)
 * AOP (Aspect Oriented Programming)
 * MVC
 */
	public static void main(String[] args) {
		Car c = new Car();
		c.drive();
		
	}//end of main
} //end of class
