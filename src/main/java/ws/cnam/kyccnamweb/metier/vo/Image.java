package ws.cnam.kyccnamweb.metier.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	private Long id;
	private String name;
	private String type;
	private byte[] image;
}