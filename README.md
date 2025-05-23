## Schedule API 명세서

스케쥴 등록, 조회, 수정, 삭제 기능을 제공하는 REST API입니다.

---
<details>
    <summary>1. Lv_1 : API 명세서</summary>

## 📌 1. 스케쥴 등록

- **Method**: `POST`
- **URL**: `/api/schedules`

#### 🔸Request

##### Body (JSON)
| 필드명      | 타입    | 필수 | 설명        |
|----------|---------|------|-----------|
| `content`  | `String`  | ✅   | 등록할 일정 내용 |
| `title`    | `String`  | ✅   | 제목        |
| `username` | `String`  | ✅   | 작성자 이름    |
| `password` | `String`  | ✅   | 비밀번호      |

#### 🔸Sample Request
```json
{
  "content": "스프링 1주차 듣기",
  "title": "제목",
  "username": "홍길동",
  "password": "1234"
}
```

#### 🔸Response Body
| 필드명     | 타입   | 필수  | 설명                |
|------------|------|-----|-------------------|
| `id`         | `Long` | ✅   | 일정 고유 ID          |
| `contents`   | `String` | ✅   | 등록된 일정 내용         |
| `userName`   | `String` | ✅   | 작성자 이름            |
| `createdAt`  | `Date` | ✅   | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt`  | `Date` | ✅   | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response
```json
{
  "id": 1,
  "contents": "스프링 1주차 듣기",
  "username": "홍길동",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 등록 완료 |

---

## 📌 2. 특정 스케쥴 조회

- **Method**: `GET`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명 | 타입 | 필수 | 설명 |
|-----|-----|----|----|
| `scheduleID` | `Long` | ✅ | 조회할 스케쥴 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
/api/schedules/1

#### 🔸Response Body

| 필드명       | 타입     | 필수 | 설명                |
|-----------|----------|----|-------------------|
| `id`        | `Long`     | ✅  | 일정 고유 ID          |
| `content`   | `String`   | ✅  | 등록된 일정 내용         |
| `username`  | `String`   | ✅  | 작성자 이름            |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "contents": "스프링 1주차 듣기",
  "userName": "홍길동",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 조회 완료 |
| 400 | 비밀번호 오류  |

---

## 📌 3. 특정 스케쥴 수정

- **Method**: `PATCH`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명            |
|------------|-------|------|-----------------|
| scheduleID | Long  | ✅   | 수정할 스케쥴 ID |

##### Body (JSON)
| 필드명      | 타입    | 필수 | 설명             |
|----------|---------|------|------------------|
| `content`  | `String`  | ✅   | 수정할 일정 내용    |
| `username` | `String`  | ✅   | 작성자 이름       |
| `password` | `String`  | ✅   | 수정/삭제용 비밀번호 |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/schedules/1`

##### Body (JSON)
```json
{
  "content": "스프링 2주차 듣기",
  "username": "홍길동",
  "password": "1234"
}
```

#### 🔸Response Body

| 필드명       | 타입      | 필수 | 설명                   |
|-----------|-----------|--|----------------------|
| `id`        | `Long`      | ✅ | 일정 고유 ID             |
| `content`   | `String`    | ✅ | 등록된 일정 내용            |
| `username`  | `String`    | ✅ | 작성자 이름               |
| `createdAt` | `Date` | ✅ | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `LocalDate` | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "content": "스프링 2주차 듣기",
  "username": "홍길동",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드

| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 수정 완료 |
| 400 | 비밀번호 오류 |

---

## 📌 4. 특정 스케쥴 삭제

- **Method**: `DELETE`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명            |
|------------|-------|------|-----------------|
| `scheduleID` | `Long`  | ✅   | 수정할 스케쥴 ID |

##### Body (JSON)
| 필드명     | 타입    | 필수 | 설명             |
|------------|---------|------|------------------|
| `password`   | `String`  | ✅   | 수정/삭제용 비밀번호 |


#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/schedules/1`

##### Body (JSON)
```json
{
  "password" : "1234"
}
```

#### 🔸Response Body

X

#### 🔸Sample Response
`헤더 200 OK`

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 삭제 완료 |
| 400 | 비밀번호 오류  |

---
## ERD
```mermaid
erDiagram
    SCHEDULE {
        bigInt id PK
        varchar(100) title
        varchar(100) username
        varchar(100) content
        datetime createAt
        datetime updateAt
    }
```
</details>
<details>
    <summary>2. Lv_2 : API 명세서</summary>

## 📌 1. 사용자 등록

- **Method**: `POST`
- **URL**: `/api/users`

#### 🔸Request

##### Body (JSON)
| 필드명        | 타입    | 필수 | 설명    |
|------------|---------|-----|-------|
| `username` | `String`  | ✅  | 사용자 명 |
| `email`    | `String`  |    | 이메일   |

#### 🔸Sample Request
```json
{
  "username": "홍길동",
  "email": "홍길동@example.com"
}
```

#### 🔸Response Body
| 필드명         | 타입   | 필수 | 설명                   |
|-------------|------|----|----------------------|
| `id`        | `Long` | ✅  | 일정 고유 ID             |
| `userName`  | `String` | ✅  | 사용자 명                |
| `email`     | `String` |    | 이메일 |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response
```json
{
  "id": 1,
  "username": "홍길동",
  "email": "홍길동@example.com",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 등록 완료 |

---

## 📌 2. 특정 사용자 조회

- **Method**: `GET`
- **URL**: `/api/users/{userID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명 | 타입 | 필수 | 설명         |
|-----|-----|----|------------|
| `userID` | `Long` | ✅ | 조회할 사용자 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/users/1`

#### 🔸Response Body

| 필드명         | 타입   | 필수 | 설명                   |
|-------------|------|----|----------------------|
| `id`        | `Long` | ✅  | 일정 고유 ID             |
| `userName`  | `String` | ✅  | 사용자 명                |
| `email`     | `String` |    | 이메일 |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "username": "홍길동",
  "email": "홍길동@example.com",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 조회 완료 |
| 400 | 사용자 명 오류 |

---

## 📌 3. 특정 사용자 수정

- **Method**: `PATCH`
- **URL**: `/api/users/{userID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명         |
|------------|-------|------|------------|
| userID | Long  | ✅   | 수정할 사용자 ID |

##### Body (JSON)
| 필드명        | 타입    | 필수 | 설명    |
|------------|---------|-----|-------|
| `username` | `String`  | ✅  | 사용자 명 |
| `email`    | `String`  |    | 이메일   |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/users/1`

##### Body (JSON)
```json
{
  "username": "김철수",
  "email": "김철수@example.com"
}
```

#### 🔸Response Body

| 필드명         | 타입      | 필수 | 설명                   |
|-------------|-----------|--|----------------------|
| `id`        | `Long`      | ✅ | 일정 고유 ID             |
| `username`  | `String`    | ✅ | 사용자 명                |
| `email`     | `String`    |  | 이메일                  |
| `createdAt` | `Date` | ✅ | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "username": "김철수",
  "email": "김철수@example.com",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드

| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 수정 완료 |
| 400 | 사용자 명 오류 |

---

## 📌 4. 특정 사용자 삭제

- **Method**: `DELETE`
- **URL**: `/api/users/{userID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명         |
|------------|-------|------|------------|
| `userID` | `Long`  | ✅   | 수정할 사용자 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/users/1`

#### 🔸Response Body

`X`

#### 🔸Sample Response

`헤더 200 OK`

#### 🔸상태코드
| 코드     | 설명        |
|--------|-----------|
| 200 OK | 정상 삭제 완료  |
| 400 | 사용자 id 오류 |

---

## 📌 1. 스케쥴 등록 (변경 사항)

- **Method**: `POST`
- **URL**: `/api/schedules`

#### 🔸Request

##### Body (JSON)
| 필드명        | 타입       | 필수 | 설명        |
|------------|----------|------|-----------|
| `content`  | `String` | ✅   | 등록할 일정 내용 |
| `title`    | `String` | ✅   | 제목        |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `password` | `String` | ✅   | 비밀번호      |

#### 🔸Sample Request
```json
{
  "content": "스프링 1주차 듣기",
  "title": "제목",
  "userId": 1,
  "password": "1234"
}
```

#### 🔸Response Body
| 필드명     | 타입   | 필수  | 설명                |
|------------|------|-----|-------------------|
| `id`         | `Long` | ✅   | 일정 고유 ID          |
| `contents`   | `String` | ✅   | 등록된 일정 내용         |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `createdAt`  | `Date` | ✅   | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt`  | `Date` | ✅   | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response
```json
{
  "id": 1,
  "contents": "스프링 1주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 등록 완료 |

---

## 📌 2. 특정 스케쥴 조회 (변경 사항)

- **Method**: `GET`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명 | 타입 | 필수 | 설명 |
|-----|-----|----|----|
| `scheduleID` | `Long` | ✅ | 조회할 스케쥴 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
/api/schedules/1

#### 🔸Response Body

| 필드명       | 타입     | 필수 | 설명                |
|-----------|----------|----|-------------------|
| `id`        | `Long`     | ✅  | 일정 고유 ID          |
| `content`   | `String`   | ✅  | 등록된 일정 내용         |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "contents": "스프링 1주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 조회 완료 |
| 400 | 비밀번호 오류  |

---

## 📌 3. 특정 스케쥴 수정 (변경 사항)

- **Method**: `PATCH`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명            |
|------------|-------|------|-----------------|
| scheduleID | Long  | ✅   | 수정할 스케쥴 ID |

##### Body (JSON)
| 필드명      | 타입    | 필수 | 설명             |
|----------|---------|------|------------------|
| `content`  | `String`  | ✅   | 수정할 일정 내용    |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `password` | `String`  | ✅   | 수정/삭제용 비밀번호 |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/schedules/1`

##### Body (JSON)
```json
{
  "content": "스프링 2주차 듣기",
  "userId": 1,
  "password": "1234"
}
```

#### 🔸Response Body

| 필드명       | 타입      | 필수 | 설명                   |
|-----------|-----------|--|----------------------|
| `id`        | `Long`      | ✅ | 일정 고유 ID             |
| `content`   | `String`    | ✅ | 등록된 일정 내용            |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `createdAt` | `Date` | ✅ | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `LocalDate` | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "content": "스프링 2주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드

| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 수정 완료 |
| 400 | 비밀번호 오류 |

---

## 📌 4. 특정 스케쥴 삭제

- **Method**: `DELETE`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명            |
|------------|-------|------|-----------------|
| `scheduleID` | `Long`  | ✅   | 수정할 스케쥴 ID |

##### Body (JSON)
| 필드명     | 타입    | 필수 | 설명             |
|------------|---------|------|------------------|
| `password`   | `String`  | ✅   | 수정/삭제용 비밀번호 |


#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/schedules/1`

##### Body (JSON)
```json
{
  "password" : "1234"
}
```

#### 🔸Response Body

X

#### 🔸Sample Response
`헤더 200 OK`

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 삭제 완료 |
| 400 | 비밀번호 오류  |

---
## ERD
```mermaid
erDiagram
    USER {
        bigInt id PK
        varchar(100) username
        varchar(100) email
        datetime createAt
        datetime updateAt
    }

    SCHEDULE {
        bigInt id PK
        varchar(100) title
        bigInt userId
        varchar(100) content
        datetime createAt
        datetime updateAt
    }
```
</details>
<details>
    <summary>3. Lv_3 : API 명세서</summary>

## 📌 1. 사용자 등록

- **Method**: `POST`
- **URL**: `/api/users`

#### 🔸Request

##### Body (JSON)
| 필드명        | 타입    | 필수 | 설명    |
|------------|---------|-----|-------|
| `username` | `String`  | ✅  | 사용자 명 |
| `email`    | `String`  |    | 이메일   |

#### 🔸Sample Request
```json
{
  "username": "홍길동",
  "email": "홍길동@example.com"
}
```

#### 🔸Response Body
| 필드명         | 타입   | 필수 | 설명                   |
|-------------|------|----|----------------------|
| `id`        | `Long` | ✅  | 일정 고유 ID             |
| `userName`  | `String` | ✅  | 사용자 명                |
| `email`     | `String` |    | 이메일 |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response
```json
{
  "id": 1,
  "username": "홍길동",
  "email": "홍길동@example.com",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 등록 완료 |

---

## 📌 2. 특정 사용자 조회

- **Method**: `GET`
- **URL**: `/api/users/{userID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명 | 타입 | 필수 | 설명         |
|-----|-----|----|------------|
| `userID` | `Long` | ✅ | 조회할 사용자 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/users/1`

#### 🔸Response Body

| 필드명         | 타입   | 필수 | 설명                   |
|-------------|------|----|----------------------|
| `id`        | `Long` | ✅  | 일정 고유 ID             |
| `userName`  | `String` | ✅  | 사용자 명                |
| `email`     | `String` |    | 이메일 |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "username": "홍길동",
  "email": "홍길동@example.com",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 조회 완료 |
| 400 | 사용자 명 오류 |

---

## 📌 3. 특정 사용자 수정

- **Method**: `PATCH`
- **URL**: `/api/users/{userID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명         |
|------------|-------|------|------------|
| userID | Long  | ✅   | 수정할 사용자 ID |

##### Body (JSON)
| 필드명        | 타입    | 필수 | 설명    |
|------------|---------|-----|-------|
| `username` | `String`  | ✅  | 사용자 명 |
| `email`    | `String`  |    | 이메일   |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/users/1`

##### Body (JSON)
```json
{
  "username": "김철수",
  "email": "김철수@example.com"
}
```

#### 🔸Response Body

| 필드명         | 타입      | 필수 | 설명                   |
|-------------|-----------|--|----------------------|
| `id`        | `Long`      | ✅ | 일정 고유 ID             |
| `username`  | `String`    | ✅ | 사용자 명                |
| `email`     | `String`    |  | 이메일                  |
| `createdAt` | `Date` | ✅ | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "username": "김철수",
  "email": "김철수@example.com",
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드

| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 수정 완료 |
| 400 | 사용자 명 오류 |

---

## 📌 4. 특정 사용자 삭제

- **Method**: `DELETE`
- **URL**: `/api/users/{userID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명         |
|------------|-------|------|------------|
| `userID` | `Long`  | ✅   | 수정할 사용자 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/users/1`

#### 🔸Response Body

`X`

#### 🔸Sample Response

`헤더 200 OK`

#### 🔸상태코드
| 코드     | 설명        |
|--------|-----------|
| 200 OK | 정상 삭제 완료  |
| 400 | 사용자 id 오류 |

---

## 📌 1. 스케쥴 등록

- **Method**: `POST`
- **URL**: `/api/schedules`

#### 🔸Request

##### Body (JSON)
| 필드명        | 타입       | 필수 | 설명        |
|------------|----------|------|-----------|
| `content`  | `String` | ✅   | 등록할 일정 내용 |
| `title`    | `String` | ✅   | 제목        |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `password` | `String` | ✅   | 비밀번호      |

#### 🔸Sample Request
```json
{
  "content": "스프링 1주차 듣기",
  "title": "제목",
  "userId": 1,
  "password": "1234"
}
```

#### 🔸Response Body
| 필드명     | 타입   | 필수  | 설명                |
|------------|------|-----|-------------------|
| `id`         | `Long` | ✅   | 일정 고유 ID          |
| `contents`   | `String` | ✅   | 등록된 일정 내용         |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `createdAt`  | `Date` | ✅   | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt`  | `Date` | ✅   | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response
```json
{
  "id": 1,
  "contents": "스프링 1주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 등록 완료 |

---

## 📌 2. 특정 스케쥴 조회

- **Method**: `GET`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명 | 타입 | 필수 | 설명 |
|-----|-----|----|----|
| `scheduleID` | `Long` | ✅ | 조회할 스케쥴 ID |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
/api/schedules/1

#### 🔸Response Body

| 필드명       | 타입     | 필수 | 설명                |
|-----------|----------|----|-------------------|
| `id`        | `Long`     | ✅  | 일정 고유 ID          |
| `content`   | `String`   | ✅  | 등록된 일정 내용         |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `createdAt` | `Date` | ✅  | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅  | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "contents": "스프링 1주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 조회 완료 |
| 400 | 비밀번호 오류  |

---

## 📌 3. 특정 스케쥴 수정

- **Method**: `PATCH`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명            |
|------------|-------|------|-----------------|
| scheduleID | Long  | ✅   | 수정할 스케쥴 ID |

##### Body (JSON)
| 필드명      | 타입    | 필수 | 설명             |
|----------|---------|------|------------------|
| `content`  | `String`  | ✅   | 수정할 일정 내용    |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `password` | `String`  | ✅   | 수정/삭제용 비밀번호 |

#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/schedules/1`

##### Body (JSON)
```json
{
  "content": "스프링 2주차 듣기",
  "userId": 1,
  "password": "1234"
}
```

#### 🔸Response Body

| 필드명       | 타입      | 필수 | 설명                   |
|-----------|-----------|--|----------------------|
| `id`        | `Long`      | ✅ | 일정 고유 ID             |
| `content`   | `String`    | ✅ | 등록된 일정 내용            |
| `userId`   | `Long`    | ✅   | 작성자 ID    |
| `createdAt` | `Date` | ✅ | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `LocalDate` | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### 🔸Sample Response

```json
{
  "id": 1,
  "content": "스프링 2주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 🔸상태코드

| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 수정 완료 |
| 400 | 비밀번호 오류 |

---

## 📌 4. 특정 스케쥴 삭제

- **Method**: `DELETE`
- **URL**: `/api/schedules/{scheduleID}`

#### 🔸Request

##### Parameters (Path Variable / Query Parameter)
| 변수명     | 타입  | 필수 | 설명            |
|------------|-------|------|-----------------|
| `scheduleID` | `Long`  | ✅   | 수정할 스케쥴 ID |

##### Body (JSON)
| 필드명     | 타입    | 필수 | 설명             |
|------------|---------|------|------------------|
| `password`   | `String`  | ✅   | 수정/삭제용 비밀번호 |


#### 🔸Sample Request

##### Parameters (Path Variable / Query Parameter)
`/api/schedules/1`

##### Body (JSON)
```json
{
  "password" : "1234"
}
```

#### 🔸Response Body

X

#### 🔸Sample Response
`헤더 200 OK`

#### 🔸상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 삭제 완료 |
| 400 | 비밀번호 오류  |

---
## ERD
```mermaid
erDiagram
    USER {
        bigInt id PK
        varchar(100) username
        varchar(100) password
        varchar(100) email
        datetime createAt
        datetime updateAt
    }

    SCHEDULE {
        bigInt id PK
        varchar(100) title
        bigInt userId
        varchar(100) content
        datetime createAt
        datetime updateAt
    }
```
</details>
<details>
    <summary>7. Lv_4 : API 명세서</summary>

## 📌 1. 댓글 생성

- **Method**: `POST`
- **URL**: `/api/comments`

#### Request

- Body (JSON)

    | 필드명          | 타입       | 필수 | 설명         |
    |--------------|----------|------|------------|
    | `userId`     | `Long`   | ✅   | 연관된 작성자 ID |
    | `scheduleId` | `Long`      | ✅   | 연관된 스케줄 ID |
    | `content`    | `String` | ✅   | 댓글 내용 |

#### Sample Request
```json
{
  "userId": 1,
  "scheduleId": 1,
  "content": "댓글 구현 완료!"
}
```

#### Response Body
| 필드명          | 타입   | 필수  | 설명                   |
|--------------|------|-----|----------------------|
| `id`         | `Long` | ✅   | 일정 고유 ID             |
| `content`    | `String` | ✅   | 댓글 내용                |
| `userId`     | `Long`    | ✅   | 연관된 작성자 ID           |
| `scheduleId` | `Long`    | ✅   | 연관된 스케줄 ID           |
| `createdAt`  | `Date` | ✅   | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt`  | `Date` | ✅   | 수정일 (형식: YYYY-MM-DD) |

#### Sample Response
```json
{
  "id": 1,
  "content": "댓글 응답 완료!",
  "userId": 1,
  "scheduleId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 등록 완료 |
| 404    | 유저, 스케줄 정보 없음 |

---

## 📌 2. 특정 댓글 조회

- **Method**: `GET`
- **URL**: `/api/comments/{commentID}`

#### Request

- Parameters (Path Variable / Query Parameter)

    | 변수명         | 타입 | 필수 | 설명        |
    |-------------|-----|----|-----------|
    | `commentID` | `Long` | ✅ | 조회할 댓글 ID |

#### Sample Request

- Parameters (Path Variable / Query Parameter)

    `/api/comments/1`

#### Response Body

| 필드명 | 타입 | 필수 | 설명                   |
|------------|----------|----|----------------------|
| `id`       | `Long` | ✅ | 댓글 고유 ID             |
| `content`  | `String` | ✅ | 등록된 댓글 내용            |
| `userId`   | `Long` | ✅ | 연관된 사용자 ID           |
| `scheduleId` | `Long` | ✅ | 연관된 스케줄 ID           |
| `createdAt` | `Date` | ✅ | 작성일 (형식: YYYY-MM-DD) |
| `updatedAt` | `Date` | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### Sample Response

```json
{
  "id": 1,
  "content": "댓글 조회 하기!",
  "userId": 1,
  "scheduleId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 상태코드
| 코드     | 설명        |
|--------|-----------|
| 200 OK | 정상 조회 완료  |
| 401    | 사용자 인증 실패 |

---

## 📌 3. 특정 댓글 수정

- **Method**: `PATCH`
- **URL**: `/api/comments/{commentID}`

#### Request

- Parameters (Path Variable / Query Parameter)

    | 변수명     | 타입  | 필수 | 설명        |
    |------------|-------|------|-----------|
    | commentID | Long  | ✅   | 수정할 댓글 ID |

- Body (JSON)

    | 필드명      | 타입    | 필수 | 설명          |
    |----------|---------|----|---------------|
    |`content`  | `String`  | ✅ | 수정할 일정 내용 |

#### Sample Request

- Parameters (Path Variable / Query Parameter)

    `/api/comments/1`

- Body (JSON)
    ```json
    {
      "id": 1,
      "userId": 1,
      "scheduleId": 1,
      "content": "스프링 2주차 듣기",
      "updateAt": "2025-05-19"
    }
    ```

#### Response Body

| 필드명       | 타입       | 필수 | 설명                   |
|-----------|----------|--|----------------------|
| `id`        | `Long`   | ✅ | 댓글 고유 ID             |
| `userId`   | `Long` | ✅ | 연관된 유저 ID            |
| `scheduleId`   | `Long`   | ✅   | 연관된 스케줄 ID           |
| `content` | `String`      | ✅ | 댓글 내용                |
| `updatedAt` | `Date`   | ✅ | 수정일 (형식: YYYY-MM-DD) |

#### Sample Response

```json
{
  "id": 1,
  "content": "스프링 2주차 듣기",
  "userId": 1,
  "createdAt": "2025-05-19",
  "updatedAt": "2025-05-19"
}
```

#### 상태코드

| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 수정 완료 |
| 401    | 사용자 인증 실패 |

---

## 📌 4. 특정 댓글 삭제

- **Method**: `DELETE`
- **URL**: `/api/comments/{commentID}`

#### Request

- Parameters (Path Variable / Query Parameter)

   | 변수명     | 타입  | 필수 | 설명        |
   |------------|-------|------|-----------|
   | `commentID` | `Long`  | ✅   | 삭제할 댓글 ID |

#### Sample Request

- Parameters (Path Variable / Query Parameter)

  `/api/comments/1`


- Response Body

  x

#### Sample Response
`헤더 200 OK`

#### 상태코드
| 코드     | 설명       |
|--------|----------|
| 200 OK | 정상 삭제 완료 |
| 401    | 사용자 인증 실패  |

---
## ERD
```mermaid
erDiagram
    USER ||--o{ SCHEDULE : contains
    USER ||--o{ COMMENT : contains
    USER {
        bigInt id PK
        varchar(100) username
        varchar(100) password
        varchar(100) email
        datetime create_at
        datetime update_at
    }
    SCHEDULE ||--o{ COMMENT : contains
    SCHEDULE {
        bigInt id PK
        varchar(100) title
        bigInt userId
        varchar(100) content
        datetime createAt
        datetime updateAt
    }
    COMMENT {
        bigInt id PK
        bigInt user_id FK
        bigInt schedule_id FK
        varchar(100) content
        datetime create_at
        datetime update_at
    }
```
</details>