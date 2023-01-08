function chkForm() {
	var f = ducument.frm;
	
	if(f.m_title.value == '') {
		alert("영화 제목을 입력해주세요.");
		return false;
	}
	if(f.m_director.value == '') {
		alert("영화 감독을 입력해주세요.");
		return false;
	}
	if(f.m_genre.value == '') {
		alert("영화 장르를 입력해주세요.");
		return false;
	}
	
	f.submit();
}

function chkDelete (m_no) {
	const result = confirm ("삭제하시겠습니까?");
	
	if (result) {
		const url = location.origin;
		location.href = url + "/cinepedia_jsp/delete?m_no=" + m_no;
	} else {
		return false;
	}
}