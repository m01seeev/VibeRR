package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Mappers.SubscriptionMapper;
import org.example.viberr.Models.Subscription;
import org.example.viberr.Repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Subscription findById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    public Subscription save(Subscription subscription) {
        subscription.setSubscribedAt(LocalDateTime.now());
        return subscriptionRepository.save(subscription);
    }

    public Subscription update(Long id, Subscription subscriptionDetails) {
        Subscription subscription = findById(id);
        subscriptionMapper.updateSubscriptionFromDto(subscriptionDetails, subscription);
        subscription.setId(id);
        return subscriptionRepository.save(subscription);
    }

    public Subscription patch(Long id, Subscription subscriptionDetails) {
        Subscription subscription = findById(id);
        subscriptionMapper.patchSubscriptionFromDto(subscriptionDetails, subscription);
        return subscriptionRepository.save(subscription);
    }

    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
