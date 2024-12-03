package org.example.viberr.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subscribed_from_id", nullable = false)
    private Long subscribedFromId;
    @Column(name = "subscribed_to_id", nullable = false)
    private Long subscribedToId;
    @Column(name = "subscribed_at")
    private LocalDateTime subscribedAt;
}
