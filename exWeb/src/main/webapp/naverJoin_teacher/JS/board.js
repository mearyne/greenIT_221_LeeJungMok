function saveBoardCodeInSession(code) {
    sessionStorage.setItem("runningBoard", code);
    location.href = "boardViewPro.jsp";
}

function bringSessionCode() {
	let code = sessionStorage.getItem("runningBoard");
	return code;
}