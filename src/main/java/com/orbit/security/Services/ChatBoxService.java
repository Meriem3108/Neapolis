package com.orbit.security.Services;

import com.orbit.security.Entities.ChatBox;
import com.orbit.security.Interfaces.IChatBoxService;
import com.orbit.security.Repositories.ChatBoxRepository;
import com.orbit.security.user.User;
import com.orbit.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatBoxService implements IChatBoxService {
    @Autowired
    ChatBoxRepository chatBoxRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ChatBox addChatBox(ChatBox chatBox) {
        return chatBoxRepository.save(chatBox);
    }

    @Override
    public ChatBox retrieveBoite(Integer id1, Integer id2) {
        User user1 = userRepository.findById(id1).get();
        User user2 = userRepository.findById(id2).get();
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        List<ChatBox> chatBoxes = chatBoxRepository.findAll();
        ChatBox boite = chatBoxes.stream()
                .filter(cb -> cb.getId().equals("channel-" + id1 + "-" + id2) || cb.getId().equals("channel-" + id2 + "-" + id1))
                .findFirst()
                .orElse(null);
        return boite;    }
}
