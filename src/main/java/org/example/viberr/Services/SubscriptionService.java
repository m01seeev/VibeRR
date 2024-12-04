package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.SubscriptionDTO;
import org.example.viberr.Mappers.SubscriptionMapper;
import org.example.viberr.Models.Subscription;
import org.example.viberr.Repositories.SubscriptionRepository;
import org.example.viberr.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepository userRepository;

    public List<SubscriptionDTO> findAll() {
        return subscriptionMapper.dtoListFromSubscription(subscriptionRepository.findAll());
    }

    public SubscriptionDTO findById(Long id) {
        return subscriptionMapper.dtoFromSubscription(subscriptionRepository.findById(id).orElse(null));
    }

    public SubscriptionDTO save(SubscriptionDTO subscriptionDto) {
        Subscription subscription = subscriptionMapper.subscriptionFromDto(subscriptionDto);
        subscription.setSubscribedAt(LocalDateTime.now());
        subscriptionRepository.save(subscription);
        return subscriptionMapper.dtoFromSubscription(subscription);
    }

    public SubscriptionDTO update(Long id, SubscriptionDTO subscriptionDto) {
        Subscription subscription = subscriptionRepository.findById(id).orElse(null);
        subscriptionMapper.updateSubscriptionFromDto(subscriptionDto, subscription);
        assert subscription != null;
        subscriptionRepository.save(subscription);
        return subscriptionMapper.dtoFromSubscription(subscription);
    }

    public SubscriptionDTO patch(Long id, SubscriptionDTO subscriptionDto) {
        Subscription subscription = subscriptionRepository.findById(id).orElse(null);
        subscriptionMapper.patchSubscriptionFromDto(subscriptionDto, subscription);
        assert subscription != null;
        subscriptionRepository.save(subscription);
        return subscriptionMapper.dtoFromSubscription(subscription);
    }

    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
