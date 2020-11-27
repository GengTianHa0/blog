package com.hao.blog.repository;

import com.hao.blog.object.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);


//    @Query("select t from Type t")
//    List<Type> findTop(Pageable pageable);

}
