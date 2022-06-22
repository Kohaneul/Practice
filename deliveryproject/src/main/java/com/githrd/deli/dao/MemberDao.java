package com.githrd.deli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.deli.vo.memberVO;

@Mapper
public class MemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	public memberVO selectOne(String id) {
		
		return sqlSession.selectOne("MemberDao.selectOne",id);
	}

	public List<memberVO> selectList() {
		List<memberVO> list = sqlSession.selectList("MemberDao.selectList");
		return list;
	}


}



