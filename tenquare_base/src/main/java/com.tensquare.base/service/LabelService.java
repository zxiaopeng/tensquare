/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LabelService
 * Author:   15028
 * Date:     2019/12/8 15:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15028
 * @create 2019/12/8
 * @since 1.0.0
 */
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public Label fingById(String id) {
        return labelDao.findById(id).get();
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    public void updateById(Label label) {
        labelDao.save(label);
    }

    public void saveLabel(Label label) {
        String id = idWorker.nextId()+"";
        label.setId(id);
        labelDao.save(label);
    }

//多条件查询
    public List<Label> fingByAll() {
        return  labelDao.findAll();
    }

    public List<Label> findBywhere(Label label) {
        Specification<Label> specification =  createSpecification(label);
        return labelDao.findAll(specification);
}
    //分页查询
    public Page<Label> findPageBywhere(Label label, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1,size);
        Specification<Label> specification =  createSpecification(label);
        return labelDao.findAll(specification,pageRequest);
    }

    //创建条件对象
    private Specification<Label> createSpecification(Label label) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder cb) {
                //声明list容器进行存放
                List<Predicate> predicateList = new ArrayList<>();

                //解析条件,获取Predicate对象,并且放到list集合中
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class),
                            "%" + label.getLabelname() + "%");
                    //放到list容器中
                    predicateList.add(predicate);
                }

                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    predicateList.add(predicate);
                }

                if (label.getRecommend() != null && !"".equals(label.getRecommend())) {
                    Predicate predicate = cb.equal(root.get("recommend").as(String.class), label.getRecommend());
                    predicateList.add(predicate);
                }

                if (label.getCount() != null) {
                    Predicate predicate = cb.equal(root.get("count").as(Long.class), label.getCount());
                    predicateList.add(predicate);
                }
                if (label.getFans() != null) {
                    Predicate predicate = cb.equal(root.get("fans").as(Long.class), label.getFans());
                    predicateList.add(predicate);
                }

                //声明存放条件的数组
                Predicate[] predicates = new Predicate[predicateList.size()];
                //把list容器中的元素放到数组中
                predicates = predicateList.toArray(predicates);

                return cb.and(predicates);

            }
        };
    }


}