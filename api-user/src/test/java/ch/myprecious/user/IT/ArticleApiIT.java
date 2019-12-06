package ch.myprecious.user.IT;

import ch.myprecious.common.helper.RestHelper;
import ch.myprecious.user.Config;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@WebAppConfiguration
public class ArticleApiIT {

  private static final Logger log = LoggerFactory.getLogger(ArticleApiIT.class);

  private static final String GET_ARTICLE_URI = "/article/{id}";
  private static final String VALID_ARTICLE_ID = "1";
  private static final String INVALID_ARTICLE_ID = "214748364";
  @Autowired
  public RestHelper restHelper;
//  private RestCaller<Article> articleRestCaller;
//
//  @Before
//  public void setUp() throws Exception {
//    articleRestCaller = restHelper
//        .createGetCaller(Article.class, GET_ARTICLE_URI);
//  }
//
//  @Test
//  public void whenGetArticleReturn404() {
//    Article article = articleRestCaller.execute(HttpStatus.NOT_FOUND, INVALID_ARTICLE_ID);
//    assertNull("Article not null for articleId=" + INVALID_ARTICLE_ID, article);
//  }
//
//  @Test
//  public void whenGetArticleReturnValidArticle() {
//    Article article = articleRestCaller.execute(HttpStatus.OK, VALID_ARTICLE_ID);
//    Article newArticle = new Article("1");
//    assertEquals("Article null for articleId=" + VALID_ARTICLE_ID, newArticle, article);
//  }
}