<%@ page import="com.quest.QuestLogic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title>MegaQuest</title>
        <link href="static/main.css" rel="stylesheet">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    </head>

    <body>

        <h2>MegaQuest</h2>

        <hr>
        <p><%=QuestLogic.getCurrentQuestion()%></p>

        <br>


        <div class="answers">
            <%
                for (String a : QuestLogic.getAnswerOption()) {
            %>
            <input type="button" onclick="go(this.value)" value="<%=a%>" class="answer_button">
            <br>
            <%
                }
            %>
        </div>


        <hr>

        <div class="statistic">
            <p>Статистика:</p>
            <p>Количество игр: <%=session.getAttribute("gamesCount")%></p>
            <p>Количество побед: <%=session.getAttribute("winCount")%></p>
            <p>Количество поражений: <%=session.getAttribute("loseCount")%></p>
        </div>

        <script>
            function go(answer) {
                $.ajax({
                    url: '/quest',
                    type: 'GET',
                    contentType: 'application/json;charset=UTF-8',
                    async: false,
                    data: {
                      answer : answer
                    },
                    success: function () {
                        location.reload();
                    }
                });
            }

        </script>
    </body>
</html>
