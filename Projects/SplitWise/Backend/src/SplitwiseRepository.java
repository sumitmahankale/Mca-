package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Model.UserCreation;

public interface SplitwiseRepository extends JpaRepository<UserCreation, String> {

}
