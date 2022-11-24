package com.company.dao;

import java.sql.PreparedStatement;

public interface DbHelper {
    PreparedStatement getConnection(String sql);
}
