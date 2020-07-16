# 깃 명령어
## 깃 소스 업데이트 
git pull origin master
## 깃 소스 받기
git clone https://github.com/kimyongyeon/toy-board-app.git
## 깃 소스 추가 
git add .
## 깃 소스 커밋 (로컬 저장 )
git commit -am "코멘트 달고... 블라블라~"
## 깃 소스 푸시 (서버 전송)
git push origin 브런치명
## 깃 브런치 따기 
git checkout -b 브런치명
## 깃 브런치명 확인 (로컬)
git branch 
## 깃 브런치명 확인(서버 )
git branch -a
## 깃 로그 
git log 
## 깃 롤백 (revert: 본인것만 돌리기)
git revert index
## 깃 롤백 (reset: 앞에 커밋된 내용부터 롤백 인덱스까지 다 돌린다.)
git reset --soft

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
