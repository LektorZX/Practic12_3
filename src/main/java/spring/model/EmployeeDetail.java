package spring.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import javax.persistence.*;

@Data
@ToString(exclude = "employee")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "employee_detail", schema = "employee_storage")
public class EmployeeDetail extends BaseEntity<Long> {
   // Parameter(name="property",value="employee")
    @Id
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name="property",value="employee"))
    @Column(name = "employee_id")
    private Long id;

    private String email;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @PrimaryKeyJoinColumn
    private Employee employee;
}
