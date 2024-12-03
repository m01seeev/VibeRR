package org.example.viberr.Mappers;

import org.example.viberr.Models.Subscription;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchSubscriptionFromDto(Subscription subscriptionDetails, @MappingTarget Subscription subscription);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updateSubscriptionFromDto(Subscription subscriptionDetails, @MappingTarget Subscription subscription);
}
