package com.sdp3.SDP3.repository;

import com.sdp3.SDP3.entites.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
}
