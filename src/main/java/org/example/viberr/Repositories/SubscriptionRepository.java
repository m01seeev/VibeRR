package org.example.viberr.Repositories;

import org.example.viberr.Models.Subscription;
import org.example.viberr.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findBySubscribedFromId(Long subscribedFromId);
    List<Subscription> findBySubscribedToId(Long subscribedToId);
}
