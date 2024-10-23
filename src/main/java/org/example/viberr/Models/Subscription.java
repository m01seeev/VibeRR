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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscribed_from_id", nullable = false)
    private User subscribedFrom;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscribed_to_id", nullable = false)
    private User subscribedTo;
    @Column(name = "subscribed_at", nullable = false)
    private LocalDateTime subscribedAt;
}
