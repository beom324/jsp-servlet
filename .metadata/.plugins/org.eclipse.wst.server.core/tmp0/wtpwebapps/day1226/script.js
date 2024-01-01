function inputCheck(){

	if(document.regForm.pwd.value != document.regForm.repwd.value){
		alert("비밀번호와 비밀번호확인란이 일치하지 않습니다");
		document.regForm.pwd.focus();
		return;
	}
	
	document.regForm.submit();
}