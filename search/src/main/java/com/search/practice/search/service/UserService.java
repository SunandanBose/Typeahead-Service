package com.search.practice.search.service;

import com.search.practice.search.model.Filter;
import com.search.practice.search.model.Search;
import com.search.practice.search.model.User;
import com.search.practice.search.repository.UserRepository;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class UserService {

    private UserRepository userRepository;

    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    public UserService(UserRepository userRepository, ElasticsearchRestTemplate elasticsearchTemplate) {
        this.userRepository = userRepository;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public void createUserIndexBulk(final List<User> users) {
        userRepository.saveAll(users);
    }

    public List<User> search(String searchTerm) {
        return userRepository.findByFirstName(searchTerm);
    }

    public List<User> search(Search search) {
        List<User> users = new ArrayList<>();
        BoolQueryBuilder boolQueryBuilder = getBoolQueryBuilder(search);
        Iterable<User> searchResult = userRepository.search(boolQueryBuilder);
        searchResult.forEach(users::add);
        return users;
    }

    public Integer count(Search search) {
        Integer count = 0;
        try {
            BoolQueryBuilder boolQueryBuilder = getBoolQueryBuilder(search);
            Long elasticCount = elasticsearchTemplate.count(new NativeSearchQuery(boolQueryBuilder), User.class);
            count = Integer.valueOf(elasticCount.intValue());
        } catch (Exception e){
            System.out.println("Exception occurred");
        }
        return count;
    }

    private BoolQueryBuilder getBoolQueryBuilder(Search search) {
        BoolQueryBuilder boolQueryBuilder = boolQuery();
        if(search.getName() != null){
            MatchQueryBuilder displayNameQuery = matchQuery("DisplayName", search.getName()).fuzziness(Fuzziness.AUTO);
            boolQueryBuilder.must(displayNameQuery);
        }
        if(search.getEmail() != null){
            MatchQueryBuilder emailQuery = matchQuery("Email", search.getEmail()).fuzziness(Fuzziness.AUTO);
            boolQueryBuilder.must(emailQuery);
        }
        if(search.getFilter() != null){
            Filter filter = search.getFilter();
            if(filter.getCity().size() > 0){
                List<String> cities = filter.getCity();
                TermsQueryBuilder cityTermBuilder = QueryBuilders.termsQuery("City", cities.stream().toArray(String[]::new));
                boolQueryBuilder.filter(cityTermBuilder);
            }
            if(filter.getCountry().size() > 0){
                List<String> countries = filter.getCountry();
                TermsQueryBuilder countryTermBuilder = QueryBuilders.termsQuery("CountryCode", countries.stream().toArray(String[]::new));
                boolQueryBuilder.filter(countryTermBuilder);
            }
            if(filter.getJobName().size() > 0){
                List<String> jobNames = filter.getJobName();
                TermsQueryBuilder jobNameTermBuilder = QueryBuilders.termsQuery("JobName", jobNames.stream().toArray(String[]::new));
                boolQueryBuilder.filter(jobNameTermBuilder);
            }
        }
        System.out.println("Query executed : " + boolQueryBuilder.toString());
        return boolQueryBuilder;
    }
}
