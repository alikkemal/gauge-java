# Search Test Cases
===================
tags: search

| email                 |password|
|-----------------------|--------|
|kemalsakligol@gmail.com|541893  |

Scenario : Search keyword use as filter and write to text with new user
-----------------------------------------------------------------------
* Login with register user <email> and <password>.
* User should login successfully.
* Search keyword.
| keyword                |
|------------------------|
|Active Noise Cancelation|

* Should showing keyword as successfully.
| keyword                |
|------------------------|
|Active Noise Cancelation|

* Write to console and save to file as product filter "point" item "10".
* Write to console and save to file as product filter "price" item "10".
* Write to console and save to file as product filter "review" item "10".
* Write to console and save to file as product filter "sale" item "10".