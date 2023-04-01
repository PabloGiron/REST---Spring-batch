package com.example.rest.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "BATCH_JOB_INSTANCE")
public class JobInstance {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "JOB_INSTANCE_ID")
    private BigInteger jobInstanceId;

    @Version
    @Column(name = "VERSION")
    private short version;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_KEY")
    private String jobKey;
}
