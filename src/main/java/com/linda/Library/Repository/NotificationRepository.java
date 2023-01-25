package com.linda.Library.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.Notification;
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
