package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "company", schema = "employee_storage")
public class Company extends BaseEntity<Integer> {

    private String name;

    @OneToMany(mappedBy = "company")
    private Set<Employee> employees = new HashSet<>();

    public Company(String name) {
        this.name = name;
    }
}
