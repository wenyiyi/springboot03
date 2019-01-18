package com.imooc.firstappdemo.repository;

import com.imooc.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式->Map
     * ConcurrentHashMap是HashMap的线程安全版本
     */
    private ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>() ;

    //id自增长生成器
    private final static AtomicInteger idGernerator = new AtomicInteger();

    public boolean save(User user){
        //id从 1 开始
        Integer id = idGernerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }

}
