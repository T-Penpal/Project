package green.spring.member_register;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String name;
	private String email;
	private String password;
	private String gender;
	private String note;
	private boolean married;
	private Date birthday;
	private String profession;

}
