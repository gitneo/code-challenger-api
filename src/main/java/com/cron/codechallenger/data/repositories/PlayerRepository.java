package com.cron.codechallenger.data.repositories;

import com.cron.codechallenger.data.projections.PlayerRanking;
import com.cron.codechallenger.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {
    @Query(value = "SELECT \n" +
                    "  pla_id id,\n" +
                    "  pla_name name,\n" +
                    "  pla_password,\n" +
                    "\tpla_nickname,\n" +
                    "\tcount(*) top\n" +
                    "FROM  player,submission\n" +
                    "WHERE pla_id = sub_player_id\n" +
                    "GROUP BY pla_id,pla_nickname\n" +
                    "ORDER BY top DESC \n" +
                    "LIMIT 3" ,
            nativeQuery = true)
    List<PlayerRanking> findTopRankingPlayers();
    Optional<Player> findByNickname(String nickname);
}
