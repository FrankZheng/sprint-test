package com.xzheng.soundsystem;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by xzheng on 16/7/9.
 */
public class MyBatisTest {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            PetMapper mapper = sqlSession.getMapper(PetMapper.class);
            Pet pet = mapper.selectPetByName("Lucky");
            if (pet != null) {
                System.out.println(pet.getName());
                System.out.println(pet.getOwner());
            }

            Pet pet1 = new Pet();
            pet1.setName("Catty");
            pet1.setOwner("Eric");
            pet1.setSpecies("Cat");
            pet1.setSex('M');

            int ret = mapper.insert(pet1);
            System.out.println(ret);

            List<Pet> pets = mapper.getAllPets();
            if (pets != null) {
                System.out.println(pets.size());
            }
        } finally {
            sqlSession.close();
        }
    }

}
