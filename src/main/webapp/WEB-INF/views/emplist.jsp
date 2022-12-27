<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- C태그 쓰기 위해 넣은 taglib 므로 반드시 확인 -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table width="1000" border="1">
    <tr>
        <td>EMPNO</td>
        <td>ENAME</td>
        <td>JOB</td>
        <td>MGR</td>
        <td>HIREDATE</td>
        <td>SAL</td>
        <td>COMM</td>
        <td>DEPTNO</td>
    </tr>

    <!--이때 list 는 BListCommand 에서 메모리에 올린 list 를 뜻함. 포워딩시까지 살아있으므로-->
    <!--forEach 문을 이용해 데이터를 꺼낼 수 있다.-->
    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.empno}</td>
            <td>${board.ename}</td>
            <td>${board.job}</td>
            <td>${board.mgr}</td>
            <td>${board.hiredate}</td>
            <td>${board.sal}</td>
            <td>${board.comm}</td>
            <td>${board.deptno}</td>
        </tr>
    </c:forEach>

</table>

    <c:if test="${pageMaker.prev}">
        <a href="emplist${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
    </c:if>

    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
        <c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
        <a href="emplist${pageMaker.makeQuery(idx)}">${idx}</a>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
        <a href="emplist${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
    </c:if> <br>

</body>
</html>