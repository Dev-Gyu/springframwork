package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
					member.getId(), member.getEmail(),
					member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	// Autowired의 경우 설정파일에 Autowired선언된 데이터타입의 빈이 없으면 예외발생시킴
	// 따라서 반드시 빈이 필요없는경우엔 Annotation에 required=false선언해주면 예외 발생 안된다.
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if (formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		} else {
//			this.dateTimeFormatter = null;
//		}
//	}
	
	// @Nullable = @Autowired 선언된 데이터타입의 빈이 설정파일에 있으면 해당 빈 반환, 없으면 인자로 null반환
	// @Autowired(require=false) = 해당 데이터타입 빈이 없으면 메소드 실행 아예 안함
	// @Nullable = 빈이 없어도 메소드 실행함 (ex: 아래 코드 주석풀고 Nullable주면 dateTimeFormatter 인자 null로 주게되고
	// 이 때문에 생성자에서 초기화한 dateTimeFormatter가 null값이 대입되면서 dateTime의 출력형식이 초기화됨
//	@Autowired
//	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
	
}
