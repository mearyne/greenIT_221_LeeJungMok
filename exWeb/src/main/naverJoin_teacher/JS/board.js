const tbody = document.body.querySelector('tbody');
tbody.innerHTTP += `
    <tr>
    <td>
        <%=no%>
    </td>
    <td>
        <%=code%>
    </td>
    <td>
        <%=title%>
    </td>
    <td>
        <%=viewCnt%>
    </td>
    <td>
        <%=likeCnt%>
    </td>
    <td>
        <%=createdAt%>
    </td>
    <td>
        <%=modifiedAt%>
    </td>
    </tr>
    `
