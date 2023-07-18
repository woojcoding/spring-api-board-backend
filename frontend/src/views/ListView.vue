<template>
  <div>
    <h1>자유게시판 - 목록</h1>
    <form action="/boards/free/list" method="get">
      <table class="search">
        <tr>
          <td>등록일</td>
          <td><input type="date" name="startDate"> ~ <input type="date" name="endDate"></td>
          <td>
            <select name="category">
              <option value="ALL">전체 카테고리</option>
              <option></option>
            </select>
          </td>
          <td> <input type="text" name="keyword" placeholder="검색어를 입력해 주세요.(제목 + 작성자 + 내용)"></td>
          <td><button type="submit">검색</button></td>
        </tr>
      </table>
    </form><br>
    총 &nbsp <span>0</span> &nbsp 건
    <table class="boardList">
      <tr>|
        <td>카테고리</td>
        <td>첨부</td>
        <td>제목</td>
        <td>작성자</td>
        <td>조회수</td>
        <td>등록 일시</td>
        <td>수정 일시</td>
      </tr>
      <tr >
        <td>카테고리</td>
        <td>첨부여부</td>
        <td>
          <a href="boards/free/view">제목</a>
        </td>
        <td>글쓴이</td>
        <td>조회수</td>
        <td>등록일시</td>
        <td>수정일시</td>
      </tr>
    </table>
  </div>
</template>
