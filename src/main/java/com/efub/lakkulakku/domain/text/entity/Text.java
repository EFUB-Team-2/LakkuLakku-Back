package com.efub.lakkulakku.domain.text.entity;

import com.efub.lakkulakku.domain.diary.entity.Diary;
import com.efub.lakkulakku.global.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Text extends BaseTimeEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(length = 16)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diary_id")
	private Diary diary;

	@Column(length = 50)
	@NotNull
	private String style;

	@Column(length = 20)
	@NotNull
	private String weight;

	@Column(length = 20)
	@NotNull
	private String size;

	@Column(length = 20)
	@NotNull
	private String width;

	@Column(length = 20)
	@NotNull
	private String height;

	@Column(length = 20)
	@NotNull
	private String align;

	@Column(length = 20)
	@NotNull
	private String color;

	@NotNull
	private String content;

	@Column(length = 20)
	@NotNull
	private String xcoord;

	@Column(length = 20)
	@NotNull
	private String ycoord;
}
