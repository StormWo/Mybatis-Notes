package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Author: wyl
 * @Date: 2022/7/13
 * @Time: 15:40
 * @Description:
 */
public interface BrandMapper {

    //��ѯ����
    List<Brand> selectAll();

    //ע�⿪��
    @Select("select *from tb_brand where id=#{id}")
    Brand selectZhuJie(int id);

    //�鿴���飺����idֵ
    Brand selectById(int id);

    /**
     * ��������ѯ
     * 1.ɢװ�������������ж����������Ҫʹ��Param(SQL����ռλ������)
     * 2.���������
     * 3.map���ϲ���
    */

    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    //��������̬��ѯ
    List<Brand> selectByConditionDuo(Brand brand);

    //��������̬��ѯ���Ӷ��������ѡ��һ��
    List<Brand> selectByConditionSingle(Brand brand);

    //���Ӳ���
    void add(Brand brand);

    //��ӣ�����id
    void addBackId(Brand brand);

    //�޸�
    int update(Brand brand);

    //ɾ������
    void deleteById(int id);
    //����ɾ��
    void deleteByIds(int ids[]);



}
