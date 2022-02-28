/*
 * Rhythm - A modern community (forum/BBS/SNS/blog) platform written in Java.
 * Modified version from Symphony, Thanks Symphony :)
 * Copyright (C) 2012-present, b3log.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package latke.cache;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.b3log.latke.Keys;
import org.b3log.latke.cache.Cache;
import org.b3log.latke.cache.CacheFactory;
import org.b3log.latke.ioc.BeanManager;
import org.b3log.latke.ioc.Singleton;
import org.b3log.latke.repository.*;
import org.b3log.latke.util.Stopwatchs;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Article cache.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @author <a href="https://qiankunpingtai.cn">qiankunpingtai</a>
 * @version 1.3.1.3, May 20, 2019
 * @since 1.4.0
 */
@Singleton
public class FileCache {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(FileCache.class);

    /**
     * Article cache.
     */
//    private static final Cache ARTICLE_CACHE = CacheFactory.getCache(Article.ARTICLES);
//
//    /**
//     * Article abstract cache.
//     */
//    private static final Cache ARTICLE_ABSTRACT_CACHE = CacheFactory.getCache(Article.ARTICLES + "_"
//            + Article.ARTICLE_T_PREVIEW_CONTENT);
//
//
//    /**
//     * Gets perfect articles.
//     *
//     * @return side random articles
//     */
//    public List<JSONObject> getPerfectArticles() {
//        if (PERFECT_ARTICLES.isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        return JSONs.clone(PERFECT_ARTICLES);
//    }
//
//
//    /**
//     * Puts an article abstract by the specified article id and article abstract.
//     *
//     * @param articleId       the specified article id
//     * @param articleAbstract the specified article abstract
//     */
//    public void putArticleAbstract(final String articleId, final String articleAbstract) {
//        final JSONObject value = new JSONObject();
//        value.put(Common.DATA, articleAbstract);
//        ARTICLE_ABSTRACT_CACHE.put(articleId, value);
//    }
//
//    /**
//     * Gets an article by the specified article id.
//     *
//     * @param id the specified article id
//     * @return article, returns {@code null} if not found
//     */
//    public JSONObject getArticle(final String id) {
//        final JSONObject article = ARTICLE_CACHE.get(id);
//        if (null == article) {
//            return null;
//        }
//
//        return JSONs.clone(article);
//    }
//
//    /**
//     * Adds or updates the specified article.
//     *
//     * @param article the specified article
//     */
//    public void putArticle(final JSONObject article) {
//        final String articleId = article.optString(Keys.OBJECT_ID);
//
//        ARTICLE_CACHE.put(articleId, JSONs.clone(article));
//        ARTICLE_ABSTRACT_CACHE.remove(articleId);
//    }

    /**
     * Removes an article by the specified article id.
     *
     * @param id the specified article id
     */
//    public void removeArticle(final String id) {
//        ARTICLE_CACHE.remove(id);
//        ARTICLE_ABSTRACT_CACHE.remove(id);
//    }
}
