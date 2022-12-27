<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>list</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">

        $(document).ready(function (){

            $("#updateForm").submit(function(event) {
                //　preventDefault()는 href　로 연결해 주지 않고
                //　단순히 click　에 대한 처리를 하도록 해준다.
                event.preventDefault();     // 기본동작 action 주소로 보내지 않는다.

                let bid = $("#input_bid").val();
                let bname = $("#input_bname").val();
                let btitle = $("#input_btitle").val();
                let bcontent = $("#input_bcontent").val();

                let form={
                    bid: bid,
                    bname: bname,
                    btitle: btitle,
                    bcontent:bcontent
                };

                /*
                $.ajax({
                     type : `http method type`,
                     url : `url`,
                     data : `서버에 전송할 데이터`,
                     contentType : "전송할 데이터 타입",
                     //기본 값 : "application / x-www-form-urlencoded; charset = UTF-8"
                     dataType : '서버로 부터 수신할 데이터 타입',
                     //아무것도 지정하지 않으면 jQuery 는 응답의 MIME 유형을 기반으로 해석을 시도
                     error : `에러 발생시 수행할 함수`,
                     success : `성공시 수행할 함수`
                   });
                */

                console.log(JSON.stringify(form));  // JS Code 를 제이슨으로 서버에게 보낸다.

                $.ajax({
                    type : "PUT",
                    url : "/boards/" + bid,      /* /boards/{bod} */
                    cashe:false,                 /* cashe 는 무조건 false */
                    contentType:'application/json; charset=utf-8',  /* MINE 타입 : 안의 데이터 정보를 무엇인지 알려주어서
                                                                       어떻게 처리할 것인지 미리 정하게 할 수 있음 */
                    data: JSON.stringify(form), /* 제이슨으로 바꿔준다. */
                    success: function (result) {
                        console.log(result);
                        //location.href = "/list";　(자바 스크립트 문법) = $(location).attr('href', '/list2'); (제이쿼리 문법)
                        //$(location).attr('href', '/rest_board.html');
                        $(location).attr('href', '/list2');
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });

            });

        });
    </script>¥
</head>
<body>
<table width="700" cellpadding="0" cellspacing="0" border="1">
    <form id="updateForm" action="modify" method="post">
        <input id="input_bid" type="hidden" name="bid" value="${content_view.bid}">
        <tr>
            <td> 번호 </td>
            <td> ${content_view.bid} </td>
        </tr>
        <tr>
            <td> 히트 </td>
            <td> ${content_view.bhit} </td>
        </tr>
        <tr>
            <td> 이름 </td>
            <td> <input id="input_bname" type="text" name="bname" value="${content_view.bname}"></td>
        </tr>
        <tr>
            <td> 제목 </td>
            <td> <input id="input_btitle" type="text" name="btitle" value="${content_view.btitle}"></td>
        </tr>
        <tr>
            <td> 내용 </td>
            <td> <textarea id="input_bcontent" rows="10" name="bcontent" >${content_view.bcontent}</textarea></td>
        </tr>
        <tr >
            <td colspan="2"> <input type="submit" value="수정">
                &nbsp;&nbsp; <a href="list">목록보기</a>
                &nbsp;&nbsp; <a href="delete?bid=${content_view.bid}">삭제</a>
                &nbsp;&nbsp; <a href="reply_view?bid=${content_view.bid}">답변</a></td>
        </tr>
    </form>
</table>

</body>
</html>