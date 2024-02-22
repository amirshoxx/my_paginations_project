package com.example.chat_app_project.repo;

import com.example.chat_app_project.entity.Message;

import com.example.chat_app_project.projection.MessageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MessageRepo extends JpaRepository<Message, UUID> {

    @Query( value = "select m.id,m.text,m.created_at,u.first_name||' '||u.last_name as fullName , m.created_at as createdAt ,u.id as fromUserId  from messages m inner join users u on u.id = m.from_user_id\n" +
            " where m.from_user_id=:fromId and m.to_user_id=:toId or m.from_user_id=:toId and m.to_user_id =:fromId",nativeQuery = true)
    List<MessageProjection> myMessagesNative(UUID fromId,UUID toId);
}
