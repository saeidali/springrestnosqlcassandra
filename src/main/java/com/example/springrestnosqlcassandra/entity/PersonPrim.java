package com.example.springrestnosqlcassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyClass
public class PersonPrim implements Serializable {

    @PrimaryKeyColumn(name = "first_name", type = PARTITIONED, ordinal = 0)
    private String firstName;

    @PrimaryKeyColumn(name = "last_name", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String lastName;

    @PrimaryKeyColumn(name = "person_id", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID id;
}
