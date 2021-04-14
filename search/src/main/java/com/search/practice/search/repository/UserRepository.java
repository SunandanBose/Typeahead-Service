package com.search.practice.search.repository;

import com.search.practice.search.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer integer);

    List<User> findByDisplayName(String Name);

}
