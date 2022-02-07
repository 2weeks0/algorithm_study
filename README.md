# algorithm_study

## 스터디 운영 방식

- 횟수: 주 3일 (월, 화, 목)
- 시간: 주 3시간 이상 (19시 ~ 22시)
- 문제 난이도: 실버 3 ~ 실버 1
- 문제 수: 3문제 이상
- 소스와 문제 풀이 md 파일을 함께 업로드

## 파일 구조

- src
    - 본인 아이디의 패키지
      - 소스 (boj_1000.java)
      - 문제 풀이 (boj_1000.md)  
- doc
  - 풀었던 문제를 정리한 문서 (추가 예정)
  - 다룬 유형을 정리한 문서 (추가 예정)
- img
    - 문제 풀이 사용될 이미지


## 커밋 규칙

- 각자 본인의 브랜치에 작업하는 것을 기본으로 한다.
- 한 문제를 풀 때마다, 소스와 문제 풀이(.md)를 커밋한다.
    - 커밋 메시지 컨벤션
        - `keyword` (`package`): `내용`
        - feat: 문제 풀이 소스 추가 
            - 예) feat (2weeks0): boj_1000 소스 및 풀이 추가
        - fix: 소스 수정
            - 예) fix (2weeks0): boj_1000 소스 수정
        - docs: 문서 수정
            - 예) docs (2weeks0): boj_1000 풀이 수정
            - 예) docs: readme 수정
        - 참고: https://doublesprogramming.tistory.com/256
- 해당 일에 문제를 모두 풀면 master 브랜치에 merge 한다.
    - 단, merge 하기 전, master 브랜치에 rebase 되어 있는지 확인!!
    - 참고: https://techblog.woowahan.com/2553/
