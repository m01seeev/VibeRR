package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Models.Subscription;
import org.example.viberr.Services.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.findAll();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        Subscription subscription = subscriptionService.findById(id);
        return ResponseEntity.ok(subscription);
    }
    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription savedSubscription = subscriptionService.save(subscription);
        return ResponseEntity.ok(savedSubscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id, @RequestBody Subscription subscriptionDetails) {
        Subscription updatedSubscription = subscriptionService.update(id, subscriptionDetails);
        return ResponseEntity.ok(updatedSubscription);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Subscription> patchSubscription(@PathVariable Long id, @RequestBody Subscription subscriptionDetails) {
        Subscription patchedSubscription = subscriptionService.patch(id, subscriptionDetails);
        return ResponseEntity.ok(patchedSubscription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
