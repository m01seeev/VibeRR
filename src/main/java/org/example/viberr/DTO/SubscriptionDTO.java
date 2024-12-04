package org.example.viberr.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubscriptionDTO {
    private Long id;
    private Long subscribedFromId;
    private Long subscribedToId;
    private LocalDateTime subscribedAt;
}
