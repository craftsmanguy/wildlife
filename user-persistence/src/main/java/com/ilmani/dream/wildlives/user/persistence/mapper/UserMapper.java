package com.ilmani.dream.wildlives.user.persistence.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ilmani.dream.wildlives.framework.dto.pet.PetDto;
import com.ilmani.dream.wildlives.framework.dto.user.AbstractUserDto;
import com.ilmani.dream.wildlives.framework.dto.user.UserDto;
import com.ilmani.dream.wildlives.framework.dto.user.UserInscriptionDto;
import com.ilmani.dream.wildlives.user.persistence.entity.UserEntity;

public class UserMapper {

	public static AbstractUserDto transformUserEntityToUserInscriptionDto(UserEntity userEn) {
		AbstractUserDto userDto = new UserInscriptionDto();
		if (userEn == null) {
			return userDto;
		}
		try {
			BeanUtils.copyProperties(userDto, userEn);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return userDto;
	}

	public static UserEntity transformUserDtoToUserEntity(AbstractUserDto userDto) {
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
	
	
	public static AbstractUserDto transformUserEntityToUserDto(UserEntity userEn) {
		AbstractUserDto userDto = new UserDto();
		if (userEn == null) {
			return userDto;
		}
		try {
			BeanUtils.copyProperties(userDto, userEn);
			if (userEn.getPetsEn() != null) {
				List<PetDto> pets = PetForUserEntityMapper.transformListForUserEntityToListPetDto(userEn.getPetsEn());
				((UserDto) userDto).setPets(pets);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO log
		}
		return userDto;
	}

}
