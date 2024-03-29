package cn.yellow.mappers;

import cn.yellow.entity.huangShiZhe;
import cn.yellow.entity.huangShiZheExample;
import java.util.List;
import java.util.concurrent.Future;

import com.dianping.zebra.dao.AsyncDaoCallback;
import com.dianping.zebra.dao.annotation.TargetMethod;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface huangShiZheMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int countByExample(huangShiZheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int deleteByExample(huangShiZheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int insert(huangShiZhe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int insertSelective(huangShiZhe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    List<huangShiZhe> selectByExample(huangShiZheExample example);

    @TargetMethod(name = "selectByExample")
    Future<List<huangShiZhe>> selectAll(huangShiZheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    huangShiZhe selectByPrimaryKey(@Param("id") Integer id);


    @TargetMethod(name="selectByPrimaryKey")
    void selectByPrimaryKey(@Param("id") Integer id, AsyncDaoCallback<huangShiZhe> callback);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int updateByExampleSelective(@Param("record") huangShiZhe record, @Param("example") huangShiZheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int updateByExample(@Param("record") huangShiZhe record, @Param("example") huangShiZheExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int updateByPrimaryKeySelective(huangShiZhe record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table huangshizhe
     *
     * @mbggenerated Tue Dec 19 18:24:13 CST 2017
     */
    int updateByPrimaryKey(huangShiZhe record);
}