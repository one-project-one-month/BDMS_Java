package com.opom.bdms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a certificate issued to a user.
 * Certificates can be issued for various achievements or donations.
 */
@Entity
@Table(name = "certificates")
@Getter
@Setter
public class Certificate extends MasterEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "certificate_title", nullable = false)
    private String certificateTitle;

    @Column(name = "certificate_description", columnDefinition = "TEXT")
    private String certificateDescription;

    @Column(name = "certificate_date")
    private String certificateDate;
}
