<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
        <th>사원번호</th>
        <th>이름</th>
        <th>부서이름</th>
        <th>매니저</th>
        <th>입사일</th>
        <th>월급</th>
        <th>커미션</th>
        <th>부서번호</th>
        <td>부서이름</td>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>EMPNO</th>
        <th>ENAME</th>
        <th>JOB</th>
        <th>MGR</th>
        <th>HIREDATE</th>
        <th>SAL</th>
        <th>COMM</th>
        <th>DEPTNO</th>
        <th>DNAME</th>
    </tr>
    </tfoot>
    <tbody>
    <%-- var = "dept" page 메모리에 저장 items = 컨트롤러에서 보낸 데이터를 읽어 오는 것 --%>
    <c:forEach var="dept" items="${deptList}" varStatus="empList">
        <%-- var = "list" page 메모리에 저장 items = --%>
        <c:forEach var="emp" items="${dept.empList}">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.mgr}</td>
                <td>${emp.hiredate}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.deptno}</td>
                <td>${board.dname}</td>
            </tr>
        </c:forEach>
    </c:forEach>
    </tbody>
</table>