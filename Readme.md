# 목록 => 상세보기 
1. 못만들고 반성... 
2. 홈페이지 가장중요한 것: 페이지 연결 (프로그래밍방식/태그방식) 
3. SSR, CSR: 
   - 서버사이드랜더링(get)-화면깜박거림, 
   - 클라이언트사이드랜더링-페이지그림-화면깜박거림없음,SEO못함

# cli => command line 
 => cmd 

# java cli 
	=> java
		=> java -jar profile=dev database=jdbc=24234 app.jar 
	=> javac 

```
private printTest(name) { // 파라미터 
}

printTest('naasdf');
```
	
# project 
## 형상관리
	=> 소스관리 : git
	=> 배포: default, local, dev, stag, prod 
		default, local: 나의 pc
		dev: 개발서버 
		stag: 운영DB + 운영도메인 + private dns 서버 
			dns => 사람이 이해하기 쉽다. 
				=> dns vs ip 차이점?
				=> dns => 이중화 서버 
				=> 로드밸런스 => 알고리즘 2가지 
							=> round robin: 동일하게 분기 처리  
							=> sticky: 한쪽으로만 간다. 
								=> 로그인 필요하다 => 세션획득
		prod: 운영DB + 운영도메인 + public dns 서버  

## maven cli 
