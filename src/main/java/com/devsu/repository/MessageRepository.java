package com.devsu.repository;

import com.devsu.model.MessageDevsu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<MessageDevsu, Long> {
}
