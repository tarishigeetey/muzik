package tarishi.project.muzik.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="spotify_users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID id;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name = "created_at", updatable = false)
	private Instant createdAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = Instant.now();
	}
}
