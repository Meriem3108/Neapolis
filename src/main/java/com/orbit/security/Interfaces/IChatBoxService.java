package com.orbit.security.Interfaces;

import com.orbit.security.Entities.ChatBox;

public interface IChatBoxService {
    ChatBox addChatBox(ChatBox chatBox);
    ChatBox retrieveBoite(Integer id1, Integer id2);
}
