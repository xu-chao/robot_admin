package org.dromara.workflow.domain.bo;

import io.github.linpeilie.AutoMapperConfig__5;
import io.github.linpeilie.BaseMapper;
import org.dromara.workflow.domain.FlowCategory;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__5.class,
    uses = {},
    imports = {}
)
public interface FlowCategoryBoToFlowCategoryMapper extends BaseMapper<FlowCategoryBo, FlowCategory> {
}
