<%--
  Created by IntelliJ IDEA.
  User: Flyer
  Date: 24.01.2020
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Безымянная страница</title>
    <meta name="generator" content="WYSIWYG Web Builder 14 - http://www.wysiwygwebbuilder.com">
    <link href="Безымянный1.css" rel="stylesheet">
    <link href="index.css" rel="stylesheet">
    <script>
        function Validatecontact()
        {
            var regexp;
            var Editbox1 = document.getElementById('Editbox1');
            if (!(Editbox1.disabled || Editbox1.style.display === 'none' || Editbox1.style.visibility === 'hidden'))
            {
                if (Editbox1.value == "")
                {
                    alert("Please enter a value for the \"name\" field.");
                    Editbox1.focus();
                    return false;
                }
            }
            var Editbox2 = document.getElementById('Editbox2');
            if (!(Editbox2.disabled || Editbox2.style.display === 'none' || Editbox2.style.visibility === 'hidden'))
            {
                if (Editbox2.value == "")
                {
                    alert("Please enter a value for the \"Editbox2\" field.");
                    Editbox2.focus();
                    return false;
                }
            }
            var Editbox4 = document.getElementById('Editbox4');
            if (!(Editbox4.disabled || Editbox4.style.display === 'none' || Editbox4.style.visibility === 'hidden'))
            {
                if (Editbox4.value == "")
                {
                    alert("Please enter a value for the \"phone\" field.");
                    Editbox4.focus();
                    return false;
                }
            }
            var Editbox5 = document.getElementById('Editbox5');
            if (!(Editbox5.disabled || Editbox5.style.display === 'none' || Editbox5.style.visibility === 'hidden'))
            {
                if (Editbox5.value == "")
                {
                    alert("Please enter a value for the \"Editbox5\" field.");
                    Editbox5.focus();
                    return false;
                }
            }
            var Editbox6 = document.getElementById('Editbox6');
            if (!(Editbox6.disabled || Editbox6.style.display === 'none' || Editbox6.style.visibility === 'hidden'))
            {
                if (Editbox6.value == "")
                {
                    alert("Please enter a value for the \"Editbox6\" field.");
                    Editbox6.focus();
                    return false;
                }
            }
            var Editbox3 = document.getElementById('Editbox3');
            if (!(Editbox3.disabled || Editbox3.style.display === 'none' || Editbox3.style.visibility === 'hidden'))
            {
                if (Editbox3.value == "")
                {
                    alert("Please enter a value for the \"Editbox3\" field.");
                    Editbox3.focus();
                    return false;
                }
            }
            return true;
        }
    </script>
</head>
<body>
<div id="wb_Form1" style="position:relative;left:324px;top:149px;width:368px;height:276px;z-index:14;">
    <form name="addNewUser" method="post" action="" enctype="multipart/form-data" id="Form2" onsubmit="return Validatecontact()">
        <label for="Editbox1" id="Label1" style="position:absolute;left:10px;top:15px;width:120px;height:16px;line-height:16px;z-index:0;">Имя</label>
        <input type="text" id="Editbox1" style="position:absolute;left:148px;top:15px;width:190px;height:16px;z-index:1;" name="name" value="" maxlength="50" spellcheck="false">
        <label for="Editbox2" id="Label2" style="position:absolute;left:10px;top:46px;width:120px;height:16px;line-height:16px;z-index:2;">Фамилия</label>
        <input type="text" id="Editbox2" style="position:absolute;left:148px;top:46px;width:190px;height:16px;z-index:3;" name="Editbox2" value="" maxlength="50" spellcheck="false">
        <label for="Editbox3" id="Label3" style="position:absolute;left:10px;top:77px;width:120px;height:16px;line-height:16px;z-index:4;">Должность</label>
        <label for="Editbox4" id="Label4" style="position:absolute;left:10px;top:108px;width:120px;height:16px;line-height:16px;z-index:5;">Номер телефона</label>
        <input type="tel" id="Editbox4" style="position:absolute;left:148px;top:108px;width:190px;height:16px;z-index:6;" name="phone" value="+375291234567" maxlength="13" spellcheck="false">
        <label for="Editbox5" id="Label5" style="position:absolute;left:10px;top:139px;width:120px;height:16px;line-height:16px;z-index:7;">Пароль</label>
        <input type="password" id="Editbox5" style="position:absolute;left:148px;top:139px;width:190px;height:16px;z-index:8;" name="Editbox5" value="" spellcheck="false">
        <label for="Editbox6" id="Label6" style="position:absolute;left:10px;top:170px;width:120px;height:16px;line-height:16px;z-index:9;">Подтвердить пароль</label>
        <input type="password" id="Editbox6" style="position:absolute;left:148px;top:170px;width:190px;height:16px;z-index:10;" name="Editbox6" value="" spellcheck="false">
        <input type="submit" id="Button2" onclick="location.href='/addNewUser'" name="" value="Send" style="position:absolute;left:148px;top:201px;width:96px;height:25px;z-index:11;">
        <input type="reset" id="Button3" onclick="document.getElementById('').reset();return false;" name="" value="Reset" style="position:absolute;left:148px;top:231px;width:96px;height:25px;z-index:12;">
        <input type="text" id="Editbox3" style="position:absolute;left:148px;top:74px;width:190px;height:16px;z-index:13;" name="Editbox3" value="" maxlength="50" spellcheck="false">
    </form>
</div>
</body>
</html>