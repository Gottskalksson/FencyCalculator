<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<div id="app">
    <table>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tbody id="result">
        <tr class="title">
            <td>Product</td>
            <td>Type</td>
            <td>Quantity</td>
            <td>Price Each</td>
            <td>Total Price</td>
        </tr>
        <c:forEach items="${itemList}" var="item">
        <tr>
            <td>${item.description}</td>
            <td>${item.type}</td>
            <td>${item.quantity}</td>
            <td>£ ${item.priceForEach}</td>
            <td class="price">£ ${item.totalPrice}</td>
        </tr>
        </c:forEach>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="2">&nbsp;</td>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="title">Total exVAT</td>
            <td id="exVat" class="price">£ exVAT</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="title">VAT</td>
            <td id="vat" class="price">£ VAT</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="title">TOTAL PRICE: </td>
            <td id="sum" class="price">£ SUM</td>
        </tr>

        </tbody>

    </table>
</div>

</body>
</html>
