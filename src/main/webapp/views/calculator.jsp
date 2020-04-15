<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="Calculator">
    <h2>Fencing Calculator</h2>
    <form id="fencyForm" method="post">
        <form:label path="fencyList">Fency Type: </form:label>
        <form:select name="fencyList" path="fencyList" items="${fencyList}" itemLabel="type" itemValue="id"/>
        <label for="fenceLength">Fency Length: </label>
        <input name="fenceLength" id="fenceLength" type="number" value="1" min="1" step="0.1"> meter
        <input type="submit" value="Check">
    </form>
</div>

<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--    <script src="<c:url value="/resources/app.js" />"></script>--%>
</body>
</html>
