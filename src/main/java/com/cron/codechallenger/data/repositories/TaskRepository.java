package com.cron.codechallenger.data.repositories;

import com.cron.codechallenger.data.projections.PlayerRanking;
import com.cron.codechallenger.data.projections.PlayerTasks;
import com.cron.codechallenger.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {

    @Query(value = "SELECT \n" +
                    "\t  tsk_task_title task,\n" +
                    "    pla_nickname player\n" +
                    "FROM  player,task,submission\n" +
                    "where tsk_id = sub_task_id\n" +
                    "and   pla_id = sub_player_id\n" +
                    "and   sub_player_id = ?",
            nativeQuery = true)
    List<PlayerTasks> findTasksByPlayerId(long id);
}
