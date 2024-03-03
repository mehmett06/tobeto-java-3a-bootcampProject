package com.tobeto.bootcampproject.model.entities;

import com.tobeto.bootcampproject.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="USERS")

public class User extends BaseEntity<Integer> {

    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "FİRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DATEOFBİRTHNAME")
    private LocalDate dateOfBirth;
    @Column(name = "NATİONALIDENTİTY")
    private String nationalIdentity;
    @Column(name = "EMAİL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

}
