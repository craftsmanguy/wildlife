package com.ilmani.dream.wildlives.user.persistence.mapper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.user.UserDto;
import com.ilmani.dream.wildlives.framework.dto.user.UserInscriptionDto;
import com.ilmani.dream.wildlives.user.persistence.entity.UserEntity;

public class UserMapper {

	public static UserDto transformUserEntityToUserDto(UserEntity userEn) {
		UserDto UserDto = new UserInscriptionDto();
		if (userEn == null) {
			return UserDto;
		}
		try {
			BeanUtils.copyProperties(UserDto, userEn);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return UserDto;
	}

	public static UserEntity transformUserDtoToUserEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		if (userDto == null) {
			return userEntity;
		}
		try {
			BeanUtils.copyProperties(userEntity, userDto);
			userEntity.setPass(((UserInscriptionDto) userDto).getPassword());
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return userEntity;
	}

}
