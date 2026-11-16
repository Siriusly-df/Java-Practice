module order.threads {
    requires order.processing;
    requires order.storage;

    exports com.store.threads;
}