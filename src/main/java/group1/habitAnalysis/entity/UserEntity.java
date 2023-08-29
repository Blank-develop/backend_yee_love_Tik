package group1.habitAnalysis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(nullable = false, length =100)
    private String email;
    @Column(nullable = false, length = 100)
    private String firstName;

    private String lastName;
    private String imageUrl;

    private String phoneNumber;
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<HistoryEntity> userHistory;
}
