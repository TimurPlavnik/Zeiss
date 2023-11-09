package org.acme;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity @ApplicationScoped @Transactional
public class TestClass extends PanacheEntity {

    public int number;

    public int multiply(int b) {
        return number * b;
    }
}
