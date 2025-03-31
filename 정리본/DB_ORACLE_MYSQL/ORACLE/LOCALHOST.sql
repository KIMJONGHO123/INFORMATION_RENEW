ALTER SESSION SET tracefile_identifier = '_TEST_';


-- 추적 시작
ALTER SESSION SET sql_trace = TRUE;

-- 고급 트레이스 설정: 이벤트 10046 레벨 12는 바인드 변수와 대기 이벤트까지 포함한 상세한 트레이스를 활성화
ALTER SESSION SET EVENTS '10046 trace name context forever, level 12';


-- 실제로 트레이스를 적용할 SQL 문 실행
select * from usertbl where addr='서울';


-- SQL 트레이스 기능 종료: 이후 SQL은 더 이상 트레이스하지 않음
ALTER SESSION SET sql_trace = FALSE;

-- 트레이스 파일이 저장된 디렉토리 위치 확인
SELECT VALUE FROM v$diag_info;

