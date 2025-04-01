# LINUX 권한 & 명령어

## 1. 권한 개요

파일 및 디렉토리 권한은 **소유자**, **그룹**, **기타 사용자**로 나뉩니다. 각 권한은 **읽기(r)**, **쓰기(w)**, **실행(x)**으로 구성됩니다.

### 예시

```bash
drwxr-xr-x  2 root root 220 10월 2 2020 yum.repos.d
```

- **d** : 디렉토리
- **rwx** : 소유자(root)의 권한
- **r-x** : 그룹(root)의 권한
- **r-x** : 기타 사용자의 권한

---

## 2. 권한 종류

### 2.1 읽기 (r)

- **파일**: 내용 보기 (명령어: `cat`, `head`, `tail`, `more` 등)
- **디렉토리**: 폴더 내 목록 보기 (`ls`)

### 2.2 쓰기 (w)

- **파일**: 내용 수정 (명령어: `vi`, `>` 리다이렉션)
- **디렉토리**: 파일 생성, 수정, 삭제 (`touch`, `cp`, `mv`, `rm` 등)

### 2.3 실행 (x)

- **파일**: 실행 (명령어: `./cmd`)
- **디렉토리**: 디렉토리 진입 (`cd`)

---

## 3. 권한 표현 방식

### 3.1 Symbolic 방식

- **예시**: `rwxr-xr-x`

### 3.2 Numeric 방식

- **예시**: `755`

### 3.3 권한 계산 방법

- **r** = 4
- **w** = 2
- **x** = 1

각 권한을 합산하여 숫자로 표현합니다.

```bash
rwx = 4 + 2 + 1 = 7
r-x = 4 + 0 + 1 = 5
```

---

## 4. 권한 변환 예제

### 4.1 Symbolic → Numeric

- `rwxr-xr-x` → `755`
- `rw-r--r--` → `644`
- `rwx-----x` → `701`
- `r-xr---w-` → `542`
- `rw-r---wx` → `643`
- `wxrwxr-x` → `375`

### 4.2 Numeric → Symbolic

- `755` → `rwxr-xr-x`
- `644` → `rw-r--r--`
- `701` → `rwx-----x`
- `542` → `r-xr---w-`
- `643` → `rw-r---wx`
- `375` → `wxrwxr-x`

---

## 5. 권한 예제 문제

### 문제: 다음 권한을 Numeric 방식으로 변환하세요.

1. rw_r_xr__
2. rwxr__r_x
3. r__rwxr__
4. r_xr__r_x
5. r__r_x___

### 정답

1. rw_r_xr__ → 654
2. rwxr__r_x → 745
3. r__rwxr__ → 474
4. r_xr__r_x → 545
5. r__r_x___ → 450

---

## 6. 권한 부여 및 소유권

- **소유권 양도**는 **관리자(root)**만 가능합니다.

### 소유권 예시

- **파일**
    - `r` : 문서 내용 보기 (`cat`, ...)
    - `w` : 문서 내용 수정 (`vi`, `>`)
    - `x` : 실행 파일 동작 (`./filename`)
- **디렉토리 (폴더)**
    - `r` : 디렉토리 내 목록 보기 (`ls`)
    - `w` : 디렉토리 내 파일 생성, 수정, 삭제 (`mkdir`, `touch`, `cp`, `mv`, `rm`, ...)
    - `x` : 디렉토리 진입 (`cd`)

---

## 7. 추가 참고 사항

- **소유한 사용자 계정 예시**: 축구부 부원
    - `rwx` : 소유자 계정이 쓸 수 있는 권한
- **소유한 그룹 계정 예시**: 축구부
    - `r-x` : 그룹 계정이 쓸 수 있는 권한
- **기타 사용자**
    - `r-x` : 누구나 사용 가능한 권한

## `chown` (Change Ownership)

### 개요

`chown` 명령어는 파일이나 디렉토리의 소유자(owner)와 소유 그룹(group)을 변경하는 데 사용됩니다.

### 환경 설정

```bash
mkdir -p /chown/a
touch /chown/b /chown/a/c
cd /chown
useradd user10
```

### 실습 명령어

1. **소유자 및 소유 그룹 변경**
    
    ```bash
    chown user10:user10 /chown
    ```
    
    - `/chown`의 소유자와 소유 그룹을 `user10`으로 변경합니다.
2. **소유자 및 소유 그룹을 `root`로 변경**
    
    ```bash
    chown root:root /chown
    ```
    
3. **소유자만 변경**
    
    ```bash
    chown user10 /chown
    ```
    
    ```bash
    chown root /chown
    ```
    
4. **소유 그룹만 변경**
    
    ```bash
    chown .user10 /chown
    chown :user10 /chown  (일반적)
    ```
    
5. **재귀적으로 소유자 및 소유 그룹 변경**
    
    ```bash
    /chown
    ├── src
    │   ├── main.c
    │   └── utils.c
    ├── include
    │   └── main.h
    └── README.md
    ```
    
    - `/chown` 디렉토리의 소유 그룹을 user10으로 변경하고 싶다면, 단순히 `/chown`디렉토리에 대해서만 `chown` 명령어를 사용하면 그 안의 `src`, `include`, 그리고 그 안의 파일들은 변경되지 않는다.
    
    하위 디렉토리나 파일들도 변경하고 싶다면 
    
                               ⬇️
    
    ```bash
    chown -R user10:user10 /chown
    ```
    
    - `/chown`의 모든 하위 파일 및 디렉토리의 소유자와 소유 그룹을 `user10`으로 변경합니다.
    
    재귀적으로 변경한다의 의미
    
    - 특정 디렉토리와 그 디렉토리 안에 포함된 모든 하위 디렉토리 및 파일들에 대해서도 동일한 작업을 반복적으로 적용한다는 것을 의미한다.

