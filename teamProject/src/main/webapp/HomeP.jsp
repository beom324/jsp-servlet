<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모두의자격증</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&family=Poppins:wght@400;600&display=swap"
        rel="stylesheet"><!--구글폰트-->
    <script src="https://kit.fontawesome.com/e72539902e.js" crossorigin="anonymous"></script> <!--아이콘 사용-->
    <style>
        /* 초기화 */
        body,h1,h2,h3,div,p,ul, li,dl, dt,dd {
            margin: 0;
            padding: 0
        }

        /*바디 기본폰트설정,구글 폰트설정함*/
        body { 
            font-family: 'Poppins', 'Noto Sans KR', sans-serif;
            font-size: 14px;
            line-height: 1.5
            
        }

        .header {
            width: 1200px;
            height: 90px;
            margin: 0 auto;
            padding: 15px 10px 0px 5px;
            position: relative;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        li {
            list-style: none;
        }

        a {
            text-decoration: none;
            color: #575656;

        }

        .logo img {
            width: 260px;
            height: 90px;
        }

        .menuBar {
            width: 550px;
            height: 90px;
        }

        .gnb {
            height: 90px;
            display: flex;
            justify-content: space-between;
            font-size: 22px;
            padding-right: 20px;
        }

        .gnb li {
            align-self: center;
        }

        .topMenu {       
            padding-bottom: 13px;
            position: relative;
        }

        .TM {
            display: flex;
            justify-content: flex-end;
            font-size: 15px;
            padding: 0 5px 0 5px;
            width: 210px;
            height: 25px;
        }

        .searchBar {
            border: 3px solid #928e8e;
            border-radius: 7px;
            height: 23px;
        }
    
        /*돋보기아이콘*/
        .fa-magnifying-glass{  
            position: absolute;
            right: 9px;  /*모니터 크기에 따라 위치 달라짐.필요하면 수치조정하기 */
            bottom: 19px;
            color: #928e8e;
        }



        /*--------header CSS 끝-----*/

        /* -------main css---------*/


        /* 배너-레이아웃용이므로 삭제하고 작업 ㄱ  */
        .banner {
            width: 1fr;
            height: 320px;
            background: #DDDDDD;
        }

        .article {
            width: 1200px;
            height: 1000px;
        }


        /* -------main css끝--------*/

        

        /* ----footer CSS ---- */
        
        .footer {
            width: 1fr;
            height: 320px;
            background: #4F4A45;
            color: #ffffff;

        }

        .ft_info {
            width: 1215px;
            margin: auto;
            padding-top: 14px;
            font-size: 15px;
            position: relative;
        }

        .ft_link {
            margin: 20px;
        }

        .ft_link li {
            list-style: disc
        }

        .fa-brands{
            width: 100px;
            height: 30px;
        }
        .sns{
            width: 350px;
            height: 50px;
            position: absolute;
            right: 5px;
            bottom: 70px;
            display: flex;
            align-content: space-between;

        }
    </style>
</head>

<body>
    <header id="header" class="header">
        <h1 class="logo"><a href="main.html"><img src="logo.png" 모두의자격증"></a> </h1>
        <nav class="menuBar">
            <ul class="gnb">
                <li><a href="#">자격증정보</a></li>
                <li><a href="#">스터디모집</a></li>
                <li><a href="#">마이페이지</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </nav>
        <div class="topMenu">
            <ul class="TM">
                <li><a href="#">로그인</a></li>
                <span>&nbsp;|&nbsp;</span>
                <li><a href="#">회원가입</a></li>
                <i class="fa-solid fa-magnifying-glass"></i>
            </ul>
            <input class="searchBar" id="searchBar" name="searchBar" type="text" size="28" />
        </div>

    </header>



    <main id="main" class="main">
        <div class="banner"><hr></div> <!--배너 레이아웃용 삭제하고 작업 ㄱ  -->
        <article class="article" id="article">
            <section></section>
            <section></section>
            <section></section>
        </article>
    </main>



    <footer id="footer" class="footer">

        <div class="ft_info">
            <p>모두의자격증)대표자 : 김유성 서울특별시 동작구 보라매로5길 15 (신대방동, 전문건설회관) 고객센터 : 1588-3413 (09:00 ~ 18:00 / 토, 일, 공휴일 휴무) 이메일 :
                echosting@mojacorp.com
                <br>사업자등록번호 : 118-81-20586 통신판매업신고 : 동작 제 02-680-078호 사업자정보확인 호스팅 제공 : 모두의자격증(주)
                <br>모두의자격증(주)는 통신판매중개자로서 통신판매의 거래당사자가 아니며, 입점판매자가 등록한 상품정보 및 거래에 대해 일체 책임을 지지 않습니다.
            </p>
            <br>
            <p>Copyright © MojaCorp. All Rights Reserved.</p><br>
            <div class="ft_link">
                <ul>
                    <li>회사소개</li>
                    <li>엑스퍼트 이용약관</li>
                    <li>파트너센터 이용약관</li>
                    <li>개인정보처리방침</li>
                </ul>
            </div>
            <br>
            <div class="sns">
                <i class="fa-brands fa-youtube fa-3x"></i>
                <i class="fa-brands fa-facebook  fa-3x"></i>
                <i class="fa-brands fa-instagram  fa-3x"></i>
                <i class="fa-brands fa-twitter  fa-3x" id="searchBTN"><a href="#"></a></i>
            </div>
        </div>
      
    </footer>

</body>

</html>