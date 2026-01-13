package org.dromara.system.domain.bo;

import io.github.linpeilie.AutoMapperConfig__6;
import io.github.linpeilie.BaseMapper;
import org.dromara.system.domain.SysRole;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__6.class,
    uses = {},
    imports = {}
)
public interface SysRoleBoToSysRoleMapper extends BaseMapper<SysRoleBo, SysRole> {
}
