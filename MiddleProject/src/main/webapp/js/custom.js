//회원가입 전화번호탭 하이픈 정규식

function formatPhoneNumber(input) {
	// 전화번호 포맷팅을 위한 정규식 패턴
	const pattern1 = /^(\d{0,3})(\d{0,4})(\d{0,4})$/g;
	const pattern2 = /^(\d{0,2})(\d{0,3})(\d{0,4})$/g;

	// 입력된 전화번호에서 숫자만 추출
	const phoneNumber = input.value.replace(/[^\d]/g, "");

	// 숫자만 추출한 전화번호에 따라 포맷팅 처리
	if (phoneNumber.length > 10) {
		input.value = phoneNumber.replace(pattern1, "$1-$2-$3").replace(/\-{1,2}$/g, "");
	} else {
		input.value = phoneNumber.replace(pattern2, "$1-$2-$3").replace(/\-{1,2}$/g, "");
	}
}


//비밀번호
const passwordInput = document.getElementById('user_pw');
const passwordConfirmInput = document.getElementById('c_pw2');
const passwordWarning = document.getElementById('password-warning');

function checkPasswordValidity() {
  const passwordValue = passwordInput.value;
  const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+])[\w!@#$%^&*()_+]{8,}$/;

  if (!passwordValue) {
    passwordWarning.textContent = '비밀번호를 입력해주세요.';
  } else if (!passwordRegex.test(passwordValue)) {
    passwordWarning.textContent = '영어 대소문자, 특수문자를 모두 사용하고 8자 이상으로 입력하세요.';
  } else {
    passwordWarning.textContent = '';
  }
}

function checkPasswordMatch() {
  const passwordValue = passwordInput.value;
  const passwordConfirmValue = passwordConfirmInput.value;

  if (passwordValue !== passwordConfirmValue) {
    passwordWarning.textContent = '비밀번호와 비밀번호 확인 값이 일치하지 않습니다.';
  } else {
    passwordWarning.textContent = '';
  }
}

function validatePassword() {
  const pw = passwordInput.value;
  const pw2 = passwordConfirmInput.value;

  if (pw !== pw2) {
    alert('비밀번호와 비밀번호 확인 값이 일치하지 않습니다.');
    return false;
  }

  return true;
}

// 비밀번호 유효성 검사와 일치 여부 검사를 수행하는 이벤트를 등록
passwordInput.addEventListener('input', checkPasswordValidity);
passwordInput.addEventListener('keyup', checkPasswordMatch);

// 비밀번호 함수 false면 회원가입 버튼 중단
const submitButton = document.getElementById('submit-button');

submitButton.addEventListener('click', function(event) {
  if (!validatePassword()) {
    event.preventDefault();
  }
});




function submitForm() {
	if (!validatePassword()) {
		return false;
	}

	checkEmailDuplicate();

}


