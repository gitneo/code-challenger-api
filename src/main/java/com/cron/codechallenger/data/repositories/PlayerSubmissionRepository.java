package com.cron.codechallenger.data.repositories;

import com.cron.codechallenger.model.PlayerSubmission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSubmissionRepository extends CrudRepository<PlayerSubmission,Long> {
}