---

## `chmod` (Change Mode)

### 개요

`chmod` 명령어는 파일이나 디렉토리의 접근 권한을 변경하는 데 사용됩니다.

### 환경 설정

```bash
mkdir /chmod
touch /chmod/a
cd /chmod
```

### 허가권 부여 방식

### 1. 숫자(Numeric) 방식

숫자 형식으로 권한을 설정합니다. 각 권한은 다음과 같이 숫자로 표현됩니다:

- `r` (읽기) = 4
- `w` (쓰기) = 2
- `x` (실행) = 1

**예시:**

```bash
chmod 755 a
chmod 566 a
chmod 755 a
```

### 2. 문자(Symbolic) 방식

문자 형식으로 권한을 설정합니다. 다음과 같은 형식을 사용합니다:

- `u` : 소유자(user)
- `g` : 소유 그룹(group)
- `o` : 기타 사용자(other)
- `a` : 모두(all)

권한 추가(`+`), 제거(`-`), 설정(`=`)을 할 수 있습니다.

- `r` : 읽기
- `w` : 쓰기
- `x` : 실행

**예시:**

```bash
chmod u-rw a       # 소유자의 읽기 및 쓰기 권한 제거
chmod g+w a        # 소유 그룹에 쓰기 권한 추가
chmod o+rw a       # 기타 사용자에 읽기 및 쓰기 권한 추가
chmod a-x a        # 모든 사용자의 실행 권한 제거
chmod u+x,g+x a    # 소유자와 소유 그룹에 실행 권한 추가
```

**참고:** 여러 권한을 동시에 변경할 때는 콤마(,)를 사용하여 구분합니다.

```bash
chmod u+r,g+w,o-x a
```

### 리눅스 권한 예제

```bash
user10,user20,user30 생성상태에서 진행

1. /perm 디렉토리 생성

2. /perm 소유자계정 user30, 소유그룹 계정 user20 으로 소유권변경

3. /perm 디렉토리에 user10 은 접근가능,목록보기가능,파일생성불가 허가권부여
r_x

4. /perm 디렉토리에 user20 은 접근가능,목록보기불가,파일생성가능 허가권부여
_wx

5. /perm 디렉토리에 user30 은 접근불가,목록보기불가,파일생성불가 허가권부여
___

chmod 035 /perm

6번할때 권한 풀기
6. /perm 디렉토리에 user30 이 test파일을 만들고 그안에 'testfile' 내용을 저장

7. user30계정으로 /perm/test의 파일의 허가 범위를 다음과 같이 지정
chown : user20 /perm/test

user30:읽기,쓰기 가능, user20:읽기불가 쓰기가능, 나머지계정 :읽기가능 쓰기불가
 
chmod 624 /perm/test
```

![시험문제 root 계정.PNG](%25EC%258B%259C%25ED%2597%2598%25EB%25AC%25B8%25EC%25A0%259C_root_%25EA%25B3%2584%25EC%25A0%2595.png)

![시험문제 user30 계정.PNG](%25EC%258B%259C%25ED%2597%2598%25EB%25AC%25B8%25EC%25A0%259C_user30_%25EA%25B3%2584%25EC%25A0%2595.png)

## `usermod` : 사용자 계정정보 변경 명령어

---

## 옵션

- `d` : 홈 디렉토리 설정
- `m` : 홈 디렉토리 이동

---

## 실습

### 1. UID 변경

```bash
usermod -u 2000 mod
```

- `u` : UID 변경

### 2. 주 그룹 변경

```bash
usermod -g heath mod
```

- `g` : 주 그룹 변경

### 3. 보조 그룹 변경

```bash
usermod -G test1 mod
```

- `G` : 보조 그룹 변경

### 4. 계정 설정 변경 (Comment)

```bash
usermod -c linux mo
```

- `c` : 계정 설정 변경

### 5. 쉘 변경

```bash
usermod -s /bin/sh mod
```

- `s` : 쉘 변경

### 6. 홈 디렉토리 설정 및 이동

```bash
mkdir -p /export/home
usermod -md /export/home/mod mod
```

- `m` : 홈 디렉토리 이동
- `d` : 홈 디렉토리 설정

---

## 미니 문제 (스냅샷 돌리고 문제 풀기)

### 문제 1. 계정 생성

```bash
useradd test1
useradd test2
useradd test3
```

- `test1`, `test2`, `test3` 계정 생성

### 문제 2. `test1`의 comment 변경

```bash
usermod -c "modtest" test1
```

- `test1`의 comment를 `modtest`로 변경

### 문제 3. `test2`의 주 그룹과 보조 그룹 지정

```bash
usermod -g test1 -G test3 test2
```

- `test2`의 주 그룹을 `test1`으로 변경
- `test2`의 보조 그룹을 `test3`으로 지정

### 문제 4. `test1`의 쉘 변경

```bash
usermod -s /bin/ksh test1
```

- `test1`의 쉘을 `/bin/ksh`로 변경

### 문제 5. 홈 디렉토리 설정 및 이동

```bash
mkdir /test1 /test2
usermod -md /test1/home test1
usermod -md /test2/home test2
```

- `test1`의 홈 디렉토리를 `/test1/home`으로 설정 및 이동
- `test2`의 홈 디렉토리를 `/test2/home`으로 설정 및 이동
