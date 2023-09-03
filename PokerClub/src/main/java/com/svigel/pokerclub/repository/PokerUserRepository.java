package com.svigel.pokerclub.repository;

import com.svigel.pokerclub.model.PokerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Repository
public interface PokerUserRepository extends JpaRepository<PokerUser, Long> {
    PokerUser findByUsernameAndPassword(@NotEmpty @Size(min = 2, max = 24) @Pattern(regexp = "[a-zA-Z]{2,24}",
            message = "Expected Latin letters") String username, @NotEmpty @Size(min = 1, max = 20) String password);

    PokerUser findByUsername(String name);

}
