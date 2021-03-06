/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;

/**
 * @author Joern Huxhorn - jhuxhorn at googlemail.com
 */
public interface ListSubscribersMethods {
    /**
     * Returns the subscribers of the specified list.
     * <br>This method calls http://api.twitter.com/1/lists/subscribers.json
     *
     * @param listId The id of the list
     * @param cursor Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
     * @return the members of the specified list.
     * @throws twitter4j.TwitterException when Twitter service or network is unavailable
     * @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
     * @since Twitter4J 2.2.3
     */
    PagableResponseList<User> getUserListSubscribers(int listId, long cursor) throws TwitterException;

    /**
     * Returns the subscribers of the specified list.
     * <br>This method calls http://api.twitter.com/1/lists/subscribers.json
     *
     * @param ownerId The user ID of the user who owns the list being requested by a slug.
     * @param slug    slug of the list
     * @param cursor  Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
     * @return the members of the specified list.
     * @throws twitter4j.TwitterException when Twitter service or network is unavailable
     * @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
     * @since Twitter4J 3.0.0
     */
    PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, long cursor) throws TwitterException;

    /**
     * Make the authenticated user follow the specified list.
     * <br>This method calls http://api.twitter.com/1/list/subscribers/create.json
     *
     * @param listId The id of the list.
     * @return the updated list
     * @throws TwitterException when Twitter service or network is unavailable
     * @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">POST lists/subscribers/create | Twitter Developers</a>
     * @since Twitter4J 2.2.3
     */
    UserList createUserListSubscription(int listId) throws TwitterException;

    /**
     * Make the authenticated user follow the specified list.
     * <br>This method calls http://api.twitter.com/1/list/subscribers/create.json
     *
     * @param ownerId The user ID of the user who owns the list being requested by a slug.
     * @param slug    slug of the list
     * @return the updated list
     * @throws TwitterException when Twitter service or network is unavailable
     * @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/create">POST lists/subscribers/create | Twitter Developers</a>
     * @since Twitter4J 3.0.0
     */
    UserList createUserListSubscription(long ownerId, String slug) throws TwitterException;

    /**
     * Unsubscribes the authenticated user form the specified list.
     * <br>This method calls http://api.twitter.com/1/subscribers/destroy.json
     *
     * @param listId The id of the list.
     * @return the updated list
     * @throws TwitterException when Twitter service or network is unavailable
     * @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">POST lists/subscribers/destroy | Twitter Developers</a>
     * @since Twitter4J 2.2.3
     */
    UserList destroyUserListSubscription(int listId) throws TwitterException;

    /**
     * Unsubscribes the authenticated user form the specified list.
     * <br>This method calls http://api.twitter.com/1/subscribers/destroy.json
     *
     * @param ownerId The user ID of the user who owns the list being requested by a slug.
     * @param slug    slug of the list
     * @return the updated list
     * @throws TwitterException when Twitter service or network is unavailable
     * @see <a href="https://dev.twitter.com/docs/api/1/post/lists/subscribers/destroy">POST lists/subscribers/destroy | Twitter Developers</a>
     * @since Twitter4J 3.0.0
     */
    UserList destroyUserListSubscription(long ownerId, String slug) throws TwitterException;

    /**
     * Check if the specified user is a subscriber of the specified list.
     * <br>This method calls http://api.twitter.com/1/lists/subscribers/show.json
     *
     * @param listId The id of the list.
     * @param userId The id of the user who you want to know is a member or not of the specified list.
     * @return the updated list
     * @throws TwitterException when Twitter service or network is unavailable
     *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
     * @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers/show">GET lists/subscribers/show | Twitter Developers</a>
     * @since Twitter4J 2.2.3
     */
    User showUserListSubscription(int listId, long userId) throws TwitterException;

    /**
     * Check if the specified user is a subscriber of the specified list.
     * <br>This method calls http://api.twitter.com/1/lists/subscribers/show.json
     *
     * @param ownerId The user ID of the user who owns the list being requested by a slug.
     * @param slug    slug of the list
     * @param userId  The id of the user who you want to know is a member or not of the specified list.
     * @return the updated list
     * @throws TwitterException when Twitter service or network is unavailable
     *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
     * @see <a href="https://dev.twitter.com/docs/api/1/get/lists/subscribers/show">GET lists/subscribers/show | Twitter Developers</a>
     * @since Twitter4J 3.0.0
     */
    User showUserListSubscription(long ownerId, String slug, long userId) throws TwitterException;
}
