<%--
  Created by IntelliJ IDEA.
  User: xwb
  Date: 2022/2/6
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>局部刷新-ajax</title>
    <script type="text/javascript">
        var xmlHttp = new XMLHttpRequest();
        function doAjax(){
            xmlHttp.onreadystatechange = function () {
                //alert("==readyState属性值==" + xmlHttp.readyState + "==status:" + xmlHttp.status)
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                    var data = xmlHttp.responseText;
                    document.getElementById("mydata").innerText = data;
                }
            }
            var name = document.getElementById("name").value
            var height = document.getElementById("height").value
            var weight = document.getElementById("weight").value
            var param = "name=" + name + "&w="+ weight +"&h=" + height;
            xmlHttp.open("get","bmiAjax?"+param,true);
            xmlHttp.send()
    }
    </script>
</head>
<body>
    <p>局部刷新ajax-计算bmi</p>
    <div>
        姓名：<input type="text" id="name"/><br/>
        身高：<input type="text" id="height"/><br/>
        体重：<input type="text" id="weight"/><br/>
        <input type="button" value="计算bmi" onclick="doAjax()">
        <br/>
        <br/>
        <div id="mydata">等待加载数据...</div>
    </div>
</body>
</html>
