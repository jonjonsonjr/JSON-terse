JSON-terse
==========

Terse JSON-simple-based decoding.

I made this for my own use, so it's mostly terrible, but feel free to use/modify it! If there's an easier way of doing what I set out to accomplish here, please let me know. I always feel like I'm doing something wrong when I traverse any complicated JSON structure in Java.


Example
-------

Consider the example JSON from https://dev.twitter.com/docs/api/1.1/get/statuses/mentions_timeline

```

[
  {
    "coordinates": null,
    "favorited": false,
    "truncated": false,
    "created_at": "Mon Sep 03 13:24:14 +0000 2012",
    "id_str": "242613977966850048",
    "entities": {
      "urls": [
 
      ],
      "hashtags": [
 
      ],
      "user_mentions": [
        {
          "name": "Jason Costa",
          "id_str": "14927800",
          "id": 14927800,
          "indices": [
            0,
            11
          ],
          "screen_name": "jasoncosta"
        },

...

```

If you wanted to grab an element from the "indices" array, you would do this with JSON-simple:

```
(Long) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) ((JSONObject) t.get(0)).get("entities")).get("user_mentions")).get(0)).get("indices")).get(0);
```

Or this with JSON-terse:

```
t.obj(0).obj("entities").arr("user_mentions").obj(0).arr("indices").num(0);
```
