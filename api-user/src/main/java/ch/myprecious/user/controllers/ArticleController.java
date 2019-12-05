package ch.myprecious.user.controllers;

import ch.myprecious.common.model.Response;
import ch.myprecious.user.models.Article;
import ch.myprecious.user.services.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

  private ArticleService articleService;

  @Autowired
  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping(value = "/article/{articleId}", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response> getArticle(
      @PathVariable(name = "articleId") String id) {
    log.info("START - getArticle for id={}", id);

    Article article = articleService.getArticle(id);

    if (null != article) {
      log.info("END - getArticle return article={} for id={}", article, id);
      //TODO: check if I should add exception and handler instead of bubble up null
      return new ResponseEntity<>(article, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
