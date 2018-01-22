package com.quan;

import com.quan.mapper.RoleMapper;
import com.quan.pojo.Role;
import com.quan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

public class SqlSessionTest {
    @BeforeMethod
    public void init(){

    }

    @Test
    public void TestCRUD(){
        Logger log = LogManager.getLogger();

        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

}
