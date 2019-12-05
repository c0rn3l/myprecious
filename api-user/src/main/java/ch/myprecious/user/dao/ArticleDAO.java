package ch.myprecious.user.dao;

import ch.myprecious.user.models.Article;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDAO {

  public Article findArticle(String id) {
    return new Article(id);
  }
}
