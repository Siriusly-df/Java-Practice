module order.processing {
    requires static lombok;
    requires javafaker;
    requires java.sql;

    exports com.store.processing.model;
    exports com.store.processing.service;
}