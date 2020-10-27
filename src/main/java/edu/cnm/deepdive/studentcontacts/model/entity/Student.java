package edu.cnm.deepdive.studentcontacts.model.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    indexes = {
        @Index(columnList = "enrolled"),
        @Index(columnList = "disenrolled")
    },
    uniqueConstraints =
    @UniqueConstraint(columnNames = {
        "last_name",
        "first_name",
        "middle_name",
    })
)

public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_id", updatable = false, nullable = false)
  private Long id;

  @NonNull
  @Column(unique = true, nullable = false)
  private String studentNumber;

  @NonNull
  @Column(nullable = false)
  private String lastName;

  @NonNull
  @Column(nullable = false)
  private String firstName;

  private String middleName;

  @NonNull
  @Column(nullable = false)
  private LocalDate enrolled;

  @NonNull
  @Column(nullable = false)
  private LocalDate disenrolled;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private final List<StudentContact> studentContacts = new LinkedList<>();

  public Long getId() {
    return id;
  }

  @NonNull
  public String getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber(@NonNull String studentNumber) {
    this.studentNumber = studentNumber;
  }

  @NonNull
  public String getLastName() {
    return lastName;
  }

  public void setLastName(@NonNull String lastName) {
    this.lastName = lastName;
  }

  @NonNull
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(@NonNull String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @NonNull
  public LocalDate getEnrolled() {
    return enrolled;
  }

  public void setEnrolled(@NonNull LocalDate enrolled) {
    this.enrolled = enrolled;
  }

  @NonNull
  public LocalDate getDisenrolled() {
    return disenrolled;
  }

  public void setDisenrolled(@NonNull LocalDate disenrolled) {
    this.disenrolled = disenrolled;
  }
}
