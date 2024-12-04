package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.SubscriptionDTO;
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
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions() {
        List<SubscriptionDTO> subscriptions = subscriptionService.findAll();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable Long id) {
        SubscriptionDTO subscription = subscriptionService.findById(id);
        return ResponseEntity.ok(subscription);
    }
    @PostMapping
    public ResponseEntity<SubscriptionDTO> addSubscription(@RequestBody SubscriptionDTO subscriptionDto) {
        SubscriptionDTO savedSubscription = subscriptionService.save(subscriptionDto);
        return ResponseEntity.ok(savedSubscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable Long id, @RequestBody SubscriptionDTO subscriptionDto) {
        SubscriptionDTO updatedSubscription = subscriptionService.update(id, subscriptionDto);
        return ResponseEntity.ok(updatedSubscription);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> patchSubscription(@PathVariable Long id, @RequestBody SubscriptionDTO subscriptionDto) {
        SubscriptionDTO patchedSubscription = subscriptionService.patch(id, subscriptionDto);
        return ResponseEntity.ok(patchedSubscription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        subscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
