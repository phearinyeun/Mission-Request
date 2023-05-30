package com.mission.request.mapper;

import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    RequestMapper REQUEST_MAPPER = Mappers.getMapper(RequestMapper.class);

    @Mappings({
            @Mapping(target = "requestId", source = "id"),
            @Mapping(target = "requestUsername", source = "username"),
            @Mapping(target = "approval", source = "approval"),
            @Mapping(target = "teamMembers", source = "members"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "missionDate", source = "missionDate", dateFormat = "dd-MM-yyyy"),
            @Mapping(target = "missionStartDate", source = "startDate", dateFormat = "dd-MM-yyyy HH:mm"),
            @Mapping(target = "missionEndDate", source = "endDate", dateFormat = "dd-MM-yyyy HH:mm")
    })
    RequestDto requestToRequestDto(Request request);
    @Mappings({
            @Mapping(target = "id", source = "requestId"),
            @Mapping(target = "username", source = "requestUsername"),
            @Mapping(target = "approval", source = "approval"),
            @Mapping(target = "members", source = "teamMembers"),
            @Mapping(target = "missionDate", source = "missionDate", dateFormat = "dd-MM-yyyy"),
            @Mapping(target = "startDate", source = "missionStartDate", dateFormat = "dd-MM-yyyy HH:mm"),
            @Mapping(target = "endDate", source = "missionEndDate", dateFormat = "dd-MM-yyyy HH:mm")
    })
    Request requestDotToRequest(RequestDto requestDto);

    List<RequestDto> requestDtoToRequestList(Page<RequestDto> requests);
}
