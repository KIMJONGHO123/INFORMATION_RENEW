ALTER SESSION SET tracefile_identifier = '_TEST_';


-- ���� ����
ALTER SESSION SET sql_trace = TRUE;

-- ��� Ʈ���̽� ����: �̺�Ʈ 10046 ���� 12�� ���ε� ������ ��� �̺�Ʈ���� ������ ���� Ʈ���̽��� Ȱ��ȭ
ALTER SESSION SET EVENTS '10046 trace name context forever, level 12';


-- ������ Ʈ���̽��� ������ SQL �� ����
select * from usertbl where addr='����';


-- SQL Ʈ���̽� ��� ����: ���� SQL�� �� �̻� Ʈ���̽����� ����
ALTER SESSION SET sql_trace = FALSE;

-- Ʈ���̽� ������ ����� ���丮 ��ġ Ȯ��
SELECT VALUE FROM v$diag_info;

