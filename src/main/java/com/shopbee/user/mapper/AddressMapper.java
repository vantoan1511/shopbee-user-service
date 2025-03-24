/*
 * AddressMapper.java
 *
 * Copyright by shopbee-user-service, all rights reserved.
 * MIT License: https://mit-license.org
 */

package com.shopbee.user.mapper;

import com.shopbee.user.entity.Address;
import com.shopbee.user.v1.dto.CreateUserAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * Mapper interface for converting between Address entities and DTOs.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface AddressMapper {

    /**
     * Maps a com.shopbee.user.v1.dto.Address object to an Address entity.
     * Ignores the user field and maps the isDefault field to asDefault.
     *
     * @param source the source Address DTO
     * @return the mapped Address entity
     */
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "asDefault", source = "isDefault")
    Address toAddress(com.shopbee.user.v1.dto.Address source);

    /**
     * Maps a CreateUserAddressRequest object to an Address entity.
     * Ignores the id and user fields and maps the isDefault field to asDefault.
     *
     * @param source the source CreateUserAddressRequest DTO
     * @return the mapped Address entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "asDefault", source = "isDefault")
    Address toAddress(CreateUserAddressRequest source);

    /**
     * Maps an Address entity to a com.shopbee.user.v1.dto.Address object.
     * Maps the asDefault field to isDefault.
     *
     * @param source the source Address entity
     * @return the mapped Address DTO
     */
    @Mapping(target = "isDefault", source = "asDefault")
    com.shopbee.user.v1.dto.Address toAddress(Address source);
}
