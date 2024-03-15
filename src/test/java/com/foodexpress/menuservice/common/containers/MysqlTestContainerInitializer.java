package com.foodexpress.menuservice.common.containers;

import org.testcontainers.containers.MySQLContainer;

public class MysqlTestContainerInitializer {

    static final MySQLContainer MY_SQL_CONTAINER;

    static {
        MY_SQL_CONTAINER = new MySQLContainer("mysql");
        MY_SQL_CONTAINER.start();
    }
}
