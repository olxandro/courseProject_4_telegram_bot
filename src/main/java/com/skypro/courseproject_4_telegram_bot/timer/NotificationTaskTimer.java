package com.skypro.courseproject_4_telegram_bot.timer;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.skypro.courseproject_4_telegram_bot.service.NotificationTaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationTaskTimer {
    private final NotificationTaskService notificationTaskService;
    private final TelegramBot telegramBot;

    public NotificationTaskTimer(NotificationTaskService notificationTaskService, TelegramBot telegramBot) {
        this.notificationTaskService = notificationTaskService;
        this.telegramBot = telegramBot;
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void findNotificationTasks() {
        notificationTaskService.findNotificationNow().forEach(notificationTask -> {
            telegramBot.execute(new SendMessage(notificationTask.getChatId(),
                    "Напоминаю: " + notificationTask.getMessage()));
        });
    }
}
