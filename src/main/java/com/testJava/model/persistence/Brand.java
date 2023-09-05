package com.testJava.model.persistence;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Brand() {

    }

    private Brand(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static final class Builder {
        private Long id;
        private String name;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Brand build() {
            return new Brand(this);
        }
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
