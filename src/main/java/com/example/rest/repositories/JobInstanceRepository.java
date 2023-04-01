package com.example.rest.repositories;

import com.example.rest.entities.User;
import com.example.rest.models.JobInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobInstanceRepository extends JpaRepository<JobInstance, BigInteger> {

    @Query(value = "SELECT * FROM m",nativeQuery = true)
    public List<JobInstance> findJobName();

    public Optional<List<JobInstance>> findByJobName(String jobName);
}
