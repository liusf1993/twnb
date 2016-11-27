package com.lsf.twnb.dao;

import com.lsf.twnb.entity.Sign;

public interface SignMapper {
    void insert(Sign twnb);

    void updateByUsername(Sign twnb);
}