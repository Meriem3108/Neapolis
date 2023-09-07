package com.orbit.security.Repositories;

import com.orbit.security.Entities.ChatBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBoxRepository extends JpaRepository<ChatBox,Integer> {
}
