<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%--<script>
    function send(method, url, data = '') {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        xhr.onload = function() {
            location.reload();
        };
        xhr.send(data);
    }
</script>--%>

<form action="/web1/" method="POST">
    Name:<br>
    <input type="text" name="name"><br>
    <input type="text" name="action" value="put" hidden>
    <br>
    <button type="submit">add</button>
</form>

<c:if test="${fn:length(users) > 0}">
    <table border="1" cellspacing="0" cellpadding="2">
        <br>
        <br>
        <tr>
            <td>ID</td>
            <td>Name</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>
                    <form method="post" action="/web1/" style="margin: 0;">
                        <input type="text" name="id" value="${user.id}" hidden>
                        <input type="text" name="name" value="${user.name}">
                        <input type="text" name="action" value="update" hidden>
                        <button type="submit">update</button>
                    </form>
                </td>
                <td>
                    <form method="post" action="/web1/" style="margin: 0;">
                        <input type="text" name="id" value="${user.id}" hidden>
                        <input type="text" name="action" value="delete" hidden>
                        <button type="submit">delete</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>

