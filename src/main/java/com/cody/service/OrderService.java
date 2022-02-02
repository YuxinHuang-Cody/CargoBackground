package com.cody.service;

import com.cody.dao.OrderDao;
import com.cody.es.OrderESDAO;
import com.cody.pojo.Order_;
import com.cody.util.Page4Navigator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/14
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderESDAO orderESDAO;

    public Page4Navigator<Order_> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =orderDao.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public void delete(int id) {
        orderDao.delete(id);
        orderESDAO.delete(id);
    }

    public void add(Order_ bean) {
        orderDao.save(bean);
        orderESDAO.save(bean);
    }

    public Order_ update(Order_ bean) {
        orderESDAO.save(bean);
        return orderDao.save(bean);
    }

    public Order_ get(int id) {
        return orderDao.findOne(id);
    }

    public Page4Navigator<Order_> search(String keyword, int start, int size) {
        //initDatabase2ES();
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                //matchPhraseQuery是对keyword使用分词器的查询
                    .add(QueryBuilders.boolQuery()
                                    .should(QueryBuilders.matchPhraseQuery("company", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("operator", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("dispatcher", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("pickUpAddress", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("shippingAddress", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("warehousingNumber", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("companyOrderNumber", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("driver", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("cargoInformation", keyword))
                                    .should(QueryBuilders.matchPhraseQuery("remarks", keyword)),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .scoreMode("sum")
                .setMinScore(100);
        Sort sort  = new Sort(Sort.Direction.DESC,"id");

//        HighlightBuilder.Field highlightBuilder = new HighlightBuilder.Field("*")
//                .preTags("<font color='red'>").postTags("</font>");
        Pageable pageable = new PageRequest(start, size,sort);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
//                .withHighlightFields(highlightBuilder)
                .withQuery(functionScoreQueryBuilder).build();

        Page<Order_> pageFromJPA = orderESDAO.search(searchQuery);
        return new Page4Navigator<>(pageFromJPA,15);
    }

    private void initDatabase2ES() {
        Pageable pageable = new PageRequest(0, 5);
        Page<Order_> page =orderESDAO.findAll(pageable);
        if(page.getContent().isEmpty()) {
            List<Order_> orderList= orderDao.findAll();
            for (Order_ order : orderList) {
                orderESDAO.save(order);
            }
        }
    }
}
