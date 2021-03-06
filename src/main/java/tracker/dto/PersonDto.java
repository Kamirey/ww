package tracker.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import tracker.entity.WeightRecordEntity;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
	@NonNull private String name;
	@NonNull private Integer height;
	@NonNull private List<WeightRecordEntity> weightRecords;
}
