package com.efub.lakkulakku.domain.user.entity;

import com.efub.lakkulakku.domain.profile.entity.Profile;
import com.efub.lakkulakku.global.entity.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

	/*@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(length = 16)
	private UUID id;*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, length = 9)
	//@NotNull
	private Integer uid;

	@NotNull
	private String email;

	@JsonIgnore
	@NotNull
	private String password;

	@NotNull
	private String nickname;

	@OneToOne(mappedBy = "user")
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@Builder
	public User(String email, String password, String nickname, Profile profile)
	{
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.profile = profile;
	}
}
