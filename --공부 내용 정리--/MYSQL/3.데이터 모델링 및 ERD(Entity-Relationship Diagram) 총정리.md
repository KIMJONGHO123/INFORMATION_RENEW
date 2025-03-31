# 데이터 모델링 및 ERD(Entity-Relationship Diagram) 총정리

## 1. 데이터 모델링 개요

- **데이터 모델링**은 데이터베이스의 구조를 설계하고 조직하는 과정을 말합니다. 이는 데이터의 저장, 접근, 관리 방식을 정의하여 효율적이고 일관된 데이터 관리를 가능하게 합니다.

## 2. 데이터 모델링의 중요성

- 효율적인 데이터 관리
- 변경 용이성
- 데이터 일관성 보장

## 3. 데이터 모델링의 단계

### 1) 개념적 데이터 모델링

- 데이터 구조를 설계
- 특징 : 엔터티, 주요 속성, 관계를 식별

즉 개념적 데이터 모델링은 데이터 간의 관계를 구상하는 단계이다. 각 개체들과 각각의 관계들을 표현하기 위해 ERD 다이어그램을 생성한다.

피터 첸 표기법(Peter Chen Natation)으로 ERD 다이어그램을 구성한다.

![image 1](https://github.com/user-attachments/assets/ca43c78e-ffeb-43cf-9383-fabe1131859c)

![image 2](https://github.com/user-attachments/assets/97f411a1-6d4b-4b24-b9f5-4697a5bf8123)

사람과 주민등록번호를 할당의 관계로 개념적 데이터 모델을 구현해본것이다.

### 2) 논리적 데이터 모델링

- 목적 : 개념적 모델을 기반으로 구체화된 업무 중심의 데이터 모델을 만든다.
- 특징 : 속성의 세분화, 키 정의, 관계의 상세화

개념적 모델이 완성이 되면 구체화된 업무 중심의 데이터 모델을 만든다. 이것을 논리적 데이터 모델링이라고 한다. 위에서 구현한 개념적 ERD 다이어그램을 IE표기법(== 정보공학 표기법(Information ENgineering Notation))인 테이블 형태고 다시 구성한다.

![image 3](https://github.com/user-attachments/assets/837ee056-1860-4a3d-b942-d723593b0e44)

위와 같이 1대 1관계일때는 관계 엔터티를 따로 만들지 않는다. 

밑에서 설명할꺼지만 자식이 부모의 PK를 FK로 참조해서 자신의 PK로 설정하는 경우는 식별자 관계여서 실선으로 표현.

 

### 3) 물리적 데이터 모델링

- 목적 : 실제 데이터베이스 시스템으로 구현
- 특징 : 인덱스, 파티셔닝, 성능 최적화

물리적 데이터 모델링은 데이터를 관리할 데이터베이스를 결정하고 선택한 데이터 베이스에 실제 데이터를 만드는 작업이다. 시각적인 ERD를 실제 SQL로 만드는 과정이다.

// 여기서는 MySQL Workbench로 논리적 데이터 모델링을 만들고 실제 테이블로 뽑은 것이다.

![image 4](https://github.com/user-attachments/assets/615c327e-754e-4460-90d9-0ebfd18161e1)

MySQL Workbench로 논리적 데이터 모델링을 한 사진.

![People엔터티(아직 값은 들어가 있지 않다.)](image%203.png)

People엔터티(아직 값은 들어가 있지 않다.)

![image](https://github.com/user-attachments/assets/1cf6abac-68e7-46e1-8f08-a6c8f1ee83b7)

resident registration number 엔터티 (마잔차기로 아직 값은 안들어가 있다.)

<aside>
✅ 저거 설정할때 CASCADE 설정해줘야 한다.

CASCADE : 개체 변경/삭제 시, 다른 개체가 해당 개체를 참조하고 있을 경우, 모든 개체가 변경/삭제 된다.

</aside>
