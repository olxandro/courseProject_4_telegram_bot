package com.skypro.courseproject_4_telegram_bot.repositories;

import com.skypro.courseproject_4_telegram_bot.entity.NotificationTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {
    List<NotificationTask> findNotificationTaskByNotificationDateTime(LocalDateTime localDateTime);
}