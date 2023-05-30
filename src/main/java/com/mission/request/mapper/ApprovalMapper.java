package com.mission.request.mapper;

import com.mission.request.dto.ApprovalDto;
import com.mission.request.model.Approval;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApprovalMapper {
    ApprovalMapper APPROVAL_MAPPER = Mappers.getMapper(ApprovalMapper.class);

    @Mappings({
            @Mapping(target = "approvalId", source = "id"),
            @Mapping(target = "approvalUsername", source = "username"),
            @Mapping(target = "approvalResponseDate", source = "responseDate")
    })
    ApprovalDto approvalToApprovalDto(Approval approval);
    @Mappings({
            @Mapping(target = "id", source = "approvalId"),
            @Mapping(target = "username", source = "approvalUsername" ),
            @Mapping(target = "responseDate", source = "approvalResponseDate")
    })
    Approval approvalDtoToApproval(ApprovalDto approvalDto);
}
