package models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@MappedSuperclass
//@NoArgsConstructor
//AllArgsConstructor
public class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date modifiedAt;

}
