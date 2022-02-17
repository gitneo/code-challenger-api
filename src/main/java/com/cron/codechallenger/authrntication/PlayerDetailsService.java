package com.cron.codechallenger.authrntication;

import com.cron.codechallenger.data.repositories.PlayerRepository;
import com.cron.codechallenger.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerDetailsService implements UserDetailsService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
       Optional<Player> player =  playerRepository.findByNickname(nickname);
        System.out.println(player.get().getNickname()+ " "+player.get().getId());
       player.orElseThrow(()->new UsernameNotFoundException("not found: " + nickname));
        return player.map(PlayerDetails::new).get();
    }



}
