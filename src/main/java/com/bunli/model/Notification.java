package com.bunli.model;

import com.bunli.enumeration.NotificationChanel;
import com.bunli.enumeration.NotificationType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_notification")
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private NotificationType notificationType;
    private NotificationChanel notificationChanel;
    private boolean read;
    private Long userId;
    private Long deviceId;

}
