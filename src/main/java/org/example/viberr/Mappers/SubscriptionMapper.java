package org.example.viberr.Mappers;

import org.example.viberr.DTO.SubscriptionDTO;
import org.example.viberr.Models.Subscription;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateSubscriptionFromDto(SubscriptionDTO subscriptionDto, @MappingTarget Subscription subscription);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchSubscriptionFromDto(SubscriptionDTO subscriptionDto, @MappingTarget Subscription subscription);

    SubscriptionDTO dtoFromSubscription(Subscription subscription);

    Subscription subscriptionFromDto(SubscriptionDTO subscriptionDto);

    List<SubscriptionDTO> dtoListFromSubscription(List<Subscription> subscriptionList);

    List<Subscription> subscriptionListFromDto(List<SubscriptionDTO> subscriptionDtoList);
}
