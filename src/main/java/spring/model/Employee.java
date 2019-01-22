package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;



@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(schema = "employee_storage", name = "employee")
public class Employee extends BaseEntity<Long> {

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

/////////////////////////////////////////////////

    @ManyToOne(fetch = FetchType.EAGER)//ставим что бы подтягивало поле(делало запрос в бд) если дергают гетер
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetail employeeDetail;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//синхрон со всеми связанными таблицами(удаление,добавление и т.д.
    @JoinTable(name = "employee_meeting", schema = "employee_storage",//общая таблица для Employee и meeting
            joinColumns = @JoinColumn(name = "employee_id"),//указываем по каким колонкам связывает таблица
            inverseJoinColumns = @JoinColumn(name = "meeting_id")
    )
    private Set<Meeting> meetings = new HashSet<>();

    public Employee(String name) {
        this.name = name;
    }


}
