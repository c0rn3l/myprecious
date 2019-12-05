package ch.myprecious.user.services;

import ch.myprecious.user.dao.ArticleDAO;
import ch.myprecious.user.models.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleService {

  private static final Logger log = LoggerFactory.getLogger(ArticleService.class);

  private ArticleDAO articleDao;

  @Autowired
  public ArticleService(ArticleDAO articleDao) {
    this.articleDao = articleDao;
  }

  public Article getArticle(String id) {
    log.debug("Service getArticle for id={}", id);
    Article article = articleDao.findArticle(id);
    log.debug("Service returned article={} for id={}", article, id);
    return article;
  }
}
