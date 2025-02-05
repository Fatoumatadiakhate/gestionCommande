package dette.Jpa.data.fily;

import java.util.List;

public interface DtoInterface<Entity, EntityDto> {
    EntityDto toDto(Entity dto);

    List<EntityDto> toListDto(List<Entity> listDto);
}
