package com.liella.consumer;

import cn.hutool.json.JSONUtil;
import com.liella.model.dto.CanalDTO;
import com.liella.model.vo.ArticleSearchVO;
import com.liella.service.ElasticsearchService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static com.liella.constant.ElasticConstant.*;
import static com.liella.constant.MqConstant.*;

/**
 * 文章消费者
 *
 * @author  liyuu
 **/
@Component
public class ArticleConsumer {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = ARTICLE_QUEUE, durable = "true", autoDelete = "false"),
                    exchange = @Exchange(value = ARTICLE_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = ARTICLE_KEY
            )})
    public void listenSaveArticle(Message message) {
        String data = new String(message.getBody(), StandardCharsets.UTF_8);
        CanalDTO canalDTO = JSONUtil.toBean(JSONUtil.toJsonStr(data), CanalDTO.class);
        if (canalDTO.getIsDdl()) {
            return;
        }
        ArticleSearchVO article = JSONUtil.toBean(JSONUtil.toJsonStr(canalDTO.getData().get(0)), ArticleSearchVO.class);
        switch (canalDTO.getType()) {
            case INSERT:
                elasticsearchService.addArticle(article);
            case UPDATE:
                elasticsearchService.updateArticle(article);
                break;
            case DELETE:
                elasticsearchService.deleteArticle(article.getId());
                break;
            default:
                break;
        }
    }
}