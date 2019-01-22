package spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "meeting", schema = "employee_storage")
public class Meeting extends BaseEntity<Long> {

    private Instant date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_meeting", schema = "employee_storage",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees = new ArrayList<>();
}
