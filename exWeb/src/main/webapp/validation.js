function checkVal(form) {
	let cnt = 0;

	for (let i = 0; i < form.choice.length; i++) {
		if (form.choice[i].checked) { // checked는 체크됐는지 여부를 알려준다
			cnt++;
		}
	}

	if (cnt === 0) {
		alert("최소한 하나 이상 선택해야합니다.");
	} else {
		form.submit();
	}
}