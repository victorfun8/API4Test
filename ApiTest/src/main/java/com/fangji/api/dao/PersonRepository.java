package com.fangji.api.dao;

import com.fangji.api.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fangji on 2018/3/5.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
