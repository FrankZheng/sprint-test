package com.xzheng.soundsystem;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xzheng on 16/7/9.
 */
public interface PetMapper {
    String TABLE = "pet";
    String INSERT_KEYS = "name, owner, species, sex, birth, death";
    String INSERT_VALUES = "#{name}, #{owner}, #{species}, #{sex}, #{birth}, #{death}";

    Pet selectPetByName(String name);

    @Select("SELECT * FROM pet")
    List<Pet> getAllPets();

    @Insert("INSERT INTO " + TABLE + "(" + INSERT_KEYS + ") VALUES (" + INSERT_VALUES + ")")
    int insert(Pet pet);
}
