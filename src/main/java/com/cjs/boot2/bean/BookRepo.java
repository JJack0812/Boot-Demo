package com.cjs.boot2.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository< Book , Integer> {

}
