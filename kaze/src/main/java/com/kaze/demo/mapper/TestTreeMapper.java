package com.kaze.demo.mapper;

import com.kaze.common.annotation.DataColumn;
import com.kaze.common.annotation.DataPermission;
import com.kaze.common.core.mapper.BaseMapperPlus;
import com.kaze.demo.domain.TestTree;
import com.kaze.demo.domain.vo.TestTreeVo;

/**
 * 测试树表Mapper接口
 *
 * @author Lion Li
 * @date 2021-07-26
 */
@DataPermission({
    @DataColumn(key = "deptName", value = "dept_id"),
    @DataColumn(key = "userName", value = "user_id")
})
public interface TestTreeMapper extends BaseMapperPlus<TestTreeMapper, TestTree, TestTreeVo> {

}
