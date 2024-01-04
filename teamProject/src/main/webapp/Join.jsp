<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모두의자격증</title>
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
	
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&family=Poppins:wght@400;600&display=swap"
        rel="stylesheet"><!--구글폰트-->
    <script src="https://kit.fontawesome.com/e72539902e.js" crossorigin="anonymous"></script> <!--아이콘 사용-->
    <style>
    	@font-face {
		 font-family: 'NanumBarunGothic';
		 font-style: normal;
		 font-weight: 400;
		 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
		 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf') format('truetype');
	}

	.login-form {
	  	width: 500px;
	  	margin-right: auto;
	    margin-left: auto;
	    margin-top: 50px;
	    padding: 20px;
	  	text-align: center;
	    border: none;
	}

	.i_d {
		float: left;
		font-weight: bold;
	}

	.id {
		float: center;
		text-align: left;
	    font-size: 14px;
	    padding: 10px;
	    border: none;
	  	border-bottom: 1px solid gray;
	    width: 200px;
	    margin-bottom: 10px;

	}

	.idcheck {
	   	  width: 65px;
	   	  height: 32px;
	   	  background-color: white;
	   	  border-radius: 25px;
	   	  border-color: gray;
	   	  cursor:pointer;
	}

	.passwd {
		float: left;
		font-weight: bold;
	}

	.passwdche {
		float: left;
		font-weight: bold;
	}

	.pwd {
		text-align: left;
		float: center;
	    font-size: 14px;
	    padding: 10px;
	    border: none;
	  	border-bottom: 1px solid gray;
	    width: 260px;
	    margin-bottom: 10px;
	    margin-left: -50px;
	}

	.pwdCheck {
	  font-size: 14px;
	  float: center;
	  padding: 10px;
	  border: none;
	  border-bottom: 1px solid gray;
	  width: 260px;
	  margin-bottom: 10px;
	  margin-left: -80px;
	}

	.Na {
		float: left;
		font-weight: bold;
	}

	.name {
		float: center;
	  font-size: 14px;
      padding: 10px;
      border: none;
	  border-bottom: 1px solid gray;
      width: 260px;
      margin-bottom: 10px;
      margin-left: -30px;
	}


	.adr {
		float: left;
		font-weight: bold;
	}



	.addresscheck {
		background-color: white;
	   	  border-radius: 25px;
	   	  border-color: gray;
	   	  cursor:pointer;
	}

	#sample4_postcode {
	  font-size: 14px;
	  padding: 10px;
	  border: none;
	  border-bottom: 1px solid gray;
	  width: 220px;
	  margin-bottom: 10px;
	}

	#sample4_roadAddress {
	  font-size: 14px;
	  padding: 10px;
	  border: none;
	  border-bottom: 1px solid gray;
	  width: 260px;
	  margin-bottom: 10px;
	}

	#sample4_jibunAddress {
	  font-size: 14px;
	  padding: 10px;
	  border: none;
	  border-bottom: 1px solid gray;
	  width: 260px;
	  margin-bottom: 10px;
	}

	#sample4_detailAddress {
	  font-size: 14px;
	  padding: 10px;
	  border: none;
	  border-bottom: 1px solid gray;
	  width: 260px;
	  margin-bottom: 10px;
	}

	.join {
	  font-size: 14px;
	  border: 3px solid gray;
	  padding: 10px;
	  width: 260px;
	  background-color: white;
	  margin-bottom: 30px;
	  color: black;
	  cursor:pointer;
	}

	.Administrator_Login {
	  background-color: white;
	  font-size: 15px;
	  border: none;
	}

	.title {
	  color: gray;
	}

	.dat {
		float: left;
		font-weight: bold;
	}

	.date {
		float: left;
		font-weight: bold;
	  	font-size: 14px;
	  	color: gray;
	}


	p {
	  font-size: 13px;
	  color: gray;
		padding: 10px;
	}

	.gen {
		float: left;
		font-weight: bold;
	}

	.col-tit {
		float: left;
		font-weight: bold;
		padding-top: 20px;

	}

	.col-content {
		font-size: 14px;
      	padding: 10px;
      	border: none;
      	width: 260px;
      	margin-bottom: 10px;
	}

	#HPhone1 {
		text-align: left;
		font-size: 14px;
	    padding: 10px;
	    border: none;
	  	border-bottom: 1px solid gray;
	    width: 50px;
	    margin-bottom: 10px;
	}

	#HPhone2 {
		text-align: left;
		font-size: 14px;
	    padding: 10px;
	    border: none;
	  	border-bottom: 1px solid gray;
	    width: 50px;
	    margin-bottom: 10px;
	}

	.inpTxt {
		text-align: left;
		font-size: 14px;
	    padding: 10px;
	    border: none;
	  	border-bottom: 1px solid gray;
	    width: 80px;
	    margin-bottom: 10px;
	}

	.select_email {
		text-align: center;
		width: 85px;
		height: 32px;
		line-height: 32px;
	}

	.MS_select {
		text-align: center;
		width: 60px;
		height: 32px;
		line-height: 32px;
	}

	.col_select {
		text-align: center;
		width: 50px;
		height: 32px;
		line-height: 32px;
	}
    
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
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress;
                var extraRoadAddr = '';

                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }

                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                document.getElementById("sample4_engAddress").value = data.addressEnglish;

                if (roadAddr !== '') {
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");

                if (data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';
                } else if (data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    function openZipSearch() {
  new  daum.Postcode( {
    oncomplete: function(data) {
      $('[name=zip]').val(data.zonecod);
      $('[name=addr1]').val(data.address);
      $('[name=addr2]').val(data.buildingName);
    }
  }).open();
}
  
  </script>

<div class="login-form">
    <h2 align="center">Join</h2>
    <form action="/userJoin" method="post">
        <a class="i_d">아이디</a>
        <input type="text" class="id" name="username">
        <input type="submit" class="idcheck" name="username" " value="중복확인">&nbsp;<br>
        <a class="passwd">비밀번호</a>
        <input type="password" class="pwd" name="password" ><br>
        <a class="passwdche">비밀번호확인</a>
        <input type="password" class="pwdCheck" ><br>
        <a class="Na">이름</a>
        <input type="text" class="name" name="name" ><br>
        <a class="adr">주소</a>
        <input type="text" id="sample4_postcode" name="address" placeholder="우편번호">
        <input type="button" class="addresscheck" onclick="sample4_execDaumPostcode()" value="찾기"><br>
        <input type="text" id="sample4_roadAddress" name="address"  placeholder="도로명주소" size="60" ><br>
        <input type="hidden" id="sample4_jibunAddress" name="address" placeholder="지번주소"  size="60">
        <span id="guide" style="color:#999;display:none"></span>
        <input type="text" id="sample4_detailAddress" name="address"  placeholder="상세주소"  size="60"><br>
        <input type="hidden" id="sample4_extraAddress" placeholder="참고항목"  size="60">
        <input type="hidden" id="sample4_engAddress" placeholder="영문주소"  size="60" ><br>
        <br>
        <div class="birth">
            <a class="dat">생년월일</a>
            <input type="hidden" class="date" name="date">
            <select name="date"  class="MS_select MS_birthday">
                <option value="">생년</option>
                <option value="1920">1920</option>
                <option value="1921">1921</option>
                <option value="1922">1922</option>
                <option value="1923">1923</option>
                <option value="1924">1924</option>
                <option value="1925">1925</option>
                <option value="1926">1926</option>
                <option value="1927">1927</option>
                <option value="1928">1928</option>
                <option value="1929">1929</option>
                <option value="1930">1930</option>
                <option value="1931">1931</option>
                <option value="1932">1932</option>
                <option value="1933">1933</option>
                <option value="1934">1934</option>
                <option value="1935">1935</option>
                <option value="1936">1936</option>
                <option value="1937">1937</option>
                <option value="1938">1938</option>
                <option value="1939">1939</option>
                <option value="1940">1940</option>
                <option value="1941">1941</option>
                <option value="1942">1942</option>
                <option value="1943">1943</option>
                <option value="1944">1944</option>
                <option value="1945">1945</option>
                <option value="1946">1946</option>
                <option value="1947">1947</option>
                <option value="1948">1948</option>
                <option value="1949">1949</option>
                <option value="1950">1950</option>
                <option value="1951">1951</option>
                <option value="1952">1952</option>
                <option value="1953">1953</option>
                <option value="1954">1954</option>
                <option value="1955">1955</option>
                <option value="1956">1956</option>
                <option value="1957">1957</option>
                <option value="1958">1958</option>
                <option value="1959">1959</option>
                <option value="1960">1960</option>
                <option value="1961">1961</option>
                <option value="1962">1962</option>
                <option value="1963">1963</option>
                <option value="1964">1964</option>
                <option value="1965">1965</option>
                <option value="1966">1966</option>
                <option value="1967">1967</option>
                <option value="1968">1968</option>
                <option value="1969">1969</option>
                <option value="1970">1970</option>
                <option value="1971">1971</option>
                <option value="1972">1972</option>
                <option value="1973">1973</option>
                <option value="1974">1974</option>
                <option value="1975">1975</option>
                <option value="1976">1976</option>
                <option value="1977">1977</option>
                <option value="1978">1978</option>
                <option value="1979">1979</option>
                <option value="1980">1980</option>
                <option value="1981">1981</option>
                <option value="1982">1982</option>
                <option value="1983">1983</option>
                <option value="1984">1984</option>
                <option value="1985">1985</option>
                <option value="1986">1986</option>
                <option value="1987">1987</option>
                <option value="1988">1988</option>
                <option value="1989">1989</option>
                <option value="1990">1990</option>
                <option value="1991">1991</option>
                <option value="1992">1992</option>
                <option value="1993">1993</option>
                <option value="1994">1994</option>
                <option value="1995">1995</option>
                <option value="1996">1996</option>
                <option value="1997">1997</option>
                <option value="1998">1998</option>
                <option value="1999">1999</option>
                <option value="2000">2000</option>
                <option value="2001">2001</option>
                <option value="2002">2002</option>
                <option value="2003">2003</option>
                <option value="2004">2004</option>
                <option value="2005">2005</option>
                <option value="2006">2006</option>
                <option value="2007">2007</option>
                <option value="2008">2008</option>
                <option value="2009">2009</option>
                <option value="2010">2010</option>
                <option value="2011">2011</option>
                <option value="2012">2012</option>
                <option value="2013">2013</option>
                <option value="2014">2014</option>
                <option value="2015">2015</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2021">2022/option>
                <option value="2021">2023</option>
            </select>
            년
            <select name="date" class="MS_select MS_birthday">
                <option value="">월</option>
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
                <option value="06">6</option>
                <option value="07">7</option>
                <option value="08">8</option>
                <option value="09">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
            월
            <select name="date"  class="MS_select MS_birthday">
                <option value="">일</option>
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
                <option value="06">6</option>
                <option value="07">7</option>
                <option value="08">8</option>
                <option value="09">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
            </select>
            일
        </div>
        <br>
        <span class="interest">관심목록</span>
        <select name="interest" id="interest">
        	<option>1</option>
        	<option>2</option>
        	<option>3</option>
        	<option>4</option>
        	<option>5</option>
        </select>

        <br>
        <div class="col-tit">휴대폰</div>
        <div class="col-content">
            <select class="col_select" name="phone"  >
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
            </select>
            -
            <input type="text" id="HPhone1" class="inpTxt" name="phone" >
            -
            <input type="text" id="HPhone2" class="inpTxt" name="phone" >
        </div>
       
       
        <input type="submit" class="join" value="가입하기">

    </form>
</div>



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