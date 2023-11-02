package com.songw.sbp.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude= {"userPassword"})
public class User {
	private String userID;
	private String userPassword;
	private String userName;
	private Integer userAge;
}
