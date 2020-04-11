<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="Calculator">
    <h2>Fencing Calculator</h2>
    <table width="700" border="0" cellpadding="2" cellspacing="0">
        <tbody>
        <tr>
            <td width="107" valign="top">Fence Type:</td>
            <td colspan="4">
                <select id="fenceType" style="width: 300px">
                    <option class="fence" id="900095">0.9m x 95 x 18</option>
                    <option class="fence" id="1200095">1.2m x 95 x 18</option>
                    <option class="fence" id="1500095">1.5m x 95 x 18</option>
                    <option class="fence" id="1500150">1.5m x 150 x 18</option>
                    <option class="fence" id="1800095">1.8m x 95 x 18</option>
                    <option class="fence" id="1800150">1.8m x 150 x 18</option>
                    <option class="fence" id="3600150">3.6m x 150 x 18</option>
                    <option class="fence" id="4800150">4.8m x 150 x 18</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="50" valign="top">Fence Length:</td>
            <td colspan="4">
                <input class="fenceLength" type="number" value="1" min="1" step="0.1">
            </td>
        </tr>
        <tr>
            <td>
                <button id="button">Check</button>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="2">&nbsp;</td>
        </tr>
        <tbody id="result">
        <tr class="title">
            <td>Type</td>
            <td>Description</td>
            <td>Quantity</td>
            <td>Price Each</td>
            <td>Total Price</td>
        </tr>
        <tr>
            <td>Board</td>
            <td>Some board</td>
            <td>Count</td>
            <td>1 pound</td>
            <td>1 pound</td>
        </tr>
        <tr>
            <td>Post</td>
            <td>Some post</td>
            <td>Count</td>
            <td>1 pound</td>
            <td>1 pound</td>
        </tr>
        <tr>
            <td>Rails</td>
            <td>Some rails</td>
            <td>Count</td>
            <td>1 pound</td>
            <td>1 pound</td>
        </tr>
        <tr>
            <td>Post Crete</td>
            <td>Some posts</td>
            <td>Count</td>
            <td>1 pound</td>
            <td>1 pound</td>
        </tr>
        <tr>
            <td>Nails</td>
            <td>A lot of nails</td>
            <td>Count</td>
            <td>1 pound</td>
            <td>1 pound</td>
        </tr>
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
            <td> exVAT</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="title">VAT</td>
            <td> VAT</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="title">TOTAL PRICE: </td>
            <td> SUM</td>
        </tr>

        </tbody>


        </tbody>
    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/app.js" />"></script>
</body>
</html>
