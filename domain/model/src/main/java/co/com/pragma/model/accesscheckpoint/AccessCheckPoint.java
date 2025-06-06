package co.com.pragma.model.accesscheckpoint;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class AccessCheckPoint {
    private String viewIdentifier;
    private String userId;
    private String ip;
}
