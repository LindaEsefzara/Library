package com.linda.Library.Service;

import com.linda.Library.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    public void save (Notification notification) {
        notificationRepository.save(notification);
    }

    public void saveById (Long id) {
        Notification notification = notificationRepository.findById(id).get();
        notificationRepository.save(notification);
    }

    public List<Notification> findAll(){
        List<Notification> notifications = (ArrayList<Notification>) notificationRepository.findAll();
        return notifications;
    }

    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}