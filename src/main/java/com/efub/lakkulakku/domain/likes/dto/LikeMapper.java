package com.efub.lakkulakku.domain.likes.dto;

import com.efub.lakkulakku.domain.diary.entity.Diary;
import com.efub.lakkulakku.domain.likes.entity.Likes;
import com.efub.lakkulakku.domain.likes.exception.LikeNotFoundException;
import com.efub.lakkulakku.domain.likes.repository.LikesRepository;
import com.efub.lakkulakku.domain.users.entity.Users;
import com.efub.lakkulakku.domain.users.exception.UserNotFoundException;
import com.efub.lakkulakku.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeMapper {

	private final UsersRepository usersRepository;
	private final LikesRepository likesRepository;

	public LikeClickResDto toLikeClickResDto(Likes entity) {
		if (entity == null)
			return null;

		return LikeClickResDto.builder()
				.id(entity.getId())
				.createdOn(entity.getCreatedOn())
				.diaryId(entity.getDiary().getId())
				.isLike(entity.getIsLike())
				.build();
	}

	public LikeResDto toLikeResDto(Likes entity) {
		String profileImageUrl;
		if (entity == null)
			return null;
		if (entity.getUsers().getProfile() == null || entity.getUsers().getProfile().getFile() == null) {
			profileImageUrl = null;
		}
		return LikeResDto.builder()
				.id(entity.getId())
				.userId(entity.getUsers().getId())
				.nickname(entity.getUsers().getNickname())
				.profileImageUrl(entity.getUsers().getProfile().getFile().getUrl())
				.createdOn(entity.getCreatedOn())
				.build();
	}

	public Likes toEntity(Diary diary, LikeResDto dto) {
		if (diary == null || dto == null)
			return null;

		Users users = usersRepository.findById(dto.getUserId()).orElseThrow(UserNotFoundException::new);

		return Likes.builder()
				.diary(diary)
				.users(users)
				.build();
	}

	public Likes toEntityFromReqDto(Users user, Diary diary, LikeReqDto dto) {
		if (diary == null || dto == null)
			return null;

		return Likes.builder()
				.diary(diary)
				.users(user)
				.build();
	}
}
