package com.mission.request.mapper;

import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    RequestMapper REQUEST_MAPPER = Mappers.getMapper(RequestMapper.class);

    @Mappings({
            @Mapping(target = "requestId", source = "id"),
            @Mapping(target = "requestUsername", source = "username"),
            @Mapping(target = "approval", source = "approval"),
            @Mapping(target = "members", source = "members"),
            @Mapping(target = "status", source = "status")
    })
    RequestDto requestToRequestDto(Request request);

    @Mappings({
            @Mapping(target = "id", source = "requestId"),
            @Mapping(target = "username", source = "requestUsername"),
            @Mapping(target = "approval", source = "approval"),
            @Mapping(target = "members", source = "members")
    })
    Request requestDtoToRequest(RequestDto requestDto);
}
