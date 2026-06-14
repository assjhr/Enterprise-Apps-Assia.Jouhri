package com.example.entrapps.repository;

import com.example.entrapps.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findTop10ByOrderByTijdstipDesc();
}
