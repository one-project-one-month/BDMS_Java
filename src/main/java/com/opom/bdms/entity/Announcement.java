package com.opom.bdms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity representing system announcements.
 * Announcements can be displayed to users and have expiration dates.
 */
@Entity
@Table(name = "announcements")
@Getter
@Setter
public class Announcement extends MasterEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "expired_at")
    private LocalDate expiredAt;
}
