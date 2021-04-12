package com.giuaki.dao;

import java.util.List;


import com.giuaki.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql,RowMapper<T> rowMapper, Object... parameters);
	void update(String sql,Object... parametes);
	Long insert(String sql,Object... parametes);
}
