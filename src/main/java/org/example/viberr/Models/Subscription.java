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
    @Column(name = "subscribedFromId", nullable = false)
    private Long subscribedFromId;
    @Column(name = "subscribedToId", nullable = false)
    private Long subscribedToId;
    @Column(name = "subscribedAt")
    private LocalDateTime subscribedAt;
}
