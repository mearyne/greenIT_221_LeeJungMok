<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="join.css">

    <title>Join HTML </title>
</head>

<body>
    <a href="http://naver.com">
        <header><br></header>
    </a>
    <form>
        <p>아이디<br></p> <input id="box" type="text" placeholder="아이디를 입력해주세요" required>

        <p>비밀번호<br></p><input id="box" type="password" placeholder="비밀번호를 입력해주세요" required>
        <p>비밀번호 재확인<br></p><input id="box" type="password" placeholder="동일한 비밀번호를 입력해주세요" required>

        <p>이름<br></p><input id="box" type="text" placeholder="이름을 입력해주세요" required>

        <p>생년월일<br></p>
        <input class="miniBox" id="box" type="text" placeholder="년" required>

        <select name="month" id="box" class="miniBox">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
        </select>

        <input class="miniBox" id="box" type="text" placeholder="일" required>

        <p>성별<br></p>
        <select name="gender" id="box" required>
            <option value="male">남자</option>
            <option value="female">여자</option>
            <option value="none">선택 안함</option>
        </select>

        <p>본인 확인 이메일(선택)<br></p><input type="text" id="box" placeholder="이메일을 입력해주세요">
        <p>휴대전화<br></p><input id="box" type="text" required><br>

        <input type="submit" id="submit" value="가입하기" id="box">
    </form>
</body>

</html>