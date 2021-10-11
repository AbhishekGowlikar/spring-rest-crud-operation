package com.abhishek.demo.repository;

import com.abhishek.demo.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository  extends JpaRepository<Site, Integer> {
}
