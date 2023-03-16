package com.skypro.courseproject_4_telegram_bot.service;

import com.skypro.courseproject_4_telegram_bot.entity.NotificationTask;
import com.skypro.courseproject_4_telegram_bot.repositories.NotificationTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NotificationTaskService {

    private final NotificationTaskRepository notificationTaskRepository;

    public NotificationTaskService(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }

    @Transactional
    public void addNotificationTask(LocalDateTime localDateTime, String message, Long chatId) {
        NotificationTask notificationTask = new NotificationTask();
        notificationTask.setNotificationDateTime(localDateTime);
        notificationTask.setMessage(message);
        notificationTask.setChatId(chatId);
        notificationTaskRepository.save(notificationTask);
    }

    public List<NotificationTask> findNotificationNow() {
        return notificationTaskRepository.findNotificationTaskByNotificationDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }

}